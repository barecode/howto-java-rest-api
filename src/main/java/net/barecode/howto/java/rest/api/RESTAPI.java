package net.barecode.howto.java.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.barecode.howto.java.rest.objects.HelloPOJO;
import net.barecode.howto.java.rest.objects.PayloadPOJO;
import net.barecode.howto.java.rest.objects.TimePOJO;

/**
 * Sample REST API using JAX-RS 2.0
 * <p>
 * This is by no means a complete sample, but it is intended to provide
 * a very simple set of referenceable methods to get started.
 * 
 * @author barecode
 */
@Path("/")
public class RESTAPI {
	
	/**
	 * Static container of the payload which a POST call and re-write.
	 * This needs to be static, because the RESTAPI object will be created
	 * to handle each invocation and it needs to be shared across the
	 * instances.
	 */
	private static PayloadPOJO payload = new PayloadPOJO();

	/**
	 * Simple GET method to return a simple text/plain response.
	 * @param name The ?name= parameter. Will be {@code null} if not set.
	 * @return A simple "hello, world" style string
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@QueryParam("name") String name) {
		if (name == null) {
			name = "world";
		}
		return "Hello, " + name;
	}

	/**
	 * Simple GET method to return a simple application/json response.
	 * @param name The ?name= parameter. Will be {@code null} if not set.
	 * @return A HelloPOJO pojo which will return JSON like { "hello": "world" }
	 */
	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public HelloPOJO sayHelloJSON(@QueryParam("name") String name) {
		if (name == null) {
			name = "world";
		}
		return new HelloPOJO(name);
	}
	
	/**
	 * Simple GET method to return an application/json response.
	 * @return A TimePOJO formatted in JSON
	 */
	@GET
	@Path("time")
	@Produces(MediaType.APPLICATION_JSON)
	public TimePOJO getTime() {
		return new TimePOJO();
	}
	
	/**
	 * Simple GET method which captures a path param and feeds it into
	 * the TimePOJO, wich is returned as an application/json response.
	 * @return A TimePOJO formatted in JSON
	 */
	@GET
	@Path("time/{qualifier}")
	@Produces(MediaType.APPLICATION_JSON)
	public TimePOJO getTime(@PathParam("qualifier") String qualifier) {
		return new TimePOJO(qualifier);
	}
	
	/**
	 * GET method to return the PayloadPOJO as application/json.
	 * @return The current PayloadPOJO
	 */
	@GET
	@Path("payload")
	@Produces(MediaType.APPLICATION_JSON)
	public PayloadPOJO getPayload() {
		return payload;
	}
	
	/**
	 * POST method to set the PayloadPOJO, input as application/json.
	 * @param payload The new PayloadPOJO
	 */
	@POST
	@Path("payload")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setPayload(PayloadPOJO payload) {
		RESTAPI.payload = payload;
	}
}
