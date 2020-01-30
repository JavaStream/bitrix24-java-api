# Bitrix24 Java API  [![HitCount](http://hits.dwyl.io/JavaStream/bitrix24-java-api.svg)](http://hits.dwyl.io/JavaStream/bitrix24-java-api)

Java Library for easy work with **CRM Bitrix24.ru** 

Now you can work with:

***- Contact, Lead, Company, Product, Product Section*** 

***- Chat with a Lead*** 

Other features coming soon!

### Connection and functionalities:
I. **Create account and webhook token**
![Screenshot](screen_1.gif)

II. **Add Maven dependency** 
```xml
<repositories>
   <repository>
      <id>bitrix24-java-api-mvn-repo</id>
	  <url>https://raw.github.com/JavaStream/bitrix24-java-api/mvn-repo/</url>
		 <snapshots>
		     <enabled>true</enabled>
			  <updatePolicy>always</updatePolicy>
		 </snapshots>
   </repository>
</repositories>

<dependency>
    <groupId>com.javastream</groupId>
    <artifactId>java-bitrix24-api</artifactId>
    <version>0.6-SNAPSHOT</version>
 </dependency>
  ```

III. **Init Client in your project.**
You need insert yours Token and bitrix-account. It's easy!

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");
```

***Contact***  

```java
// Create a new Contact
Contact contact = new Contact();

// Name and lastName are mandatory fields. Without these parameters, the card cannot be saved.
contact.add_name_and_lastName("Robert", "Kane");
contact.setLAST_NAME("Edward");
contact.setTYPE_ID(Type_id.CLIENT.getCode());
contact.add_comments("He is the best");
contact.add_post("Manager");

// Attach a company card (requires company ID)
contact.add_company(2);

// At the end Save the created contact in CRM
client.getContactService().addNewContact(contact);

// 1.2. Get the Contact by ID (For example, 74)
Contact contact = client.getContactService().getContactById(74);

// 1.3. Delete Contact
client.getContactService().deleteContactById(72);

// Update Contact
contact.setCOMPANY_ID("2");
contact.setNAME("John");

// In multiple fields containing lists, the data is entered differently (for example, Phone)
// 1. Add a new phone. Do not specify ID and ID_Type (will be assigned to CRM itself)
Phone phone = Phone.builder()
      .VALUE("600-00-00").VALUE_TYPE(Phone_type.MOBILE.getCode()).build();
List<Phone> listPhone = new ArrayList<>();
listPhone.add(phone);
contact.setPHONE(listPhone);
client.getContactService().updateContact(contact);

// 2. Change an existing phone (Get the Phone object, set new values for Value and (or) Value_type). 
// For example, I change the first phone
Phone phone = contact.getPHONE().get(0);
phone.setVALUE("222-22-22");
List<Phone> phoneList = new ArrayList<>();
phoneList.add(phone);
contact.setPHONE(phoneList);
client.getContactService().updateContact(contact);
```


***Lead***

```java
// 1.1. Create a new Lead	
Lead lead = new Lead();
lead.add_title("Torrentino");
client.getLeadService().addNewLead(lead);

// 1.2. Get lead by ID = 4
Lead lead = client.getLeadService().getLeadById(4);

// 1.3. Delete lead 
client.getLeadService().deleteLeadById(4);

// 1.4. Update lead 
// Simple fields (like String) can just set new data
lead.setNAME("Albert");
lead.setLAST_NAME("Shtein");
lead.setADDRESS("West Olympic Boulevard Apt. 100");
lead.setCOMMENTS("Interested in price");
lead.setSTATUS_ID(StatusID_type.NEW.getCode());
lead.setCURRENCY_ID(CurrencyID_type.EUR.getCode());
lead.setSOURCE_ID(SourceID_type.RECOMMENDATION.getCode());
	
// In multiple fields containing lists, the data is entered differently (for example, Phone, Email, Website, IM)
// 1. Add a new Email. Do not specify ID and ID_Type (will be assigned to CRM itself)
Email email = Email.builder()
	.VALUE("albert@gmail.com").VALUE_TYPE(Email_type.PRIVATE.getCode()).build();
List<Email> listEmail = new ArrayList<>();
listEmail.add(email);
lead.setEMAIL(listEmail);
client.getLeadService().updateLead(lead);

// 2. Change an existing Website (Get the Website object, set new values for Value and (or) Value_type). 
// For example, I change the first website
Website website = lead.getWEB().get(0);
website.setVALUE("www.albert-best.org");
website.setVALUE_TYPE(Website_type.OTHER.getCode());
List<Website> websitList = new ArrayList<>();
websitList.add(website);
lead.setWEB(websitList);
client.getLeadService().updateLead(lead);	
```

***Company***

The way of working with the Company is the same as with other entities.

```java
//1. Create New Company
Company company = new Company();
company.add_companyTitle("LLT Prizma");
company.add_companyType(Company_type.PARTNER);
company.add_employeesType(Employees_type.FROM_250_TO_500);
company.add_industryType(Industry_type.BANKING);

//2. Get company by ID
Company company = client.getCempanyService().getCompanyById(2);

//3. Delete company by ID 
client.getCempanyService().deleteCompanyById(3);

//4.1. Update simple fields
company.setBANKING_DETAILS("r/s 40702810865698252");
company.setCOMPANY_TYPE(Company_type.SUPPLIER.getCode());
company.setADDRESS("Olympic Boulevard Apt. 120");
company.setCOMMENTS("Interested in price");

//4.2. Update multiple fields Website
Website website = company.getWEB().get(0);
website.setVALUE("www.albert12.org");
website.setVALUE_TYPE(Website_type.OTHER.getCode());
List<Website> websitList = new ArrayList<>();
websitList.add(website);
company.setWEB(websitList);
client.getCempanyService().updateCompany(company);

//5. Add new multiple fields (for example, Email)
Company company = client.getCempanyService().getCompanyById(2);
List<Email> listEmail = new ArrayList<>();
Email email = Email.builder()
	.VALUE("srtur12@gmail.com").VALUE_TYPE(Email_type.PRIVATE.getCode()).build();
listEmail.add(email);
company.setEMAIL(listEmail);
client.getCempanyService().updateCompany(company);
```

***Product***
```java
// Create
Product product = new Product();
product.setNAME("MainRouter");
client.getProductService().addProduct(product);

// Get, Delete and Update 
Product product = client.getProductService().getProduc(4);
client.getProductService().deleteProduct(6);
client.getProductService().updateProduct(product);
```

***Product Section***
```java
// Create
ProductSection productSection = new ProductSection();
productSection.add_name("Auto");
productSection.setSECTION_ID(12);  // ID of Main category

// Get, Delete and Update 
ProductSection productSection = client.getProductSectionService().getProductSection(16);
client.getProductSectionService().deleteProductSection(2);
client.getProductSectionService().updateProductSection(productSection);
```

***Chats with a Leads***

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

