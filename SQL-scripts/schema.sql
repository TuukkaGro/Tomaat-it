/* foreign key checks
 * drops earlier tables if any exist */
SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE IF EXISTS Producer; 
DROP TABLE IF EXISTS Clothing; 
SET FOREIGN_KEY_CHECKS=1;

/* Creates database
CREATE DATABASE tomaatit; */

/* Creates table for Producers */
CREATE TABLE Producer (
    producerID int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    PRIMARY KEY(producerID)
    );

/* inserts values into Producer table*/
INSERT INTO Producer (name)
VALUES ('M&M'),
('Leikki');

/* creates clothing table */
CREATE TABLE Clothing (
    clothingID int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    type varchar(50),
    price int,
    producerID int,
    PRIMARY KEY (clothingID),
    FOREIGN KEY (producerID) REFERENCES Producer(producerID)
    );

/* inserts values into clothing table */
INSERT INTO Clothing (name, type, price, producerID)
VALUES ('JoustavaMeno', 'Haalari', 59.00, 1),
('70-luku', 'Haalari', 32.00, 2);

SELECT * FROM Producer;
SELECT * FROM Clothing;