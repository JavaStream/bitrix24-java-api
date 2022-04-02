package com.javastream.examples.productSection;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.ProductSection;

/**
 * UpdateProductSection.
 *
 * @author javastream
 */
public class UpdateProductSection {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        ProductSection productSection = client.productSectionService().get(2);
        productSection.setName("VIP");

        client.productSectionService().update(productSection);
    }
}