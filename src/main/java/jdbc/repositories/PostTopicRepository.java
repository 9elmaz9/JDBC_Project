package jdbc.repositories;

import jdbc.model.PostTopic;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class PostTopicRepository {

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
    public long create(PostTopic newPostTopic) throws SQLException {
        try (Connection connection = getConnection();
             Statement createStatement = connection.createStatement()) {
            String insertQuery = "INSERT INTO PostTopic (postId, topicId) VALUES (" +
                    newPostTopic.getPostId() + ", " +
                    newPostTopic.getTopicId() + ")";

            int rowsAffected = createStatement.executeUpdate(insertQuery);
            if (rowsAffected == 0) {
                throw new SQLException("Creating PostTopic failed, no rows affected.");
            } else {
                // Return the ID of the newly created post-topic relationship
                return newPostTopic.getPostId();
            }
        }
    }


    //2
    public PostTopic read(long id) throws SQLException {
        try (Connection connection = getConnection();
             Statement selectStatement = connection.createStatement()) {

            String selectQUERY = "SELECT *FROM  post_topicWHERE id = " + id;

            ResultSet resultSet = selectStatement.executeQuery(selectQUERY);

            //check
            if (resultSet.next()){

                //dan
                PostTopic postTopic = new PostTopic();
                postTopic.setPostId(resultSet.getLong("id"));
                postTopic.setPostId(resultSet.getLong("postId"));
                postTopic.setTopicId(resultSet.getLong("topicId"));
                return postTopic;
            }else

                // returnnull if fails
                return null;
            }
        }




public List<PostTopic> read(PostTopic example) throws SQLException {

    Statement selectStatement = getConnection().createStatement();

    // add read statements here..

    // return empty collection if fails
    return Collections.emptyList();
}

public List<PostTopic> read() throws SQLException {

    Statement selectStatement = getConnection().createStatement();

    // return empty collection if fails
    return Collections.emptyList();
}

public boolean update(long id, PostTopic existingPostTopic) throws SQLException {

    Statement updateStatement = getConnection().createStatement();

    // return false if fails
    return false;
}

public boolean delete(long id) throws SQLException {

    Statement deleteStatement = getConnection().createStatement();

    // return false if fails
    return false;
}
}
