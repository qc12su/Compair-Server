package ComparisonAPI.Controllers;

import UserAPI.Entities.User;
import UserAPI.Repositories.Interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CompairsonController {
    /*@Autowired
    IUserRepository userRepository;*/



    /*
    //Add pagination
    @RequestMapping(value = "imageAPI/comparisons", method = RequestMethod.GET)
    public Iterable<Comparison> getComparisons() {
        return comparisonRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "userAPI/comparisons/{userName}", method = RequestMethod.GET)
    public Iterable<Comparison> getComparisons(@PathVariable String userName) {
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
    }*/



}
