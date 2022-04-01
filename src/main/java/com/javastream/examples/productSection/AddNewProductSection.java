package com.javastream.examples.productSection;

import com.javastream.Client;
import com.javastream.entity.ProductSection;

/*  Created by JavaStream   */

public class AddNewProductSection {

    public void start() {

         // Инициализация клиента (вебхук токен и аккаунт CRM)
       Client client = new Client("token", "your-account.bitrix24.ru", 1);

        ProductSection productSection = new ProductSection();
        productSection.setSectionId(12); // Main category

        client.productSectionService().add(productSection);
    }

}
