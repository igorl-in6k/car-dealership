package persistence.daoimpl;

import core.dao.CarDao;
import core.entity.Brand;
import core.entity.Car;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAll() {
        return createCriteria()
                .list();
    }

    @Override
    public Car getById(int id) {
        return getSession().get(Car.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Car> getCarsByBrand(Brand brand) {
        return createCriteria()
                .add(Restrictions.eq("brand", brand))
                .list();
    }

    private Criteria createCriteria() {
        return getSession()
                .createCriteria(Car.class);
    }
}