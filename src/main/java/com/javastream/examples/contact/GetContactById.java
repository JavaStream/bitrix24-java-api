package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Contact;

/**
 * GetContactById.
 *
 * @author javastream
 */
public class GetContactById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Contact contact = client.contactService().get(74);
    }
}