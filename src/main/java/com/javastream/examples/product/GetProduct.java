package com.javastream.examples.product;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Product;

/**
 * GetProduct.
 *
 * @author javastream
 */
public class GetProduct {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Product product = client.productService().get(4);
    }
}