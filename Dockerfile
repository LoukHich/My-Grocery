FROM openjdk:17
ADD target/My-Grocery-App-0.0.1-SNAPSHOT.jar  /GroceryApp.jar
ENTRYPOINT [ \
    "java", \
    "-jar", \
    "GroceryApp.jar" \
]
