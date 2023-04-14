#  Inversion of Control Pattern

### Inversion of Control container
IoC container is responsible for creating and managing objects (or beans) in your application, and it does this by **injecting dependencies** into those objects.

This means that you don't have to worry about creating objects yourself, or managing the dependencies between them. Instead, you simply declare the dependencies that your objects need, and the Spring container takes care of the rest.



### Dependency Injection
Dependency Injection makes our programming code loosely coupled.

It means that the container injects dependencies (i.e., objects that a class depends on) into the class at runtime, rather than having the class create or find its dependencies itself.

```java
@Service
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    // Here, the MyService class depends on an instance of MyRepository. 
    // Rather than creating the MyRepository instance itself, 
    // the Spring container injects an instance of MyRepository into the MyService constructor at runtime.
}

```

## Annotation

1. ``@Bean``: It is used to declare a method as a bean that will be managed by the Spring framework's IoC container.When you mark a method with the **@Bean annotation**, Spring will automatically manage the lifecycle of the bean created by that method, and will make it available for dependency injection to other beans.
2. ``@Configuration``: It is used to define beans (i.e., objects) and their relationships within the Spring container.By using configuration classes and @Bean methods, you can easily define the objects and relationships that make up your application.
3. ``@Autowired``: It is used to automatically inject dependencies (i.e., objects that a class depends on) into a Spring-managed bean.When you mark a class property, constructor, or setter method with the **@Autowired annotation**, the Spring container will automatically resolve and inject the appropriate dependency at runtime.
4. ``@Qualifier``: It is used to disambiguate dependencies when multiple beans of the same type are available for autowiring.
5. ``@Component``: It allows the class to be automatically detected and instantiated by the Spring container at runtime.
5. ``@Lazy``: Essentially you are telling the Spring container to only initialize the bean when it is actually requested, rather than at startup.
6. ``@Scope``: The scope of a bean defines how many instances of the bean will be created (```Singleton``` by default) and managed by the Spring container, and how long those instances will live.
7. ``@Primary``: It  is used to indicate that a **bean** should be given higher priority than other beans of the same type when the Spring container is autowiring dependencies.
8. ``@PostConstruct``: It is used to indicate a method that should be executed after a **bean** has been instantiated and its dependencies have been injected.
9. ``@PreDestroy``: It is used to indicate a method that should be executed before a bean is destroyed or removed from the Spring container.