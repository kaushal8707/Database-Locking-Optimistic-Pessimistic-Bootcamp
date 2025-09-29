
-- transaction propagation and isolation queries

show variables like 'transaction_isolation';
use db2;
create database db2;

    insert into Product (name, price, stockQuantity)
    values('Laptop', 25000.0, 50);                  
    
    insert into Product (name, price, stockQuantity)
    values('Smartphone', 5000.0, 5);               
    
    insert into Product (name, price, stockQuantity)
    values('Watch', 1500.0, 34);                    
    
    insert into Product (name, price, stockQuantity)
    values('TV', 75000.0, 4);  
    commit;
    select * from Product;
    update Product set stockQuantity = 50 where id = 5;
   
   SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
   SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
   SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;  
   SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
 
   show variables like 'transaction_isolation';
 
 
-- transaction internal workflow queries
   
	insert into Account (id, balance, holderName)
    values(1, 10000.0, 'Kaushal');                  
    
    insert into Account (id, balance, holderName)
    values(2, 5500.0, 'Basant');               
    
    insert into Account (id, balance, holderName)
    values(3, 15000.0, 'Sameer');   
    
    select * from Account;
    commit;

    
    desc Account
    
    
-- transaction optimistic - pessimistic locking queries

    desc seat;

    Insert into seat (booked, movieName, version) values (false, 'Inception', 0);
    Insert into seat (booked, movieName, version) values (false, 'Titanic', 0);
    Insert into seat (booked, movieName, version) values (false, 'Avengers', 0);
    Insert into seat (booked, movieName, version) values (false, 'Intestaller', 0);
    Insert into seat (booked, movieName, version) values (false, 'Dark Night', 0);
    
    select * from Seat;
    delete from Seat;
    

    
-- spring - hibernate - jpa - query
-- one - to - many- with- join- query

create database spring_hibernate_db;
use spring_hibernate_db;
drop table customer;
select * from customer;
select * from product;
    commit;
    
-- one to many bi directional

select * from library;
select * from book;
drop table library;
-- delete from book where id IN(7,8);

-- many to many
select * from student;
select * from course;
select * from student_course;


-- pagination and sorting query

select * from product_pagination_tbl;
select count(*) from product_pagination_tbl;


-- composite primary key
select * from employee;
select * from employee2;


-- Put and Patch Http Method
select * from productputpatch

-- crud rest operations
select * from productop

-- eager vs lazy
select * from address1;
select * from customer1;

-- cascade type
select * from address2;
select * from customer2;


