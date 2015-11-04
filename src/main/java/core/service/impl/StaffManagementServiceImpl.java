package core.service.impl;

import core.dao.DealDao;
import core.dao.ManagerDao;
import core.entity.Manager;
import core.service.ManagerService;

import java.util.List;

public class StaffManagementServiceImpl implements ManagerService {

    private ManagerDao managerDao;
    private DealDao dealDao;

    public StaffManagementServiceImpl(ManagerDao managerDao, DealDao dealDao) {
        this.managerDao = managerDao;
        this.dealDao = dealDao;
    }

    @Override
    public void addManager(Manager newManager) {
        managerDao.add(newManager);
    }

    @Override
    public List<Manager> getManagers() {
        return managerDao.getAll();
    }

    @Override
    public Manager getManagerById(int id) {
        return managerDao.getById(id);
    }
}
