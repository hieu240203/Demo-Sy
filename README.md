# Demo-Sy  
Ngôn ngữ:: Java Springboots Maven  
DataBase: mySQL  
CREATE TABLE `users` (  
  `id` bigint NOT NULL AUTO_INCREMENT,  
  `username` varchar(255) NOT NULL,  
  `email` varchar(255) NOT NULL,  
  `password` varchar(255) NOT NULL,  
  `gender` enum('MALE','FEMALE') NOT NULL,  
  `birthday` date DEFAULT NULL,  
  `createdAt` datetime DEFAULT NULL,  
  `jwt_token` varchar(512) DEFAULT NULL,  
  `created_at` datetime(6) DEFAULT NULL,  
  PRIMARY KEY (`id`),  
  UNIQUE KEY `username_UNIQUE` (`username`),  
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci  
API:    
-	Sign up:  
+	POST: /ui/v1/auth/signup  
+	Inupt:   
{  
  "username": "vietanh",  
  "email": "vietdcom1234@gmail.com",  
  "password": "Va@01646049423",  
  "gender": "MALE",  
  "birthday": "2003-09-23"  
}  
+	Ouput: User created successfully!  
-	Log in:  
+	POST /ui/v1/auth/login  
+	Input:  
{  
  "email": "vietdcom1234@gmail.com",  
  "password": "Va@01646049423"  
}  
+	Output: jwt_token  
Use jwt_token: jwt.io  
  
