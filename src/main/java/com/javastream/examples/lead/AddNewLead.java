package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.configs.Configs;
import com.javastream.entity.Lead;
import com.javastream.entity.model.Phone;
import com.javastream.entity.types.PhoneType;
import com.javastream.entity.types.SourceIdType;

import java.util.ArrayList;
import java.util.List;

/**
 * AddNewLead.
 *
 * @author javastream
 */
public class AddNewLead {

    public static void main(String[] args) {
        Client client = new Client(
                Configs.token,
                Configs.account,
                Configs.restId
        );

        Lead lead = new Lead();

        lead.setTitle("Test2");
        lead.setSourceId(SourceIdType.ADVERTISING.getCode());
        lead.setAddress("England, Rosenberg str, 100");

        Phone phone = Phone.builder()
                .value("79310225686").valueType(PhoneType.HOME.getCode()).build();
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(phone);
        lead.setPhones(listPhones);

        client.leadService().add(lead);
    }
}