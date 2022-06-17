package apis;

import enums.LINES;
import io.restassured.response.Response;
import models.Customer;
import enums.SERVICE;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repos.InquiryRepo;
import repos.UserRepo;

public class InquiryTest {
    @DataProvider(name = "inquiry-provider")
    public Object[][] inquiryProvider(){
        return new Object[][] {{SERVICE.ELECTRICITY,"customer1", "inquiry1" }, {5, 7, 9}};
    }

    @Test(dataProvider = "inquiry-provider")
    public void testInquiry(SERVICE service , String user, LINES line ) {
//        precondition
        Customer eligibleCustomer = UserRepo.get(user);
//        action
        Response response=  eligibleCustomer.inquiry(service, InquiryRepo.get(line));
//        assert values in the response

    }
}
