import core.dao.CarDao;
import core.entity.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Fake {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        CarDao carDao = context.getBean(CarDao.class);
        Car car = carDao.getById(2);
        System.out.println(car.getBrand().getName() + " " + car.getModel() + " " + car.getPrice());
    }
}
