# Documentation

SpringBoot application Java Persistent API (JPA) hibernate with multiple relationship databases


## API

---

### One-to-One Relationship

#### Request
- Method : GET
- Endpoint : ``/api/v1/{user_id}/wallet`` example user_id = 1 until 3
- Header :
  - Accept: application/json

#### Response
- Body :
    ```json
    {
      "code": "integer",
      "message": "number",
      "data": {
        "name" : "string",
        "email" : "string",
        "wallet" : "string"
      }
    }
    ```
  
---

### One-to-Many Relationship

#### Request
- Method : GET
- Endpoint : ``/api/v1/{user_id}/product`` example user_id = 1 until 3
- Header :
    - Accept: application/json

#### Response
- Body :
    ```json
    {
      "code": "number",
      "message": "string",
      "data": [
         {
            "id": "number",
            "name" : "string",
            "price" : "number",
            "qty": "number"
         }
      ]
    }
    ```

---

### Many-to-Many Relationship

#### Request
- Method : GET
- Endpoint : ``/api/v1/{user_id}/order`` example user_id = 1 until 3
- Header :
    - Accept: application/json

#### Response
- Body :
    ```json
    {
      "code": "number",
      "message": "string",
      "data": [
         {
            "id": "number",
            "createdAt": "string",
            "updatedAt": "string",
            "orderProduct": [
                {
                  "id": "number",
                  "productId": "number",
                  "orderId": "number",
                  "orderPrice": "number",
                  "orderQty": "number"
                }
            ] 
         }
      ]
    }
    ```