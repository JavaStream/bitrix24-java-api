package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.Chat;
import com.javastream.entity.Lead;
import com.javastream.entity.model.chat.User;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.chat.ParamChatUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * ChatService.
 *
 * @author javastream
 */
public class ChatService {

    private Logger logger = LoggerFactory.getLogger(ChatService.class);

    private final static String GET_METHOD = "im.chat.get";
    private final static String MUTE_METHOD = "im.chat.mute";
    private final static String USER_LIST_METHOD = "im.chat.user.list";
    private final static String BUSINESS_USER_LIST_METHOD = "im.user.business.list";
    private final static String ADD_CHAT_METHOD = "im.chat.add";
    private final static String LEAD = "LEAD";
    private final static String SLASH_PATTERN = "|";
    private Chat chat = null;

    public Chat get(Object entity) {
        UriParamsCreator params = new UriParamsCreator();
        logger.info("Initializing chat service");

        if (entity instanceof Lead)
            params = new ParamChatUtils()
                    .paramsForGetChat(LEAD + SLASH_PATTERN + ((Lead) entity).getId().toString());
        JSONObject json = PushRunner.get(params, GET_METHOD);

        if (json != null) {
            JSONObject jsonResult = json.getJSONObject("result");
            Gson gson = new Gson();
            chat = gson.fromJson(jsonResult.toString(), Chat.class);
        }

        return chat;
    }

    public void muteNotifications(Chat chat, String yesOrNot) {
        logger.info("Mute of Notifications: {}", yesOrNot);
        UriParamsCreator params = new ParamChatUtils().paramsForChatNotifications(chat.getId(), yesOrNot);
        PushRunner.post(params, MUTE_METHOD);
    }

    public List<User> getUsers(Chat chat) {
        logger.info("Request to get a list of users from chat: {}", chat);

        UriParamsCreator params = new ParamChatUtils().paramsForGetUsersInChat(chat);
        JSONObject json = PushRunner.get(params, USER_LIST_METHOD);
        JSONArray jsonResult = json.getJSONArray("result");

        List<User> userList = new ArrayList<>();
        for (Object idObj : jsonResult) {
            Integer id = Integer.parseInt(idObj.toString());
            User user = User.builder().id(id).build();
            userList.add(user);
        }

        return userList;
    }

    public List<User> getListBusinessUsers() {
        logger.info("Request to get a list of business users from chat");

        UriParamsCreator params = new ParamChatUtils().paramsForGetBusinessUsersInChat();
        JSONObject json = PushRunner.get(params, BUSINESS_USER_LIST_METHOD);
        JSONArray jsonResult = json.getJSONArray("result");

        List<User> userList = new ArrayList<>();
        for (Object idObj : jsonResult) {
            Integer id = Integer.parseInt(idObj.toString());
            User user = User.builder().id(id).build();
            userList.add(user);
        }

        return userList;
    }

    public void createChat(Chat chat, Lead lead, List<User> users) {
        if (chat.getMessage() != null) {
            logger.info("New chat {} was created", chat.getId());

            UriParamsCreator params = new ParamChatUtils().paramsForCreateChat(chat, lead, users);
            PushRunner.post(params, ADD_CHAT_METHOD);
        } else {
            logger.warn("The created Chat must contain a message. This is a required field! It can be done like this: chat.setMESSAGE(\"Your message..\")");
        }
    }
}
