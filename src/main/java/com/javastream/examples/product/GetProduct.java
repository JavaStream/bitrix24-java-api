package com.javastream.examples.product;

import com.javastream.Client;
import com.javastream.entity.Product;

/*  Created by JavaStream   */

public class GetProduct {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
        Client client = new Client("token", "your-account.bitrix24.ru", 1);

        Product product = client.productService().get(4);
    }

}
