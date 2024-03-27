CREATE TABLE PostTopic (
                           postId BIGINT NOT NULL,
                           topicId BIGINT NOT NULL,
                           PRIMARY KEY (postId, topicId),
                           FOREIGN KEY (postId) REFERENCES Post(id),
                           FOREIGN KEY (topicId) REFERENCES Topic(id)
);


INSERT INTO PostTopic (postId, topicId)
VALUES
          (1, 1), (1, 9),
          (2, 2), (2, 10),
          (3, 3), (3, 10),
          (4, 4), (4, 8),
          (5, 5), (5, 8),
          (6, 6), (6, 9),
          (7, 7), (7, 8),
          (8, 8), (8, 9),
          (9, 9), (9, 10),
          (10, 10);