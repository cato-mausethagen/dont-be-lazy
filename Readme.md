# Running locally
- Place any secrets in `src/main/resources/application-local.yml`, which is `.gitignore`d
- `docker compose up` to start PostgreSQL
- Start the application with Spring Boot active profile `local`

# Disclaimer
This is a simplified example project to visualize a problem experienced from a real solution.
In this project, the `Entity` objects are exposed directly on the REST APIs.
**Don't do this in a real application!** Map your entity objects to API models, before exposing them in a `@RestController`.
This makes sure you don't get a tight coupling between the API versioning and your internal database model, and you can make changes on either side without it directly affecting the other side. 

# Docs
## About
From project root, you find the folder `docs` which contains some of the documents used during the presentation.
- `Database_Script_insert_Data.sql`
- `Dont be lazy.pptx`

## Use cases
This example project is inspired by a real customer project. The inital use case is only assumed to have been something like this:  
![Use Case 1 - Initial use case.png](docs%2Fimg%2FUse%20Case%201%20-%20Initial%20use%20case.png)

Then, in a later phase, we assume the use case expanded to something like this:
![Use Case 2 - What came up several months later.png](docs%2Fimg%2FUse%20Case%202%20-%20What%20came%20up%20several%20months%20later.png)

## Test data
You can find a `PostgreSQL` script used to generate fake test data into your local running instance. 
See the file: [Database_Script_Insert_Data.sql](docs%2FDatabase_Script_Insert_Data.sql)

# Issues along the road
The setup has been inspired by some Baeldung tutorials: 
- https://www.baeldung.com/spring-data-rest-relationships
- https://www.baeldung.com/hibernate-one-to-many

Following the guides, and exposing the data on a REST endpoint, you may stumble upon some issues which will cause a `StackOverflowError`.
This issue is caused when the entity object is exposed directly from the API, and being serialized with Jackson using the `.toString()` method.
The same issue can be visualized and reproduced if you do a mapping between the `Products` list and the `Company` within the data model:
![Stack overflow.png](docs%2Fimg%2FStack%20overflow.png)

To resolve this issue (_in this demo_), it has been applied a `@JsonIgnoreProperties` annotation of the fields causing the circular dependencies.

# Sneak peek
Within this project you also may find some code related to another, upcoming topic to be discussed.
