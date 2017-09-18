package org.sagar.javabrains.messenger.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParametersUsingAnnotations(@MatrixParam("param")String matrixParam,
												@HeaderParam("customHeaderValue") String headerParam,
												@CookieParam("Version") String cookieParam){
		
		return "Matrix param: " + matrixParam+ " Header Param: " + headerParam + " Cookie param : " + cookieParam;
	}
	
	@GET
	@Path("context")
	public String getParametersUsingContext(@Context UriInfo info, @Context HttpHeaders headers){
		String path =info.getAbsolutePath().toString();
		String cookies=headers.getCookies().toString();
		return "Path: " + path + "Cookies : " + cookies;
	}
}
