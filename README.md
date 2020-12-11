# koffie-app-backend
VERY IMPORTANT: i run my database locally without a database this app will not compile.  
you can add your own local MySql database by editing the application.properties file under the recources folder.  

example application.properties file.  

spring.jpa.hibernate.ddl-auto=update  
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/koffieappdatabase  
spring.datasource.username=admin  
spring.datasource.password=password  

the main thing to edit here if you wanna add your own local MySQL database is the spring.datasource.url line.  
you wanna change the part after {MYSQL_HOST:localhost}: to your own localhost were the MySQL server is running.  
than you wanna change the database name from koffieappdatabase to the name you specified for your own database.  
after this you wanna change the username and password, to your own username and password that you specified when setting up your local MySQL database.  

another important note is that your own database is gonna be empty of records.   
so if you want an account with admin functionality you need to register an account with the username admin.  
this can be done when running the frontend and backend together and simply creating an account by clicking on the register button on the login page.  

to start this app you need an java SDK like intellij.  

once you loaded this project into your SDK you can start it by selecting the koffieapplication class as the startup class than it should work.  

note: when first loading this project into intellij it will install the depencies, let it install first before attempting to run it.  
