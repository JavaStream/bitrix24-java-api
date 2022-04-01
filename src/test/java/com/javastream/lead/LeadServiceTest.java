package com.javastream.lead;

import com.javastream.Client;
import com.javastream.entity.Lead;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * LeadServiceTest.
 *
 * @author javastream
 */
public class LeadServiceTest {

    private final Client client = new Client(
            Configs.token,
            Configs.account,
            Configs.restId
    );

    @DisplayName("LeadService.getLeadById()")
    @Test
    void testGetLeadById() {
        Lead lead = client.leadService().get(2);

        assertEquals(2, lead.getId());
    }

    @DisplayName("LeadService.getLeadById()")
    @Test
    void testUpdateLeadById() {
        Lead leadBefore = client.leadService().get(2);
        leadBefore.setName("Albert2");
        leadBefore.setLastName("Shtein");
        leadBefore.setAddress("West Olympic Boulevard Apt. 100");
        leadBefore.setComments("Interested in price");
        leadBefore.setStatusId(StatusIdType.NEW.getCode());
        leadBefore.setCurrencyId(CurrencyIdType.EUR.getCode());
        leadBefore.setSourceId(SourceIdType.RECOMMENDATION.getCode());

        List<Email> listEmail = new ArrayList<>();
        Email email = Email.builder()
                .value("albert@gmail.com").valueType(EmailType.PRIVATE.getCode()).build();
        listEmail.add(email);
        leadBefore.setEmails(listEmail);

        List<Website> webs = leadBefore.getWebsites();
        if (webs == null) {
            Website website = Website.builder()
                    .id("111")
                    .value("www.albert-best.org")
                    .valueType(WebsiteType.OTHER.getCode())
                    .build();

        } else  {
            Website website = leadBefore.getWebsites().get(0);
            website.setValue("www.albert-best.org");
            website.setValueType(WebsiteType.OTHER.getCode());
            webs.add(website);
            leadBefore.setWebsites(webs);
        }

        client.leadService().update(leadBefore);

        Lead leadAfter = client.leadService().get(2);

        assertEquals(leadBefore.getName(), leadAfter.getName());
        assertEquals(leadBefore.getLastName(), leadAfter.getLastName());
        assertEquals(leadBefore.getAddress(), leadAfter.getAddress());
        assertEquals(leadBefore.getComments(), leadAfter.getComments());
        assertEquals(leadBefore.getStatusId(), leadAfter.getStatusId());
        assertEquals(leadBefore.getCurrencyId(), leadAfter.getCurrencyId());
        assertEquals(leadBefore.getSourceId(), leadAfter.getSourceId());
    }
}
