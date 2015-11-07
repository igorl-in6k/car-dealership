package web.controller;

import core.entity.Brand;
import core.service.BrandService;
import core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/cars/brands")
public class BrandController {

    @Autowired
    BrandService brandService;
    @Autowired
    CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBrands(ModelMap modelMap) {
        modelMap.addAttribute("brands", brandService.getAllBrands());
        return "brands";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addBrandPage() {
        return "newbrand";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addCar(
            @RequestParam("name") String name){
        Brand brand = new Brand();

        brand.setName(name);

        brandService.addBrand(brand);

        return "redirect:/cars/brands";
    }

    @RequestMapping(value = "/{brandId}/remove", method = RequestMethod.POST)
    public String removeBrand(@PathVariable int brandId, ModelMap model) {
        Brand brand = brandService.getBrandById(brandId);
        if ( carService.getCarsByBrand(brand).isEmpty() )
            brandService.removeBrand(brand);
        return "redirect:/cars/brands";
    }

}
