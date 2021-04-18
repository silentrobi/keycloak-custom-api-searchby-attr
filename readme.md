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
curl --location --request GET 'http://localhost:8090/auth/realms/demo/userapi-rest/users/search-by-attr?attr=merchant_id&value=1'
```
**Response:**
```json
[
    {
        "userName": "test1",
        "firstName": "test1",
        "id": "a91e7e97-ecac-4e3f-b45b-0a6edab062c1",
        "email": "test1@test.com",
        "marchentId": "1"
    },
    {
        "userName": "test2",
        "firstName": "test2",
        "id": "820be3c0-1a30-4218-a4b7-a183992adcf9",
        "email": "test2@test.com",
        "marchentId": "1"
    },
    {
        "userName": "test4",
        "firstName": "test4",
        "id": "6e9925ba-e235-43a8-93db-db2073ca6f51",
        "email": "test4@test.com",
        "marchentId": "1"
    }
]
```
