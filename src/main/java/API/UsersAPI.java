package API;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersAPI {
    Connection connection = new Connection();

    @RequestMapping("/getUsers")
    public String getUsers() {
        MongoCollection usersCollection = connection.database.getCollection("users");
        return usersCollection.find().first().toString();
    }

    @RequestMapping(value= "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody String userString) {
        System.out.println("In /addUser request");
        JSONObject userObject = new JSONObject (userString);
        String username, password, email;
        username = (String) userObject.get("username");
        password = (String) userObject.get("password");
        email = (String) userObject.get("email");

        MongoCollection usersCollection = connection.database.getCollection("users");
        Document doc = new Document("username", username)
                .append("password", password)
                .append("email", email);
        usersCollection.insertOne(doc);

        System.out.println("Inserted User in db with");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);
    }
}
