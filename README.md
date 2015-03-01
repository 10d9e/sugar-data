# Sugar Data
A simple POJO based database abstraction.  Sugar Data allows you to create annotated DAO interfaces and automatically serializes your Pojo's to JDBC datasources

# Quick Start

1. Supply a @Datasource annotation that contains the connection information and unique identifier of the JDBC datasource.  This can be placed on any class, but it is recommended to keep it on your entity or Dao classes.

2. Define an interface that will represent your Data Access Object (DAO).  Note the name of the ```@Bind``` annotations in the parameters are referenced with braces in the annotated SQL ```@Update``` or ```@Query``` expression.

```
@Datasource(id="data1", url="jdbc:h2:mem:test", user="username", password="password")
public interface SomethingDao {

    @Update("create table something(id int, name varchar(100), birthday date)")
    void create();
    
    @Update("insert into something(id, name, birthday) values ({id}, {name}, {birthday})")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("birthday") Date birthday);
    
    @Query("select name from something")
    Collection<String> findAllNames();

    @Query("select * from something where id = {id} and name = {name}")
    Something find(@Bind("id") int id, @Bind("name") String name);
    
    @Query("select name from something where name = {n}")
    List<Map<String, String>> findNames(@Bind("n") String name);
}
```

3.  Inject the dao into your service class with the @Dao annotation, referencing the Datasource by unique id.
```
class MyService{

    @Dao("data1")
    private SomethingDao dao;
    
    ...
```    
