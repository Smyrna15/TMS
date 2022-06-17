package Requests;

import io.restassured.response.Response;
import models.FeesBody;
import enums.SERVICE;


public class FeesRequest extends PostRequest{
    public FeesRequest(SERVICE service, String token) {
        super("http://164.160.104.66:8080", "/api/services/"+service.getValue()+"/fees");
        addToken(token);
    }
    public Response send(FeesBody body) {
        return send(body);
    }
}
