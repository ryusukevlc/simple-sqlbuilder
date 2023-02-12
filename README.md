# simple-sqlbuilder
Under development.

The following are the features of this utility class  
- It can be written in query builder format and returns an SQL string by executing create().
- You don't need to manage a lot of files. You can use this class just by installing it in your project.

##  Example

1. Specify by List  
"table" and "columns" are specified as String, and value can be any type.
```Java
List<String> columns = new ArrayList<>() {{
    add("id");
    add("title");
    add("content");
    add("isDraft");
}};
List<Object> values = new ArrayList<>() {{
    add(1);
    add("this is title");
    add("this is content");
    add(true);
}};
String sql = new InsertCreator().table("articles").columns(columns).values(values).create();
// INSERT INTO articles (id, title, content, isDraft) VALUES (1, 'this is title', 'this is content', true);
 ```
 
 2. Specify by variable length parameter  
 "values" allows variable-length arguments only when the arguments are of the same type.
 ```Java
 String sql = new InsertCreator().table("articles").columns("number_one", "number_two").values(1, 2).create()
 // INSERT INTO articles (number_one, number_two) VALUES (1, 2);
  ```
