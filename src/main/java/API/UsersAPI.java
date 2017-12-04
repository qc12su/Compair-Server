package API;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mongodb.client.model.Filters.eq;

@RestController
public class UsersAPI {
    Connection connection = Connection.getConnection();


    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers() {
        MongoCollection usersCollection = connection.database.getCollection("users");
        return usersCollection.find().first().toString();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam int userid) {
        System.out.println("In get user");
        MongoCollection usersCollection = connection.database.getCollection("users");
        FindIterable<Document> findIterable = usersCollection.find(eq("userid", "1"));
            for (Document document : findIterable) {
            System.out.println(document.toJson());
            return document.toJson();
        }
        return "";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    //public void addUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
    public ResponseEntity addUser(@RequestBody String body) {
        JSONObject userObject = new JSONObject (body);
        String username, password, email;
        username = (String) userObject.get("username");
        password = (String) userObject.get("password");
        email = (String) userObject.get("email");

        System.out.println("Attemping to add user with ");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);

        MongoCollection usersCollection = connection.database.getCollection("users");

        Document newUserDoc = new Document("username", username)
                .append("password", password)
                .append("email", email);

        usersCollection.insertOne(newUserDoc);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
