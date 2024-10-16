CREATE TABLE IF NOT EXISTS
    `user_profiles` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `resource_id` VARCHAR(36),
        `user_id` VARCHAR(36),
        `artist_image_url` VARCHAR(36),
        `artist_name` VARCHAR(36),
        `description` VARCHAR(36),
        `phone_number` VARCHAR(36),
        `pix_key` VARCHAR(36),
        `pix_account_name` VARCHAR(36),
        PRIMARY KEY (`id`),
        FOREIGN KEY (`user_id`) REFERENCES users(`resource_id`)
    );