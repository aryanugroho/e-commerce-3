# Spring Boot - MongoDB - AngularJS

## Running e-commerce locally
```
	git clone https://github.com/suatdm/e-commerce.git
	cd e-commerce
	./mvnw spring-boot:run
```

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 8
- Maven > 3.0
- MongoDB

You can then access e-commerce here: http://localhost:8098/index.html

### Get information about e-commerce modules.

```
http://localhost:8098/rest/category/list
http://localhost:8098/rest/product/list
http://localhost:8098/rest/basket/list
```

### Create a category resource

```
POST /rest/category/
Accept: application/json
Content-Type: application/json

{
   "name":"Category Name",
   "link":"permanent_link"
}

RESPONSE: HTTP 201 (Created)
{
  "name": "Category Name",
  "link": "permanent_link",
  "createdDate": 1482691151603,
  "_links": {
    "self": {
      "href": "http://localhost:8098/rest/category/5860124f88afbd1989a24569"
    }
  }
}
```