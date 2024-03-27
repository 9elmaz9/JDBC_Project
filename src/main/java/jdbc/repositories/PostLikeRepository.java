package jdbc.repositories;

import jdbc.model.PostLike;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostLikeRepository {
    //
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }


    //1
    public long create(PostLike newPostLike) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement createStatement = connection.prepareStatement(
                     "INSERT INTO PostLike (postId, userId) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            // Set values for placeholders
            createStatement.setLong(1, newPostLike.getPostId());
            createStatement.setLong(2, newPostLike.getUserId());
            // Execute the insert statement
            int affectedRows = createStatement.executeUpdate();
            // Check if the insertion was successful
            if (affectedRows > 0) {
                // Retrieve the generated key (if any)
                try (ResultSet generatedKeys = createStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Return the generated key
                    } else {
                        throw new SQLException("Creating PostLike failed, no ID obtained.");
                    }
                }
            } else {
                // Insertion failed, return -1
                return -1;
            }
        } catch (SQLException e) {
            // Handle the exception (logging, error message, etc.)
            e.printStackTrace();
            // Return -1 if an exception occurs
            return -1;
        }
    }

    public PostLike read(long id) throws SQLException {
        try (
                Connection connection = getConnection();
                PreparedStatement selectStatement = connection.prepareStatement("SELECT *FROM PostLike WHERE id = ?")) {
            selectStatement.setLong(1, id);
//my
            // String selectSQL = "SELECT *PostLike WHERE id = " + id;

            ResultSet resultSet = selectStatement.executeQuery();

            //check
            if (resultSet.next()) {
                PostLike postLike = new PostLike();
                postLike.setPostId((resultSet.getLong("postId")));
                postLike.setPostId(resultSet.getLong("userId"));
                return postLike;
            } else {
                // return null if fails
                return null;
            }
        } finally {
        }
    }


    public List<PostLike> read(PostLike example) throws SQLException {
        List<PostLike> postLikes = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM PostLike WHERE id = ? AND userId=?")
        ) {

            selectStatement.setLong(1, example.getPostId());
            selectStatement.setLong(2, example.getUserId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                PostLike postLike = new PostLike();
                postLike.setPostId(resultSet.getLong("postId"));
                postLike.setUserId(resultSet.getLong("userId"));
                postLikes.add(postLike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // add read statements here..

        // return empty collection if fails
        //return Collections.emptyList();
        return postLikes;
    }

    public List<PostLike> read() throws SQLException {
        List<PostLike> postLikes = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement selectStatement = connection.createStatement()) {
            String selectSQL = "SELECT * FROM PostLike";
            ResultSet resultSet = selectStatement.executeQuery(selectSQL);
            while (resultSet.next()) {
                PostLike postLike = new PostLike();
                postLike.setPostId(resultSet.getLong("postId"));
                postLike.setUserId(resultSet.getLong("userId"));
                postLikes.add(postLike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postLikes;
    }

    public boolean update(long id, PostLike existingPostLike) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement updateStatement = connection.prepareStatement("UPDATE postLike SET postId = ?,user=? WHERE id=?")) {
            updateStatement.setLong(1, existingPostLike.getPostId());
            updateStatement.setLong(2, existingPostLike.getUserId());
            updateStatement.setLong(3, id);

            int rowAffected = updateStatement.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM PostLike WHERE id=?")) {
            deleteStatement.setLong(1, id);
            int rowAffected = deleteStatement.executeUpdate();
            return rowAffected > 0;
        }

    }

}
