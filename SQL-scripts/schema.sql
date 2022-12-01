/* foreign key checks
 * drops earlier tables if any exist */
SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE IF EXISTS Producer; 
DROP TABLE IF EXISTS Clothing; 
DROP TABLE IF EXISTS User;
SET FOREIGN_KEY_CHECKS=1;

/* Creates database
CREATE DATABASE tomaatit; */

/* Creates table for Producers */
CREATE TABLE Producer (
    producerID int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    PRIMARY KEY(producerid)
    );

/* inserts values into Producer table*/
INSERT INTO Producer (name)
VALUES ('M&M'),
('Leikki');

/* creates clothing table */
CREATE TABLE Clothing (
    clothingid int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    type varchar(50),
    price DECIMAL(5, 2),
    producerid int,
    PRIMARY KEY (clothingid),
    FOREIGN KEY (producerid) REFERENCES Producer(producerid)
    );

/* inserts values into clothing table */
INSERT INTO Clothing (name, type, price, producerid)
VALUES ('JoustavaMeno', 'Haalari', 59.50, 1),
('70-luku', 'Haalari', 32.76, 2);

/* creates clothing table */
CREATE TABLE User (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    password VARCHAR(80) NOT NULL,
    role varchar(50) NOT NULL,
    PRIMARY KEY (id)
    );

/* inserts values into clothing table */
INSERT INTO User (username, password, role)
VALUES ('USER', '$2a$10$Zm5nm2PAGx1F4RYbhOnU.eYPBCKby8WYj3N27BrycJl3SlV7afdWe', 'USER'),
('ADMIN', '$2a$10$6urpdFDsbIWWJsD/5lOBd.iOGoAIBCl9x9oUD3cAyBxvLpnJQS9qu', 'ADMIN');

SELECT * FROM Producer;
SELECT * FROM Clothing;
SELECT * FROM User;