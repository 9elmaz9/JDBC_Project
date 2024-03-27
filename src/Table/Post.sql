CREATE TABLE Post (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      userId BIGINT NOT NULL,
                      title VARCHAR(255) NOT NULL,
                      slug VARCHAR(255) NOT NULL,
                      views BIGINT DEFAULT 0,
                      image VARCHAR(255),
                      body TEXT,
                      published BIGINT,
                      createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      FOREIGN KEY (userId) REFERENCES User(id)
);

INSERT INTO Post (userId, title, slug, views, image, body, published)
VALUES
        (1, 'Unlocking the Secrets of Algorithms', 'unlocking-secrets-algorithms', 500, 'algorithm.jpg', 'Delving deep into the intricacies of algorithms, revealing their beauty and power.', 1),
        (2, 'Brush Strokes of Creativity', 'brush-strokes-creativity', 350, 'painting.jpg', 'Exploring the depths of imagination through vibrant strokes and colors.', 1),
        (3, 'Harmony in Melodies', 'harmony-melodies', 600, 'music.jpg', 'Crafting symphonies that resonate with the soul, weaving tales through notes.', 1),
        (4, 'Taste of Adventure', 'taste-adventure', 450, 'food.jpg', 'Embarking on culinary journeys, savoring flavors from every corner of the globe.', 1),
        (5, 'Footprints in Foreign Lands', 'footprints-foreign-lands', 400, 'travel.jpg', 'Traversing through unknown paths, collecting stories from distant shores.', 1),
        (6, 'Worlds Between Pages', 'worlds-between-pages', 550, 'books.jpg', 'Losing oneself in the realms of literature, where stories come to life.', 1),
        (7, 'Sweat and Success', 'sweat-success', 480, 'fitness.jpg', 'Pushing limits, sculpting bodies, and embracing the journey to wellness.', 1),
        (8, 'Guardians of Nature', 'guardians-nature', 520, 'environment.jpg', 'Standing tall for the planet, advocating for a greener and cleaner tomorrow.', 1),
        (9, 'Innovating Tomorrow', 'innovating-tomorrow', 580, 'innovation.jpg', 'Pioneering solutions that shape the future, turning dreams into reality.', 1),
        (10, 'Stargazing Adventures', 'stargazing-adventures', 420, 'stars.jpg', 'Lost in the vast expanse of the cosmos, seeking answers among the stars.', 1);
