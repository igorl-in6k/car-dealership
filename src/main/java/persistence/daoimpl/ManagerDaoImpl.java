package persistence.daoimpl;

import core.dao.ManagerDao;
import core.entity.Car;
import core.entity.Manager;
import org.hibernate.Criteria;

import java.util.List;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Manager> getAll() {
        return createCriteria()
                .list();
    }

    @Override
    public Manager getById(int id) {
        return sessionFactory.getCurrentSession().get(Manager.class, id);
    }

    private Criteria createCriteria() {
        return getSession()
                .createCriteria(Manager.class);
    }
}