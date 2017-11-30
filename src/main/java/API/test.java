package API;

import API.Connection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class test {
    public static void main(String[] args){
        Connection connection = new Connection();
        MongoCollection usersCollection = connection.database.getCollection("users");
        System.out.println("API.test");
        System.out.println(usersCollection.find().first());
    }
}
