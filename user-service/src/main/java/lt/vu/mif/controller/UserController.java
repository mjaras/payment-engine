package lt.vu.mif.controller;

import lt.vu.mif.domain.User;
import lt.vu.mif.exception.UserNotFoundException;
import lt.vu.mif.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by s77323 on 3/2/2017.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<?> listAllUsers() {
        List<User> users = userRepository.findAll();

        if(users == null || users.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/count", method = RequestMethod.GET)
    public ResponseEntity<?> countUsers() {
        return new ResponseEntity<>(userRepository.countUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserById(@PathVariable("id") long id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new UserNotFoundException("User with id: " + id
                    + " not found");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/personalId/{personalId}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserById(@PathVariable("personalId") Long personalId) {
        User user = userRepository.findByPersonalId(personalId);

        if (user == null) {
            throw new UserNotFoundException("User with personal id: " + personalId
                    + " not found");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/firstName/{firstName}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByFirstName(@PathVariable("firstName") String firstName) {
        List<User> users = userRepository.findByFirstName(firstName);

        if (users == null) {
            throw new UserNotFoundException("Users with first name: " + firstName
                    + " not found");
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/lastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByLastName(@PathVariable("lastName") String lastName) {
        List<User> users = userRepository.findByLastName(lastName);

        if (users == null) {
            throw new UserNotFoundException("Users with last name: " + lastName
                    + " not found");
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/phoneNumber/{phoneNumber}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
       User user = userRepository.findByPhoneNumber(phoneNumber);

        if (user == null) {
            throw new UserNotFoundException("Users with phone number: " + phoneNumber
                    + " not found");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/emailAddress/{emailAddress}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByEmailAddress(@PathVariable("emailAddress") String emailAddress) {
        User user = userRepository.findByEmailAddress(emailAddress);

        if (user == null) {
            throw new UserNotFoundException("Users with email address: " + emailAddress
                    + " not found");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        User created = userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(created.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserById(@PathVariable("id") long id) {
        userRepository.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/user/personalId/{personalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserByPersonalId(@PathVariable("personalId") long id) {
        userRepository.deleteUserByPersonalId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll(){
        userRepository.deleteUsers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
