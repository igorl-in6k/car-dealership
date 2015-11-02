package core.service;

import core.entity.Deal;
import core.entity.Manager;

import java.util.List;

public interface StaffManagementService {

    void addManager(Manager newManager);

    List<Manager> getManagers();

    Manager getManagerById(int id);

    List<Deal> getDealsByManager(Manager manager);

    List<Deal> getAllDeals();
}
