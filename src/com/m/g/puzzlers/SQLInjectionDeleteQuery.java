package com.m.g.puzzlers;

public class SQLInjectionDeleteQuery {
}

/**
 * package com.pastebin.service.post;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import java.util.ArrayList;
 import java.util.List;

 import javax.sql.DataSource;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import com.pastebin.model.Post;

 @Service
 public class PostServiceImpl implements PostService {

 @Autowired
 private DataSource dataSource;

 private final String insertQuery = "insert into posts "
 + "(title, description, name, email) values (?, ?, ?, ?)";
 private final String selectQuery = "select id, title, description, "
 + "name, email from posts";
 private final String deletePostQuery = "delete from posts ";
 private final String deletePostByIdQuery = deletePostQuery + "where id = ";

 @Override
 public boolean savePost(Post post) {
 try (Connection con = dataSource.getConnection();
 PreparedStatement statement = con.prepareStatement(insertQuery)) {
 statement.setString(1, post.getTitle());
 statement.setString(2, post.getDescription());
 statement.setString(3, post.getName());
 statement.setString(4, post.getEmail());
 return !statement.execute();
 } catch (Exception e) {
 e.printStackTrace();
 return false;
 }
 }

 @Override
 public List<Post> getAllPosts() {
 try (Connection con = dataSource.getConnection();
 Statement statement = con.createStatement()) {
 ResultSet data = statement.executeQuery(selectQuery);
 List<Post> dataList = new ArrayList<Post>();
 while (data.next()) {
 Post post = new Post();
 post.setId(data.getLong(1));
 post.setTitle(data.getString(2));
 post.setDescription(data.getString(3));
 post.setName(data.getString(4));
 post.setEmail(data.getString(5));
 dataList.add(post);
 }
 return dataList;
 } catch (Exception e) {
 e.printStackTrace();
 return null;
 }
 }

 @Override
 public boolean deletePost(Long id) {
 StringBuilder query = new StringBuilder(deletePostByIdQuery).append(id);
 try (Connection con = dataSource.getConnection();
 PreparedStatement statement = con
 .prepareStatement(query.toString())) {
 return !statement.execute();
 } catch (Exception e) {
 e.printStackTrace();
 return false;
 }
 }

 @Override
 public boolean deleteUserPost(Post post) {
*************************************************************************************************************

 ================= problem code start =====================

 StringBuilder query = new StringBuilder(deletePostQuery)
 .append("where title = '").append(post.getTitle())
 .append("' and name = '").append(post.getName())
 .append("' and email = '").append(post.getEmail()).append("'");

 Problem Description: The delete query in "deleteUserPost" method is being constructed through StringBuilder() which makes it seem like the inputs are being parameterized. However, as the inputs are simply being concatenated into the query, the functionality is vulnerable to SQL injection attack. This compromises the security of the database as an attacker can exploit such a vulnerability to execute queries on the database by providing malicious data in the email field of the "deletePostPage" form.

 Though "getAllPosts" and "deletePost" methods also use nonparameterized queries, they cannot be used to execute SQL injection attack since no string based input is being concatenated into the query expression in these scenarios.

================= problem code end =====================


================= better code start =====================

 private final String deletePostQuery = "delete from posts "
 + "where title = ? and name = ? and email = ?";

 public boolean deleteUserPost(Post post) {
 try (Connection con = dataSource.getConnection();
 PreparedStatement statement = con
 .prepareStatement(deletePostQuery)) {
 statement.setString(1, post.getTitle());
 statement.setString(2, post.getName());
 statement.setString(3, post.getEmail());
 return !statement.execute();


 Solution Description: Parameterized SQL queries are used via PreparedStatement objects to perform all database operations that take user inputs. Since PreparedStatement uses bound parameters to execute database queries without relying on user inputs and any character in the user given data is only inserted within the already compiled SQL statement, this approach protects the application from SQL injection attack.

 ================= better code end =======================
 try (Connection con = dataSource.getConnection();
 Statement statement = con.createStatement()) {
 return !statement.execute(query.toString());
 } catch (Exception e) {
 e.printStackTrace();
 return false;
 }
 }

 }
 * */