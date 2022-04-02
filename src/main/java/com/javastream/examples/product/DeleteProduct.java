package com.javastream.examples.product;

import com.javastream.Client;
import com.javastream.configs.Configs;

/**
 * DeleteProduct.
 *
 * @author javastream
 */
public class DeleteProduct {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        client.productService().delete(6);
    }
}