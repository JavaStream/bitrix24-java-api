package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Contact;
import com.javastream.entity.types.TypeIdContact;

/**
 * CreateNewContact.
 *
 * @author javastream
 */
public class CreateNewContact {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Contact contact = new Contact("Robert", "Klein");

        contact.setTypeId(TypeIdContact.CLIENT.getCode());
        contact.setAddress("USA, Delaware");
        contact.setComments("best contact");
        contact.setCompanyId("2");

        client.contactService().add(contact);
    }
}