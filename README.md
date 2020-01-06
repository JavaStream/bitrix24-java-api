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
    <version>0.0.1-SNAPSHOT</version>
 </dependency>
  ```

3. **Init Client in your project**
You need insert yours Token and bitrix-account. It's easy!

```java
Client client = new Client("mlqg5ktzo5pd2244", "b24-yv2vtt.bitrix24.ru");
```
