package com.javastream.lead;

import com.javastream.Client;
import com.javastream.entity.ProductSection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ProductSectionTest.
 *
 * @author javastream
 */
public class ProductSectionTest {

    private final Client client = new Client(
            Configs.token,
            Configs.account,
            Configs.restId
    );

    @DisplayName("ProductSection.getProductSectionById()")
    @Test
    void testGetProductSectionById() {
        ProductSection productSection = client.productSectionService().get(8);

        assertEquals(8, productSection.getId());
    }
}
