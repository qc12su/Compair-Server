package UserAPI;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.Datastore;

public class Connection {
    private MongoClient mongoClient;
    public MongoDatabase database;
    private static Connection connectionInstance = null;

    private Connection(){

    }
    public void start(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://admin:admin@cluster0-shard-00-00-rxqtu.mongodb.net:27017,cluster0-shard-00-01-rxqtu.mongodb.net:27017,cluster0-shard-00-02-rxqtu.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");
        mongoClient = new MongoClient(uri);
        final Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
        database = mongoClient.getDatabase("compairDb");
    }

    public static Connection getConnection(){
        if (connectionInstance == null){
            connectionInstance = new Connection();
        }
        return connectionInstance;
    }

    public void stop(){
        mongoClient.close();
    }

}
