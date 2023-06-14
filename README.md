# Spring-Boot-CRUD-API
CRUD-API with Spring Boot and JUnit Test cases

## Queries on Postman with Input and Output JSON data
### GET
### ===

1) http://localhost:8080/students
-> [
    {
        "id": 11,
        "firstName": "Vivek",
        "lastName": "Khatri",
        "course": "B.E.",
        "department": "Computer Science",
        "semister": 8,
        "contactNumber": 9028647849
    }
   ]

2) http://localhost:8080/students/11
-> {
    "id": 11,
    "firstName": "Vivek",
    "lastName": "Khatri",
    "course": "B.E.",
    "department": "Computer Science",
    "semister": 8,
    "contactNumber": 9028647849
   }

### POST
### ====

1) http://localhost:8080/students
{
    "firstName": "Vivek",
    "lastName": "Khatri",
    "course": "B.E.",
    "department": "Computer Science",
    "semister": 8,
    "contactNumber": 9028647849
}
-> {
    "id": 11,
    "firstName": "Vivek",
    "lastName": "Khatri",
    "course": "B.E.",
    "department": "Computer Science",
    "semister": 8,
    "contactNumber": 9028647849
   }

### PUT
### ===

1) http://localhost:8080/students/11
{
    "semister": 1
}
-> {
    "id": 11,
    "firstName": "Vivek",
    "lastName": "Khatri",
    "course": "B.E.",
    "department": "Computer Science",
    "semister": 1,
    "contactNumber": 9028647849
  }

### DELETE
### ======

1) http://localhost:8080/students/11
-> 