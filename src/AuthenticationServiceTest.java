import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    @Test
    public void testAuthenticationSuccess() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);
        when(mockRepo.findUserByUsername("username")).thenReturn(new User("username", "password"));

        AuthenticationService service = new AuthenticationService(mockRepo);
        assertTrue(service.authenticate("username", "password"));
    }
}
