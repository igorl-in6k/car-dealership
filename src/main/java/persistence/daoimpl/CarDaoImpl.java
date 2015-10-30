package persistence.daoimpl;

import core.dao.CarDao;
import core.entity.Car;
import org.hibernate.Criteria;

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

    private Criteria createCriteria() {
        return getSession()
                .createCriteria(Car.class);
    }
}