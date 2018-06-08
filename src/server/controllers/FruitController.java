package server.controllers;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruit")
public class FruitController {

    @POST
    @Produces(MediaType.TEXT_PLAIN)

    public String fruitHandler (@FormParam("chosenFruit") String chosenFruit) {

        return "You have chosen " + chosenFruit + "!";

    }

}
