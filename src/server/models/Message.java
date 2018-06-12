package server.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Message {

    public static ArrayList<Message> messages = new ArrayList<>();

    private int messageID;
    private String messageText, datePosted, authorName;

    public Message (int messageID, String messageText, String messageDate, String messageAuthor) {

        this.messageID = messageID;
        this.messageText = messageText;
        this.datePosted = messageDate;
        this.authorName = messageAuthor;

    }

    public static int nextID () {

        int id = 0;

        for (int i = 0; i < messages.size(); i++) {

            if (messages.get(i).getMessageID() > id) {

                id = messages.get(i).getMessageID();

            }

        }

        return id + 1;

    }

    public int getMessageID () { return messageID; }

    public void setMessageID (int messageID) { this.messageID = messageID; }

    public String getMessageText() { return messageText; }

    public void setMessageText(String messageText) { this.messageText = messageText; }

    public String getMessageDate() { return datePosted; }

    public void setMessageDate(String datePosted) { this.datePosted = datePosted; }

    public String getMessageAuthor() { return authorName; }

    public void setMessageAuthor(String authorName) { this.authorName = authorName; }

    @Override
    public String toString () {

        return "Message{" +
                "messageID=" + messageID +
                ", messageText='" + messageText + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';

    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON () {

        JSONObject j = new JSONObject();
        j.put("id", getMessageID());
        j.put("text", getMessageText());
        j.put("postDate", getMessageDate());
        j.put("author", getMessageAuthor());
        return j;

    }

}
