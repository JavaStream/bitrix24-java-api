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
        Contact contact = new Contact();

        // Обязательный метод. Без параметров name и lastName карточку не сохранить.
        contact.add_name_and_lastName("Роберт", "Кейн");

        contact.setLAST_NAME("Джонович");

        // Тип контакта - > в Type_id_contact можно выбрать 1 из 4 вариантов
        contact.setTYPE_ID(Type_id_contact.CLIENT.getCode());

        // Поле комментарий
        contact.add_comments("Известная в узких кругах личность");

        // Должность
        contact.add_post("Начальник отдела");

        // Сохраняем созданный контакт в CRM
        client.getContactService().addNewContact(contact);

    }

}
