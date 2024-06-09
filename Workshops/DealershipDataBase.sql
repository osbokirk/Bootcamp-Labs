CREATE DATABASE Dealership;
/*
Table 1: dealerships
--------------------
Columns:
dealership_id
name
address
phone
int, auto-increment, primary key
varchar(50)
varchar(50)
varchar(12)
*/
Create Table dealership.dealerships(
dealershipID INT Auto_Increment,
dealershipName varchar(50),
address varchar(50),
phone varchar(12),
primary key (dealershipID)
);
/*
Table 2: vehicles
------------------
Columns:
you decide
VIN should be the primary key
VIN should NOT be auto-increment
include a column called SOLD
*/

Create Table dealership.vehicles(
Vin varchar(16) Unique,
ModelYear int,
Model varchar(25),
Make varchar(25),
VehicleType varchar(15),
Color varchar(25),
Odometer Int,
Price Float,
Sold bit,
Primary Key(Vin)
);
/*
!!!!Table 3: inventory (track which dealership has the vehicle)
------------------------------------------------------------
Columns:
dealership_id
VIN
*/
Create Table dealership.inventory(
DealershipID INT,
Vin varChar(16),
Foreign Key (DealershipID) References dealership.Dealerships (dealershipID),
Foreign Key (Vin) References dealership.Vehicles(Vin)
);

/*
Table 4: sales_contracts
-------------------------
Columns:
you decide
id should be auto-incremented
use a foreign key (VIN) to link to the vehicle
*/
Create Table dealership.salesContracts(
SalesId Int Auto_Increment,
Vin varchar(16),
salesTaxAmmount Float,
isFinanced Bit,
TermLenght Int,
InterestRate Float,
ProcessingFee Float,
RecordingFee Float,
ContractDate Date,
CustomerName Varchar (50),
Email Varchar(50),
TotalPrice Float,
MonthlyPayment Float,
Primary Key(SalesId),
Foreign Key(Vin) References dealership.Vehicles(Vin)
);

/*
Table 5: (OPTIONAL) lease_contracts
------------------------------------
Columns:
you decide
id should be auto-incremented
use a foreign key (VIN) to link to the vehicle
*/
Create Table dealership.leaseContract(
LeaseID Int Auto_Increment,
Vin Varchar(16),
EndingingValue Float,
LeaseFeeCharge Float,
InterestRate Float,
ContractDate Date,
CustomerName Varchar (50),
Email Varchar(50),
TotalPrice Float,
MonthlyPayment Float,
Primary Key (LeaseID),
Foreign Key(Vin) References dealership.Vehicles(Vin)
);

Insert Into dealership.dealerships(dealershipName,address,phone)
values('ABC Motors', '123 Main Street, Cityville, State, 12345', '555-1234'),
    ('XYZ Auto', '456 Elm Street, Townsville, State, 67890', '555-5678'),
    ('MNO Cars', '789 Oak Street, Villagetown, State, 13579', '555-2468');
    
Insert Into dealership.Vehicles(Vin,ModelYear,Model,Make,VehicleType,Color,Odometer,Price,Sold)
values('HGBH41JXMN109186', 2020, 'Corolla', 'Toyota', 'Sedan', 'Blue', 15000, 20000.00, 1),
    ('HGFG12629H123456', 2019, 'Civic', 'Honda', 'Sedan', 'Red', 20000, 22000.00, 0),
    ('FA6P0G72FR288201', 2018, 'Fusion', 'Ford', 'Sedan', 'Silver', 18000, 18000.00, 1),
    ('G1ZD5ST9JF157543', 2017, 'Malibu', 'Chevrolet', 'Sedan', 'Black', 22000, 19000.00, 1),
    ('N4AL3AP7JC256761', 2019, 'Altima', 'Nissan', 'Sedan', 'White', 19000, 23000.00, 1),
    ('NPDH4AE9EH498351', 2020, 'Elantra', 'Hyundai', 'Sedan', 'Gray', 12000, 21000.00, 0),
    ('VW2K7AJ3FM290949', 2018, 'Jetta', 'Volkswagen', 'Sedan', 'Blue', 25000, 20000.00, 1),
    ('S3GTAA64H3727823', 2017, 'Impreza', 'Subaru', 'Sedan', 'Green', 17000, 22000.00, 1);
    
Insert Into dealership.Inventory(DealershipId,Vin)
values(1, 'HGBH41JXMN109186'), -- Corolla at ABC Motors
    (2, 'HGFG12629H123456'), -- Civic at XYZ Auto
    (3, 'FA6P0G72FR288201'), -- Fusion at MNO Cars
    (1, 'G1ZD5ST9JF157543'), -- Malibu at ABC Motors
    (2, 'N4AL3AP7JC256761'), -- Altima at XYZ Auto
    (3, 'NPDH4AE9EH498351'), -- Elantra at MNO Cars
    (1, 'VW2K7AJ3FM290949'), -- Jetta at ABC Motors
    (3, 'S3GTAA64H3727823');

Insert Into dealership.SalesContracts(Vin,SalesTaxAmmount,isFinanced,TermLenght,InterestRate,
ProcessingFee,RecordingFee,ContractDate,CustomerName,Email,TotalPrice,MonthlyPayment)
Values ('HGBH41JXMN109186', 2000.00, 1, 48, 0.05, 200.00, 100.00, '2024-06-01', 'John Doe', 'john@example.com', 22000.00, 475.00),
    ('FA6P0G72FR288201', 1600.00, 0, NULL, NULL, NULL, NULL, '2024-06-02', 'Jane Smith', 'jane@example.com', 19600.00, NULL),
    ('G1ZD5ST9JF157543', 1900.00, 1, 60, 0.04, 250.00, 150.00, '2024-06-03', 'Alice Johnson', 'alice@example.com', 21100.00, 395.00),
    ('VW2K7AJ3FM290949', 2000.00, 1, 36, 0.06, 300.00, 120.00, '2024-06-04', 'Bob Williams', 'bob@example.com', 23000.00, 630.00);
    
insert Into dealership.LeaseContracts(Vin,EndingingValue,LeaseFeeCharge,InterestRate,ContractDate,
CustomerName,Email,TotalPrice,MonthlyPayment)
Values('N4AL3AP7JC256761', 16000.0, 2800.00, 0.03, '2024-06-06', 'Emily Wilson', 'emily@example.com', 21000.00, 350.00),
    ('S3GTAA64H3727823', 15500.0, 2900.00, 0.045, '2024-06-08', 'Sarah Martinez', 'sarah@example.com', 22000.00, 410.00);   

#1
Select * from dealership.dealerships;
#2
Select * from dealership.Vehicles
join dealership.inventory  on dealership.Vehicles.Vin = dealership.inventory.Vin
where dealership.inventory.dealershipId = 1;
#3
Select * From dealerhship.vehicles where Vin = 'FA6P0G72FR288201';
#4
Select * from dealerShip.dealerships
join inventory on dealerships.DealershipId = inventory.DealershipId
where inventory.vin  = 'FA6P0G72FR288201';
#5
Select * from Dealership.Dealerships
join inventory on dealerships.dealershipID = inventory.dealershipID
join vehicles on inventory.Vin = Vehicles.Vin
where Vehicles.Color like '%Blue%' and Vehicles.Make like '%%' and Vehicles.Model like '%%';
#6
Select * from dealership.salesContracts
join vehicles on salesContracts.vin = vehicles.vin
join inventory on vehicles.vin = inventory.vin
where inventory.DealershipID like'1' and salesContracts.ContractDate between '2024-06-03' and '2024-06-04'






