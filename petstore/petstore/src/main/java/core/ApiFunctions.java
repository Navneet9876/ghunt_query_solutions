package core;


import exception.APIResponseException;
import http.HTTPMethodType;
import http.HttpClient;
import http.Request;
import http.Response;

public class ApiFunctions extends HttpClient {
    private static ApiFunctions _instance = null;

    public synchronized static ApiFunctions getInstance() {
        if (_instance == null)
            _instance = new ApiFunctions();
        return _instance;
    }

    public Response doGet(String uri) throws APIResponseException {
        return callAPI(generateRequest(uri, HTTPMethodType.GET));
    }

    public Response doGet(Request request) throws APIResponseException {
        return callAPI(request);
    }

    public Response doPost(Request request) throws APIResponseException {
        return callAPI(request);

    }

    public Response doPut(Request request) throws APIResponseException {
        return callAPI(request);
    }

    public Response doDelete(Request request) throws APIResponseException {
        return callAPI(request);
    }

    private Request generateRequest(String uri, HTTPMethodType methodType) {
        return new Request(uri, methodType);
    }
}
