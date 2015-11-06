package web.controller;

import core.entity.Deal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/deals")
public class DealsController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String getDeals(ModelMap modelMap) {
        modelMap.addAttribute("deals", dealService.getAllDeals());
        return "deals";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newDeal(ModelMap model) {
        model.addAttribute("cars", carService.getAvailableCars());
        model.addAttribute("managers", managerService.getManagers());
        return "newdeal";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newDeal(@RequestParam("carId") int carId,
                          @RequestParam("managerId") int managerId) {
        dealService.sellCar(carService.getCarById(carId),
                managerService.getManagerById(managerId));
        return "redirect:/deals";
    }

    @RequestMapping(value = "/{dealId}", method = RequestMethod.GET)
    public String getCar(@PathVariable int dealId, ModelMap model) {
        Deal deal = dealService.getDealById(dealId);
        model.addAttribute("deal", deal);
        return "dealinfo";
    }

    @RequestMapping(value = "/{dealId}", method = RequestMethod.DELETE)
    public String removeCar(@PathVariable int dealId) {
        Deal deal = dealService.getDealById(dealId);
        dealService.removeDeal(deal);
        carService.removeCar(deal.getCar());
        return "redirect:/deals";
    }

}
