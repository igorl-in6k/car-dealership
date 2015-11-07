package core.service.impl;

import core.dao.ManagerDao;
import core.entity.Manager;
import core.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDao managerDao;

    public ManagerServiceImpl(ManagerDao managerDao) {
        this.managerDao = managerDao;
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

    @Override
    public void removeManager(Manager manager) {
        managerDao.delete(manager);
    }

    @Override
    public void editManager(int id, String newName, int newAge) {
        Manager manager = getManagerById(id);
        manager.setName(newName);
        manager.setAge(newAge);
        managerDao.update(manager);
    }
}
