package http;

public class Response {
    private io.restassured.response.Response response;
    private HTTPStatusCode statusCode;
    private MimeType contentType;

    public Response(io.restassured.response.Response response, HTTPStatusCode statusCode, MimeType contentType) {
        this.response = response;
        this.statusCode = statusCode;
        this.contentType = contentType;
    }

    public io.restassured.response.Response getResponse() {
        return response;
    }

    public String getResponseBody() {
        return response.body().asString();
    }

    public HTTPStatusCode getStatusCode() {
        return statusCode;
    }

    public MimeType getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return "Response : " + System.lineSeparator() +
                "StatusCode = " + statusCode + System.lineSeparator() +
                "ContentType = " + contentType;
    }
}
