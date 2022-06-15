package objectmodel;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.driver.DriverFactory;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


@SuppressWarnings("unchecked")
public class elecObjectModel {
	public RestActions apiObject;
	

	public elecObjectModel(RestActions apiObject) {
			this.apiObject = apiObject; 
	}
		//login
	public Response logIn(String userName, String password, int accountId, int channelCategory,int ChannelType,String channelId, String LocalDate, int Version, int ServiceListVersion ,String Language)
	{

		  apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");

		 
			JSONObject authentication=new JSONObject();
			
			authentication.put("username", userName);
			authentication.put("password", password);
			authentication.put("AccountID",accountId);
			authentication.put("ChannelCategory", channelCategory);
			authentication.put("ChannelType", ChannelType);
			authentication.put("ChannelId", channelId);
			authentication.put("LocalDate", LocalDate);
			authentication.put("Version", Version);
			authentication.put("ServiceListVersion", ServiceListVersion);
			authentication.put("Language", Language);

			return apiObject.buildNewRequest("/api/accounts/6/authenticate", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(authentication).
			performRequest();	
}
		
	//inquiry for electricity bills 
	public Response ingquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject inquiry=new JSONObject();
		
		inquiry.put("billingAccount", billingAccount);
		inquiry.put("localDate", localDate);
		inquiry.put("version",version);
		inquiry.put("servicelistVersion", servicelistVersion);

		return apiObject.buildNewRequest("/api/services/126/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(inquiry).addHeader("Authorization", "Bearer "+token)
				.performRequest();
		
	}
	//check fees electricity bills
	
public Response fees(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject fees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1,2"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
                   bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/126/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
.performRequest();

	}
// check payment  electricity bills

public Response payment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject payment=new JSONObject();
	
	payment.put("amount", amount);
	payment.put("version",version);
	payment.put("servicelistVersion", servicelistVersion);
	payment.put("Brn", Brn);
	payment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/126/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(payment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}


//inquiry electricity cards

public Response eleccardsinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject eleccardsinquiry=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "CardType");
			  smallJSONObject.put("Value", "CardType"); dataArray.add(smallJSONObject);
			  new JSONObject(); smallJSONObject.put("key", "CardData");
			  smallJSONObject.put("Value", "CardData"); dataArray.add(smallJSONObject);
			  
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	  
	return apiObject.buildNewRequest("/api/services/135/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();
	
}
//check fees electricity cards

public Response eleccardsfees(double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject eleccardsfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
               bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/135/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//check payment  electricity cards

public Response  eleccardspayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject eleccardspayment=new JSONObject();

eleccardspayment.put("amount", amount);
eleccardspayment.put("version",version);
eleccardspayment.put("servicelistVersion", servicelistVersion);
eleccardspayment.put("Brn", Brn);
eleccardspayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/135/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(eleccardspayment).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}



//check fees for topup
public Response feestopup(String billingAccount,String localDate,int version,int servicelistVersion,double amount,String Brn,String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feestopup=new JSONObject();
	
	feestopup.put("billingAccount", billingAccount);
	feestopup.put("localDate", localDate);
	feestopup.put("version",version);
	feestopup.put("servicelistVersion", servicelistVersion);
	feestopup.put("Brn", Brn);
	feestopup.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/154/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feestopup).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//check payment for topup

public Response paymenttopup(String billingAccount,double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject paymenttopup=new JSONObject();
	
	paymenttopup.put("billingAccount", billingAccount);
	paymenttopup.put("amount", amount);
	paymenttopup.put("version",version);
	paymenttopup.put("servicelistVersion", servicelistVersion);
	paymenttopup.put("Brn", Brn);
	paymenttopup.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/154/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymenttopup).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//fees vouchers
public Response feesvouchers(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesvouchers=new JSONObject();
	
	feesvouchers.put("localDate", localDate);
	feesvouchers.put("version",version);
	feesvouchers.put("servicelistVersion", servicelistVersion);
	feesvouchers.put("Brn", Brn);
	feesvouchers.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/33/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesvouchers).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment vouchers

public Response paymentvouchers(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject paymentvouchers=new JSONObject();
	
	paymentvouchers.put("amount", amount);
	paymentvouchers.put("version",version);
	paymentvouchers.put("servicelistVersion", servicelistVersion);
	paymentvouchers.put("Brn", Brn);
	paymentvouchers.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/33/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentvouchers).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//fees gam3ya
public Response feesgm3ya(double amount,String Brn,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesgm3ya=new JSONObject();
	feesgm3ya.put("amount", amount);
	feesgm3ya.put("Brn", Brn);
	feesgm3ya.put("version",version);
	feesgm3ya.put("servicelistVersion", servicelistVersion);

	return apiObject.buildNewRequest("/api/services/442/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesgm3ya).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment gam3ya
public Response paymentgam3ya(String billingAccount,double amount,String localDate,int version,int servicelistVersion, String token,String Brn) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject paymentgam3ya=new JSONObject();
	paymentgam3ya.put("billingAccount", billingAccount);
	paymentgam3ya.put("amount", amount);
	paymentgam3ya.put("localDate", localDate);
	paymentgam3ya.put("version",version);
	paymentgam3ya.put("servicelistVersion", servicelistVersion);
	paymentgam3ya.put("Brn", Brn);
	

	
	return apiObject.buildNewRequest("/api/services/442/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentgam3ya).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//inquiry accept
public Response accept(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject inquiry=new JSONObject();
	
	inquiry.put("billingAccount", billingAccount);
	inquiry.put("localDate", localDate);
	inquiry.put("version",version);
	inquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/394/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(inquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}
	
//fees accept
	
public Response feesaccept(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject fees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
                   bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/394/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
.performRequest();
}


//payment accept == payment

public Response paymentaccept(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject paymentaccept=new JSONObject();
	
	paymentaccept.put("amount", amount);
	paymentaccept.put("version",version);
	paymentaccept.put("servicelistVersion", servicelistVersion);
	paymentaccept.put("Brn", Brn);
	paymentaccept.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/394/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentaccept).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//5dmat 7komya inquiry
public Response efinanceservicesinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject efinanceservicesinquiry=new JSONObject();
	
	efinanceservicesinquiry.put("billingAccount", billingAccount);
	efinanceservicesinquiry.put("localDate", localDate);
	efinanceservicesinquiry.put("version",version);
	efinanceservicesinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/499/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(efinanceservicesinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}
	
//5dmat 7komya fees
	
public Response efinanceservicessfess(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject efinanceservicessfess=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1,2"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
                   bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/499/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
.performRequest();
}


///5dmat 7komya  payment


public Response efinanceservicespayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject efinanceservicespayment=new JSONObject();
	
	efinanceservicespayment.put("amount", amount);
	efinanceservicespayment.put("version",version);
	efinanceservicespayment.put("servicelistVersion", servicelistVersion);
	efinanceservicespayment.put("Brn", Brn);
	efinanceservicespayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/499/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(efinanceservicespayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//Btech inquiry
public Response Btechinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject Btechfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "BillCount");
			  smallJSONObject.put("Value", "2"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("billingAccount",billingAccount);
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	
	return apiObject.buildNewRequest("/api/services/340/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(bigJSONObject).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}
	
//Btech fees
	
public Response Btechfees(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject Btechfees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
                 bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/340/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
.performRequest();
}


//Btech payment


public Response Btechpayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject Btechpayment=new JSONObject();
	
	Btechpayment.put("amount", amount);
	Btechpayment.put("version",version);
	Btechpayment.put("servicelistVersion", servicelistVersion);
	Btechpayment.put("Brn", Brn);
	Btechpayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/340/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(Btechpayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//check valu inquiry

public Response valuinquiryt(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject Btechfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "BillingAccountType");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("billingAccount",billingAccount);
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	
	return apiObject.buildNewRequest("/api/services/316/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(bigJSONObject).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}

// valu fees

public Response valufees
(double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject Btechfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
             bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/316/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();
}


// valu payment

public Response valupayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject valupayment=new JSONObject();
	
	valupayment.put("amount", amount);
	valupayment.put("version",version);
	valupayment.put("servicelistVersion", servicelistVersion);
	valupayment.put("Brn", Brn);
	valupayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/316/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(valupayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}


//gam3a inquiry

public Response uniinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject uniinquiry=new JSONObject();
	
	uniinquiry.put("billingAccount", billingAccount);
	uniinquiry.put("localDate", localDate);
	uniinquiry.put("version",version);
	uniinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/320/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(uniinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//check uni fees

public Response unifees(double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject fees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1,2"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
               bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/320/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//check gam3yapayment

public Response unipayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject unipayment=new JSONObject();
unipayment.put("amount", amount);
unipayment.put("version",version);
unipayment.put("servicelistVersion", servicelistVersion);
unipayment.put("Brn", Brn);
unipayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/126/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(unipayment).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}



//check schools inquiry

public Response schoolsinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject schoolsinquiry=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Mobile");
			  smallJSONObject.put("Value", "01200341116"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("billingAccount",billingAccount);
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	
	return apiObject.buildNewRequest("/api/services/348/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(bigJSONObject).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}
	
//schools fees
	
public Response schoolsfees(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject schoolsfees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
                 bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/348/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
.performRequest();
}


//schools payment


public Response schoolspayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject schoolspayment=new JSONObject();
	
	schoolspayment.put("amount", amount);
	schoolspayment.put("version",version);
	schoolspayment.put("servicelistVersion", servicelistVersion);
	schoolspayment.put("Brn", Brn);
	schoolspayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/348/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(schoolspayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}

//inquiry sports

public Response sportsinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject sportsinquiry=new JSONObject();
	
	sportsinquiry.put("billingAccount", billingAccount);
	sportsinquiry.put("localDate", localDate);
	sportsinquiry.put("version",version);
	sportsinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/389/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(sportsinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}
//sports fees
public Response sportsfees(double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject sportsfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1,2"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
             bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/389/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();
}
//sports payment
public Response sportspayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject sportspayment=new JSONObject();
	
	sportspayment.put("amount", amount);
	sportspayment.put("version",version);
	sportspayment.put("servicelistVersion", servicelistVersion);
	sportspayment.put("Brn", Brn);
	sportspayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/389/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(sportspayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
}


//fees spotify
public Response feesspotify(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesspotify=new JSONObject();
	
	feesspotify.put("localDate", localDate);
	feesspotify.put("version",version);
	feesspotify.put("servicelistVersion", servicelistVersion);
	feesspotify.put("Brn", Brn);
	feesspotify.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/396/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesspotify).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment spotify

public Response spottifypayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject spottifypayment=new JSONObject();
	
	spottifypayment.put("amount", amount);
	spottifypayment.put("version",version);
	spottifypayment.put("servicelistVersion", servicelistVersion);
	spottifypayment.put("Brn", Brn);
	spottifypayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/396/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(spottifypayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//fees sony

public Response feesony(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesony=new JSONObject();
	
	feesony.put("localDate", localDate);
	feesony.put("version",version);
	feesony.put("servicelistVersion", servicelistVersion);
	feesony.put("Brn", Brn);
	feesony.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/379/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesony).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment sony
public Response sonypayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
	
	
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject sonypayment=new JSONObject();
	
	sonypayment.put("amount", amount);
	sonypayment.put("version",version);
	sonypayment.put("servicelistVersion", servicelistVersion);
	sonypayment.put("Brn", Brn);
	sonypayment.put("localDate", localDate);
	

	
	return apiObject.buildNewRequest("/api/services/379/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(sonypayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//fees microsoft 
public Response feesmicrosoft(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesmicrosoft=new JSONObject();
	
	feesmicrosoft.put("localDate", localDate);
	feesmicrosoft.put("version",version);
	feesmicrosoft.put("servicelistVersion", servicelistVersion);
	feesmicrosoft.put("Brn", Brn);
	feesmicrosoft.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/357/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesmicrosoft).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment microsoft
public Response paymentmicrosoft(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject paymentmicrosoft=new JSONObject();

paymentmicrosoft.put("amount", amount);
paymentmicrosoft.put("version",version);
paymentmicrosoft.put("servicelistVersion", servicelistVersion);
paymentmicrosoft.put("Brn", Brn);
paymentmicrosoft.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/357/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentmicrosoft).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}

//fees itunes
public Response feesitunes(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesitunes=new JSONObject();
	
	feesitunes.put("localDate", localDate);
	feesitunes.put("version",version);
	feesitunes.put("servicelistVersion", servicelistVersion);
	feesitunes.put("Brn", Brn);
	feesitunes.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/212/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesitunes).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment itunes

public Response paymentitunes(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject paymentitunes=new JSONObject();

paymentitunes.put("amount", amount);
paymentitunes.put("version",version);
paymentitunes.put("servicelistVersion", servicelistVersion);
paymentitunes.put("Brn", Brn);
paymentitunes.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/212/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentitunes).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}
//fees onecard
public Response feesonecard(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject feesonecard=new JSONObject();
	
	feesonecard.put("localDate", localDate);
	feesonecard.put("version",version);
	feesonecard.put("servicelistVersion", servicelistVersion);
	feesonecard.put("Brn", Brn);
	feesonecard.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/217/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(feesonecard).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//payment one card 

public Response paymentonecard(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject paymentonecard=new JSONObject();

paymentonecard.put("amount", amount);
paymentonecard.put("version",version);
paymentonecard.put("servicelistVersion", servicelistVersion);
paymentonecard.put("Brn", Brn);
paymentonecard.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/217/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentonecard).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}
// cash u voucher fees

public Response cashuvouchersfees(String localDate,int version,int servicelistVersion, String token,double amount,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject cashuvouchersfees=new JSONObject();
	
	cashuvouchersfees.put("localDate", localDate);
	cashuvouchersfees.put("version",version);
	cashuvouchersfees.put("servicelistVersion", servicelistVersion);
	cashuvouchersfees.put("Brn", Brn);
	cashuvouchersfees.put("amount", amount);

	return apiObject.buildNewRequest("/api/services/342/fees", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(cashuvouchersfees).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}

//cash u voucher payment
public Response cashuvoucherpayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject cashuvoucherpayment=new JSONObject();

cashuvoucherpayment.put("amount", amount);
cashuvoucherpayment.put("version",version);
cashuvoucherpayment.put("servicelistVersion", servicelistVersion);
cashuvoucherpayment.put("Brn", Brn);
cashuvoucherpayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/342/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(cashuvoucherpayment).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}

//cash u top-up

public Response cashutopupinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject cashutopupinquiry=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Amount");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("billingAccount",billingAccount);
			  bigJSONObject.put("localDate",localDate);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	  
	
	return apiObject.buildNewRequest("/api/services/347/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(bigJSONObject).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	
}
//check cash u top up fees

public Response cashutopupfees(double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject cashutopupfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
               bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/347/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//check cash u top up payment


	public Response cashutopuppayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject cashuvoucherpayment=new JSONObject();

		cashuvoucherpayment.put("amount", amount);
		cashuvoucherpayment.put("version",version);
		cashuvoucherpayment.put("servicelistVersion", servicelistVersion);
		cashuvoucherpayment.put("Brn", Brn);
		cashuvoucherpayment.put("localDate", localDate);



		return apiObject.buildNewRequest("/api/services/347/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(cashuvoucherpayment).addHeader("Authorization", "Bearer "+token)
				.performRequest();

		}
		//water bills
	public Response waterbillsinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject waterbillsinquiry=new JSONObject();
		
		waterbillsinquiry.put("billingAccount", billingAccount);
		waterbillsinquiry.put("localDate", localDate);
		waterbillsinquiry.put("version",version);
		waterbillsinquiry.put("servicelistVersion", servicelistVersion);
		
		return apiObject.buildNewRequest("/api/services/403/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(waterbillsinquiry).addHeader("Authorization", "Bearer "+token)
				.performRequest();
	}
		
	//water bills fees
		
	public Response waterbillfees(double amount,int version,int servicelistVersion, String token,String Brn) {
			
			apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
			JSONObject waterbillfees=new JSONObject();
			  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
					  new JSONObject(); smallJSONObject.put("key", "Sequence");
					  smallJSONObject.put("Value", "1,2"); dataArray.add(smallJSONObject);
					  JSONObject bigJSONObject = new JSONObject();
					  bigJSONObject.put("Data",dataArray);
					  bigJSONObject.put("amount", amount);
					  bigJSONObject.put("version",version);
					  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	                 bigJSONObject.put("Brn", Brn);	
			  
			return apiObject.buildNewRequest("/api/services/403/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
		.setRequestBody(bigJSONObject)
	.performRequest();
	}


	//water bills payment


	public Response watebillspayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {
		
		
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject watebillspayment=new JSONObject();
		
		watebillspayment.put("amount", amount);
		watebillspayment.put("version",version);
		watebillspayment.put("servicelistVersion", servicelistVersion);
		watebillspayment.put("Brn", Brn);
		watebillspayment.put("localDate", localDate);
		

		
		return apiObject.buildNewRequest("/api/services/403/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(watebillspayment).addHeader("Authorization", "Bearer "+token)
				.performRequest();
		
	}
	
	//TAQA 
	
	
	public Response TAQAinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject TAQAinquiry=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "CurrentMeterReading");
				  smallJSONObject.put("Value", "100"); dataArray.add(smallJSONObject);
				  
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("billingAccount", billingAccount);	
				  bigJSONObject.put("localDate", localDate);	
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
		  
		return apiObject.buildNewRequest("/api/services/450/inquiry", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
	.performRequest();
		
	}
	//check fees taqa

	public Response TAQAfees(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject TAQAfees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1,2"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	               bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/450/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
	.performRequest();

	}
	//check payment  TAQA

	public Response paymentTAQA(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject paymentTAQA=new JSONObject();

	paymentTAQA.put("amount", amount);
	paymentTAQA.put("version",version);
	paymentTAQA.put("servicelistVersion", servicelistVersion);
	paymentTAQA.put("Brn", Brn);
	paymentTAQA.put("localDate", localDate);



	return apiObject.buildNewRequest("/api/services/450/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(paymentTAQA).addHeader("Authorization", "Bearer "+token)
			.performRequest();

	}
	
	//petrotrade inquiry
public Response petrotradeinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject petrotradeinquiry=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Mobile");
				  smallJSONObject.put("Value", "01200341116"); dataArray.add(smallJSONObject);
				  
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("billingAccount", billingAccount);	
				  bigJSONObject.put("localDate", localDate);	

				  bigJSONObject.put("Data",dataArray);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
		  
		return apiObject.buildNewRequest("/api/services/366/inquiry", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
	.performRequest();
		
	}
	//check fees petrotrade

	public Response petrotradefees(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject petrotradefees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);
				  
				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	               bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/366/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
	.performRequest();

	}
	//check petrotradepayment

	public Response petrotradepayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject petrotradepayment=new JSONObject();

	petrotradepayment.put("amount", amount);
	petrotradepayment.put("version",version);
	petrotradepayment.put("servicelistVersion", servicelistVersion);
	petrotradepayment.put("Brn", Brn);
	petrotradepayment.put("localDate", localDate);



	return apiObject.buildNewRequest("/api/services/366/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(petrotradepayment).addHeader("Authorization", "Bearer "+token)
			.performRequest();

	}
	//orange mobile inquiry
	
public Response orangemobileinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject orangemobileinquiry=new JSONObject();
		
		orangemobileinquiry.put("billingAccount", billingAccount);
		orangemobileinquiry.put("localDate", localDate);
		orangemobileinquiry.put("version",version);
		orangemobileinquiry.put("servicelistVersion", servicelistVersion);
		
		return apiObject.buildNewRequest("/api/services/364/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangemobileinquiry).addHeader("Authorization", "Bearer "+token)
				.performRequest();
		

}
//orange mobile fees
public Response orangemobilefees(double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject orangemobilefees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
               bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/364/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//orange mobile payment

public Response orangemobilepayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangemobilepayment=new JSONObject();

orangemobilepayment.put("amount", amount);
orangemobilepayment.put("version",version);
orangemobilepayment.put("servicelistVersion", servicelistVersion);
orangemobilepayment.put("Brn", Brn);
orangemobilepayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/364/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangemobilepayment).addHeader("Authorization", "Bearer "+token)
		.performRequest();

}
//vodafonemobileinquiry
public Response vodafonemobileinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject vodafonemobileinquiry=new JSONObject();
	
	vodafonemobileinquiry.put("billingAccount", billingAccount);
	vodafonemobileinquiry.put("localDate", localDate);
	vodafonemobileinquiry.put("version",version);
	vodafonemobileinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/65/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(vodafonemobileinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//vodafone mobile fees
public Response vodafonemobilefees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject vodafonemobilefees=new JSONObject();
  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
           bigJSONObject.put("Brn", Brn);	
  
return apiObject.buildNewRequest("/api/services/65/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//vodafonemobilepayment

public Response vodafonemobilepayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject vodafonemobilepayment=new JSONObject();

vodafonemobilepayment.put("amount", amount);
vodafonemobilepayment.put("version",version);
vodafonemobilepayment.put("servicelistVersion", servicelistVersion);
vodafonemobilepayment.put("Brn", Brn);
vodafonemobilepayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/65/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(vodafonemobilepayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}
//etislat mobile inquiry
public Response Etislatmobileinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject Etislatmobileinquiry=new JSONObject();
	
	Etislatmobileinquiry.put("billingAccount", billingAccount);
	Etislatmobileinquiry.put("localDate", localDate);
	Etislatmobileinquiry.put("version",version);
	Etislatmobileinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/63/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(Etislatmobileinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//Etislat mobile fees
public Response Etislatmobilefees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject Etislatmobilefees=new JSONObject();
  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
           bigJSONObject.put("Brn", Brn);	
  
return apiObject.buildNewRequest("/api/services/63/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//Etislat mobile payment

public Response Etislatmobilepaymen(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject Etislatmobilepaymen=new JSONObject();

Etislatmobilepaymen.put("amount", amount);
Etislatmobilepaymen.put("version",version);
Etislatmobilepaymen.put("servicelistVersion", servicelistVersion);
Etislatmobilepaymen.put("Brn", Brn);
Etislatmobilepaymen.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/63/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(Etislatmobilepaymen).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}
//orange co-orporate inquiry

public Response orangecorporateinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject orangecorporateinquiry=new JSONObject();
	
	orangecorporateinquiry.put("billingAccount", billingAccount);
	orangecorporateinquiry.put("localDate", localDate);
	orangecorporateinquiry.put("version",version);
	orangecorporateinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/365/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangecorporateinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//orangecorporatefees
public Response orangecorporatefees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangecorporatefees=new JSONObject();
  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
           bigJSONObject.put("Brn", Brn);	
  
return apiObject.buildNewRequest("/api/services/365/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//orangecorporatepayment

public Response orangecorporatepayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangecorporatepayment=new JSONObject();

orangecorporatepayment.put("amount", amount);
orangecorporatepayment.put("version",version);
orangecorporatepayment.put("servicelistVersion", servicelistVersion);
orangecorporatepayment.put("Brn", Brn);
orangecorporatepayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/365/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangecorporatepayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}



//orange DSL inquiry

public Response orangeDSLinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject orangeDSLinquiry=new JSONObject();
	
	orangeDSLinquiry.put("billingAccount", billingAccount);
	orangeDSLinquiry.put("localDate", localDate);
	orangeDSLinquiry.put("version",version);
	orangeDSLinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/60/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangeDSLinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//orangeDSLfees
public Response orangeDSLfees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangeDSLfees=new JSONObject();
ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
         bigJSONObject.put("Brn", Brn);	

return apiObject.buildNewRequest("/api/services/60/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//orangecorporatepayment

public Response orangeDSLpayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangeDSLpayment=new JSONObject();

orangeDSLpayment.put("amount", amount);
orangeDSLpayment.put("version",version);
orangeDSLpayment.put("servicelistVersion", servicelistVersion);
orangeDSLpayment.put("Brn", Brn);
orangeDSLpayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/60/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangeDSLpayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}

//orange reseller inquiry
public Response orangeResellerinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject orangeResellerinquiry=new JSONObject();
	
	orangeResellerinquiry.put("billingAccount", billingAccount);
	orangeResellerinquiry.put("localDate", localDate);
	orangeResellerinquiry.put("version",version);
	orangeResellerinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/61/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangeResellerinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//orangeresellerfees
public Response orangeresellerfees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangeresellerfees=new JSONObject();
ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
         bigJSONObject.put("Brn", Brn);	

return apiObject.buildNewRequest("/api/services/61/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//orangeresellerpayment
public Response orangeresellerpayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject orangeresellerpayment=new JSONObject();

orangeresellerpayment.put("amount", amount);
orangeresellerpayment.put("version",version);
orangeresellerpayment.put("servicelistVersion", servicelistVersion);
orangeresellerpayment.put("Brn", Brn);
orangeresellerpayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/61/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(orangeresellerpayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}
//etislatnet

public Response etislatnetinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject etislatnetinquiry=new JSONObject();
	
	etislatnetinquiry.put("billingAccount", billingAccount);
	etislatnetinquiry.put("localDate", localDate);
	etislatnetinquiry.put("version",version);
	etislatnetinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/64/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(etislatnetinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//etislatnetfees
public Response etislatnetfees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject etislatnetfees=new JSONObject();
ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
         bigJSONObject.put("Brn", Brn);	

return apiObject.buildNewRequest("/api/services/64/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//etislatnetpayment
public Response etislatnetpayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject etislatnetpayment=new JSONObject();

etislatnetpayment.put("amount", amount);
etislatnetpayment.put("version",version);
etislatnetpayment.put("servicelistVersion", servicelistVersion);
etislatnetpayment.put("Brn", Brn);
etislatnetpayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/64/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(etislatnetpayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}
//wenetinquiry
public Response wenetinquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject wenetinquiry=new JSONObject();
	
	wenetinquiry.put("billingAccount", billingAccount);
	wenetinquiry.put("localDate", localDate);
	wenetinquiry.put("version",version);
	wenetinquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/62/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(wenetinquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//wenetfees
public Response wenetfees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject wenetfees=new JSONObject();
ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
         bigJSONObject.put("Brn", Brn);	

return apiObject.buildNewRequest("/api/services/62/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//wenetpayment
public Response wenetpayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject wenetpayment=new JSONObject();

wenetpayment.put("amount", amount);
wenetpayment.put("version",version);
wenetpayment.put("servicelistVersion", servicelistVersion);
wenetpayment.put("Brn", Brn);
wenetpayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/62/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(wenetpayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}
//Telecom inquiry
public Response telecominquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject telecominquiry=new JSONObject();
	
	telecominquiry.put("billingAccount", billingAccount);
	telecominquiry.put("localDate", localDate);
	telecominquiry.put("version",version);
	telecominquiry.put("servicelistVersion", servicelistVersion);
	
	return apiObject.buildNewRequest("/api/services/317/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(telecominquiry).addHeader("Authorization", "Bearer "+token)
			.performRequest();
	

}
//telecomfees
public Response telecomfees(double amount,int version,int servicelistVersion, String token,String Brn) {

apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject telecomfees=new JSONObject();
ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
		  new JSONObject(); smallJSONObject.put("key", "Sequence");
		  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
		  JSONObject bigJSONObject = new JSONObject();
		  bigJSONObject.put("Data",dataArray);
		  bigJSONObject.put("amount", amount);
		  bigJSONObject.put("version",version);
		  bigJSONObject.put("servicelistVersion", servicelistVersion);	
         bigJSONObject.put("Brn", Brn);	

return apiObject.buildNewRequest("/api/services/317/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//telecompayment
public Response telecompayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
JSONObject telecompayment=new JSONObject();

telecompayment.put("amount", amount);
telecompayment.put("version",version);
telecompayment.put("servicelistVersion", servicelistVersion);
telecompayment.put("Brn", Brn);
telecompayment.put("localDate", localDate);



return apiObject.buildNewRequest("/api/services/317/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(telecompayment).addHeader("Authorization", "Bearer "+token)
	.performRequest();

}

//vodafonenet fees

public Response vodafonenetfees(String BillingAccount,double amount,int version,int servicelistVersion, String token,String Brn) {
	
	apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
	JSONObject vodafonenetfees=new JSONObject();
	  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
			  new JSONObject(); smallJSONObject.put("key", "Sequence");
			  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
			  JSONObject bigJSONObject = new JSONObject();
			  bigJSONObject.put("Data",dataArray);
			  bigJSONObject.put("BillingAccount", BillingAccount);

			  bigJSONObject.put("amount", amount);
			  bigJSONObject.put("version",version);
			  bigJSONObject.put("servicelistVersion", servicelistVersion);	
               bigJSONObject.put("Brn", Brn);	
	  
	return apiObject.buildNewRequest("/api/services/66/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
.setRequestBody(bigJSONObject)
.performRequest();

}
//vodafonenetpayment

	public Response vodafonenetpayment(String BillingAccount,double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject vodafonenetpayment=new JSONObject();
		vodafonenetpayment.put("BillingAccount", amount);
		vodafonenetpayment.put("amount", amount);
		vodafonenetpayment.put("version",version);
		vodafonenetpayment.put("servicelistVersion", servicelistVersion);
		vodafonenetpayment.put("Brn", Brn);
		vodafonenetpayment.put("localDate", localDate);



		return apiObject.buildNewRequest("/api/services/66/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(vodafonenetpayment).addHeader("Authorization", "Bearer "+token)
				.performRequest();

		}
	
	//extra qouta inquiry
	
	public Response extraqoutainquiry(String billingAccount,String localDate,int version,int servicelistVersion, String token) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject extraqoutainquiry=new JSONObject();
		
		extraqoutainquiry.put("billingAccount", billingAccount);
		extraqoutainquiry.put("localDate", localDate);
		extraqoutainquiry.put("version",version);
		extraqoutainquiry.put("servicelistVersion", servicelistVersion);
		
		return apiObject.buildNewRequest("/api/services/488/inquiry", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(extraqoutainquiry).addHeader("Authorization", "Bearer "+token)
				.performRequest();
		

	}
	//extra qouta fees
	public Response extraqoutafees(double amount,int version,int servicelistVersion, String token,String Brn) {
		
		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject extraqoutafees=new JSONObject();
		  ArrayList<Object> dataArray = new ArrayList<>(); JSONObject smallJSONObject =
				  new JSONObject(); smallJSONObject.put("key", "Sequence");
				  smallJSONObject.put("Value", "1"); dataArray.add(smallJSONObject);
				  JSONObject bigJSONObject = new JSONObject();
				  bigJSONObject.put("Data",dataArray);

				  bigJSONObject.put("amount", amount);
				  bigJSONObject.put("version",version);
				  bigJSONObject.put("servicelistVersion", servicelistVersion);	
	               bigJSONObject.put("Brn", Brn);	
		  
		return apiObject.buildNewRequest("/api/services/488/fees", RequestType.POST).setContentType(ContentType.JSON).addHeader("Authorization", "Bearer "+token)
	.setRequestBody(bigJSONObject)
	.performRequest();
	}
	
	//extra qouta payment
		
	public Response extraqoutapayment(double amount,int version,int servicelistVersion, String token,String Brn,String localDate ) {



		apiObject= DriverFactory.getAPIDriver("http://164.160.104.66:8080");
		JSONObject extraqoutapayment=new JSONObject();
		extraqoutapayment.put("amount", amount);
		extraqoutapayment.put("version",version);
		extraqoutapayment.put("servicelistVersion", servicelistVersion);
		extraqoutapayment.put("Brn", Brn);
		extraqoutapayment.put("localDate", localDate);



		return apiObject.buildNewRequest("/api/services/488/payment", RequestType.POST).setContentType(ContentType.JSON).setRequestBody(extraqoutapayment).addHeader("Authorization", "Bearer "+token)
				.performRequest();

		}
}









