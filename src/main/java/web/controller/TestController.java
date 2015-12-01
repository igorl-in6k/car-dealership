package web.controller;

import core.entity.Brand;
import core.entity.Car;
import core.service.BrandService;
import core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    BrandService brandService;
    @Autowired
    CarService carService;

    @RequestMapping(value = "/allbrands/", method = RequestMethod.GET)
    public List<Brand> index() {
        return brandService.getAllBrands();
    }

    @RequestMapping(value = "/allbrands/{id}", method = RequestMethod.DELETE)
    public void deleteBrand(@PathVariable("id") Integer id ) {
        Brand brand = brandService.getBrandById(id);
        brandService.removeBrand(brand);
    }

    @RequestMapping(value = "/allbrands/", method = RequestMethod.POST)
    public void create(@RequestBody Brand brand) {
        brandService.addBrand(brand);
    }

    // - CARS -
    @RequestMapping(value = "/allcars/", method = RequestMethod.GET)
    public List<Car> getCars() {
        return carService.getCars();
    }

    @RequestMapping(value = "/allcars/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("id") Integer id ) {
        Car car = carService.getCarById(id);
        carService.removeCar(car);
    }

    @RequestMapping(value = "/allcars/", method = RequestMethod.POST)
    public void createCar(@RequestBody Car car) {
        carService.addCar(car);
    }

}