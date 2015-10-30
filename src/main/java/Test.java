import core.service.CarManagementService;
import core.service.StaffManagementService;
import core.service.UtilService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarManagementService carService = context.getBean(CarManagementService.class);
        StaffManagementService staff = context.getBean(StaffManagementService.class);
        UtilService util = context.getBean(UtilService.class);

    }
}
