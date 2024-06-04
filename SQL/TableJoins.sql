#list Product id name and unit Price and category name of products order by category Name &&  product name
Select products.productId,products.productName,products.UnitPrice,categories.CategoryName
from products
join categories on products.CategoryID = Categories.CategoryId
Order by Categories.CategoryName,products.ProductName;
#list product id ,name , unit price, supplier name of all products that cost more than 75 order by product name
select products.productId, products.productName,products.UnitPrice,suppliers.CompanyName
from products
join suppliers on Products.supplierId  = suppliers.SupplierID
where products.UnitPrice >75
order by products.productName; 
#List product names Categories of the most expensive products
select products.productId,products.ProductName,products.UnitPrice,categories.CategoryName,suppliers.CompanyName
from products
join categories on products.CategoryID = categories.CategoryID
join suppliers on products.SupplierID = suppliers.SupplierID
order by products.ProductName;
#products names and categories of the most expensive products

#list orderID shipname ship address and shipping company name of each order in ship
select orders.orderId, orders.shipName, orders.ShipAddress,shippers.CompanyName
from orders
join shippers on orders.ShipVia = shippers.ShipperID
where Orders.shipCountry ='Germany';
#List the orderid ,order date, ship name, ship address of orders of Sasquatch Ale
Select orders.orderId,orders.orderDate,orders.shipName,orders.shipAddress,products.ProductName
from orders
join `order details`as Od on orders.orderId = od.OrderId
join products on od.ProductId = Products.productId
Where products.productName = 'Sasquatch Ale';