DROP TABLE Addresses;

CREATE TABLE Addresses
(
	AddressID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	FirstName VARCHAR (15) NOT NULL,
	LastName VARCHAR (30) NOT NULL,
	Email VARCHAR (30) NOT NULL,
	PhoneNumber VARCHAR (15) NOT NULL
);


