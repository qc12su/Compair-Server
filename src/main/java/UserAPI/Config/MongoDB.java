package UserAPI.Config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Configuration;

import UserAPI.Entities.IEntities;

@Configuration
public class MongoDB {
    public static final String DB_HOST =
            "mongodb://admin:admin@cluster0-shard-00-00-rxqtu.mongodb.net:27017,cluster0-shard-00-01-rxqtu.mongodb.net:27017,cluster0-shard-00-02-rxqtu.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin";
    public static final int DB_PORT = 27017;
    public static final String DB_NAME = "compairDb";

    //private static final Logger LOG = Logger.getLogger(MongoDB.class.getName());

    private static MongoClient mongoClient = null;

    private static Datastore datastore = null;

    public MongoDB() {
        //LOG.info("Connection to database '" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "' initialized");
    }

    private static MongoClient getMongoClient() {
        if (mongoClient == null){
            mongoClient = new MongoClient(new MongoClientURI(DB_HOST));
        }
        return mongoClient;
    }

    public static Datastore getDatastore() {
        if (datastore == null){
            datastore = new Morphia().mapPackage("UserAPI.Entities.IEntities")
                    .createDatastore(getMongoClient(), DB_NAME);
        }
        return datastore;
    }
}