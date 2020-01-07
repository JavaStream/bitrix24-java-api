# Bitrix24 Java API  [![HitCount](http://hits.dwyl.io/JavaStream/bitrix24-java-api.svg)](http://hits.dwyl.io/JavaStream/bitrix24-java-api)

Java Library for easy work with **CRM Bitrix24.ru** 

Now you can work only with the **Client Card**. Other features coming soon!

### Connection and functionalities:
1. **Create account and webhook token**
![Screenshot](1_screen.jpg)
![Screenshot](2_screen.jpg)

2. **Add Maven dependency** 
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
    <version>0.2-SNAPSHOT</version>
 </dependency>
  ```

3. **Init Client in your project.**
You need insert yours Token and bitrix-account. It's easy!

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");
```

4. **Create New Contact**

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");

// Create a new Contact card and fill in its fields
Contact contact = new Contact();

// Mandatory method. Without the name and lastName parameters, the card cannot be saved.
contact.add_name_and_lastName("Robert", "Kane");

contact.setLAST_NAME("Edward");

// Contact type -> in Type_id you can select 1 of 4 options
contact.setTYPE_ID(Type_id.CLIENT.getCode());

// Comment field
contact.add_comments("He is the best");

// Post field
contact.add_post("Manager");

// Attach a company card (requires company ID)
contact.add_company(2);

// Adding a phone. Phone type is set in Phone_type
contact.add_phone("89119500085", Phone_type.MOBILE);
contact.add_phone("500-00-90", Phone_type.WORK);
contact.add_phone("500-00-92", Phone_type.FAX);

// Adding email. Phone type is set in Email_type
contact.add_email("robert@gmail.com", Email_type.PRIVATE);
contact.add_email("robert.dia@digital.com", Email_type.WORK);

// Adding a site. Phone type is set in Website_type
contact.add_website("www.digital.com", Website_type.WORK);
contact.add_website("www.facebook.com/robert", Website_type.FACEBOOK);

// Adding instant messengers. Messengers type is set in Messengers_type
contact.add_messenger("roby-tgr", Messengers_type.TELEGRAM);
contact.add_messenger("roby-van", Messengers_type.VIBER);

// At the end Save the created contact in CRM
client.getContactService().addNewContact(contact);
```

5. **Get Contact By Id**

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");

// We get the contact card by contact ID (For example, 74)
Contact contact = client.getContactService().getContactById(74);

```


6. **Delete Contact By Id**

```java
Client client = new Client("token", "your-account.bitrix24.ru");

client.getContactService().deleteContactById(72);
```

7. **Add or Remove Company Into Existing Contact By Id**

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");

// We get the contact card by contact ID (For example, 74)
Contact contact = client.getContactService().getContactById(74);

// The first way is to set the COMPANY_ID field. Here is the ID of a company already created in CRM
contact.setCOMPANY_ID("2");

// Second way
contact.add_company(2);

// Remove this company from this contact card (first parameter - ContactID, second param - CompanyID)
client.getContactService().deleteCompanyFromExistingContactById(74, 2);
```


8. **Update Contact**

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");

// We get the contact card by contact ID (For example, 74)
Contact contact = client.getContactService().getContactById(74);

// Simple fields like String can just set new data
contact.setCOMPANY_ID("2");
contact.setNAME("Джон");

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
