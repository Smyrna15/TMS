package apis;

import enums.LINES;
import io.restassured.response.Response;
import models.Customer;
import enums.SERVICE;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repos.FeeRepo;
import repos.InquiryRepo;
import repos.UserRepo;

public class FeeTest {
    @DataProvider(name = "fee-provider")
    public Object[][] feeProvider(){
        return new Object[][] {{SERVICE.ELECTRICITY,"customer1", "inquiry1","fee1" }, {5, 7, 9}};
    }
    @Test(dataProvider = "fee-provider")
    public void testFees(SERVICE service,  String user, LINES line, String fee) {
//        precondition
        Customer eligibleCustomer = UserRepo.get(user);
        String token  = eligibleCustomer.login();
        int brn = eligibleCustomer.getBrn(service , InquiryRepo.get(line));
//        action
        Response resp = eligibleCustomer.getFees(service, FeeRepo.get(fee,brn));
//        assert values in the response
    }



}
