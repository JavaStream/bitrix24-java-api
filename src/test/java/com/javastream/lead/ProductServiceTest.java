package com.javastream.lead;

import com.javastream.Client;
import com.javastream.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ProductServiceTest.
 *
 * @author javastream
 */
public class ProductServiceTest {

    private final Client client = new Client(
            Configs.token,
            Configs.account,
            Configs.restId
    );

    @DisplayName("ProductService.getProductById()")
    @Test
    void testGetProductById() {
        Product product = client.productService().get(2);

        assertEquals(2, product.getId());
    }
}
