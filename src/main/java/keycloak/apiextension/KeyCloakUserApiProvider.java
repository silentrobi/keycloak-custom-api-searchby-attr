package keycloak.apiextension;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.utils.MediaType;

import keycloak.apiextension.mappers.UserMapper;
import keycloak.apiextension.models.UserDto;

import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class KeyCloakUserApiProvider implements RealmResourceProvider {
    private final KeycloakSession session;
    private final String defaultAttr = "merchent_id";
    private final UserMapper userMapper;
    
    public KeyCloakUserApiProvider(KeycloakSession session) {
        this.session = session;
        this.userMapper = new UserMapper();
    }

    public void close() {
    }

    public Object getResource() {
        return this;
    }

    @GET
    @Path("users/search-by-attr")
    @NoCache
    @Produces({ MediaType.APPLICATION_JSON })
    @Encoded
    public List<UserDto> searchUsersByAttribute(@DefaultValue(defaultAttr) @QueryParam("attr") String attr,
            @QueryParam("value") String value) {
        return session.users().searchForUserByUserAttribute(attr, value, session.getContext().getRealm())
                .stream().map(e -> userMapper.mapToUserDto(e)).collect(Collectors.toList());
    }
}