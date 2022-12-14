FROM openjdk:17
ADD target/My*.jar  /GroceryApp.jar
ENTRYPOINT [ \
    "java", \
    "-jar", \
    "GroceryApp.jar" \
]
EXPOSE 8080