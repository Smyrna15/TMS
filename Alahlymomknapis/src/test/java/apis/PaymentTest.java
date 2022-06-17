package apis;

import enums.LINES;
import io.restassured.response.Response;
import models.Customer;
import enums.SERVICE;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repos.InquiryRepo;
import repos.PaymentRepo;
import repos.UserRepo;

public class PaymentTest {
    @DataProvider(name = "payment-provider")
    public Object[][] paymentProvider(){
        return new Object[][] {{SERVICE.ELECTRICITY,"customer1", "inquiry1","payment1" }, {5, 7, 9}};
    }


    @Test(dataProvider = "payment-provider")
    public void testPayment(SERVICE service, String user, LINES line, String payment) {
//        precondition
        Customer eligibleCustomer = UserRepo.get(user);
        String token  = eligibleCustomer.login();
        String billingAccount= InquiryRepo.get(line).billingAccount;
        int brn = eligibleCustomer.getBrn(service, InquiryRepo.get(line));
//        action
        Response resp = eligibleCustomer.pay(service, PaymentRepo.get(payment, brn,billingAccount));
//        assert values in the response

    }
}
