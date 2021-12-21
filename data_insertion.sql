INSERT INTO user(email,password,solde)
VALUES('email1@gmail.com','$2a$10$Xb9WVbjDJfz094nb.5Il7.HQKiaMiWtMWL0YON8l2JlYnldBz9lZe','100'),
('email2@gmail.com','$2a$10$ZjNuv2JWyvEAeePmZgI0s.V1JxJuRGM3H2wtfcXB.jvMIpO2iXq2u','110'),
('email3@gmail.com','$2a$10$vIznOut4IoOCx3IbVsoI8exOSL7HvXsiygHcjf15XZq9qa3duzaym','200'),
('email11@gmail.com','$2a$10$5yKVDmMtWDfIiom26UddY.7/TCYSnsjDPTlP4oBm3YoI.sLQm.9Bq','610'),
('email22@gmail.com','$2a$10$98mCdTaiNJBKQUE2DgZslu3kizWPViUtxHdsSpxOU/J70AxB6GRd2','800'),
('email33@gmail.com','$2a$10$ftI13fnKlpbmokhJQvGUA.cqn5agxvbtMhgGbIR8xD9KhxRhmMTJO','60'),
('email4@gmail.com','$2a$10$jLEidWIoY0..dAhv51DURu5WqX0pSD8aNMLILaZxJhyntCGlFjFvS','100'),
('email5@gmail.com','$2a$10$5gTAwIRdNb4K5cr3y/9a5eDzZvFCe5K8IXLLpF2zZyg1xJo4vHQtW','110'),
('email6@gmail.com','$2a$10$g/Tpnm/gpKHwXuRdNMMexer5JSyIY5rP4KplsctZU2VIOhyEqbZm2','110'),
('email7@gmail.com','$2a$10$As/pmSzJ4Y/2pwaQJgC.Cep15GabZSM4/NRCqzHxARewFIRKYymsu','110'),
('email8@gmail.com','$2a$10$ai2/79bX//XmyXJirb7Izec8885XyB6qOCShSBBVktSzJMTHGeGku','200'),
('email9@gmail.com','$2a$10$7nmszRMNfrjxVo6bnvDhu.D1CKlawblDs1Bbyldn1DzuA5KsUbJNC','110'),
('email10@gmail.com','$2a$10$F2To1ReUEvvIRUKrnznHbuMWPdEaOdNeyOiGFeim6ht3AYghz7loy','610'),
('email44@gmail.com','$2a$10$9cKYNSDhk1bFe/5EBtNDD.cvNe25yq5yGbeDwNcr2QvAnxMv2z1Ou','800'),
('email55@gmail.com','$2a$10$YElZq.c2a1zeBGNeT5MFU.pnLT0uJwAwWAJel/W323Q7CrWVPboiK','60');
('email66@gmail.com','$2a$10$NyU/4EvkICWB0ASgYip/HeY6DGVZHK9mLByH2mb/qX1Bs7WxJaJci','110'),
('email77@gmail.com','$2a$10$pFsRKt8ExdhGBYTWLbXUXOCV1NyyNlJ1j.z1hu5h67sOen9rbZyye','110'),
('email88@gmail.com','$2a$10$M2fJTU4RUIQ6nP7lZ3mf1.MA1XiXbF3XKvdSdPvZzHXRBwJ7.FqXK','110'),
('email99@gmail.com','$2a$10$XJ545EeJUUbNaWM0bk.vbuvjxpqVuaR84nxaIjUUApmGaXOutInUa','110'),

INSERT INTO contact(email_origin,email_contact,name)
VALUES('email1@gmail.com','email11@gmail.com','contact1'),
('email2@gmail.com','email22@gmail.com','contact2'),
('email3@gmail.com','email33@gmail.com','contact3'),
('email4@gmail.com','email44@gmail.com','contact4'),
('email5@gmail.com','email55@gmail.com','contact5'),
('email6@gmail.com','email66@gmail.com','contact6'),
('email7@gmail.com','email77@gmail.com','contact7'),
('email8@gmail.com','email88@gmail.com','contact8'),
('email9@gmail.com','email99@gmail.com','contact6'),
('email1@gmail.com','email4@gmail.com','Jlo');

INSERT INTO money_transaction(email_origin,email_recipient,description,creation_date,amount)
VALUES('email1@gmail.com','email11@gmail.com','transaction number 1','2020-10-27 11:53:25','100'),
('email2@gmail.com','email22@gmail.com','transaction number 2','2020-10-28 10:43:25','110'),
('email3@gmail.com','email33@gmail.com','transaction number 3','2020-10-29 13:18:00','200');



