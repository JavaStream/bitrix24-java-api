package com.javastream.examples.product;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Product;

/**
 * AddProduct.
 *
 * @author javastream
 */
public class AddProduct {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Product product = new Product();
        product.setName("MainRouter");

        client.productService().add(product);
    }
}