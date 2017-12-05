package UserAPI.Repositories.Interfaces;
import UserAPI.Entities.User;
import com.mongodb.WriteResult;
import org.mongodb.morphia.Key;

public interface IUserRepository {

    User find(String userName);

    Iterable<User> findAll();

    Key<User> create(User entity);

    boolean exists(String userName);

    long count();

    WriteResult delete(String username);

    WriteResult delete(Iterable<String> usernames);
}
