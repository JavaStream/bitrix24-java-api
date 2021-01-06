package com.javastream.examples.productSection;

import com.javastream.Client;
import com.javastream.entity.ProductSection;

/*  Created by JavaStream   */

public class UpdateProductSection {

    public void start() {

         // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

        ProductSection productSection = client.getProductSectionService().getProductSection(2);
        productSection.setNAME("VIP");
        client.getProductSectionService().updateProductSection(productSection);
    }

}
