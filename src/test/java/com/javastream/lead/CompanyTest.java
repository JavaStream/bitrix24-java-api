package com.javastream.lead;

import com.javastream.Client;
import com.javastream.entity.Company;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CompanyTest.
 *
 * @author javastream
 */
public class CompanyTest {

    private final Client client = new Client(
            Configs.token,
            Configs.account,
            Configs.restId
    );

    @DisplayName("CompanyService.getCompanyById()")
    @Test
    void testGetCompanyById() {
        Company company = client.companyService().get(2);

        assertEquals(2, company.getId());
    }
}
