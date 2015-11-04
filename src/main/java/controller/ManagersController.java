package controller;

import core.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagersController extends BaseController {

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public String getManagers(ModelMap modelMap) {
        modelMap.addAttribute("managers", managerService.getManagers());
        return "managers";
    }

    @RequestMapping(value = "/managers/{managerId}", method=RequestMethod.GET)
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

    @RequestMapping(value = "/managers/new", method = RequestMethod.GET)
    public String newManagerPage(ModelMap modelMap) {
        return "newmanager";
    }

    @RequestMapping(value = "/managers/new", method = RequestMethod.POST)
    public String addManager(
            @RequestParam("name") String name,
            @RequestParam("age") int age){
        Manager manager = new Manager();

        manager.setName(name);
        manager.setAge(age);

        managerService.addManager(manager);

        return "redirect:/managers";
    }
}
