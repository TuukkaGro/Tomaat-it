CREATE DATABASE MariaDBtomaatit;

CREATE TABLE Producer (
    producerID int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    PRIMARY KEY(producerID)
    );

INSERT INTO Producer (name)
VALUES ('M&M'),
('Leikki');

CREATE TABLE Clothing (
    clothingID int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    type varchar(50),
    price int,
    producerID int,
    PRIMARY KEY (clothingID),
    FOREIGN KEY (producerID) REFERENCES Producer(producerID)
    );

INSERT INTO Clothing (name, type, price, producerID)
VALUES ('JoustavaMeno', 'Haalari', 59.00, 1),
('70-luku', 'Haalari', 32.00, 2);