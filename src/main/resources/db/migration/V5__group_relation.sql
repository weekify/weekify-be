CREATE TABLE study_group(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    leader_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    max INT,
    is_public BOOLEAN DEFAULT TRUE,
    created_at DATETIME,
    FOREIGN KEY (leader_id) REFERENCES users(id)
);

CREATE TABLE group_member(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    group_id BIGINT NOT NULL,
    join_at DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (group_id) REFERENCES study_group(id),
    CONSTRAINT uk_group_member_user_id_group_id UNIQUE (user_id, group_id)
);