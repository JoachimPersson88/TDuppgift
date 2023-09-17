import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User("username", "password");
        assertNotNull(user);
        assertEquals("username", user.username());
        assertEquals("password", user.password());
    }
    @Test
    public void testEqualsMethod() {
        User user1 = new User("username", "password1");
        User user2 = new User("username", "password2");
        User user3 = new User("username2", "password1");

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
    }

}
