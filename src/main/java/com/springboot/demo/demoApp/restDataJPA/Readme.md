# [JPA Repository](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories)

It's interfaces that extend the ``JpaRepository interface`` provided by Spring Data JPA, and **define methods** for performing CRUD (create, read, update, delete) operations on database entities.

It allows developers to focus on writing business logic instead of database queries.

Example:
```
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

```
- The ``UserRepository`` interface extends the ``JpaRepository interface`` and specifies the **User** class as the entity type and **Long** as the type of the primary key.

JPA to interact with ``User`` entity:
```
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}

```

## [Derived Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

It  allow you to define queries based on the method names of your repository interface.

Spring Boot automatically generates the necessary SQL statements for performing the specified queries.
```
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // finds all employees in a given department.
    List<Employee> findByDepartment(String department);

    // finds all employees with a salary greater than a given value.
    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findByDepartmentAndSalaryGreaterThan(String department, double salary);

    List<Employee> findByNameContainingIgnoreCase(String name);

    //  finds all employees in any of the given departments.
    List<Employee> findByDepartmentIn(List<String> departments);

}

```

## Java Persistence Query Language
It allows you to write database queries in an object-oriented way, using entity classes and their fields instead of tables and columns.

In JPQL, **entity names** are used instead of table names, and **attribute names** are used instead of column names.
```
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e")
    List<Employee> getAllEmployee();

    @Query("SELECT e FROM Employee e WHERE e.name =:n")
    List<Employee> getEmployeeByName(@Param("n") String name);

}

```
- The method uses the ```@Query``` annotation to specify a custom JPQL (Java Persistence Query Language) query, which is executed by the JPA provider.
- The ```@Param``` annotation is used to map the method parameter to a named parameter in the query.

### Annotation
1. ``@Repository``: It  indicate that a class is a repository, which is a Spring component that provides access to a data store, such as a database.
2. ``@Query``: It is used to specify custom SQL or JPQL (Java Persistence Query Language) queries in Spring Data JPA. This annotation allows you to write queries that are more complex than the ones that can be generated using the repository method name conventions.
3. ``@Param``: It  is used to specify the name of the parameter that is passed to the query.