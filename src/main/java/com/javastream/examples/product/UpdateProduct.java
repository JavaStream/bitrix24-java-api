package com.javastream.examples.product;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Product;

/**
 * UpdateProduct.
 *
 * @author javastream
 */
public class UpdateProduct {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Product product = client.productService().get(4);
        product.setCode("utr256587");
        product.setName("Super Router");

        client.productService().update(product);
    }
}