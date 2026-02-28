CREATE TABLE study_goal(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    weekly_hours INT,
    study_days INT,
    daily_hours INT,
    apply_month INT,
    created_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id)
);