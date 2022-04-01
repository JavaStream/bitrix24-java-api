package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.types.*;

/*  Created by JavaStream   */


public class CreateNewContact {

    public void start()  {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("token", "your-account.bitrix24.ru", 1);

        // Создаем новую карточку клиента и заполняем ее поля
        Contact contact = new Contact("Роберт", "Кейн");

        // Тип контакта - > в Type_id_contact можно выбрать 1 из 4 вариантов
        contact.setTypeId(TypeIdContact.CLIENT.getCode());

        // Сохраняем созданный контакт в CRM
        client.contactService().add(contact);

    }

}
