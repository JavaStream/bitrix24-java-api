package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.entity.Company;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.Company_type;
import com.javastream.entity.types.Email_type;
import com.javastream.entity.types.Website_type;

import java.util.ArrayList;
import java.util.List;

/*  Created by JavaStream   */

public class UpdateCompany {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        //Client client = new Client("token", "your-account.bitrix24.ru");
        Client client = new Client("axllvq7czan4cnmr", "b24-v12wfp.bitrix24.ru", 1);


        // Получаем Лид по его ID
        Company company = client.getCempanyService().getCompanyById(2);

        // Простые поля типа String можно просто засетить новые данные
        company.setBANKING_DETAILS("r/s 40702810865698252");
        company.setCOMPANY_TYPE(Company_type.SUPPLIER.getCode());
        company.setADDRESS("Olympic Boulevard Apt. 120");
        company.setCOMMENTS("Interested in price");


        //В множественные поля, содержащие в себе списки, вносятся иначе (напримере, телефон, email, мессенджер, Сайт)
        // 1. Добавить новый Email. Не укаызваем ID и ID_Type (будут присвоены самой CRM)
        List<Email> listEmail = new ArrayList<>();
        Email email = Email.builder()
                .VALUE("srtur12@gmail.com").VALUE_TYPE(Email_type.PRIVATE.getCode()).build();
        listEmail.add(email);
        company.setEMAIL(listEmail);
        client.getCempanyService().updateCompany(company);


        // 2. Изменить существующий Сайт (Получаем объект WEB, сетим новые значения Value и(или) Value_type и делаем update)
        Website website = company.getWEB().get(0);
        website.setVALUE("www.albert12.org");
        website.setVALUE_TYPE(Website_type.OTHER.getCode());
        List<Website> websitList = new ArrayList<>();
        websitList.add(website);
        company.setWEB(websitList);
        client.getCempanyService().updateCompany(company);

    }
}
