package net.barecode.howto.java.rest.objects;

/**
 * Extremely simple public field style POJO.
 * <p>
 * This POJO will be set created and initialized transparently by
 * the underlying JSON conversion provided by the jaxrs-2.0 feature.
 * 
 * @author barecode
 */
public class HelloPOJO {
	public String hello;
	
	/**
	 * Construct the HelloPOJO with given name.
	 * <p>
	 * No default constructor is provided. It is not required
	 * as the underlying JSON conversion provided by the jaxrs-2.0 feature
	 * will not attempt to construct it.
	 * 
	 * @param name The name to say hello to!
	 */
	public HelloPOJO(String name) {
		this.hello = name;
	}
}
