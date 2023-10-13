DROP TABLE IF EXISTS music;

CREATE TABLE music (
  id int unsigned AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  singer VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO songs (title, singer) VALUES ("The Beginning", "OneOkRock");
INSERT INTO songs (title, singer) VALUES ("Pretender", "Official髭男dism");
INSERT INTO songs (title, singer) VALUES ("Lemon", "米津玄師");
INSERT INTO songs (title, singer) VALUES ("打上花火", "DAOKO×米津玄師");
