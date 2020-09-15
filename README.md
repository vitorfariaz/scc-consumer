# POC Spring Cloud Contract - Consumer Side
This project contains the Consumer side of an api. It consumes the [provider-api](https://github.com/vitorfariaz/scc-provider) and have contracts tests that verify if have any changes from the Provider side. In case of any change on the provider side, the consumer will know and the contract tests will run against the new contract.

## About the project
This api consumes the provider api that return Guests on the resource `/allGuests` and  provide the filter age.
The project consumes the kafka message from the [provider-api](https://github.com/vitorfariaz/scc-provider) too, and register in memory, inside the class [GuestService.class](https://github.com/vitorfariaz/scc-provider/blob/master/src/main/java/br/com/springContract/springcloudverifier/service/GuestService.java) the list of Guests sent by kafka from the provider-api

## Resources
#### GET: /guests?age={age}
Return a list of objects of type Guest, filtering by age 

Example of request: `GET: /guests?age=13` <br />
Example of response:
```
[
    {
        "name": "vitinho2",
        "age": 20
    }
]
```
When starting the application will not have any Guest registered, for that, you can insert Guest on the [provider-api](https://github.com/vitorfariaz/scc-provider), using the resource ```/publish``` <br />

# To initialize
You must have:
- An IDE
- Java JDK 11 installed
- Maven
- Git installed (optional)

After that, follow the steps
 - First you have to raise up the [provider-api](https://github.com/vitorfariaz/scc-provider)
- Now, you need to download the project: run the command line inside the folder that you want to download ```git clone https://github.com/vitorfariaz/scc-consumer.git ``` or download the project and open in your IDE.
- Run this class inside `src/main` [SpringCloudVerifierApplication.class](https://github.com/vitorfariaz/scc-provider/blob/master/src/main/java/br/com/springContract/springcloudverifier/SpringCloudVerifierApplication.java)
