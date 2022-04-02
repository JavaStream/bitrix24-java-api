package com.javastream.examples.product;

import com.javastream.Client;
import com.javastream.entity.Product;

/*  Created by JavaStream   */

public class AddProduct {

    public void start() {

         // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

        Product product = new Product();
        product.setName("MainRouter");
        client.productService().add(product);
    }

}
