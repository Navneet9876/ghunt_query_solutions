package http;

public enum HTTPMethodType {
    GET(1, "GET"),
    PUT(2, "PUT"),
    POST(3, "POST"),
    DELETE(4, "DELETE");

    private int code;
    private String name;

    HTTPMethodType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public HTTPMethodType get(String name) {
        return valueOf(name);
    }
}
