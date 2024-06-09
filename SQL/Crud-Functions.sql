SELECT * FROM northwind.suppliers;

Insert Into Suppliers 
(CompanyName,ContactName,ContactTitle,PostalCode)
values('Hopp Industries','Jon Hop','Grand viserer','60210')

Insert into Products 
(ProductName,SupplierId,CategoryID,UnitPrice)
values('BrokenDream',30,01,9)

select * from products
join suppliers on products.supplierId = Suppliers.supplierID

update Products
set  UnitPrice =  (UnitPrice*1.15) 
where productName = 'BrokenDream'

select * From products where supplierID = 30

Delete 
From products
where productId = 78

delete 
From suppliers 
where supplierID = 30

select * from products 

select * from suppliers 