package controller.JWT;

public class Header {
    private String alg;
    private String typ;

    public Header(String alg, String typ) {
        this.alg = alg;
        this.typ = typ;
    }

    public String getAlg() {
        return this.alg;
    }
    public String getTyp() {
        return this.typ;
    }
}