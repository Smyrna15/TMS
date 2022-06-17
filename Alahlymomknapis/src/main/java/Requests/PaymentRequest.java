package Requests;

import io.restassured.response.Response;
import models.PaymentBody;
import enums.SERVICE;


public class PaymentRequest extends PostRequest{
    public PaymentRequest(SERVICE service, String token) {
        super("http://164.160.104.66:8080", "/api/services/"+service.getValue()+"/fees");
        addToken(token);
    }
    public Response send(PaymentBody body) {
        return send(body);
    }
}
