public interface UserRepository {
    User findUserByUsername(String username);
}