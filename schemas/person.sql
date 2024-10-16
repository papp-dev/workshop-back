CREATE TABLE IF NOT EXISTS
    `people` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `resource_id` VARCHAR(36) NOT NULL,
        `name` VARCHAR(512),
        `weight` DECIMAL (10,8),
        `height` DECIMAL (10,8),
        PRIMARY KEY (`id`),
        CONSTRAINT uc_person_resource_id UNIQUE(`resource_id`)
    );