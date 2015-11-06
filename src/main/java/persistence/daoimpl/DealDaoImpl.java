package persistence.daoimpl;

import core.dao.DealDao;
import core.entity.Car;
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
        return getSession()
                .createCriteria(Deal.class)
                .add(Restrictions.eq("manager", manager))
                .list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Deal getDealByCar(Car car) {
        List<Deal> deals = (List<Deal>) getSession()
                .createCriteria(Deal.class)
                .add(Restrictions.eq("car", car))
                .list();
        return deals.isEmpty() ? null : deals.get(0);
    }

}