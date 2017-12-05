package UserAPI.Controllers;

import UserAPI.Repositories.Interfaces.IUserRepository;
import UserAPI.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    IUserRepository userRepository;

    @RequestMapping(value = "userAPI/getUsers", method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "userAPI/getUser/{userName}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userName) {
        return userRepository.find(userName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "userAPI/createUser", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
         if (user == null || !user.isValid()){
             return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
         }

         userRepository.create(user);
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
