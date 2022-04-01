package com.javastream.examples.productSection;

import com.javastream.Client;

/*  Created by JavaStream   */

public class DeleteProductSection {

    public void start() {

         // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

        client.productSectionService().delete(2);
    }

}
