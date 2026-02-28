CREATE TABLE study_log(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    study_date DATE,
    start_time TIME,
    end_time TIME,
    study_hours INT,
    created_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id)
);