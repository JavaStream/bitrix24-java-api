package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.configs.Configs;

/**
 * DeleteLeadById.
 *
 * @author javastream
 */
public class DeleteLeadById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        client.leadService().delete(8);
    }
}