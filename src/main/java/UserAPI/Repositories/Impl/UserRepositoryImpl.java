package UserAPI.Repositories.Impl;

import java.util.List;

import UserAPI.Config.MongoDB;
import UserAPI.Entities.User;
import UserAPI.Connection;
import UserAPI.Repositories.Interfaces.IUserRepository;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    Datastore ds = MongoDB.getDatastore();

    public Key<User> create(User user){
        return ds.save(user);
    }

    public Iterable<User> findAll(){
        return ds.createQuery(User.class).asList();
    }

    public User find(String username){
        return ds.get(User.class, username);
    }

    public boolean exists(String username){
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
