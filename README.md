# springboot-sample-kotlin-app

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

## Running the Application

You can run the application by typing the following command in the terminal -

```shell
./gradlew bootRun
```
The application will start at Spring Boot’s default port 8080.

## Exploring the Rest APIs

1. POST /api/articles - Create an Article

```shell
curl -i -H "Content-Type: application/json" -X POST -d '{"title": "Test", "content": "Test Content"}' http://localhost:8080/api/articles
```

2. GET /api/articles - Get all Articles

```shell
curl -i -H 'Accept: application/json' http://localhost:8080/api/articles
```

3. Get /api/articles/{id} - Get an Article by id

```shell
curl -i -H 'Accept: application/json' http://localhost:8080/api/articles/1
```

4. PUT /api/articles/{id} - Update an Article

```shell
curl -i -H "Content-Type: application/json" -X PUT -d '{"title": "Learning Spring Boot", "content": "Some resources to learn Spring Boot"}' http://localhost:8080/api/articles/1
```

5. DELETE /api/articles/{id} - Delete an Article

```shell
curl -i -X DELETE http://localhost:8080/api/articles/1
```
6. GET /api/articles?title - Get an Article by title - using native @query

```shell
curl -i -H 'Accept: application/json' http://localhost:8080/api/articles?title=test
```

