ALTER TABLE user_categories
    ADD CONSTRAINT uk_user_categories_user_id_category_id UNIQUE (user_id, category_id);