package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Company;

/**
 * AddNewCompany.
 *
 * @author javastream
 */
public class AddNewCompany {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Company company = new Company();
        company.setAddress("USA, Delaware");
        company.setTitle("This is title");

        client.companyService().add(company);
    }
}