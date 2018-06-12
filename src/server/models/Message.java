package server.models;

import java.util.ArrayList;

public class Message {

    public static ArrayList<Message> messages = new ArrayList<>();

    private int messageID;
    private String messageText, datePosted, authorName;

    public Message (int messageID, String messageText, String datePosted, String authorName) {

        this.messageID = messageID;
        this.messageText = messageText;
        this.datePosted = datePosted;
        this.authorName = authorName;

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

    public String getDatePosted() { return datePosted; }

    public void setDatePosted(String datePosted) { this.datePosted = datePosted; }

    public String getAuthorName() { return authorName; }

    public void setAuthorName(String authorName) { this.authorName = authorName; }

    @Override
    public String toString () {

        return "Message{" +
                "messageID=" + messageID +
                ", messageText='" + messageText + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';

    }

}
