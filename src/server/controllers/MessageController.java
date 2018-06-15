package server.controllers;

import org.json.simple.JSONArray;
import server.models.Message;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("message/")
public class MessageController {

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)

    public String newMessage (@FormParam("messageText") String messageText,
                                @FormParam("messageAuthor") String messageAuthor) {

        int messageID = Message.nextID();
        String messageDate = new Date().toString();

        Message.messages.add(new Message(messageID, messageText, messageDate, messageAuthor));

        JSONArray messageList = new JSONArray();

        for (Message m : Message.messages) {

            messageList.add(m.toJSON());

        }

        return messageList.toString();

    }

}
