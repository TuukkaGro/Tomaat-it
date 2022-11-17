SELECT clothing.clothingID, clothing.name, clothing.type, clothing.price, producer.name AS 'producer'
FROM clothing
INNER JOIN producer ON clothing.producerID=producer.producerID;

SELECT * FROM clothing;
SELECT * FROM producer;