# sugar-data
A simple POJO based database abstraction.  Sugar Data allows you to create annotated DAO interfaces and automatically serializes your Pojo's to JDBC datasources

# Quick Start
First define an interface that will represent your Data Access Object (DAO).  Note the name of the @Bind annotations in the parameters are referenced with braces in the annotated SQL @Update or @Query expression.

```
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
