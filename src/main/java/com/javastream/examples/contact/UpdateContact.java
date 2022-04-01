package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.model.Phone;
import com.javastream.entity.types.PhoneType;

import java.util.ArrayList;
import java.util.List;

/*  Created by JavaStream   */

//@Component
public class UpdateContact {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("wovpq8bg7tq7of0b", "b24-v12wfp.bitrix24.ru", 1);

        //Получаем карточку клиента по ID контакта
        Contact contact = client.contactService().get(2);

        // Простые поля типа String можно просто засетить новые данные
        contact.setCompanyId("2");
        contact.setName("Джон");

        //В множественные поля, содержащие в себе списки, вносятся иначе (напримере, телефона)
        // 1. Добавить новый телефон. Не укаызваем ID и ID_Type (будут присвоены самой CRM)
        List<Phone> listPhone = new ArrayList<>();
        Phone phone = Phone.builder()
                .value("601-00-00").valueType(PhoneType.MOBILE.getCode()).build();
        listPhone.add(phone);
        contact.setPhones(listPhone);
        client.contactService().update(contact);


        // 2. Изменить существующий телефон (Получаем объект Phone, сетим новые значения Value и(или) Value_type и делаем update)
        Phone phone2 = contact.getPhones().get(0);
        phone2.setValue("222-22-22");
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone2);
        contact.setPhones(phoneList);
        client.contactService().update(contact);
    }

    //@PostConstruct
    public void run() {
        start();
    }

}
