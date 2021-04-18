package keycloak.apiextension.mappers;

import org.keycloak.models.UserModel;

import keycloak.apiextension.models.UserDto;

public class UserMapper {
    
    public  UserDto mapToUserDto(UserModel um) {
        return new UserDto(
            um.getUsername(),
            um.getFirstName(),
            um.getLastName(),
            um.getId(),
            um.getEmail(),
            um.getAttribute("merchant_id").get(0)
            );

    }
}
