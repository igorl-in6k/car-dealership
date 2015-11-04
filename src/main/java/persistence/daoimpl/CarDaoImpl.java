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

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAvailableCars() {
        return getSession()
                .createCriteria(Car.class)
                .add(Restrictions.eq("saleDate", "")).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getCarsByBrand(Brand brand) {
        return getSession()
                .createCriteria(Car.class)
                .add(Restrictions.eq("brand", brand))
                .list();
    }

    private Criteria createCriteria() {
        return getSession()
                .createCriteria(Car.class);
    }
}