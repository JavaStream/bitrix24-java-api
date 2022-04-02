package com.javastream.lead;

import com.javastream.Client;
import com.javastream.entity.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ContractTest.
 *
 * @author javastream
 */
public class ContractTest {

    private final Client client = new Client(
            Configs.token,
            Configs.account,
            Configs.restId
    );

    @DisplayName("ContractService.getContactById()")
    @Test
    void testGetContactById() {
        Contact contact = client.contactService().get(2);

        assertEquals(2, contact.getId());
    }
}
