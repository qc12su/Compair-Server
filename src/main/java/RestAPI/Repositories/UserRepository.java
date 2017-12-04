package RestAPI.Repositories;
import Models.User;

public interface UserRepository extends CrudRepository<User,Integer>{
    @Override
    User findOne(int id);

    @Override
    void delete();
}
