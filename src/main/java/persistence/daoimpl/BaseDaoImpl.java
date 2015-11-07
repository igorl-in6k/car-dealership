package persistence.daoimpl;

import core.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void add(T entityObj) {
        getSession().save(entityObj);
    }

    @Override
    public void delete(T entityObj) {
        getSession().delete(entityObj);
    }

    @Override
    public void addOrUpdate(T entityObj) {
        getSession().saveOrUpdate(entityObj);
    }

    @Override
    public void update(T entityObj) {
        getSession().update(entityObj);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}