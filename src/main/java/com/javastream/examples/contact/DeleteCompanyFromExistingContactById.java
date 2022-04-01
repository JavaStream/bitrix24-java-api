package com.javastream.examples.contact;

/*  Created by JavaStream   */

import com.javastream.Client;


public class DeleteCompanyFromExistingContactById {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("token", "your-account.bitrix24.ru", 1);

        // Отцепляем указанную компанию от данной карточки контакта
        client.contactService().deleteCompanyFromExistingContactById(74, 2);
    }

}
