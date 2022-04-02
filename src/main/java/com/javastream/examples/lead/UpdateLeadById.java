package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.entity.Lead;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.*;
import java.util.ArrayList;
import java.util.List;

/*  Created by JavaStream   */

public class UpdateLeadById {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("token", "your-account.bitrix24.ru", 1);

        // Получаем Лид по его ID
        Lead lead = client.leadService().get(4);

        // Простые поля типа String можно просто засетить новые данные
        lead.setName("Albert");
        lead.setLastName("Shtein");
        lead.setAddress("West Olympic Boulevard Apt. 100");
        lead.setComments("Interested in price");
        lead.setStatusId(StatusIdType.NEW.getCode());
        lead.setCurrencyId(CurrencyIdType.EUR.getCode());
        lead.setSourceId(SourceIdType.RECOMMENDATION.getCode());

        //В множественные поля, содержащие в себе списки, вносятся иначе (напримере, телефон, email, мессенджер, Сайт)
        // 1. Добавить новый Email. Не укаызваем ID и ID_Type (будут присвоены самой CRM)
        List<Email> listEmail = new ArrayList<>();
        Email email = Email.builder()
                .value("albert@gmail.com").valueType(EmailType.PRIVATE.getCode()).build();
        listEmail.add(email);
        lead.setEmails(listEmail);
        client.leadService().update(lead);


        // 2. Изменить существующий Сайт (Получаем объект WEB, сетим новые значения Value и(или) Value_type и делаем update)
        Website website = lead.getWebsites().get(0);
        website.setValue("www.albert-best.org");
        website.setValueType(WebsiteType.OTHER.getCode());
        List<Website> websitList = new ArrayList<>();
        websitList.add(website);
        lead.setWebsites(websitList);
        client.leadService().update(lead);

    }
}
