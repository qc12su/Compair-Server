package RestAPI.Repositories;
import Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    @Override
    User findOne(Long id);

    @Override
    void delete(Long id);
}
