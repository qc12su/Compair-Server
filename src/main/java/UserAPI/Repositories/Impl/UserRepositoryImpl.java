package UserAPI.Repositories.Impl;

import UserAPI.Config.MongoDB;
import UserAPI.Entities.User;
import UserAPI.Repositories.Interfaces.IUserRepository;
import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    Datastore ds = MongoDB.getDatastore();

    public int create(User user){
        int validUserResponse = validUser(user);
        if (validUserResponse == 0){
            ds.save(user);
        }
        return validUserResponse;
    }

    public Iterable<User> findAll(){
        return ds.createQuery(User.class).asList();
    }

    public User find(String username){
        return ds.get(User.class, username);
    }


    public int validUser(User user){
        Query<User> usernameQuery = ds.createQuery(User.class)
                .field("username").equal(user.getUsername());
        Query<User> emailQuery = ds.createQuery(User.class)
                .field("email").equal(user.getEmail());
        System.out.println("Validating user");
        if (usernameQuery.get() != null){
            //System.out.println(usernameQuery.get());
            System.out.println("Duplicate username found");
            return 1;
        }
        if (emailQuery.get() != null) {
            //System.out.println(emailQuery.get());
            System.out.println("Duplicate email found");
            return 2;
        }
        return 0;
        //System.out.print(username);
        //System.out.print(ds.get(User.class, username));
    }

    public boolean exists(String username){
        //System.out.print(username);
        //System.out.print(ds.get(User.class, username));
        return ds.get(User.class, username) != null;
    }

    public long count(){
        return ds.getCount(User.class);
    }

    public Iterable<User> find(Iterable<String> usernames){
        return ds.get(User.class, usernames);
    }


    public WriteResult delete(String username){
        return ds.delete(User.class, username);
    }

    public WriteResult delete(Iterable<String> usernames){
        return ds.delete(User.class, usernames);
    }

}
