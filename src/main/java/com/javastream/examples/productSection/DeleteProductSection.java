package com.javastream.examples.productSection;

import com.javastream.Client;
import com.javastream.configs.Configs;

/**
 * DeleteProductSection.
 *
 * @author javastream
 */
public class DeleteProductSection {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        client.productSectionService().delete(2);
    }
}