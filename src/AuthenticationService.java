public class AuthenticationService {

    private UserRepository repo;

    public AuthenticationService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean authenticate(String username, String password) {
        User user = repo.findUserByUsername(username);
        if(user != null && user.password().equals(password)) {
            return true;
        }
        throw new AuthenticationException("Invalid username or password.");
    }

}