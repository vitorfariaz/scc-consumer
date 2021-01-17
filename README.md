# Spring Cloud Contract - Consumer Side
This project contains the Consumer side of an api. It consumes the [provider-api](https://github.com/vitorfariaz/scc-provider) and have contracts tests that verify 
if have any changes from the Provider side. In case of any change on the provider side, the consumer will know. <br />
The contract tests verify the resources of the external api that we use but instead to create an integrated test that are run in the test environment, we only use the 
contract artifact that are provided by the external API with Spring cloud Contract 

## About the project
This api consumes the provider api that return Guests on the resource `/guests` and  provide the filter age.
The project consumes the kafka message from the [provider-api](https://github.com/vitorfariaz/scc-provider) too, and register in memory, inside the class
[GuestService.class](https://github.com/vitorfariaz/scc-provider/blob/master/src/main/java/br/com/springContract/springcloudverifier/service/GuestService.java) 
the list of Guests sent by kafka from the provider-api

## Resources
#### GET: /guests?age={age}
Return a list of objects of type Guest, filtering by age 

Example of request: `GET: /guests?age=13` <br />
Example of response:
```
[
    {
        "name": "vitinho2",
        "age": 13
    }
]
```
When starting the application will not have any Guest registered, for that, you can insert Guest on the [provider-api](https://github.com/vitorfariaz/scc-provider),
using the resource ```/publish``` <br />

# To initialize
You must have:
- An IDE
- Java JDK 11 installed
- Maven or gradle

After that, follow the steps
 - First you have to download the [provider-api](https://github.com/vitorfariaz/scc-provider)
   - and run the tests, to generate de contract artifact. To do that just run ``mvn clean install`` and then execute the Main class.
- You need to download this project, clone ```git clone https://github.com/vitorfariaz/scc-consumer.git ``` or download the project and open in your IDE.
- Now, run the tests from this project, you will see that the tests have passed.
- If you change some information in one resource of provider-api, run the tests, and then run the test for this project, you will see that the contract tests will failed because 
  the contract artifact has changed.
