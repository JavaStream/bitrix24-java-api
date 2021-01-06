package com.javastream;

import com.javastream.configs.Settings;
import com.javastream.service.*;


public class Client {

    public Client(String token, String account, Integer rest_ID) {
        Settings.token = token;
        Settings.account = account;
        Settings.rest_ID = rest_ID;
    }

    public ContactService getContactService() {
        return new ContactService();
    }

    public LeadService getLeadService() {
        return new LeadService();
    }

    public CompanyService getCempanyService() {
        return new CompanyService();
    }

    public ProductSectionService getProductSectionService() {
        return new ProductSectionService();
    }

    public ProductService getProductService() {
        return new ProductService();
    }

    public ChatService getChatService() {
        return new ChatService();
    }

}
