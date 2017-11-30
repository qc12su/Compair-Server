package API;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

public class Connection {
    private MongoClient mongoClient;
    public MongoDatabase database;

    public Connection(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://admin:admin@cluster0-shard-00-00-rxqtu.mongodb.net:27017,cluster0-shard-00-01-rxqtu.mongodb.net:27017,cluster0-shard-00-02-rxqtu.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
        MongoClient mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("compairDb");
    }

}
