package sample.bean_validation.jaxrs;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/integration")
public class JaxrsIntegrationResource {
    
    @GET
    public void method(@QueryParam("value") @Pattern(regexp="[A-Z]+") String value) {
    }
    
    @GET @Path("/return") @NotNull
    public String method2() {
        return null;
    }
}
