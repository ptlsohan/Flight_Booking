DROP TABLE IF EXISTS Passanger;

CREATE TABLE Passanger(
Passanger_id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(20),
FirstName VARCHAR(45) NOT NULL,
LastName VARCHAR(45) ,
SSN VARCHAR(9),
Age INT,
Street VARCHAR(45) NOT NULL,
Apartment_number INT NOT NULL,
City VARCHAR(45) NOT NULL,
State VARCHAR(45) NOT NULL,
Zip INT NOT NULL,
Tel_home VARCHAR(45),
Tel_office VARCHAR(45),
Email VARCHAR(45),
PRIMARY KEY (Passanger_id)

);



