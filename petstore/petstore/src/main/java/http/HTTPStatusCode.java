package http;

public enum HTTPStatusCode {
    OK_200(200, "OK"),
    CREATED_201(201, "Created"),
    ACCEPTED_202(202, "Accepted"),
    NOT_MODIFIED_301(301, "Moved Permanently"),
    BAD_REQUEST_400(400, "Bad Request"),
    UNAUTHORIZED_401(401, "Unauthorized"),
    FORBIDDEN_403(403, "Forbidden"),
    NOT_FOUND_404(404, "Not Found"),
    INTERNAL_ERROR_500(500, "Internal Server Error"),
    NOT_IMPLEMENTED_501(501, "Not Implemented");

    private int code;
    private String message;

    HTTPStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static HTTPStatusCode getHTTPStatusCode(int statusCode) {

        switch (statusCode) {
            case 200:
                return OK_200;
            case 201:
                return CREATED_201;
            case 202:
                return ACCEPTED_202;
            case 301:
                return NOT_MODIFIED_301;
            case 400:
                return BAD_REQUEST_400;
            case 401:
                return UNAUTHORIZED_401;
            case 403:
                return FORBIDDEN_403;
            case 404:
                return NOT_FOUND_404;
            case 500:
                return INTERNAL_ERROR_500;
            case 501:
                return NOT_IMPLEMENTED_501;
            default:
                return null;
        }
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
