package controller.JWT;

public class Signature {
    private String key;

    public Signature(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}