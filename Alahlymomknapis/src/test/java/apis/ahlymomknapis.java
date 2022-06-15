package apis;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.cli.FileActions;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Assertions;

import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import objectmodel.elecObjectModel;
import util.User;


public class ahlymomknapis {
  @SuppressWarnings("unchecked")
  
 private RestActions apiObject;
  
  elecObjectModel elecObject;
 
  //authentication
  @BeforeClass
  public void beforeclass()
  {
	  elecObject = new elecObjectModel(apiObject);
  }
  
@Test

 public void checkelectricitybills() {
	User eligibleUser= UserRepo.read(1);
	User eligibleUser = new User ();
	eligibleUser.accountID=111;
	//precondtion 
	Response loginResponse=eligibleUser.login()
			
//	Response loginResponse; = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	 
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.ingquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.fees(450.7, 36, 6, token,Brn);
		elecObject.payment(450.7, 36, 6, token,Brn,"2021-01-13T13:16:20");
		//action 
		//post condition -
		
}
@Test
public void checktopup() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feestopup("01200341111", "2021-04-13T13:27:11",6,6,10,"0",token);
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feestopup("01200341111","2021-04-13T13:27:11",6,6,10,"0",token);
	elecObject.paymenttopup("01200341111",10,6,6,token,Brn,"2021-01-13T13:16:20");
		
}

@Test 

public void vouchers() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feesvouchers("2021-04-13T13:27:11",6,6,token,2.25,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesvouchers("2021-04-13T13:27:11",6,6,token,2.25,"0");
	elecObject.paymentvouchers(2.25,6,6,token,Brn,"2021-01-13T13:16:20");

}
@Test
public void checkgam3ya() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
   Response Brnfees= elecObject.feesgm3ya(10, "0",6,6,token);
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesgm3ya(10,"0",6,6,token);
	elecObject.paymentgam3ya("01200341111",10,"2021-01-13T13:16:20",6,6,token,Brn);
		
}
@Test

public void checkaccept() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.accept("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.feesaccept(428, 36, 6, token,Brn);
		elecObject.paymentaccept(428, 36, 6, token,Brn,"2021-01-13T13:16:20");
	
}

@Test

public void checkefinanceservices() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.efinanceservicesinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.efinanceservicessfess(450.7, 36, 6, token,Brn);
		elecObject.efinanceservicespayment(450.7, 36, 6, token,Brn,"2021-01-13T13:16:20");

}
@Test
public void checkBtech() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.Btechinquiry("3739460", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.Btechfees(1612, 36, 6, token,Brn);
		elecObject.Btechpayment(1612, 36, 6, token,Brn,"2021-01-13T13:16:20");

}

@Test

public void checkvalu() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.valuinquiryt("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.valufees(20, 36, 6, token,Brn);
		elecObject.valupayment(20, 36, 6, token,Brn,"2021-01-13T13:16:20");

}

@Test

public void checkuniversties() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.uniinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.unifees(443.8, 36, 6, token,Brn);
		elecObject.unipayment(443.8, 36, 6, token,Brn,"2021-01-13T13:16:20");

}

@Test

public void checkSchools() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.schoolsinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.schoolsfees(170, 36, 6, token,Brn);
		elecObject.schoolspayment(170.8, 36, 6, token,Brn,"2021-01-13T13:16:20");

}
@Test

public void checksports() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.sportsinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.sportsfees(450.7, 36, 6, token,Brn);
		elecObject.sportspayment(450.7, 36, 6, token,Brn,"2021-01-13T13:16:20");

}

@Test

public void spotify() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feesspotify("2021-04-13T13:27:11",6,6,token,2.25,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesspotify("2021-04-13T13:27:11",6,6,token,2.25,"0");
	elecObject.spottifypayment(2.25,6,6,token,Brn,"2021-01-13T13:16:20");

}

public void sony() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feesony("2021-04-13T13:27:11",6,6,token,0,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesony("2021-04-13T13:27:11",6,6,token,0,"0");
	elecObject.sonypayment(0,6,6,token,Brn,"2021-01-13T13:16:20");

}

public void microsoft() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feesmicrosoft("2021-04-13T13:27:11",6,6,token,0,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesmicrosoft("2021-04-13T13:27:11",6,6,token,0,"0");
	elecObject.paymentmicrosoft(0,6,6,token,Brn,"2021-01-13T13:16:20");

}


public void itunes() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feesitunes("2021-04-13T13:27:11",6,6,token,0,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesitunes("2021-04-13T13:27:11",6,6,token,0,"0");
	elecObject.paymentitunes(0,6,6,token,Brn,"2021-01-13T13:16:20");

}

@Test

public void onecardvouchers() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.feesonecard("2021-04-13T13:27:11",6,6,token,0,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.feesonecard("2021-04-13T13:27:11",6,6,token,0,"10");
	elecObject.paymentonecard(10,6,6,token,Brn,"2021-01-13T13:16:20");

}
@Test

public void cashuvouchers() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.cashuvouchersfees("2021-04-13T13:27:11",6,6,token,0,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.cashuvouchersfees("2021-04-13T13:27:11",6,6,token,10,"0");
	elecObject.cashuvoucherpayment(10,6,6,token,Brn,"2021-01-13T13:16:20");

}

@Test

public void cashutopup() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.cashutopupinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.cashutopupfees(1, 36, 6, token,Brn);
		elecObject.cashutopuppayment(1, 36, 6, token,Brn,"2021-01-13T13:16:20");

}

@Test
public void eleccards() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.eleccardsinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.eleccardsfees(170, 36, 6, token,Brn);
		elecObject.eleccardspayment(170.8, 36, 6, token,Brn,"2021-01-13T13:16:20");

}
@Test
public void waterbills() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.waterbillsinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.waterbillfees(450.7, 36, 6, token,Brn);
		elecObject.watebillspayment(450.7, 36, 6, token,Brn,"2021-01-13T13:16:20");
}
@Test

public void TAQA() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.TAQAinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.TAQAfees(450.7, 36, 6, token,Brn);
		elecObject.paymentTAQA(450.7, 36, 6, token,Brn,"2021-01-13T13:16:20");
}
@Test

public void petrotrade() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.petrotradeinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.petrotradefees(24, 36, 6, token,Brn);
		elecObject.petrotradepayment(24, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

//orange mobile 
@Test

public void orangemobile() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.orangemobileinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.orangemobilefees(100, 36, 6, token,Brn);
		elecObject.orangemobilepayment(100, 36, 6, token,Brn,"2021-01-13T13:16:20");
}
@Test

public void vodafonemobile() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.vodafonemobileinquiry("01000341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.vodafonemobilefees(100, 36, 6, token,Brn);
		elecObject.vodafonemobilepayment(100, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test
public void Etislatmobile() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.Etislatmobileinquiry("01100341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.Etislatmobilefees(100, 36, 6, token,Brn);
		elecObject.Etislatmobilepaymen(100, 36, 6, token,Brn,"2021-01-13T13:16:20");
}
@Test

public void orangecorporate() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.orangecorporateinquiry("01200341116", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.orangecorporatefees(100, 36, 6, token,Brn);
		elecObject.orangecorporatepayment(100, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test

public void orangeDSL() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.orangeDSLinquiry("0862352989", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.orangeDSLfees(100, 36, 6, token,Brn);
		elecObject.orangeDSLpayment(100, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test

public void orangeResller() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.orangeResellerinquiry("0862352989", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.orangeresellerfees(50, 36, 6, token,Brn);
		elecObject.orangeresellerpayment(50, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test

public void Etislatnet() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.etislatnetinquiry("0862352989", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.etislatnetfees(100, 36, 6, token,Brn);
		elecObject.etislatnetpayment(100, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test

public void wenet() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.wenetinquiry("0862352989", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.wenetfees(20, 36, 6, token,Brn);
		elecObject.wenetpayment(20, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test
public void TelecomEgypt() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.telecominquiry("0862352989", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.telecomfees(50, 36, 6, token,Brn);
		elecObject.telecompayment(50, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

@Test

public void vodafonenet() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
 Response Brnfees= elecObject.vodafonenetfees("0862352989",10,6,10,token,"0");
	String Brn = RestActions.getResponseJSONValue(Brnfees,"Brn");
	elecObject.vodafonenetfees("0862352989",10,6,10,token,"0");
	elecObject.vodafonenetpayment("0862352989",10,6,6,token,Brn,"2021-01-13T13:16:20");
		
}
@Test

public void extraqouta() {
	Response loginResponse = elecObject.logIn("111", "25802580", 6, 2, 3, "196.151.244.252", "2021-01-13T13:16:20", 1, 6 ,"en");
	String token = RestActions.getResponseJSONValue(loginResponse,"Token" );
	
  Response getBrn= elecObject.extraqoutainquiry("0862352989", "2021-04-13T13:27:11", 36, 6, token);
	String Brn = RestActions.getResponseJSONValue(getBrn,"Brn");
	elecObject.extraqoutafees(676, 36, 6, token,Brn);
		elecObject.extraqoutapayment(676, 36, 6, token,Brn,"2021-01-13T13:16:20");
}

}
