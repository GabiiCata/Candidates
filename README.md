
# API REST - Fluxit Candidates

_API desarrollada con framework Spring_


# Endpoints

| Description | HTTP Verb | Endpoint |
| ------------- | ------------- | ------------- |
| [Get candidates](#Get-candidates) | GET | /api/v1/candidates |
| [Get candidates with specific size](#Get-candidates-by-specific-size) | GET | /api/v1/candidates?size={number} |
| [Get candidates by size and page](#Get-candidates-by-size-and-page) | GET | /api/v1/candidates?page={number}&size={number} |
| [Get candidate by Id](#Get-candidate-by-Id) | GET | /api/v1/candidate/{id} |
| [Get candidates filter by Firstname](#Get-candidates-by-Firstname) | GET | /api/v1/candidates/{firstname} |
| [Create candidate ](#Create-candidate) | POST | /api/v1/candidate |
| [Update candidate ](#Update-candidate) | PUT | /api/v1/candidate |
| [Delete candidate ](#Delete-candidate) | DELETE | /api/v1/candidate/{id} |

# Get candidates

### Request

`
GET /api/v1/candidates
`
### Response

```
{
    "content": [
        {
            "id": 49,
            "firstName": "Jeniffer",
            "lastName": "Rivarola",
            "birth": "1995-03-13",
            "address": "Diaz Velez 2204",
            "phone": 15234354,
            "email": "jeniriva@gmail.com",
            "dni": 343454653
        },
        {
            "id": 47,
            "firstName": "Gabriel",
            "lastName": "Espina",
            "birth": "2020-06-08",
            "address": "Avenida Federico Lacroze 1850",
            "phone": 15553399,
            "email": "gabyespina.ge@gmail.com",
            "dni": 13243546
        },
        {
            "id": 48,
            "firstName": "Emanuel",
            "lastName": "Castillo",
            "birth": "1994-02-12",
            "address": "Yatay 204",
            "phone": 15553399,
            "email": "emacastillo@gmail.com",
            "dni": 43435465
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 3,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 3,
    "first": true,
    "empty": false
}
```

# Get candidates by specific size
### Request

`
GET /api/v1/candidates?size={number}
`

### Example

`
 GET /api/v1/candidates?size=1
`

### Response

```
{
    "content": [
        {
            "id": 49,
            "firstName": "Jeniffer",
            "lastName": "Rivarola",
            "birth": "1995-03-13",
            "address": "Diaz Velez 2204",
            "phone": 15234354,
            "email": "jeniriva@gmail.com",
            "dni": 343454653
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageSize": 1,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 3,
    "totalElements": 3,
    "last": false,
    "size": 1,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 1,
    "first": true,
    "empty": false
}
```

# Get candidates by size and page
### Request

`
GET /api/v1/candidates?page={number}&size={number}
`

### Example
`
 GET /api/v1/candidates?page=2&size=1
`

### Response

```
{
    "content": [
        {
            "id": 48,
            "firstName": "Emanuel",
            "lastName": "Castillo",
            "birth": "1994-02-12",
            "address": "Yatay 204",
            "phone": 15553399,
            "email": "emacastillo@gmail.com",
            "dni": 43435465
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 2,
        "pageSize": 1,
        "pageNumber": 2,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 3,
    "totalElements": 3,
    "last": true,
    "size": 1,
    "number": 2,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 1,
    "first": false,
    "empty": false
}
```

# Get candidate by Id

### Request

`
GET /api/v1/candidate/{id}
`

### Example

`
GET /api/v1/candidate/47
`

### Response

```
{
    "id": 47,
    "firstName": "Gabriel",
    "lastName": "Espina",
    "birth": "2020-06-08",
    "address": "Avenida Federico Lacroze 1850",
    "phone": 15553399,
    "email": "gabyespina.ge@gmail.com",
    "dni": 13243546
}
```

# Get candidates by Firstname

### Request

`
GET /api/v1/candidates/{firstname}
`
### Example

`
GET /api/v1/candidates/jeniffer
`

### Response

```
[
    {
        "id": 49,
        "firstName": "Jeniffer",
        "lastName": "Rivarola",
        "birth": "1995-03-13",
        "address": "Diaz Velez 2204",
        "phone": 15234354,
        "email": "jeniriva@gmail.com",
        "dni": 343454653
    }
]
```
# Create candidate

### Request

`
POST /api/v1/candidate
`

#### Body
```
{
    "firstName": "Cosme",
    "lastName": "Fulanito",
    "dni" : 32958493,
    "birth": "1993-02-20",
    "address": "Av. Siempre Viva 123",
    "phone": 1142325433,
    "email": "cosmefulanito@gmail.com"
}
```
### Response

```
{
    "id": 50,
    "firstName": "Cosme",
    "lastName": "Fulanito",
    "birth": "1993-02-19",
    "address": "Av. Siempre Viva 123",
    "phone": 1142325433,
    "email": "cosmefulanito@gmail.com",
    "dni": 32958493
}
```

# Update candidate

### Request

`
PUT /api/v1/candidate/{id}
`

### Example

`
PUT /api/v1/candidate/50
`
#### Body
```
{
    "firstName": "Homero",
    "lastName": "Simpson",
    "birth": "1993-02-19",
    "address": "Av. Siempre Viva 123",
    "phone": 1142325433,
    "email": "cosmefulanito@gmail.com",
    "dni": 32958493
}
```
### Response

```
{
    "id": 58,
    "firstName": "Homero",
    "lastName": "Simpson",
    "birth": "1993-02-18",
    "address": "Av. Siempre Viva 123",
    "phone": 1142325433,
    "email": "cosmefulanito@gmail.com",
    "dni": 32958493
}
```

# Delete candidate

### Request

`
DELETE api/v1/candidate/{id}
`
### Example

`
DELETE api/v1/candidate/48
`

### Response

`
"Candidate eliminated"
`
