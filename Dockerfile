FROM openjdk:17
EXPOSE 8080
ADD target/My-Grocery-App.jar  /GroceryApp.jar
ENTRYPOINT["java","-jar","/GroceryApp.jar"]