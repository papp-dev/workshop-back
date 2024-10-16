CREATE TABLE IF NOT EXISTS
    `users` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `resource_id` VARCHAR(36) NOT NULL,
        `user_name` VARCHAR(256),
        `email` VARCHAR(256),
        `password` VARCHAR(256),
        PRIMARY KEY (`id`),
        CONSTRAINT uc_user_resource_id UNIQUE(`resource_id`)
    );