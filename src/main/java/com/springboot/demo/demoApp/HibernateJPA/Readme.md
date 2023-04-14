# Hibernate and Java Persistence API

### JPA
It is a persistence technologies that can be used to interact with a database.

It defines a set of interfaces and annotations that allow you to map Java objects to relational database tables and vice versa.

JPA provides the ``EntityManager`` interface which is used to perform database operations on JPA entities. It provides methods for CRUD (Create, Read, Update, Delete) operations.
```java
@Autowired
private EntityManager entityManager;

public void saveUser(User user) {
    entityManager.getTransaction().begin();
    entityManager.persist(user);
    entityManager.getTransaction().commit();
}

```

## Mapping

### One-to-One
```@OneToOne``` annotation is used to map a one-to-one relationship between two entities.
```java
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // constructor, getters and setters
}

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zip;
    // constructor, getters and setters
}
```
-  the Employee entity has a @OneToOne relationship with the Address entity.
- The ```@JoinColumn``` annotation is used to specify the foreign key column in the employee table that references the primary key column in the address table.
- The **cascade attribute** of the @OneToOne annotation is set to ```CascadeType.ALL```, which means that any operations performed on the Employee entity will also be applied to the associated Address entity.

### One-to-many
```@OneToMany``` annotation is used to define a one-to-many relationship between two entities.
```java
@Entity
public class Parent {
   @Id
   @GeneratedValue
   private Long id;
   
   private String name;
   
   @OneToMany(mappedBy = "parent")
   private List<Child> children;
   // getters and setters
}

@Entity
public class Child {
   @Id
   @GeneratedValue
   private Long id;
   
   private String name;
   
   @ManyToOne
   @JoinColumn(name = "parent_id")
   private Parent parent;
   
   // getters and setters
}

```
- The ``mappedBy`` attribute in the @OneToMany annotation is used to specify the name of the attribute in the child entity class that maps to the parent entity class.
- The ```@ManyToOne``` annotation is used in the Child class to specify the relationship with the Parent class.
- The ```@JoinColumn``` annotation is used to specify the foreign key column name in the child table.


## Annotation
1. ``@Entity``: It is  used to define a persistent entity class. An entity class represents a database table, and its fields represent columns in that table.
2. ``@Id``: It is used to specify the primary key of the entity.
3. ``@GeneratedValue``: It is used to specify how the primary key is generated.
4. ``@Table(name="")``: It is used to specify name of the database table.
5. ``@Transaction``: It is used to ensure that a method executes within a transaction context, which means that if the method fails or throws an exception, any database changes made within that transaction will be rolled back.