package web.controller;

import core.entity.Brand;
import core.entity.Car;
import core.service.BrandService;
import core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    BrandService brandService;

    @RequestMapping(value = "/api/", method = RequestMethod.GET)
    public List<Brand> index() {
        return brandService.getAllBrands();
    }

    @RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    public void create(@PathVariable("id") Integer id ) {
        Brand brand = brandService.getBrandById(id);
        brandService.removeBrand(brand);
    }

    @RequestMapping(value = "/api/", method = RequestMethod.POST)
    public void create(@RequestBody Brand brand) {
        brandService.addBrand(brand);
    }

}