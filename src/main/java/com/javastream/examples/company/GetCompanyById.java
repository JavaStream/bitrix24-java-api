package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Company;

/**
 * GetCompanyById.
 *
 * @author javastream
 */
public class GetCompanyById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Company company = client.companyService().get(2);
        System.out.println("ID = " + company.getId());
    }
}