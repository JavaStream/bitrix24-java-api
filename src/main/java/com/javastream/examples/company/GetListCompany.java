package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Company;

import java.util.List;

/**
 * GetListCompany.
 *
 * @author javastream
 */
public class GetListCompany {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        List<Company> companies = client.companyService().getAll();
        System.out.println(companies);
    }
}
