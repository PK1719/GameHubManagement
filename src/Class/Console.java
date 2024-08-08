package Class;

public class Console {
    private String consoleId;
    private String type;
    private String availability;

    public Console(String consoleId, String type, String availability) {
        this.consoleId = consoleId;
        this.type = type;
        this.availability = availability;
    }

    public String getConsoleId() {
        return this.consoleId;
    }

    public void setConsoleId(String consoleId) {
        this.consoleId = consoleId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
