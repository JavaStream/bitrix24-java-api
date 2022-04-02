# Bitrix24 Java API 

---

<p align="center">
<sup>
<b> This Java project is designed to be simple and efficient. Now you can work with **CRM Bitrix24.ru** using our API, that provide good functionality. 
Essentially, API provided work with Contact, Lead, Company, Product, Product Section and Chat. If you have any questions send me an email: javastream.msn@gmail.com  </b> 
</sup>
</p>

---


[![Latest Version](https://img.shields.io/github/release/JavaStream/bitrix24-java-api.svg?style=flat-square)](https://github.com/releases)
[![GitHub contributors][contributors-image]][contributors-url]
[![HitCount](http://hits.dwyl.io/JavaStream/bitrix24-java-api.svg)](http://hits.dwyl.io/JavaStream/bitrix24-java-api)
[![Total Downloads](https://img.shields.io/github/downloads/JavaStream/bitrix24-java-api/total.svg)](https://github.com/JavaStream/bitrix24-java-api/releases)


[contributors-url]: https://github.com/JavaStream/bitrix24-java-api/graphs/contributors
[contributors-image]: https://img.shields.io/github/contributors/JavaStream/bitrix24-java-api.svg



QUICK START
------------

>Step 1. Add dependency:

**For Maven project:**

``` XML
<repositories>
	<repository>
	   <id>jitpack.io</id>
	   <url>https://jitpack.io</url>
    </repository>
</repositories>
```

``` XML
<dependency>
    <groupId>com.github.JavaStream</groupId>
    <artifactId>bitrix24-java-api</artifactId>
    <version>v2022.1</version>
</dependency>
```


**For Gradle project:**

``` XML
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```


``` XML
dependencies {
    implementation 'com.github.JavaStream:bitrix24-java-api:1.3'
}
```



>Step 2. Create an account and webhook token

![Screenshot](screen_2.gif)


>Step 3. Init Client in your project.
You need insert yours Token, bitrix-account and rest_id. It's easy!

```Java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru", rest_id);

```


EXAMPLES
-----------

**Contact**  

```java
// 1. CREATE (name and lastname are mandatory fields)
Contact contact = new Contact("Robert", "Kane"); 
contact.setTypeId(TypeIdContact.CLIENT.getCode());
contact.setPhones(phoneList);
contact.setAddress("USA, Delaware");
contact.setComments("best contact");
contact.setCompanyId("2");
client.contactService().add(contact);

// 2. GET
Contact contact = client.contactService().get(74);

// 3. DELETE
client.contactService().delete(72);

// 4. UPDATE
contact.setCompanyId("2");
contact.setName("Джон");
client.contactService().update(contact);
```


**Lead**

```java
// 1. CREATE	
Lead lead = new Lead();
lead.setTitle("Test2");
lead.setSourceId(SourceIdType.ADVERTISING.getCode());
lead.setAddress("England, Rosenberg str, 100");
Phone phone = Phone.builder()
		.value("89110225686")
		.valueType(PhoneType.HOME.getCode())
		.build();
List<Phone> listPhones = new ArrayList<>();
listPhones.add(phone);
lead.setPhones(listPhones);
client.leadService().add(lead);

// 2. GET
Lead lead = client.leadService().get(2);

// 3. DELETE
client.leadService().delete(8);

// 4. UPDATE
lead.setName("Albert");
lead.setLastName("Shtein");
lead.setAddress("West Olympic Boulevard Apt. 100");
lead.setComments("Interested in price");
lead.setStatusId(StatusIdType.NEW.getCode());
lead.setCurrencyId(CurrencyIdType.EUR.getCode());
lead.setSourceId(SourceIdType.RECOMMENDATION.getCode());
client.leadService().update(lead);
```

**Company**

```java
//1. CREATE
Company company = new Company();
company.setAddress("USA, Delaware");
company.setTitle("This is title"); 
client.companyService().add(company);

//2. GET
Company company = client.companyService().get(2);

//3. DELETE
client.companyService().delete(4);

//4. UPDATE
company.setBankingDetails("r/s 40702810865698252");
company.setCompanyType(CompanyType.SUPPLIER.getCode());
company.setAddress("Olympic Boulevard Apt. 120");
company.setComments("Interested in price");
client.companyService().update(company);
```

**Product**
```java
// CREATE
Product product = new Product();
product.setName("MainRouter");
client.productService().add(product);

// GET, DELETE, UPDATE 
Product product = client.productService().get(4);
client.productService().delete(6);
client.productService().update(product);
```

**Product Section**
```java
// Create
ProductSection productSection = new ProductSection();
productSection.setSectionId(12); // Main category 
client.productSectionService().add(productSection);

// Get, Delete and Update 
ProductSection productSection = client.productSectionService().get(2);
client.productSectionService().delete(2);
client.productSectionService().update(productSection);
```

**Chats with a Leads**

Soon we will add functionality for working with dialogs and messages.

```java

Lead lead = client.getLeadService().getLeadById(42);                                      // Get a Lead (for example, id = 42)
Chat chat = client.getChatService().getChat(lead);                                        // Get the chat whith this Lead
List<User> userList = client.getChatService().getUsers(chat);                             // Get the list of users in this chat 
List<User> userList = client.getChatService().getListBusinessUsers();                     // Get a list of all business users
client.getChatService().muteNotifications(chat, ChatNotifications_type.YES.getCode());    // Turn off chat notifications 

// Adding a new chat for Lead = 42. The field MESSAGE cannot be empty!
Chat chatNew = new Chat();
chatNew.setCOLOR(ChatColors_type.AZURE.getCode());
chatNew.setDESCRIPTION("Conversation with a client #42");
chatNew.setMESSAGE("Hello customer #42!");
chatNew.setTITLE("Customer " + lead.getTITLE());

client.getChatService().createChat(chatNew, lead, userList);

```

