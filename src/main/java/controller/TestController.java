package controller;

import core.entity.Car;
import core.service.CarManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    private CarManagementService carService;

    @Autowired
    public TestController(CarManagementService carManagementService) {
        carService = carManagementService;
    }

    @RequestMapping(value = "/dre", method = RequestMethod.GET)
    public String getDre(ModelMap model) {
        Car car = carService.getCarById(4);
        model.addAttribute("car", car.toString());
        return "dre";
    }

}
