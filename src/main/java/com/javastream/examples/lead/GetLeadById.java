package com.javastream.examples.lead;

import com.javastream.Client;
import com.javastream.entity.Lead;

/*  Created by JavaStream   */
public class GetLeadById {

    public static void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        //Client client = new Client("token", "your-account.bitrix24.ru", 1);
        Client client = new Client("7c26pkalmsskbaf6", "b24-ensbt0.bitrix24.ru", 1);

        // Получаем Лид по его ID
        Lead lead = client.leadService().get(2);
        lead.setAssignedById("1");
        System.out.println(lead);

    }

    public static void main(String[] args) {
        start();
    }
}


/*

    BigDecimal bigDecimal = new BigDecimal(454545454.56);
    lead.setOPPORTUNITY("0,35435");
    lead.add_opportunity("1,35435");
    client.getLeadService().updateLead(lead);
*/