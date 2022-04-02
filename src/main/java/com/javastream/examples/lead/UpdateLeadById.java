package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Lead;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UpdateLeadById.
 *
 * @author javastream
 */
public class UpdateLeadById {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Lead lead = client.leadService().get(4);

        lead.setName("Albert");
        lead.setLastName("Shtein");
        lead.setAddress("West Olympic Boulevard Apt. 100");
        lead.setComments("Interested in price");
        lead.setStatusId(StatusIdType.NEW.getCode());
        lead.setCurrencyId(CurrencyIdType.EUR.getCode());
        lead.setSourceId(SourceIdType.RECOMMENDATION.getCode());

        // set email
        List<Email> listEmail = new ArrayList<>();
        Email email = Email.builder()
                .value("albert@gmail.com").valueType(EmailType.PRIVATE.getCode()).build();
        listEmail.add(email);
        lead.setEmails(listEmail);
        client.leadService().update(lead);

        // update existing website
        Website website = lead.getWebsites().get(0);
        website.setValue("www.albert-best.org");
        website.setValueType(WebsiteType.OTHER.getCode());
        List<Website> websitList = new ArrayList<>();
        websitList.add(website);
        lead.setWebsites(websitList);

        client.leadService().update(lead);
    }
}