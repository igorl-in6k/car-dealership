package core.service;

import core.entity.Brand;

import java.util.List;

public interface BrandService {

    void addBrand(Brand brand);

    Brand getBrandByName(String name);

    Brand getBrandById(int id);

    List<Brand> getAllBrands();

}
