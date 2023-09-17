import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {
    @Test
    public void testAuthenticationUserNotFound() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);
        when(mockRepo.findUserByUsername("username")).thenReturn(null);

        AuthenticationService service = new AuthenticationService(mockRepo);
        assertThrows(AuthenticationException.class, () -> service.authenticate("username", "password"));
    }

    @Test
    public void testAuthenticationWrongPassword() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);
        when(mockRepo.findUserByUsername("username")).thenReturn(new User("username", "correctPassword"));
        AuthenticationService service = new AuthenticationService(mockRepo);
            assertThrows(AuthenticationException.class, () -> service.authenticate("username", "wrongPassword"));
    }

    @Test
    public void testAuthenticationSuccess() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);
        when(mockRepo.findUserByUsername("username")).thenReturn(new User("username", "password"));

        AuthenticationService service = new AuthenticationService(mockRepo);
        assertTrue(service.authenticate("username", "password"));
    }
}
