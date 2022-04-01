package com.javastream.examples.productSection;

import com.javastream.Client;
import com.javastream.entity.ProductSection;

/*  Created by JavaStream   */

public class GetProductSection {

    public void start() {

         // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

         ProductSection productSection = client.productSectionService().get(2);

    }

}
