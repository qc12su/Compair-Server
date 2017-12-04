package RestAPI.Controllers;

import Models.User;
import RestAPI.Repositories.UserRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mongodb.client.model.Filters.eq;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable long userId) {
        System.out.println("In getUser");
        return userRepository.findOne(userId);
        /*
        System.out.println("In get user");
        MongoCollection usersCollection = connection.database.getCollection("users");
        FindIterable<Document> findIterable = usersCollection.find(eq("userid", "1"));
        for (Document document : findIterable) {
            System.out.println(document.toJson());
            return document.toJson();
        }
        return "";
        */
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
         userRepository.save(user);
         return ResponseEntity.ok(HttpStatus.OK);
    }

   /* @RequestMapping(value = "/addUser", method = RequestMethod.POST)
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
    }*/

}
