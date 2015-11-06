package web.controller;

import core.entity.Car;
import core.entity.Deal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dto.CarDto;

@Controller
@RequestMapping(value = "/cars")
public class CarsController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String getCars(ModelMap modelMap) {
        modelMap.addAttribute("cars", carService.getCars());
        return "cars";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addCarPage(ModelMap modelMap) {
        modelMap.addAttribute("brands", brandService.getAllBrands());
        return "newcar";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCar(CarDto car){
        car.setBrand(brandService.getBrandById(car.getBrandId()));
        carService.addCar(car.toCar());
        return "redirect:/cars";
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.DELETE)
    public String removeCar(@PathVariable int carId) {
        Car car = carService.getCarById(carId);
        if ( car.sold() && dealService.getDealByCar(car) != null )
            dealService.removeDeal(car);
        carService.removeCar(car);
        return "redirect:/cars";
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.GET)
    public String getCar(@PathVariable int carId, ModelMap model) {
        Car car = carService.getCarById(carId);
        model.addAttribute("car", car);
        return "carinfo";
    }

}
