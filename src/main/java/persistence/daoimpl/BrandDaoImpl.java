package persistence.daoimpl;

import core.dao.BrandDao;
import core.entity.Brand;
import core.entity.Car;
import org.hibernate.Criteria;

import java.util.List;

public class BrandDaoImpl extends BaseDaoImpl<Brand> implements BrandDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Brand> getAll() {
        return createCriteria()
                .list();
    }

    @Override
    public Brand getById(int id) {
        return getSession().get(Brand.class, id);
    }

    private Criteria createCriteria() {
        return getSession()
                .createCriteria(Car.class);
    }
}
