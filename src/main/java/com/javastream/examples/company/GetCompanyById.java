package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.entity.Company;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*  Created by JavaStream   */

//@Component
public class GetCompanyById {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("wovpq8bg7tq7of0b", "b24-v12wfp.bitrix24.ru", 1);


        // Получаем Лид по его ID
        Company company = client.getCempanyService().getCompanyById(2);
        System.out.println("ID = " + company.getID());
    }

    //@PostConstruct
    public void run() {
        start();
    }
}
