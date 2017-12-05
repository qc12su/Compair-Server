package API;

import UserAPI.Connection;
import com.mongodb.client.MongoCollection;


public class test {
    public static void main(String[] args){
        Connection connection = Connection.getConnection();
        MongoCollection usersCollection = connection.database.getCollection("users");
        System.out.println("API.test");
        System.out.println(usersCollection.find().first());
    }
}
