package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.entity.Lead;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/*  Created by JavaStream   */

//@Service
public class GetLeadById {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        //Client client = new Client("token", "your-account.bitrix24.ru", 1);
        Client client = new Client("wovpq8bg7tq7of0b", "b24-v12wfp.bitrix24.ru", 1);

        // Получаем Лид по его ID
        Lead lead = client.getLeadService().getLeadById(2);
        lead.setASSIGNED_BY_ID("1");
        //System.out.println(lead);

    }

    //@PostConstruct
    public void run() {
        start();
    }
}


/*

    BigDecimal bigDecimal = new BigDecimal(454545454.56);
    lead.setOPPORTUNITY("0,35435");
    lead.add_opportunity("1,35435");
    client.getLeadService().updateLead(lead);
*/