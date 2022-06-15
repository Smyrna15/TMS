package util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	  @JsonProperty("UserName") 
	    public String userName;
	    @JsonProperty("Password") 
	    public String password;
	    @JsonProperty("AccountID") 
	    public String accountID;
	    @JsonProperty("ChannelCategory") 
	    public String channelCategory;
	    @JsonProperty("ChannelType") 
	    public String channelType;
	    @JsonProperty("ChannelId") 
	    public String channelId;
	    @JsonProperty("LocalDate") 
	    public Date localDate;
	    @JsonProperty("Version") 
	    public String version;
	    @JsonProperty("ServiceVersion") 
	    public String serviceVersion;
	    @JsonProperty("Longitude") 
	    public String longitude;
	    @JsonProperty("Latitude") 
	    public String latitude;
	    

}
