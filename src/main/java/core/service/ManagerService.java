package core.service;

import core.entity.Manager;

import java.util.List;

public interface ManagerService {

    void addManager(Manager newManager);

    List<Manager> getManagers();

    Manager getManagerById(int id);

    void removeManager(Manager manager);

    void editManager(Manager manager);
}
