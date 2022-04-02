package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.configs.Configs;

/**
 * DeleteContactById.
 *
 * @author javastream
 */
public class DeleteContactById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        client.contactService().delete(72);
    }
}