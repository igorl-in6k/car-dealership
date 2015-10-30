package persistence.daoimpl;

import core.dao.DealDao;
import core.entity.Deal;
import core.entity.Manager;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DealDaoImpl extends BaseDaoImpl<Deal> implements DealDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Deal> getAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Deal.class)
                .list();
    }

    @Override
    public Deal getById(int id) {
        return getSession().get(Deal.class, id);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Deal> getDealsByManager(Manager manager) {
        return sessionFactory.getCurrentSession()
                .createCriteria(Deal.class)
                .add(Restrictions.eq("managerName", manager.getName()))
                .list();
    }
}