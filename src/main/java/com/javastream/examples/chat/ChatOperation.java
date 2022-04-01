package com.javastream.examples.chat;

import com.javastream.Client;
import com.javastream.entity.Chat;
import com.javastream.entity.Lead;
import com.javastream.entity.model.chat.User;
import com.javastream.entity.types.ChatColorType;

import java.util.*;

/*  Created by JavaStream   */

public class ChatOperation {

    public void start() {

        Client client = new Client("2d3gjcvoqtccq5al", "b24-v12wfp.bitrix24.ru", 1);
        Lead lead = client.leadService().get(2);
        System.out.println(lead);
        Chat chat = client.chatService().get(lead);
        System.out.println(chat);
        List<User> userList = client.chatService().getUsers(chat);
        System.out.println(userList);
        Chat chatNew = new Chat();
        chatNew.setColor(ChatColorType.AZURE.getCode());
        chatNew.setDescription("Conversation with a client #40");
        chatNew.setMessage("Hello customer #40!");
        chatNew.setTitle("Customer " + lead.getTitle());
        client.chatService().createChat(chatNew, lead, userList);

    }



    //@PostConstruct
    public void run() {
        start();
    }

}



















/*

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        //Client client = new Client("token", "your-account.bitrix24.ru");
 /*
        Client client = new Client("mlqg5ktzo5pd2244", "b24-v12wfp.bitrix24.ru", 1);

        Lead lead = client.getLeadService().getLeadById(40);
        System.out.println(lead.getTITLE());




        String formattedDate = date2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("formattedDate = " + formattedDate);

        DateTimeFormatter dateFormatterNew = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        //String dateStringNew = DateTimeFormatter.ofPattern("dd.MM.yyyy").toString();
        //LocalDate date = LocalDate.parse(formattedDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

*/






//Chat chat = client.getChatService().getChat(lead);


/*
        // Turn off chat notifications (use the ChatNotifications_type)
        client.getChatService().muteNotifications(chat, ChatNotifications_type.YES.getCode());

        // Get a list o users in this chat
        //List<User> userList = client.getChatService().getUsers(chat);

        // Get a list of all business users
        List<User> userList = client.getChatService().getListBusinessUsers();
        System.out.println(userList);

        // You can add other users (you mast now an ID of users)
        List<User> userList = new ArrayList<>();
        User user1 = User.builder().id(1).build();
        User user2 = User.builder().id(4).build();
        userList.add(user1);
        userList.add(user2);


        // Adding a new chat for Lead = 40. The field MESSAGE cannot be empty!
        Chat chatNew = new Chat();
        chatNew.setCOLOR(ChatColors_type.AZURE.getCode());
        chatNew.setDESCRIPTION("Conversation with a client #40");
        chatNew.setMESSAGE("Hello customer #40!");
        chatNew.setTITLE("Customer " + lead.getTITLE());

        client.getChatService().createChat(chatNew, lead, userList);



        List<User> userList = client.getChatService().getListBusinessUsers();
        System.out.println("userList = " + userList);
*/