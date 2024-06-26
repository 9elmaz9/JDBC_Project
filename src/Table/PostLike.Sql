CREATE TABLE PostLike (
                          postId BIGINT NOT NULL,
                          userId BIGINT NOT NULL,
                          PRIMARY KEY (postId, userId),
                          FOREIGN KEY (postId) REFERENCES Post(id),
                          FOREIGN KEY (userId) REFERENCES User(id)
);



INSERT INTO PostLike (postId, userId)
VALUES
      (1, 3), (1, 5), (1, 7), (1, 9), (1, 10),
      (2, 2), (2, 4), (2, 6), (2, 8), (2, 10),
      (3, 1), (3, 3), (3, 5), (3, 7), (3, 9),
      (4, 2), (4, 4), (4, 6), (4, 8), (4, 10),
      (5, 1), (5, 3), (5, 5), (5, 7), (5, 9),
      (6, 2), (6, 4), (6, 6), (6, 8), (6, 10),
      (7, 1), (7, 3), (7, 5), (7, 7), (7, 9),
      (8, 2), (8, 4), (8, 6), (8, 8), (8, 10),
      (9, 1), (9, 3), (9, 5), (9, 7), (9, 9),
      (10, 2), (10, 4), (10, 6), (10, 8), (10, 10);