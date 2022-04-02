package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.entity.Company;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.CompanyType;
import com.javastream.entity.types.EmailType;
import com.javastream.entity.types.WebsiteType;

import java.util.ArrayList;
import java.util.List;

/*  Created by JavaStream   */

public class UpdateCompany {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        //Client client = new Client("token", "your-account.bitrix24.ru");
        Client client = new Client("axllvq7czan4cnmr", "b24-v12wfp.bitrix24.ru", 1);


        // Получаем Лид по его ID
        Company company = client.companyService().get(2);

        // Простые поля типа String можно просто засетить новые данные
        company.setBankingDetails("r/s 40702810865698252");
        company.setCompanyType(CompanyType.SUPPLIER.getCode());
        company.setAddress("Olympic Boulevard Apt. 120");
        company.setComments("Interested in price");


        //В множественные поля, содержащие в себе списки, вносятся иначе (напримере, телефон, email, мессенджер, Сайт)
        // 1. Добавить новый Email. Не укаызваем ID и ID_Type (будут присвоены самой CRM)
        List<Email> listEmail = new ArrayList<>();
        Email email = Email.builder()
                .value("srtur12@gmail.com").valueType(EmailType.PRIVATE.getCode()).build();
        listEmail.add(email);
        company.setEmails(listEmail);
        client.companyService().update(company);


        // 2. Изменить существующий Сайт (Получаем объект WEB, сетим новые значения Value и(или) Value_type и делаем update)
        Website website = company.getWebsites().get(0);
        website.setValue("www.albert12.org");
        website.setValueType(WebsiteType.OTHER.getCode());
        List<Website> websitList = new ArrayList<>();
        websitList.add(website);
        company.setWebsites(websitList);
        client.companyService().update(company);

    }
}
