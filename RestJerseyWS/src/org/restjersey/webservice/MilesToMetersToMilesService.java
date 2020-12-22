/**
 * 
 */
package org.restjersey.webservice;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author David
 *
 */
@Path("ConversionService")
public class MilesToMetersToMilesService {

	/**
	 * 
	 */
	
	
	final MathContext returnRules = new MathContext(4, RoundingMode.HALF_DOWN);
	public MilesToMetersToMilesService() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	 @GET
     @Path("/MilesToMeters/{miles}")
      @Produces(MediaType.TEXT_XML)
	public String conversionMilesToMeters(@PathParam("miles") double pmiles) {
		 BigDecimal conversion = new BigDecimal(1609.34);
		 BigDecimal miles = new BigDecimal(pmiles);
		 BigDecimal meters = miles.multiply(conversion,  MathContext.DECIMAL64);
		return "<MilesToMeters>"        		
        		+ "<Miles>" + pmiles + "</Miles>"
        		+ "<Meters>" + meters.doubleValue() + "</Meters>"
        		+ "</MilesToMeters>";
	}
	
	 @GET
     @Path("/MetersToMiles/{meters}")
      @Produces(MediaType.TEXT_XML)
	public String conversionMetersToMiles(@PathParam("meters") double pmeters) {
		 BigDecimal conversion = new BigDecimal(0.00062137);
		 BigDecimal meters = new BigDecimal(pmeters);
		 BigDecimal miles = meters.multiply(conversion, MathContext.DECIMAL64);		
		return "<MetersToMiles>"
	            + "<Meters>" + pmeters + "</Meters>"
	            + "<Miles>" + miles.doubleValue() + "</Miles>"
	            + "</MetersToMiles>";
				
	}

}
