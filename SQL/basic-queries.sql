#name of the table that holds items Northwind Sells
SELECT * FROM products;
#list Product id, product name, and unit Price of all products
select ProductID,ProductName,UnitPrice 
From products;
#now order by price
select ProductID,ProductName,UnitPrice 
From products 
Order by UnitPrice;
#products where unit price is less than 7.50
select * 
From products 
where UnitPrice <= 7.50; 
# products where we have over 100 in desc
Select * 
From products 
where UnitsInStock >= 100 order by UnitPrice desc;
# products where we have over 100 in desc price && asc productName
Select * 
From Products 
where UnitsInStock >= 100 
order by UnitPrice desc, ProductName ASC;
# product out of Stockbut on BackOrder ordered by product Name
Select * 
From products 
where UnitsInStock = 0 And UnitsOnOrder >=1 
Order By ProductName;
#Select categories
Select * 
From Categories;
#list all rows and colums in categories SeaFood = 8
SELECT * 
FROM categories;
#Primary Key Category ID is A foreign Key in Products
Select * From Products where CategoryID = 8;
#Pull First and last name of employees
Select LastName,FirstName From employees;
#Pull Employees Have that are Managers 
Select * from employees where Title like '%Manager%';
#List Distinct jobTitles in employees
select distinct(Title) from employees;
#Select employees that have salary Between 2000 and 2500
Select * From employees Where Salary between '2000' And '2500';
#List all info about Northwind suppliers
Select * from suppliers;
#SupplierID, Select all items from Tokyo Traders
Select * from products where SupplierId = 4;



