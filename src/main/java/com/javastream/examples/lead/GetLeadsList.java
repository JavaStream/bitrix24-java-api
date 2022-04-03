package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Lead;

import java.util.List;

/**
 * GetLeadsList.
 *
 * @author javastream
 */
public class GetLeadsList {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        List<Lead> leads = client.leadService().getAll();
        System.out.println(leads);
    }
}