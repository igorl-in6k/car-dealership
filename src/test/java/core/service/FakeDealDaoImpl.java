package core.service;

import core.dao.DealDao;
import core.entity.Brand;
import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeDealDaoImpl implements DealDao {

    private List<Deal> deals;

    public FakeDealDaoImpl() {
        Manager man1 = new Manager("Man1", 20);
        man1.setId(1);
        Manager man2 = new Manager("Man2", 25);
        man1.setId(2);
        deals = new ArrayList<>(Arrays.asList(
                new Deal(man1,
                        new Car(new Brand("Ferrari"), "Ferrari1", 600000)),
                new Deal(man1,
                        new Car(new Brand("BMW"), "BMW1", 100000)),
                new Deal(man1,
                        new Car(new Brand("BMW"), "BMW2", 150000)),
                new Deal(man1,
                        new Car(new Brand("Mercedes"), "Mercedes1", 500000)),


                new Deal(man2,
                        new Car(new Brand("Ferrari"), "Ferrari2", 100000)),
                new Deal(man2,
                        new Car(new Brand("Ferrari"), "Ferrari3", 200000)),
                new Deal(man2,
                        new Car(new Brand("BMW"), "BMW2", 200000)),
                new Deal(man2,
                        new Car(new Brand("Lamborghini"), "Lamborghini1", 800000))
                ));
        int i = 1;
        for (Deal deal : deals) {
            deal.setId(i);
            deal.getManager().setId(i);
            deal.getCar().setId(i);
            i++;
        }
    }

    @Override
    public List<Deal> getDealsByManager(Manager manager) {
        List<Deal> dealsByManager = new ArrayList<>();
        for (Deal deal : deals) {
            if ( deal.getManager().equals(manager) )
                dealsByManager.add(deal);
        }
        return dealsByManager;
    }

    @Override
    public Deal getDealByCar(Car car) { // todo
        return null;
    }

    @Override
    public List<Deal> getAll() {
        return deals;
    }

    @Override
    public Deal getById(int id) {
        for (Deal deal : deals) {
            if ( deal.getId() == id )
                return deal;
        }
        return null;
    }

    @Override
    public void add(Deal entityObj) {
        deals.add(entityObj);
    }

    @Override
    public void delete(Deal entityObj) {
        deals.remove(entityObj);
    }

    @Override
    public void addOrUpdate(Deal entityObj) {
        boolean updated = false;
        for (Deal deal : deals) {
            if ( deal.getId() == entityObj.getId() ) {
                deal.setManager(entityObj.getManager());
                deal.setCar(entityObj.getCar());
                updated = true;
            }
        }
        if ( !updated )
            deals.add(entityObj);
    }

    @Override
    public void update(Deal entityObj) {

    }
}
