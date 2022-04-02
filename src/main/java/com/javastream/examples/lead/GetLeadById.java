package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Lead;

/**
 * GetLeadById.
 *
 * @author javastream
 */
public class GetLeadById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Lead lead = client.leadService().get(2);
        System.out.println(lead);
    }
}