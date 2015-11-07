package web.controller;

import core.entity.Deal;
import core.entity.Manager;
import core.service.CarService;
import core.service.DealService;
import core.service.ManagerService;
import core.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/managers")
public class ManagersController {

    @Autowired
    ManagerService managerService;
    @Autowired
    DealService dealService;
    @Autowired
    ReportService reportService;
    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String getManagers(ModelMap modelMap) {
        modelMap.addAttribute("managers", managerService.getManagers());
        return "managers";
    }

    @RequestMapping(value = "/{managerId}", method=RequestMethod.GET)
    public String findOwner(@PathVariable int managerId, ModelMap model) {
        Manager manager = managerService.getManagerById(managerId);
        model.addAttribute("manager", manager);
        model.addAttribute("deals", dealService.getDealsByManager(manager));
        model.addAttribute("manager", manager);
        model.addAttribute("preferredBrandByPrice",
                reportService.getManagerPreferredBrandByPriceAmount(manager));
        model.addAttribute("preferredBrandByDeals",
                reportService.getManagerPreferredBrandByDealsAmount(manager));
        return "managerinfo";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newManagerPage() {
        return "newmanager";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addManager(
            @RequestParam("name") String name,
            @RequestParam("age") int age){
        Manager manager = new Manager();
        manager.setName(name);
        manager.setAge(age);
        managerService.addManager(manager);
        return "redirect:/managers";
    }

    @RequestMapping(value = "/{managerId}", method = RequestMethod.DELETE)
    public String removeManager(@PathVariable int managerId) {
        Manager manager = managerService.getManagerById(managerId);
        for (Deal deal : dealService.getDealsByManager(manager)) {
            dealService.removeDeal(deal);
            carService.removeCar(deal.getCar());
        }
        managerService.removeManager(manager);
        return "redirect:/managers";
    }
}
