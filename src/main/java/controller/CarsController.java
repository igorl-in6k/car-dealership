package controller;

import core.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addCar(
            @RequestParam("brandId") String brandId,
            @RequestParam("model") String model,
            @RequestParam("price") String price){
        Car car = new Car();

        car.setBrand(brandService.getBrandById(Integer.parseInt(brandId)));
        car.setModel(model);
        car.setPrice(Integer.parseInt(price));

        carService.addCar(car);

        return "redirect:/cars";
    }

    @RequestMapping(value = "/{carId}/remove", method = RequestMethod.POST)
    public String removeCar(@PathVariable int carId, ModelMap model) {
        Car car = carService.getCarById(carId);
        if ( car.sold() )
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