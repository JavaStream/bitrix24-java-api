package com.javastream.examples.company;

import com.javastream.Client;
import com.javastream.entity.Company;
import com.javastream.entity.types.Company_type;
import com.javastream.entity.types.Employees_type;
import com.javastream.entity.types.Industry_type;

/*  Created by JavaStream   */

public class AddNewCompany {

    public void start() {

        // Инициализация клиента (вебхук токен и аккаунт CRM)
         Client client = new Client("token", "your-account.bitrix24.ru", 1);

        // Создание ного Лида
        Company company = new Company();
        company.add_companyTitle("LLT Prizma");
        company.add_companyType(Company_type.PARTNER);
        company.add_employeesType(Employees_type.FROM_250_TO_500);
        company.add_industryType(Industry_type.BANKING);

        // Сохранение Лида
        client.getCempanyService().addNewCompany(company);
    }

}
