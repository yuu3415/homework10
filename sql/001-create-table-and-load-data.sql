DROP TABLE IF EXISTS music;

CREATE TABLE music (
  id int unsigned AUTO_INCREMENT,
  title VARCHAR(20) NOT NULL,
  singer VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
  UNIQUE KEY(title)
);


INSERT INTO music (id, title, singer) VALUES (1, 'The Beginning', 'OneOkRock');
INSERT INTO music (id, title, singer) VALUES (2, 'Pretender', 'Official髭男dism');
INSERT INTO music (id, title, singer) VALUES (3, 'Lemon', '米津玄師');
INSERT INTO music (id, title, singer) VALUES (4, '打上花火', 'DAOKO×米津玄師');
