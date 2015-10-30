package core.dao;

import core.entity.Deal;
import core.entity.Manager;

import java.util.List;

public interface DealDao extends BaseDao<Deal> {

    List<Deal> getDealsByManager(Manager manager);
}