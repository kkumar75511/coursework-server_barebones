package server.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloController {

    @GET
    @Produces(MediaType.TEXT_HTML)

    public String helloWorld () {

        return "<html><body><p>Hello World!</p></body></html>";

    }

}
