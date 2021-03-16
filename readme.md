# Keycloak Custom Rest API
## Installation
 1. Run  `mvn clean install` command from CLI. This will generate a `target` folder. Under the `target` folder there will be `{project artifact id}-*.jar` file.
 2.  Copy that `jar` file to the Keycloak `standalone/deployments/` directory. For an example, If you run your Keycloak in docker container, you can use the following command:
 ```dillinger
docker cp <jar_file_path> keycloak:/opt/jboss/keycloak/standalone/deployments/
```
## Demo
**Request:**
```sh
curl --location --request GET 'http://localhost:8090/auth/realms/demo/token-userapi-rest/users/search-by-attr?attr=marchent_id&value=1'
```
**Response:**
```json
[
    {
        "userName": "test",
        "firstName": "Mohammad Abu",
        "lastName": "RABIUL",
        "id": "d7926d45-0d4c-46a8-a5a1-10f2f1de56a0",
        "email": "test@gmail.com",
        "marchentId": "1"
    },
    {
        "userName": "test2",
        "firstName": "test2",
        "lastName": "test2",
        "id": "b98a5cec-0f04-4e90-90f2-2c62f7216d5c",
        "email": "test2@test.com",
        "marchentId": "1"
    }
]
```