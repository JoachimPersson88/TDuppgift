public class AuthenticationService {

    private UserRepository repo;

    public AuthenticationService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean authenticate(String username, String password) {
        User user = repo.findUserByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}