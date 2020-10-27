package http;

import exception.APIResponseException;
import io.restassured.specification.RequestSpecification;
import logger.Logger;

import static io.restassured.RestAssured.given;

public abstract class HttpClient {

    protected Response callAPI(Request request) throws APIResponseException {
        try {
            Logger.logDebug(request.toString());

            RequestSpecification requestSpecification = given();

            if (request.getHeaders() != null)
                requestSpecification.headers(request.getHeaders());

            if (request.getRequestBody() != null)
                requestSpecification.body(request.getRequestBody());

            io.restassured.response.Response response = null;

            switch (request.getMethodType()) {
                case GET:
                    Logger.logDebug("Performing Get Request : " + request.getUri());
                    response = requestSpecification.get(request.getUri());
                    break;
                case PUT:
                    Logger.logDebug("Performing PUT Request : " + request.getUri());
                    response = requestSpecification.put(request.getUri());
                    break;
                case POST:
                    Logger.logDebug("Performing POST Request : " + request.getUri());
                    response = requestSpecification.post(request.getUri());
                    break;
                case DELETE:
                    Logger.logDebug("Performing DELETE Request : " + request.getUri());
                    response = requestSpecification.delete(request.getUri());
                    break;
                default:
                    Logger.logDebug("Undefined HTTP MethodType");
            }


            HTTPStatusCode statusCode = HTTPStatusCode.getHTTPStatusCode(response.getStatusCode());
            MimeType contentType = MimeType.getMimeType(response.getContentType());
            Response responseFinal = new Response(response, statusCode, contentType);
            Logger.logDebug(responseFinal.toString());

            return responseFinal;
        } catch (Exception e) {
            throw new APIResponseException("API Response Exception: Making " + request.getMethodType().getName() + " request to URL = " + request.getUri(), e);
        }
    }
}