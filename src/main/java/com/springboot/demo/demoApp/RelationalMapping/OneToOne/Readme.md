# One To One Relationship

## Unidirectional


A unidirectional `````@OneToOne````` association means that there is only one association between two entities, and it is defined in only one direction.

This means that one entity has a reference to another entity, but the other entity does not have a reference to the first entity.

Example:
```java
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // constructors, getters and setters
}

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    // constructors, getters and setters
}

```
-  the **Person** entity has a reference to an **Address** entity using the ```@OneToOne``` annotation. However, the Address entity does not have a reference to the Person entity.
- The ```@JoinColumn``` annotation is used to specify the foreign key column **address_id** in the person table that references the **id** column in the address table.
- The ``cascade = CascadeType.ALL`` option specifies that when a **Person** entity is persisted or updated, the associated **Address** entity should also be persisted or updated.
- With this mapping, each Person entity can have at most one Address entity associated with it.


## Bidirectional

A bidirectional ```@OneToOne``` association is a relationship between two entities in which each entity has a reference to the other. 

This means that each entity can navigate to the other entity using its reference.

```java
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Address address;

    // constructors, getters and setters
}

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // constructors, getters and setters
}

```
- The Person entity has a reference to an Address entity using the ```@OneToOne``` annotation with the **mappedBy** attribute.
- The Address entity has a reference to the Person entity using the @OneToOne annotation with the ```@JoinColumn``` annotation.