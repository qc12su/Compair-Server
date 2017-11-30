package API;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersAPI {
    Connection connection = new Connection();

    @RequestMapping("/getUsers")
    public String getUsers() {
        MongoCollection usersCollection = connection.database.getCollection("users");
        return usersCollection.find().first().toString();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        System.out.println("Attemping to add user with ");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);

        MongoCollection usersCollection = connection.database.getCollection("users");

        Document doc = new Document("username", username)
                .append("password", password)
                .append("email", email);

        usersCollection.insertOne(doc);
    }
}
