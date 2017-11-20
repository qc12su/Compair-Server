package API;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

public class Connection {
    private MongoClient mongoClient;
    public MongoDatabase database;

    public Connection(){
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("compairDb");
    }

}
