# Hibernate and Java Persistence API

### JPA
It is a persistence technologies that can be used to interact with a database.

It defines a set of interfaces and annotations that allow you to map Java objects to relational database tables and vice versa.

JPA provides the ``EntityManager`` interface which is used to perform database operations on JPA entities. It provides methods for CRUD (Create, Read, Update, Delete) operations.
```
@Autowired
private EntityManager entityManager;

public void saveUser(User user) {
    entityManager.getTransaction().begin();
    entityManager.persist(user);
    entityManager.getTransaction().commit();
}

```

### Annotation
1. ``@Entity``: It is  used to define a persistent entity class. An entity class represents a database table, and its fields represent columns in that table.
2. ``@Id``: It is used to specify the primary key of the entity.
3. ``@GeneratedValue``: It is used to specify how the primary key is generated.
4. ``@Table(name="")``: It is used to specify name of the database table.
5. ``@Transaction``: It is used to ensure that a method executes within a transaction context, which means that if the method fails or throws an exception, any database changes made within that transaction will be rolled back.