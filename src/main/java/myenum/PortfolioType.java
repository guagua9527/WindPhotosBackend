package myenum;

public enum PortfolioType {

    LANDSCAPE("landscape", "风光"),
    PRODUCT("product", "产品"),
    PORTRAIT("portrait", "人像"),

    STILL_LIFE("still-life", "静物"),
    ;


    private final String type;

    private final String name;

    PortfolioType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
