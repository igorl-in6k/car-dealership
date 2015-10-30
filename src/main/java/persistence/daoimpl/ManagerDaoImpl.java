package persistence.daoimpl;

import core.dao.ManagerDao;
import core.entity.Manager;

import java.util.List;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Manager> getAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Manager.class)
                .list();
    }

    @Override
    public Manager getById(int id) {
        return sessionFactory.getCurrentSession().get(Manager.class, id);
    }
}