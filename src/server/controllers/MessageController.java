package server.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Console;
import server.models.Message;
import server.models.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("message/")                       // message/new
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

        return getMessageList();

    }

    private String getMessageList () {

        JSONArray messageList = new JSONArray();

        for (Message m : Message.messages) {

            messageList.add(m.toJSON());

        }

        return messageList.toString();

    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public String listMessage () {

        Console.log("/message/list - Getting all messages from database");

        String status = MessageService.selectAllInto(Message.messages);

        if (status.equals("OK")) {

            return getMessageList();

        } else {

            JSONObject response = new JSONObject();
            response.put("error", status);

            return response.toString();

        }

    }

}
