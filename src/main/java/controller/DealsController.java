package controller;

import core.entity.Car;
import core.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DealsController extends BaseController {

    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public String getDeals(ModelMap modelMap) {
        modelMap.addAttribute("deals", dealService.getAllDeals());
        return "deals";
    }

    @RequestMapping(value = "/deals/new", method = RequestMethod.GET)
    public String newDeal(ModelMap model) {
        model.addAttribute("cars", carService.getAvailableCars());
        model.addAttribute("managers", managerService.getManagers());
        return "newdeal";
    }

    @RequestMapping(value = "/deals/new", method = RequestMethod.POST)
    public String newDeal(@RequestParam("carId") int carId,
                          @RequestParam("managerId") int managerId) {
        Car car = carService.getCarById(carId);
        Manager manager = managerService.getManagerById(managerId);
        dealService.sellCar(car, manager);
        return "redirect:/deals";
    }

}
