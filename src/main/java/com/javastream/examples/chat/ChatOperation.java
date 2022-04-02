package com.javastream.examples.chat;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Chat;
import com.javastream.entity.Lead;
import com.javastream.entity.model.chat.User;
import com.javastream.entity.types.ChatColorType;

import java.util.List;

/**
 * ChatOperation.
 *
 * @author javastream
 */
public class ChatOperation {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Lead lead = client.leadService().get(2);
        Chat chat = client.chatService().get(lead);
        List<User> userList = client.chatService().getUsers(chat);

        Chat chatNew = new Chat();
        chatNew.setColor(ChatColorType.AZURE.getCode());
        chatNew.setDescription("Conversation with a client #40");
        chatNew.setMessage("Hello customer #40!");
        chatNew.setTitle("Customer " + lead.getTitle());
        client.chatService().createChat(chatNew, lead, userList);
    }
}