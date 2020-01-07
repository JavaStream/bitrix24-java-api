# Bitrix24 Java API  [![HitCount](http://hits.dwyl.io/JavaStream/bitrix24-java-api.svg)](http://hits.dwyl.io/JavaStream/bitrix24-java-api)

Java Library for easy work with **CRM Bitrix24.ru** 

Now you can work with **Client Card, Lead and Company**. Other features coming soon!

### Connection and functionalities:
I. **Create account and webhook token**
![Screenshot](1_screen.jpg)
![Screenshot](2_screen.jpg)

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
    <version>0.3-SNAPSHOT</version>
 </dependency>
  ```

III. **Init Client in your project.**
You need insert yours Token and bitrix-account. It's easy!

```java
// Init Client
Client client = new Client("token", "your-account.bitrix24.ru");
```

**Contacts**

1.1. **Create New Contact**

```java
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

1.2. **Get Contact By Id**

```java
// We get the contact card by contact ID (For example, 74)
Contact contact = client.getContactService().getContactById(74);

```


1.3. **Delete Contact By Id**

```java
client.getContactService().deleteContactById(72);
```


1.4. **Update Contact**

```java
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


**Lead**

1.1. **Create New Lead**

```java
 Lead lead = new Lead();
 lead.add_title("Torrentino");

// Save new Lead
client.getLeadService().addNewLead(lead);
```

1.2. **Get Lead by ID**
```java
// Get lead by ID = 4
Lead lead = client.getLeadService().getLeadById(4);
```

1.3. **Delete Lead by ID**
```java
// Delete lead by ID = 4
client.getLeadService().deleteLeadById(4);
```

1.4. **Update Lead**
```java
// Get lead by ID = 4
Lead lead = client.getLeadService().getLeadById(4);

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

**Company**

The way of working with the Company is the same as with other entities.

```java
1. // Create New Company and set fields you need
Company company = new Company();
company.add_companyTitle("LLT Prizma");
company.add_companyType(Company_type.PARTNER);
company.add_employeesType(Employees_type.FROM_250_TO_500);
company.add_industryType(Industry_type.BANKING);

2. // Get company by ID = 2
Company company = client.getCempanyService().getCompanyById(2);

3. // Delete company by ID = 3
client.getCempanyService().deleteCompanyById(3);

4. Update company
Company company = client.getCempanyService().getCompanyById(2);
// Update simple fields
company.setBANKING_DETAILS("r/s 40702810865698252");
company.setCOMPANY_TYPE(Company_type.SUPPLIER.getCode());
company.setADDRESS("Olympic Boulevard Apt. 120");
company.setCOMMENTS("Interested in price");

// Update multiple fields Website
Website website = company.getWEB().get(0);
website.setVALUE("www.albert12.org");
website.setVALUE_TYPE(Website_type.OTHER.getCode());
List<Website> websitList = new ArrayList<>();
websitList.add(website);
company.setWEB(websitList);
client.getCempanyService().updateCompany(company);


5. Add multiple fields (for example, Email)
Company company = client.getCempanyService().getCompanyById(2);
List<Email> listEmail = new ArrayList<>();
Email email = Email.builder()
	.VALUE("srtur12@gmail.com").VALUE_TYPE(Email_type.PRIVATE.getCode()).build();
listEmail.add(email);
company.setEMAIL(listEmail);
client.getCempanyService().updateCompany(company);
```
