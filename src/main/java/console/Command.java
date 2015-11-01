package console;

public enum Command {

    HELP("help", "prints all available commands"),
    MANAGERS("managers", "prints all managers"),
    CARS("cars", "prints all cars"),
    DEALS("deals", "prints all deals of all managers"),
    ADD_CAR("addcar", "adds car with specified price, brand and model"),
    ADD_MANAGER("addmanager", "adds manager specified name"),
    SELL_CAR("sellcar", "manager with MANAGER_ID sells car with CAR_ID"),
    MANAGER("manager", "prints information about manager with specified MANAGER_ID"),
    EXIT("exit", "closes program"),
    UNKNOWN("unknown", "no such command available");

    public final String name;
    public final String definition;

    public static Command getCommand(String command) {
        for (Command command1 : values()) {
            if (command1.name.equals(command) )
                return command1;

        }
        return UNKNOWN;
    }

    Command(String name, String definition) {
        this.name = name;
        this.definition = definition;
    }

    @Override
    public String toString() {
        return name;
    }

}