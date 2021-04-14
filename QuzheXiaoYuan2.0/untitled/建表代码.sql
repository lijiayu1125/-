CREATE TABLE `user` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT,
                        `username` varchar(45) DEFAULT NULL,
                        `password` varchar(45) DEFAULT NULL,
                        `type` int NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
CREATE TABLE `student` (
                           `id` int NOT NULL,
                           `studentnum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                           `stuname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                           `major` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                           `time` int NOT NULL,
                           UNIQUE KEY `studentnum_UNIQUE` (`studentnum`),
                           UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
CREATE TABLE `sponsor` (
                           `id` int unsigned NOT NULL,
                           `association_name` varchar(20) NOT NULL,
                           `introduction` varchar(60) DEFAULT NULL,
                           `charge` varchar(10) NOT NULL,
                           `phonenum` varchar(11) NOT NULL,
                           UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `active` (
                          `id` int unsigned NOT NULL AUTO_INCREMENT,
                          `activename` varchar(45) NOT NULL,
                          `activecontent` varchar(45) DEFAULT NULL,
                          `activetype` varchar(45) NOT NULL,
                          `activeplace` varchar(45) NOT NULL,
                          `activetime` datetime NOT NULL,
                          `activegive` int unsigned NOT NULL,
                          `activelimit` int unsigned NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `activeid_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci