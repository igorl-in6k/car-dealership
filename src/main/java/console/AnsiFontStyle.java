package console;

public enum AnsiFontStyle {

    RESET("\u001B[0m"),
    BLACK("\u001B[0;30m"),
    RED("\u001B[0;31m"),
    BOLD_RED("\u001B[1;31m"),
    GREEN("\u001B[0;32m"),
    BOLD_GREEN("\u001B[1;32m"),
    YELLOW("\u001B[1;33m"),
    BOLD_YELLOW("\u001B[1;33m"),
    BLUE("\u001B[0;34m"),
    MAGENTA("\u001B[0;35m"),
    CYAN("\u001B[0;36m"),
    BRIGHT_CYAN("\u001B[1;36m"),
    PALE_CYAN("\u001B[2;36m"),
    WHITE("\u001B[0;37m"),
    BOLD_WHITE("\u001B[1;37m"),
    ITALIC_WHITE("\u001B[3;37m");

    AnsiFontStyle(String code) {
        this.code = code;
    }

    private String code;

    @Override
    public String toString() {
        return code;
    }
}