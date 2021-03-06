package core.dao;

import core.entity.Brand;

public interface BrandDao extends BaseDao<Brand> {

    Brand getByName(String name);

}
