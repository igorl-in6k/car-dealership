package persistence.daoimpl;

import core.dao.BrandDao;
import core.entity.Brand;
import core.entity.Car;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BrandDaoImpl extends BaseDaoImpl<Brand> implements BrandDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Brand> getAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Brand.class)
                .list();
    }

    @Override
    public Brand getById(int id) {
        return getSession().load(Brand.class, id);
    }

    private Criteria createCriteria() {
        return getSession()
                .createCriteria(Car.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Brand getByName(String name) {
        List<Brand> brands = getSession().createCriteria(Brand.class).list();
        for (Brand brand : brands) {
            if ( brand.getName().toLowerCase().equals(name.toLowerCase().trim()) )
                return brand;
        }
        return null;
    }
}
