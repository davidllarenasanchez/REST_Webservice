/**
 * 
 */
package org.restjersey.webservices.client;


import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
/**
 * @author David
 *
 */


public class ConversionServiceClient {

	/**
	 * 
	 */
	
	static final String REST_URI = "http://localhost:8080/RestJerseyWS";
	static final String MILES_TO_METERS = "/ConversionService/MilesToMeters/";
	static final String METERS_TO_MILES = "/ConversionService/MetersToMiles/";
	
	public ConversionServiceClient() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		 
		int miles=100;
		int metros=100;
 
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(REST_URI);
 
		WebResource addService = service.path("rest").path(MILES_TO_METERS+miles);
		System.out.println("MILES_TO_METERS Response: " + getResponse(addService));
		System.out.println("MILES_TO_METERS Output as XML: " + getOutputAsXML(addService));
		System.out.println("---------------------------------------------------");
 
		WebResource subService = service.path("rest").path(METERS_TO_MILES+metros);
		System.out.println("FEET_TO_INCH Response: " + getResponse(subService));
		System.out.println("FEET_TO_INCH Output as XML: " + getOutputAsXML(subService));
		System.out.println("---------------------------------------------------");
 
	}
 
	private static String getResponse(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
 
	private static String getOutputAsXML(WebResource service) {
		return service.accept(MediaType.TEXT_XML).get(String.class);
	}

}
