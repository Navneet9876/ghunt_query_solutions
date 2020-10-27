package http;

import configuration.GsonConfiguration;

import java.util.Map;

public class Request {

    private String uri;
    private String requestBody;
    private HTTPMethodType methodType;
    private MimeType mimeType;
    private Map<String, String> headers;

    public Request() {
    }

    public Request(String uri, HTTPMethodType methodType) {
        this.uri = uri;
        this.methodType = methodType;
    }

    public Request(String uri, HTTPMethodType methodType, String requestBody) {
        this.uri = uri;
        this.methodType = methodType;
        this.requestBody = requestBody;
    }

    public Request(String uri, HTTPMethodType methodType, String requestBody, MimeType mimeType) {
        this.uri = uri;
        this.methodType = methodType;
        this.requestBody = requestBody;
        this.mimeType = mimeType;
    }

    public Request(String uri, HTTPMethodType methodType, String requestBody, Map<String, String> headers) {
        this.uri = uri;
        this.methodType = methodType;
        this.requestBody = requestBody;
        this.headers = headers;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public HTTPMethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(HTTPMethodType methodType) {
        this.methodType = methodType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void removeHeader(String key) {
        headers.remove(key);
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return GsonConfiguration.get().toJson(this);
    }
}
