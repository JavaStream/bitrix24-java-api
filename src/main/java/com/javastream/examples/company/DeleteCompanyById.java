package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.configs.Configs;

/**
 * DeleteCompanyById.
 *
 * @author javastream
 */
public class DeleteCompanyById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        client.companyService().delete(4);
    }
}