# How To: Java REST APIs

This "How To Guide" provides a quick look at defining REST APIs in Java. Using the JAX-RS 2.0 capabilities in Java EE 7, the REST API methods are identified using annotations and the return objects are simple POJOs.

For example, the most simple REST API:

```
@Path("/")
public class RESTAPI {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, world";
	}
}
```


# Prerequisite

This guide presumes knowledge on install and use of the following:
* Gradle
* Liberty
  * Feature apiDiscovery-1.0 is required: `bin/installUtility install apiDiscovery-1.0`
* WebSphere Developer Tools (WDT)


# Build and Deploy

* Step 1 - Build the WAR
  * Run `gradle` to build the WAR in `build/libs/howto-java-rest-api.war`
* Step 2 - Create the server
  * Copy `howto-java-rest-api` to your Liberty servers directory
  * `cp -r howto-java-rest-api/ wlp_user_dir/servers/howto-java-rest-api/`
* Step 3 - Deploy the WAR
  * Create the `dropins` directory in the `howto-java-rest-api`
  * `mkdir wlp_user_dir/servers/howto-java-rest-api/dropin`
  * Move the built WAR into `dropins`
  * `mv build/libs/howto-java-rest-api.war wlp_user_dir/servers/howto-java-rest-api/dropins`
* Step 4 - Start the server
  * `bin/server run howto-java-rest-api`


# Play with it!
`http://localhost:9080/howto-java-rest-api/`

# Defined REST APIs

URL: `http://localhost:9080/howto-java-rest-api/rest(?name=bob)`
Returns: `Hello, bob`

URL: `http://localhost:9080/howto-java-rest-api/rest/json`
Returns: `{"hello":"world"}`

URL: `http://localhost:9080/howto-java-rest-api/rest/time`
Returns: `{"qualifier":"default","time":"Thu Jul 13 10:40:45 CDT 2017"}`

URL: `http://localhost:9080/howto-java-rest-api/rest/time/mike`
Returns: `{"qualifier":"mike","time":"Thu Jul 13 10:41:09 CDT 2017"}`

URL: `http://localhost:9080/howto-java-rest-api/rest/payload`
Returns: `{ }`



# Import into Eclipse

The following are high-level instructions for importing this project into Eclipse

1. Import -> Projects from Git
2. Add `howto-java-rest-api` to your Servers view
3. You may need to modify your `.classpath` entry to point to your Liberty installation



# Acknowledgements

