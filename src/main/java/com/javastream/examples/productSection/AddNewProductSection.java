package com.javastream.examples.productSection;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.ProductSection;

/**
 * AddNewProductSection.
 *
 * @author javastream
 */
public class AddNewProductSection {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        ProductSection productSection = new ProductSection();
        productSection.setSectionId(12); // Main category

        client.productSectionService().add(productSection);
    }
}