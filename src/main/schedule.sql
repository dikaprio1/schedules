CREATE TABLE schedules (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           title VARCHAR(200) NOT NULL,
                           author_name VARCHAR(100) NOT NULL,
                           password VARCHAR(200) NOT NULL,
                           created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                           updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);