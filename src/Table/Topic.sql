CREATE TABLE Topic (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       slug VARCHAR(255) NOT NULL
);


INSERT INTO Topic (name, slug)
VALUES
        ('Algorithms & Data Structures', 'algorithms-data-structures'),
        ('Art & Creativity', 'art-creativity'),
        ('Music & Composition', 'music-composition'),
        ('Culinary Delights', 'culinary-delights'),
        ('Travel & Exploration', 'travel-exploration'),
        ('Literature & Reading', 'literature-reading'),
        ('Fitness & Wellness', 'fitness-wellness'),
        ('Environmental Activism', 'environmental-activism'),
        ('Technology & Innovation', 'technology-innovation'),
        ('Astronomy & Space Exploration', 'astronomy-space-exploration');