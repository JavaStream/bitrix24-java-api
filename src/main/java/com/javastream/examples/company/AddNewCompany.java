package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.entity.Company;

/*  Created by JavaStream   */

public class AddNewCompany {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

        // Создание ного Лида
        Company company = new Company();

        // Сохранение Лида
        client.companyService().add(company);
    }

}
