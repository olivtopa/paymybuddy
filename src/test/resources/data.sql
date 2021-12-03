INSERT INTO user(email,password,solde)
VALUES('email1@gmail.com','$2a$10$Xb9WVbjDJfz094nb.5Il7.HQKiaMiWtMWL0YON8l2JlYnldBz9lZe','100'),
('email2@gmail.com','$2a$10$ZjNuv2JWyvEAeePmZgI0s.V1JxJuRGM3H2wtfcXB.jvMIpO2iXq2u','110'),
('email3@gmail.com','$2a$10$vIznOut4IoOCx3IbVsoI8exOSL7HvXsiygHcjf15XZq9qa3duzaym','200'),
('email11@gmail.com','$2a$10$5yKVDmMtWDfIiom26UddY.7/TCYSnsjDPTlP4oBm3YoI.sLQm.9Bq','610'),
('email22@gmail.com','$2a$10$98mCdTaiNJBKQUE2DgZslu3kizWPViUtxHdsSpxOU/J70AxB6GRd2','800'),
('email33@gmail.com','$2a$10$ftI13fnKlpbmokhJQvGUA.cqn5agxvbtMhgGbIR8xD9KhxRhmMTJO','60');

INSERT INTO contact(email_origin,email_contact,name)
VALUES('email1@gmail.com','email11@gmail.com','contact1'),
('email2@gmail.com','email22@gmail.com','contact2'),
('email3@gmail.com','email33@gmail.com','contact3');


INSERT INTO money_transaction(email_origin,email_recipient,description,creation_date,amount)
VALUES('email1@gmail.com','email11@gmail.com','transaction number 1','2020-10-27 11:53:25','100'),
('email2@gmail.com','email22@gmail.com','transaction number 2','2020-10-28 10:43:25','110'),
('email3@gmail.com','email33@gmail.com','transaction number 3','2020-10-29 13:18:00','200');



