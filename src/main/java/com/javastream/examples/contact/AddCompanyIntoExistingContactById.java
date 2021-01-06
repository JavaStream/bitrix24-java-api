package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.entity.Contact;

/*  Created by JavaStream   */

public class AddCompanyIntoExistingContactById {

    public void start() {
        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("token", "your-account.bitrix24.ru", 1);

        //Получаем карточку клиента по ID контакта
        Contact contact = client.getContactService().getContactById(74);

        // Первый способ - сетим поле COMPANY_ID. Здесь ID уже созданной в CRM компании
        contact.setCOMPANY_ID("2");

        // Второй способ
        contact.add_company(2);

    }
}
