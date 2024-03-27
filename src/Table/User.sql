CREATE TABLE User (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      role VARCHAR(50),
                      password VARCHAR(255) NOT NULL,
                      createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


INSERT INTO User (username, email, role, password)
VALUES
        ('coding_guru', 'coding.guru@example.com', 'developer', 'il0v3c0ding!'),
        ('artistic_soul', 'artistic.soul@example.com', 'artist', 'paintingmyworld'),
        ('music_maestro', 'music.maestro@example.com', 'composer', 'melodymaker'),
        ('culinary_adventurer', 'culinary.adventurer@example.com', 'chef', 'tastetheworld'),
        ('wanderlust_explorer', 'wanderlust.explorer@example.com', 'traveler', 'globetrotter'),
        ('bookworm_reader', 'bookworm.reader@example.com', 'librarian', 'page_turner'),
        ('fitness_enthusiast', 'fitness.enthusiast@example.com', 'trainer', 'healthylife'),
        ('eco_warrior', 'eco.warrior@example.com', 'activist', 'sustainearth'),
        ('tech_innovator', 'tech.innovator@example.com', 'entrepreneur', 'code4change'),
        ('star_gazer', 'star.gazer@example.com', 'astronomer', 'universewithin');
