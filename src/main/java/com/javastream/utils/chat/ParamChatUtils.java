package com.javastream.utils.chat;

import com.javastream.entity.Chat;
import com.javastream.entity.Lead;
import com.javastream.entity.model.chat.User;
import com.javastream.uriParamsCreator.UriParamsCreator;

import java.net.URLEncoder;
import java.util.List;


/**
 * ParamChatUtils.
 *
 * @author javastream
 */
public class ParamChatUtils {
    private final static String ENTITY_ID = "ENTITY_ID";
    private final static String ENTITY_TYPE = "ENTITY_TYPE";
    private final static String CHAT_ID = "CHAT_ID";
    private final static String MUTE = "MUTE";
    private final static String USER_DATA = "USER_DATA";
    private final static String MESSAGE = "MESSAGE";
    private final static String USERS = "USERS";
    private final static String COLOR = "COLOR";
    private final static String TITLE = "TITLE";
    private final static String DESCRIPTION = "DESCRIPTION";
    private final static String LEAD = "LEAD";
    private final static String SPACE_PARAM = "%20";
    private final static String CRM_TYPE = "CRM";
    private final static String N_TYPE = "N";
    private final static String PIPELINE_PATTERN = "|";

    public UriParamsCreator paramsForGetChat(String entityName) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ENTITY_ID, check(entityName));
        params.put(ENTITY_TYPE, CRM_TYPE);
        params.build();
        return params;
    }

    public UriParamsCreator paramsForChatNotifications(String chatId, String yesOrNot) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(CHAT_ID, chatId);
        params.put(MUTE, yesOrNot);
        params.build();
        return params;
    }

    public UriParamsCreator paramsForGetUsersInChat(Chat chat) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(CHAT_ID, chat.getId());
        params.build();
        return params;
    }

    public UriParamsCreator paramsForGetBusinessUsersInChat() {
        UriParamsCreator params = new UriParamsCreator();
        params.put(USER_DATA, N_TYPE);
        params.build();
        return params;
    }

    public UriParamsCreator paramsForCreateChat(Chat chat, Lead lead, List<User> users) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ENTITY_TYPE, CRM_TYPE);
        params.put(MESSAGE, check(chat.getMessage()));
        params.put(USERS, check(getList(users).toString()));
        params.put(ENTITY_ID, check(LEAD + PIPELINE_PATTERN + lead.getId()));
        params.put(COLOR, chat.getColor());
        params.put(TITLE, check(chat.getTitle()));
        params.put(DESCRIPTION, check(chat.getDescription()));
        params.build();
        return params;
    }

    private String check(String field) {
        if (field == null) {
            return SPACE_PARAM;
        } else {
            return URLEncoder.encode(field.toString());
        }
    }


    private StringBuilder getList(List<User> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (User user : list) {
            builder.append(user.getId());
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("]");

        return builder;
    }
}