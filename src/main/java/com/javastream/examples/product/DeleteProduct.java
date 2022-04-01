package com.javastream.examples.product;

import com.javastream.Client;

/*  Created by JavaStream   */

public class DeleteProduct {

    public void start() {

         // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

         client.productService().delete(6);
    }

}
