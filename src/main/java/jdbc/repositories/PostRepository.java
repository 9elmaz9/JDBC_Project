package jdbc.repositories;

import jdbc.model.Post;
import jdbc.model.PostLike;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostRepository {


    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }

    // example

    public long create(Post newPost) throws SQLException {
//        Statement createStatement = getConnection().createStatement();
//        String query = "INSERT INTO post " +
//                "(user_id, title) " +
//                "VALUES " +
//                "('" + newPost.getUserId() + "', " +
//                "'" + newPost.getTitle() + "')";
////        statement.executeUpdate() -> creates a record, or updates a record.
//        return createStatement.executeUpdate(query);
//        //Statement createStatement = getConnection().createStatement();
        String query = "insert into post (user_id, title,slug,image,body,published) values (?, ?,?,?,?,?)";
        PreparedStatement insertStatement = getConnection().prepareStatement(query);
//set
        insertStatement.setLong(1, newPost.getUserId());
        insertStatement.setString(2, newPost.getTitle());
        insertStatement.setString(3, newPost.getSlug());
        insertStatement.setString(4, newPost.getImage());
        insertStatement.setString(5, newPost.getBody());
        insertStatement.setLong(6, newPost.getPublished());
// execute the insert statement  and return nul of affectedRow
        return insertStatement.executeUpdate();
    }


    //1 second one
    public Post read(long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement selectStatement = connection.prepareStatement("SELECT *FROM post WHERE id=?")) {
            selectStatement.setLong(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getLong("id"));
                post.setUserId(resultSet.getLong("user_id"));
                post.setTitle(resultSet.getString("Title"));
                post.setSlug(resultSet.getString("slug"));
                post.setImage(resultSet.getString("image"));
                post.setBody(resultSet.getString("body"));
                post.setPublished(resultSet.getLong("published"));
                return post;
            } else {
                // return null if fails
                return null;
            }
        }

    }

    //2 klaar
    public List<Post> read(Post example) throws SQLException {

        String query = "insert into post (user_id,id) values (?, ?)";
        PreparedStatement insertStatement = getConnection().prepareStatement(query);

        List<Post> postList = new ArrayList<>();
     // try (
     //         Connection connection = getConnection();
     //         PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM PostLike WHERE id = ? AND userId=?")
     // ) {

            insertStatement.setLong(1, example.getId());
            insertStatement.setLong(2, example.getUserId());
            ResultSet resultSet = insertStatement.executeQuery();

            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getLong("id"));
                post.setUserId(resultSet.getLong("user_id"));
                post.setTitle(resultSet.getString("title"));
                post.setSlug(resultSet.getString("slug"));
                post.setImage(resultSet.getString("image"));
                post.setBody(resultSet.getString("body"));
                post.setPublished(resultSet.getLong("published"));
                postList.add(post);
            }

            return postList;
        }



//3   klaar

    public List<Post> read() throws SQLException {
        List<Post> postList = new ArrayList<>();

        Statement selectStatement = getConnection().createStatement();

        String query = "SELECT * FROM POST";
        ResultSet resultSet = selectStatement.executeQuery(query);
// itterate  through   the result
        while (resultSet.next()) {
            Post post = new Post();
            post.setId(resultSet.getLong("id"));
            post.setUserId(resultSet.getLong("user_id"));
            post.setTitle(resultSet.getString("title"));
            post.setSlug(resultSet.getString("slug"));
            post.setImage(resultSet.getString("image"));
            post.setBody(resultSet.getString("body"));
            post.setPublished(resultSet.getLong("published"));
            postList.add(post);

        }
        return postList;

    }


//4 update

    public boolean update(long id, Post existingPost) throws SQLException {
 // query to update
        String query = "UPDATE post SET user_id =?, title=?,slug=?,image=?, body=?,published=? WHERE  id=?";
        try (Connection connection = getConnection();

             PreparedStatement updateStatement = connection.prepareStatement(query)) {
            // set values
            updateStatement.setLong(1, existingPost.getUserId());
            updateStatement.setString(2, existingPost.getTitle());
            updateStatement.setString(3, existingPost.getSlug());
            updateStatement.setString(4, existingPost.getImage());
            updateStatement.setString(5, existingPost.getBody());
            updateStatement.setLong(6, existingPost.getPublished());
            updateStatement.setLong(7, id);

            int rowsAffected = updateStatement.executeUpdate();
            // return false if fails
            return rowsAffected > 0;
        }
    }

    //5
    public boolean delete(long id) throws SQLException {
        String query = "DELETE FROM post WHERE id=?";
        try (Connection connection=getConnection();
        PreparedStatement deleteStatement= connection.prepareStatement(query)){
            //prepared
            deleteStatement.setLong(1,id);
            //execute delete
            int rowsAffected = deleteStatement.executeUpdate();

            // return false if fails
            return rowsAffected>0;
        }
    }
}
