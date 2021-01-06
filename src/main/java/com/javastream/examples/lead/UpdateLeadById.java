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
        Lead lead = client.getLeadService().getLeadById(4);

        // Простые поля типа String можно просто засетить новые данные
        lead.setNAME("Albert");
        lead.setLAST_NAME("Shtein");
        lead.setADDRESS("West Olympic Boulevard Apt. 100");
        lead.setCOMMENTS("Interested in price");
        lead.setSTATUS_ID(StatusID_type.NEW.getCode());
        lead.setCURRENCY_ID(CurrencyID_type.EUR.getCode());
        lead.setSOURCE_ID(SourceID_type.RECOMMENDATION.getCode());

        //В множественные поля, содержащие в себе списки, вносятся иначе (напримере, телефон, email, мессенджер, Сайт)
        // 1. Добавить новый Email. Не укаызваем ID и ID_Type (будут присвоены самой CRM)
        List<Email> listEmail = new ArrayList<>();
        Email email = Email.builder()
                .VALUE("albert@gmail.com").VALUE_TYPE(Email_type.PRIVATE.getCode()).build();
        listEmail.add(email);
        lead.setEMAIL(listEmail);
        client.getLeadService().updateLead(lead);


        // 2. Изменить существующий Сайт (Получаем объект WEB, сетим новые значения Value и(или) Value_type и делаем update)
        Website website = lead.getWEB().get(0);
        website.setVALUE("www.albert-best.org");
        website.setVALUE_TYPE(Website_type.OTHER.getCode());
        List<Website> websitList = new ArrayList<>();
        websitList.add(website);
        lead.setWEB(websitList);
        client.getLeadService().updateLead(lead);

    }

}
