package com.javastream.examples.contact;

import com.javastream.Client;
import com.javastream.entity.Contact;
import com.javastream.entity.model.Phone;
import com.javastream.entity.types.Phone_type;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/*  Created by JavaStream   */

//@Component
public class UpdateContact {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("wovpq8bg7tq7of0b", "b24-v12wfp.bitrix24.ru", 1);

        //Получаем карточку клиента по ID контакта
        Contact contact = client.getContactService().getContactById(2);

        // Простые поля типа String можно просто засетить новые данные
        contact.setCOMPANY_ID("2");
        contact.setNAME("Джон");

        //В множественные поля, содержащие в себе списки, вносятся иначе (напримере, телефона)
        // 1. Добавить новый телефон. Не укаызваем ID и ID_Type (будут присвоены самой CRM)
        List<Phone> listPhone = new ArrayList<>();
        Phone phone = Phone.builder()
                .VALUE("601-00-00").VALUE_TYPE(Phone_type.MOBILE.getCode()).build();
        listPhone.add(phone);
        contact.setPHONE(listPhone);
        client.getContactService().updateContact(contact);


        // 2. Изменить существующий телефон (Получаем объект Phone, сетим новые значения Value и(или) Value_type и делаем update)
        Phone phone2 = contact.getPHONE().get(0);
        phone2.setVALUE("222-22-22");
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone2);
        contact.setPHONE(phoneList);
        client.getContactService().updateContact(contact);
    }

    //@PostConstruct
    public void run() {
        start();
    }

}
