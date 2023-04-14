# REST API

REST controller is a class that handles HTTP requests and produces HTTP responses in the form of JSON or XML data.

```java
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    public List<User> getAllUsers() {
        //logic to fetch all users from database
    }
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        //logic to fetch user by id from database
    }
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        //logic to create a new user in the database
    }
    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        //logic to update user by id in the database
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        //logic to delete user by id from the database
    }
}

```

### [ResponseEntity](https://www.baeldung.com/spring-response-entity)
**ResponseEntity** class is used to represent an HTTP response, including the status code, headers, and body. 

It allows you to customize the response sent back to the client.
```java
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        //logic to get user from database by ID
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
            // return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

```


### Annotation
1. ``@RestController``: It  is used to indicate that a class is a **``REST``** controller that handles HTTP requests and produces HTTP responses in the form of JSON or XML data. It  is a combination of the @Controller and @ResponseBody annotations.
2. ``@RequestMapping``: It is used to map a URI to a specific method or controller class.
3. ``@GetMapping``: It is used to map a GET request to a specific method in a controller class.
4. ``@RequestBody``: It is used to map the body of an HTTP request to a Java object.
5. ``@ResponseBody``: It  is used to indicate that the return value of a method should be serialized directly to the HTTP response body.
6. ``@PathVariable``: It  is used to extract a variable from a URI path and use it as a method parameter.