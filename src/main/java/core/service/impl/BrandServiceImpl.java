package core.service.impl;

import core.dao.BrandDao;
import core.entity.Brand;
import core.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao;

    public BrandServiceImpl(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public void addBrand(Brand brand) {
        brandDao.add(brand);
    }

    @Override
    public Brand getBrandByName(String name) {
        return brandDao.getByName(name);
    }

    @Override
    public Brand getBrandById(int id) {
        return brandDao.getById(id);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandDao.getAll();
    }
}
