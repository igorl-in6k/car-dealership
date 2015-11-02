package console;

import core.entity.Brand;
import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;
import core.service.BrandService;
import core.service.CarManagementService;
import core.service.StaffManagementService;
import core.service.ReportService;

import java.util.Scanner;

import static console.Command.UNKNOWN;
import static console.OutputForegroundColors.*;

public class ConsoleIO {

    private CarManagementService carService;
    private StaffManagementService staffService;
    private ReportService reportService;
    private BrandService brandService;
    private Scanner                     sc;
    private boolean exit = false;

    public ConsoleIO(CarManagementService carService,
                     StaffManagementService staffService,
                     BrandService brandService,
                     ReportService utilService) {
        this.carService = carService;
        this.staffService = staffService;
        this.reportService = utilService;
        this.brandService = brandService;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        while (!exit) {
            System.out.print(POINTER_COLOR + ">> " + DEFAULT_COLOR);
            String inputCommand = sc.nextLine().trim().toLowerCase();
            execute(inputCommand);
        }
    }

    public void execute(String command) {
        switch (Command.getCommand(command)) {
            case HELP:
                showHelp();
                break;
            case MANAGERS:
                showManagers();
                break;
            case CARS:
                showCars();
                break;
            case ADD_CAR:
                addCar();
                break;
            case ADD_MANAGER:
                addManager();
                break;
            case SELL_CAR:
                sellCar();
                break;
            case MANAGER:
                showManager();
                break;
            case DEALS:
                showDeals();
                break;
            case EXIT:
                this.exit = true;
                break;
            case UNKNOWN:
                noSuchCommand();
                break;
        }
    }

    public void noSuchCommand() {
        //System.out.println(EXCEPTION_MESSAGE_COLOR + "No such command available" + DEFAULT_COLOR);
    }

    public void showHelp() {
        printTitle("HELP");
        for (Command command : Command.values()) {
            if ( command == UNKNOWN ) continue;
            System.out.println(HELP_COMMAND_COLOR + command.name + " - "
                               + HELP_DEFINITION_COLOR + command.definition);
        }
        printLastLine();
    }

    public void showManagers() {
        printTitle("MANAGERS");
        int idx = 1;
        System.out.print(LIST_ITEMS_COLOR);
        for (Manager manager : staffService.getManagers()) {
            System.out.printf("%s\t%d. Sale Manager %s%d%s: %s%s%s, %d y.o.\n",
                              LIST_ITEMS_COLOR, idx++, MANAGER_ID_COLOR, manager.getId(), LIST_ITEMS_COLOR,
                              MANAGER_NAME_COLOR, manager.getName(), LIST_ITEMS_COLOR, manager.getAge());
        }
        printLastLine();
    }

    public void showCars() {
        printTitle("CARS");
        System.out.print(LIST_ITEMS_COLOR);
        int idx = 1;
        for (Car car : carService.getCars()) {
            System.out.printf("%s\t%d. Car %s%d%s: ",
                              LIST_ITEMS_COLOR, idx++, CAR_ID_COLOR, car.getId(), LIST_ITEMS_COLOR);
            System.out.printf("%s%s %s",
                              CAR_NAME_COLOR, car.getBrand(), car.getModel());
            System.out.printf("%s (%s$%d%s)\n",
                              LIST_ITEMS_COLOR, CAR_PRICE_COLOR, car.getPrice(), LIST_ITEMS_COLOR);
        }
        printLastLine();
    }

    public void addCar() {
        printTitle("ADD CAR");
        System.out.print(INPUT_PARAMETERS_COLOR);
        System.out.print("\tBrand: ");
        String brandInput = sc.nextLine();
        Brand brand = brandService.getBrandByName(brandInput);
        if ( brand == null ) {
            System.out.print(EXCEPTION_MESSAGE_COLOR);
            System.out.println("Unknown brand: " + brandInput +
                               "\nAborted" + DEFAULT_COLOR);
            return;
        }
        System.out.print(INPUT_PARAMETERS_COLOR);
        System.out.print("\tModel: ");
        String model = sc.nextLine();
        System.out.print(INPUT_PARAMETERS_COLOR);
        System.out.print("\tPrice: ");
        int price = sc.nextInt();
        System.out.print(MESSAGE_COLOR);
        Car addedCar = new Car(brand, model, price);
        carService.addCar(addedCar);
        System.out.println("Added car " + addedCar);
        printLastLine();
    }

    public void addManager() {
        printTitle("ADD MANAGER");
        System.out.print(INPUT_PARAMETERS_COLOR);
        System.out.print("\tName: ");
        String name = sc.nextLine();
        System.out.print(INPUT_PARAMETERS_COLOR);
        System.out.print("\tAge: ");
        int age = sc.nextInt();
        System.out.print(INPUT_PARAMETERS_COLOR);
        Manager addedManager = new Manager(name, age);
        staffService.addManager(addedManager);
        System.out.println("Added manager " + addedManager);
        printLastLine();
    }

    public void sellCar() {
        printTitle("SELL CAR");
        System.out.print(INPUT_PARAMETERS_COLOR + "\tSale manager ID: ");
        int managerId = sc.nextInt();
        Manager manager = staffService.getManagerById(managerId);
        if ( manager == null ) {
            System.out.print(EXCEPTION_MESSAGE_COLOR);
            System.out.println("No manager found with specified ID: " + managerId +
                               "\nAborted" + DEFAULT_COLOR);
            return;
        }
        System.out.print(INPUT_PARAMETERS_COLOR + "\tCar ID: ");
        int carId = sc.nextInt();
        Car car = carService.getCarById(carId);
        if ( car == null ) {
            System.out.print(EXCEPTION_MESSAGE_COLOR);
            System.out.println("No car found with specified ID: " + carId +
                               "\nAborted" + DEFAULT_COLOR);
            return;
        }
        carService.sellCar(car, manager);
        System.out.println(MESSAGE_COLOR + "sold car: " + car + DEFAULT_COLOR);
        printLastLine();
    }


    public void showManager() {
        printTitle("MANAGER INFO");
        System.out.print(INPUT_PARAMETERS_COLOR + "\tMANAGER_ID: ");
        int id = sc.nextInt();
        Manager manager = staffService.getManagerById(id);
        if ( manager == null ) {
            System.out.print(EXCEPTION_MESSAGE_COLOR);
            System.out.println("No manager found with specified ID: " + id +
                               "\nAborted" + DEFAULT_COLOR);
            return;
        }
        System.out.println(MESSAGE_COLOR + "" + manager);
        System.out.print(DEFAULT_COLOR);
        int idx = 1;
        for (Deal deal : staffService.getDealsByManager(manager)) {
            System.out.println(LIST_ITEMS_COLOR + "\t" + idx++ + ". " + deal);
        }
        Brand bySells = reportService.getManagerPreferredBrandByPriceAmount(manager);
        Brand byPrice = reportService.getManagerPreferredBrandByDealsAmount(manager);
        System.out.println(ADVANCED_INFORMATION_COLOR + "Preferred brand by sells amount: " + bySells);
        System.out.println(ADVANCED_INFORMATION_COLOR + "Preferred brand by price amount: " + byPrice);
        printLastLine();
    }

    public void showDeals() {
        printTitle("DEALS");
        int idx = 1;
        System.out.print(LIST_ITEMS_COLOR);
        for (Manager manager : staffService.getManagers()) {
            for (Deal deal : staffService.getDealsByManager(manager)) {
                System.out.printf("\t%s%d. Deal %d: %s%s %s. %sSale Manager: %s%s\n",
                                  LIST_ITEMS_COLOR, idx++, deal.getId(), CAR_NAME_COLOR,
                                  deal.getCar().getBrand().getName(), deal.getCar().getModel(),
                                  LIST_ITEMS_COLOR, MANAGER_NAME_COLOR, deal.getManager().getName());
            }
        }
        System.out.print(DEFAULT_COLOR);
        printLastLine();
    }

    private void printTitle(String title) {
        System.out.print(TITLE_LINES_COLOR + "==================================");
        System.out.print(TITLE_COLOR + title);
        System.out.println(TITLE_LINES_COLOR + "==================================" + DEFAULT_COLOR);
    }

    private void printLastLine() {
        System.out.println(TITLE_LINES_COLOR + "============================================================================" + DEFAULT_COLOR);
    }

}