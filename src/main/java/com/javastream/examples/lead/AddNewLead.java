package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.entity.Lead;
import com.javastream.entity.model.Phone;
import com.javastream.entity.types.PhoneType;
import com.javastream.entity.types.SourceIdType;

import java.util.ArrayList;
import java.util.List;

/*  Created by JavaStream   */


public class AddNewLead {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

        // Создание ного Лида
        Lead lead = new Lead();
        lead.setTitle("Test2");
        lead.setSourceId(SourceIdType.ADVERTISING.getCode());
        lead.setAddress("England, Rosenberg str, 100");
        Phone phone = Phone.builder()
                .value("89110225686").valueType(PhoneType.HOME.getCode()).build();
        List<Phone> listPhones = new ArrayList<>();
        listPhones.add(phone);
        lead.setPhones(listPhones);


        // Сохранение Лида
        client.leadService().add(lead);
    }


}
