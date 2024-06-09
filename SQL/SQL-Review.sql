select * from customers where country = 'UK'

select productName, unitPrice from products where unitPrice > 30

select count(ProductID) from products where discontinued = 1

select Avg(UnitPrice),Min(UnitPrice),Max(UnitPrice) from products

##select CategoryName, count(products)

select SupplierId and CompanyName from supliers where Country not in('USA','Germany','UK')

select distinct Country from customers

select ProductName, UnitPrice from products order by UnitPrice Desc limit 5

#

#12 
select productName from products where unitsInStock = 0;
#13
select products.ProductName,categories.CategoryName
from products
join categories on products.CategoryID = categories.CategoryID
where CategoryName = 'Beverages'or CategoryName='Confections'

#14
SELECT Suppliers.SupplierID, Suppliers.CompanyName, COUNT(Products.ProductID) AS ProductCount
FROM Suppliers
JOIN Products ON Suppliers.SupplierID = Products.SupplierID
GROUP BY Suppliers.SupplierID, Suppliers.CompanyName
ORDER BY ProductCount DESC
LIMIT 1;

#15!
Select Products.productId,Products.productName
from products 
Right Join `order Details` on Products.productId = `Order details`.productId 
group by products.productId

#16
Select * from orders 
where Month(orderDate)='12'And Year(orderDate) = '1997' 
#17
SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, COUNT(Orders.OrderID) AS OrderCount
FROM Employees
JOIN Orders ON Employees.EmployeeID = Orders.EmployeeID
WHERE YEAR(Orders.OrderDate) = 1998
GROUP BY Employees.EmployeeID, Employees.FirstName, Employees.LastName
ORDER BY OrderCount DESC
LIMIT 1;
#18
select customerId,CompanyName, count(`Order details`.Quantity)as Quant
from customers
join orders on customer.CustomerID = orders.CustomerID
join `order details` on Customers.customerId = `order Details`.customerId


