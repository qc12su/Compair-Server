package API;

import org.bson.Document;
import com.mongodb.client.MongoCollection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsersAPI {
    Connection connection = new Connection();

    @RequestMapping("/getUsers")
    public String getUsers() {
        MongoCollection usersCollection = connection.database.getCollection("users");
        return usersCollection.find().first().toString();
    }

    @RequestMapping(value= "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        MongoCollection usersCollection = connection.database.getCollection("users");

        Document doc = new Document("username", username)
                .append("password", password)
                .append("email", email);

        usersCollection.insertOne(doc);
    }
}
