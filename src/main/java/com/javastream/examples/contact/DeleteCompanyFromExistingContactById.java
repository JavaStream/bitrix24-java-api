package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.configs.Configs;

/**
 * DeleteCompanyFromExistingContactById.
 *
 * @author javastream
 */
public class DeleteCompanyFromExistingContactById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        client.contactService().deleteCompanyFromExistingContactById(74, 2);
    }
}
