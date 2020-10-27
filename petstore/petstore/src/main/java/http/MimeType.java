package http;

public enum MimeType {

    /*
     * all content type should be in lower case
     */
    URL_ENCODED("application/x-www-form-urlencoded"),
    APPLICATION_JSON("application/json"),
    MULTIPART_FORM("multipart/form-data"),
    TEXT_PLAIN("text/plain"),
    TEXT_HTML("text/html"),
    APPLICATION_XML("application/xml");

    private String value;

    private MimeType(String name) {
        setValue(name);
    }

    public static MimeType getMimeType(String contentType) {
        for (MimeType mimeType : MimeType.values()) {
            if (contentType.contains(mimeType.getValue()))
                return mimeType;
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    private void setValue(String name) {
        this.value = name;
    }
}
