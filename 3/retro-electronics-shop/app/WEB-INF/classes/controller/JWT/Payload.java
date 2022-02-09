package controller.JWT;

public class Payload {
    private String name;
    private String date;

    public Payload(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }
    public String getDate() {
        return this.date;
    }
}