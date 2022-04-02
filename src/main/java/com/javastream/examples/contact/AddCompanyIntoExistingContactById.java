package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Contact;

/**
 * AddCompanyIntoExistingContactById.
 *
 * @author javastream
 */
public class AddCompanyIntoExistingContactById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Contact contact = client.contactService().get(74);
        contact.setCompanyId("2");

        client.contactService().addCompanyIntoExistingContactById(74, 2);
    }
}