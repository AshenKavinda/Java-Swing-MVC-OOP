create database testead;
use testead;
create table supplier (
	sID int not null auto_increment,
    `name` varchar(50) not null,
    nic varchar(50) not null,
    phone1 varchar(12) not null,
    phone2 varchar(12) not null,
    email varchar(50) not null,
    isActive int not null default 1,
    primary key (sID)
);

use testead;
INSERT INTO supplier (`name`, nic, phone1, phone2, email)
VALUES 
('John Doe', '123456789V', '0711234567', '0771234567', 'johndoe@example.com'),
('Jane Smith', '987654321V', '0712345678', '0772345678', 'janesmith@example.com'),
('Michael Brown', '456789123V', '0713456789', '0773456789', 'michaelbrown@example.com'),
('Emily Davis', '789123456V', '0714567890', '0774567890', 'emilydavis@example.com'),
('David Wilson', '321654987V', '0715678901', '0775678901', 'davidwilson@example.com'),
('Sophia Johnson', '654987321V', '0716789012', '0776789012', 'sophiajohnson@example.com'),
('James Miller', '987321654V', '0717890123', '0777890123', 'jamesmiller@example.com'),
('Olivia Garcia', '321987654V', '0718901234', '0778901234', 'oliviagarcia@example.com'),
('Liam Martinez', '654321987V', '0719012345', '0779012345', 'liammartinez@example.com'),
('Ava Anderson', '987654123V', '0710123456', '0770123456', 'avaanderson@example.com');


use testead;
create table stock (
	stockID int not null auto_increment,
    itemCode varchar(100) not null,
    itemName varchar(50) not null,
    unit varchar(10) not null,
    quantity float not null,
    costPrice decimal(6,2) not null,
    sellPrice decimal(6,2) not null,
    ool int not null,
    category varchar(50) not null,
    returnCount float not null default 0,
    sID int not null,
    stockStatus int not null default 1,
    primary key(stockID),
    foreign key (sID) references supplier(sID)
);

use testead;
INSERT INTO stock (itemCode, itemName, unit, quantity, costPrice, sellPrice, ool, category, returnCount, stockStatus, sID) VALUES
('ITM001', 'Apple Juice', 'Bottle', 100.0, 2.50, 3.00, 10, 'Beverages', 0.0, 1, 1),
('ITM002', 'Banana', 'Kg', 150.0, 1.20, 1.50, 20, 'Fruits', 0.0, 1, 2),
('ITM003', 'Chicken Breast', 'Kg', 200.0, 5.00, 7.00, 15, 'Meat', 0.0, 1, 3),
('ITM004', 'Detergent', 'Bottle', 75.0, 3.00, 4.00, 10, 'Cleaning', 0.0, 1, 4),
('ITM005', 'Eggs', 'Dozen', 50.0, 1.80, 2.50, 5, 'Dairy', 0.0, 1, 5),
('ITM006', 'Flour', 'Kg', 120.0, 0.80, 1.10, 25, 'Baking', 0.0, 1, 6),
('ITM007', 'Grapes', 'Kg', 90.0, 2.20, 3.00, 10, 'Fruits', 0.0, 1, 7),
('ITM008', 'Honey', 'Jar', 40.0, 4.50, 5.50, 10, 'Condiments', 0.0, 1, 8),
('ITM009', 'Ice Cream', 'Tub', 30.0, 3.20, 4.00, 5, 'Frozen', 0.0, 1, 9),
('ITM010', 'Juice Box', 'Pack', 200.0, 0.90, 1.20, 25, 'Beverages', 0.0, 1, 10),
('ITM011', 'Ketchup', 'Bottle', 60.0, 2.50, 3.20, 10, 'Condiments', 0.0, 1, 1),
('ITM012', 'Lettuce', 'Piece', 100.0, 0.80, 1.00, 15, 'Vegetables', 0.0, 1, 2),
('ITM013', 'Milk', 'Liter', 120.0, 1.00, 1.50, 10, 'Dairy', 0.0, 1, 3),
('ITM014', 'Noodles', 'Pack', 180.0, 0.50, 0.80, 20, 'Groceries', 0.0, 1, 4),
('ITM015', 'Orange Juice', 'Bottle', 100.0, 2.50, 3.00, 10, 'Beverages', 0.0, 1, 5),
('ITM016', 'Potatoes', 'Kg', 200.0, 0.60, 0.90, 20, 'Vegetables', 0.0, 1, 6),
('ITM017', 'Quinoa', 'Pack', 50.0, 3.00, 4.00, 5, 'Grains', 0.0, 1, 7),
('ITM018', 'Rice', 'Kg', 300.0, 0.40, 0.70, 30, 'Grains', 0.0, 1, 8),
('ITM019', 'Sugar', 'Kg', 150.0, 0.50, 0.80, 15, 'Groceries', 0.0, 1, 9),
('ITM020', 'Tomato', 'Kg', 100.0, 1.20, 1.60, 10, 'Vegetables', 0.0, 1, 10),
('ITM021', 'Udon Noodles', 'Pack', 70.0, 2.00, 2.80, 10, 'Groceries', 0.0, 1, 1),
('ITM022', 'Vinegar', 'Bottle', 40.0, 1.50, 2.00, 5, 'Condiments', 0.0, 1, 2),
('ITM023', 'Watermelon', 'Piece', 80.0, 3.00, 4.00, 10, 'Fruits', 0.0, 1, 3),
('ITM024', 'Xylitol Gum', 'Pack', 200.0, 0.60, 1.00, 25, 'Snacks', 0.0, 1, 4),
('ITM025', 'Yogurt', 'Cup', 90.0, 0.70, 1.00, 10, 'Dairy', 0.0, 1, 5),
('ITM026', 'Zucchini', 'Kg', 110.0, 1.10, 1.50, 15, 'Vegetables', 0.0, 1, 6),
('ITM027', 'Almond Milk', 'Liter', 60.0, 2.00, 2.50, 10, 'Dairy', 0.0, 1, 7),
('ITM028', 'Bread', 'Loaf', 80.0, 1.50, 2.00, 10, 'Bakery', 0.0, 1, 8),
('ITM029', 'Cheese', 'Kg', 70.0, 4.00, 5.00, 5, 'Dairy', 0.0, 1, 9),
('ITM030', 'Dates', 'Kg', 50.0, 5.00, 6.50, 5, 'Snacks', 0.0, 1, 10),
('ITM031', 'Eggplant', 'Kg', 60.0, 1.20, 1.50, 10, 'Vegetables', 0.0, 1, 1),
('ITM032', 'Figs', 'Kg', 30.0, 6.00, 7.50, 5, 'Fruits', 0.0, 1, 2),
('ITM033', 'Garlic', 'Kg', 90.0, 2.50, 3.00, 10, 'Vegetables', 0.0, 1, 3),
('ITM034', 'Hazelnut Spread', 'Jar', 50.0, 3.00, 4.50, 5, 'Snacks', 0.0, 1, 4),
('ITM035', 'Instant Coffee', 'Jar', 40.0, 4.50, 5.50, 5, 'Beverages', 0.0, 1, 5),
('ITM036', 'Jam', 'Jar', 70.0, 2.50, 3.20, 10, 'Condiments', 0.0, 1, 6),
('ITM037', 'Kiwi', 'Kg', 100.0, 3.50, 4.20, 10, 'Fruits', 0.0, 1, 7),
('ITM038', 'Lime', 'Kg', 120.0, 1.20, 1.50, 15, 'Fruits', 0.0, 1, 8),
('ITM039', 'Mango', 'Kg', 80.0, 2.80, 3.50, 10, 'Fruits', 0.0, 1, 9),
('ITM040', 'Nutmeg', 'Kg', 25.0, 8.00, 10.00, 3, 'Spices', 0.0, 1, 10),
('ITM041', 'Olive Oil', 'Liter', 50.0, 6.00, 8.00, 5, 'Condiments', 0.0, 1, 1),
('ITM042', 'Peanut Butter', 'Jar', 60.0, 3.50, 4.50, 10, 'Snacks', 0.0, 1, 2),
('ITM043', 'Quince', 'Kg', 30.0, 4.00, 5.00, 5, 'Fruits', 0.0, 1, 3),
('ITM044', 'Radish', 'Kg', 90.0, 1.50, 2.00, 10, 'Vegetables', 0.0, 1, 4),
('ITM045', 'Salmon', 'Kg', 40.0, 10.00, 12.00, 5, 'Meat', 0.0, 1, 5),
('ITM046', 'Tuna', 'Can', 60.0, 2.00, 3.00, 5, 'Seafood', 0.0, 1, 6),
('ITM047', 'Ugli Fruit', 'Piece', 70.0, 1.80, 2.50, 10, 'Fruits', 0.0, 1, 7),
('ITM048', 'Vegetable Oil', 'Liter', 80.0, 1.50, 2.00, 10, 'Condiments', 0.0, 1, 8),
('ITM049', 'Wheat Bread', 'Loaf', 100.0, 2.00, 2.50, 15, 'Bakery', 0.0, 1, 9),
('ITM050', 'Yams', 'Kg', 30.0, 1.50, 2.00, 5, 'Vegetables', 0.0, 1, 10);


use testead;
create table `user` (
	uID int auto_increment not null,
    `name` varchar(50) not null,
    nic varchar(50) not null unique,
    `type` varchar(20) not null,
    `password` varchar(20) not null,
    isActive int default 1,
    primary key (uID)
);

use testead;
INSERT INTO `user` (`name`, `nic`, `type`, `password`)
VALUES
('Ashen', 'nicTopBord', 'TopBord', '1234'),
('Kavinda', 'nicCashier', 'Cashier', '1234'),
('Hemarathna', 'nicInventory', 'Inventory', '1234');


use testead;
create table bill (
	bID int auto_increment not null,
    total decimal(6,2) not null,
    `date` datetime not null,
    uID int not null,
    primary key (bID),
    foreign key (uID) references user(uID)
);

use testead;
create table billStock (
	bID int not null,
    sID int not null,
    quantity float not null,
    primary key (bID,sID),
    foreign key (bID) references bill(bID),
    foreign key (sID) references stock(stockID),
    foreign key (bID) references bill(bID)
);

/*dumy data generated by chatGPT*/
use testead;
-- Inserting 10 bills for 2024/08/27
INSERT INTO bill (total, `date`, uID) VALUES (34.50, '2024-08-27 12:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (1, 1, 5.0);  -- Apple Juice
INSERT INTO billStock (bID, sID, quantity) VALUES (1, 5, 2.0);  -- Eggs
INSERT INTO billStock (bID, sID, quantity) VALUES (1, 15, 4.0); -- Orange Juice

INSERT INTO bill (total, `date`, uID) VALUES (25.80, '2024-08-27 14:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (2, 6, 10.0); -- Flour
INSERT INTO billStock (bID, sID, quantity) VALUES (2, 10, 8.0); -- Juice Box

INSERT INTO bill (total, `date`, uID) VALUES (40.00, '2024-08-27 16:45:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (3, 3, 4.0);  -- Chicken Breast
INSERT INTO billStock (bID, sID, quantity) VALUES (3, 17, 3.0); -- Quinoa

INSERT INTO bill (total, `date`, uID) VALUES (19.75, '2024-08-27 18:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (4, 18, 15.0); -- Rice
INSERT INTO billStock (bID, sID, quantity) VALUES (4, 7, 5.0);  -- Grapes

INSERT INTO bill (total, `date`, uID) VALUES (45.30, '2024-08-27 20:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (5, 12, 8.0); -- Lettuce
INSERT INTO billStock (bID, sID, quantity) VALUES (5, 20, 7.0); -- Tomato

INSERT INTO bill (total, `date`, uID) VALUES (15.50, '2024-08-27 21:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (6, 16, 5.0); -- Potatoes
INSERT INTO billStock (bID, sID, quantity) VALUES (6, 24, 8.0); -- Xylitol Gum

INSERT INTO bill (total, `date`, uID) VALUES (32.40, '2024-08-27 23:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (7, 4, 7.0);  -- Detergent
INSERT INTO billStock (bID, sID, quantity) VALUES (7, 8, 3.0);  -- Honey

INSERT INTO bill (total, `date`, uID) VALUES (22.10, '2024-08-27 23:59:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (8, 11, 4.0); -- Ketchup
INSERT INTO billStock (bID, sID, quantity) VALUES (8, 14, 5.0); -- Noodles

INSERT INTO bill (total, `date`, uID) VALUES (18.90, '2024-08-27 10:15:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (9, 19, 12.0); -- Sugar
INSERT INTO billStock (bID, sID, quantity) VALUES (9, 13, 3.0); -- Milk

INSERT INTO bill (total, `date`, uID) VALUES (28.60, '2024-08-27 11:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (10, 2, 20.0); -- Banana
INSERT INTO billStock (bID, sID, quantity) VALUES (10, 21, 5.0); -- Udon Noodles


-- Inserting 10 bills for 2024/08/28
INSERT INTO bill (total, `date`, uID) VALUES (45.00, '2024-08-28 10:15:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (11, 3, 3.0);  -- Chicken Breast
INSERT INTO billStock (bID, sID, quantity) VALUES (11, 7, 4.0);  -- Grapes
INSERT INTO billStock (bID, sID, quantity) VALUES (11, 17, 2.0); -- Quinoa

INSERT INTO bill (total, `date`, uID) VALUES (18.20, '2024-08-28 11:45:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (12, 8, 6.0);  -- Honey
INSERT INTO billStock (bID, sID, quantity) VALUES (12, 18, 12.0); -- Rice

INSERT INTO bill (total, `date`, uID) VALUES (33.50, '2024-08-28 13:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (13, 4, 6.0);  -- Detergent
INSERT INTO billStock (bID, sID, quantity) VALUES (13, 16, 4.0); -- Potatoes

INSERT INTO bill (total, `date`, uID) VALUES (27.80, '2024-08-28 15:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (14, 10, 8.0); -- Juice Box
INSERT INTO billStock (bID, sID, quantity) VALUES (14, 20, 5.0); -- Tomato

INSERT INTO bill (total, `date`, uID) VALUES (36.60, '2024-08-28 16:45:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (15, 13, 10.0); -- Milk
INSERT INTO billStock (bID, sID, quantity) VALUES (15, 24, 3.0);  -- Xylitol Gum

INSERT INTO bill (total, `date`, uID) VALUES (24.50, '2024-08-28 18:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (16, 6, 5.0); -- Flour
INSERT INTO billStock (bID, sID, quantity) VALUES (16, 25, 7.0); -- Yogurt

INSERT INTO bill (total, `date`, uID) VALUES (19.30, '2024-08-28 19:15:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (17, 15, 6.0); -- Orange Juice
INSERT INTO billStock (bID, sID, quantity) VALUES (17, 18, 8.0); -- Rice

INSERT INTO bill (total, `date`, uID) VALUES (37.50, '2024-08-28 21:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (18, 27, 4.0); -- Almond Milk
INSERT INTO billStock (bID, sID, quantity) VALUES (18, 29, 3.0); -- Cheese

INSERT INTO bill (total, `date`, uID) VALUES (28.90, '2024-08-28 22:15:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (19, 22, 7.0); -- Vinegar
INSERT INTO billStock (bID, sID, quantity) VALUES (19, 5, 5.0);  -- Eggs

INSERT INTO bill (total, `date`, uID) VALUES (39.60, '2024-08-28 23:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (20, 26, 6.0); -- Zucchini
INSERT INTO billStock (bID, sID, quantity) VALUES (20, 14, 4.0); -- Noodles


-- Inserting 10 bills for 2024/08/29
INSERT INTO bill (total, `date`, uID) VALUES (52.30, '2024-08-29 09:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (21, 11, 4.0); -- Ketchup
INSERT INTO billStock (bID, sID, quantity) VALUES (21, 13, 7.0); -- Milk

INSERT INTO bill (total, `date`, uID) VALUES (29.75, '2024-08-29 15:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (22, 9, 10.0); -- Ice Cream
INSERT INTO billStock (bID, sID, quantity) VALUES (22, 16, 5.0); -- Potatoes

INSERT INTO bill (total, `date`, uID) VALUES (34.00, '2024-08-29 16:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (23, 10, 6.0); -- Juice Box
INSERT INTO billStock (bID, sID, quantity) VALUES (23, 24, 3.0); -- Xylitol Gum

INSERT INTO bill (total, `date`, uID) VALUES (20.50, '2024-08-29 17:15:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (24, 20, 8.0); -- Tomato
INSERT INTO billStock (bID, sID, quantity) VALUES (24, 27, 6.0); -- Almond Milk

INSERT INTO bill (total, `date`, uID) VALUES (25.80, '2024-08-29 19:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (25, 25, 9.0); -- Yogurt
INSERT INTO billStock (bID, sID, quantity) VALUES (25, 28, 4.0); -- Blueberries

INSERT INTO bill (total, `date`, uID) VALUES (38.40, '2024-08-29 20:30:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (26, 19, 5.0); -- Sugar
INSERT INTO billStock (bID, sID, quantity) VALUES (26, 21, 3.0); -- Udon Noodles

INSERT INTO bill (total, `date`, uID) VALUES (27.30, '2024-08-29 21:45:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (27, 29, 5.0); -- Cheese
INSERT INTO billStock (bID, sID, quantity) VALUES (27, 15, 7.0); -- Orange Juice

INSERT INTO bill (total, `date`, uID) VALUES (31.50, '2024-08-29 23:00:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (28, 22, 6.0); -- Vinegar
INSERT INTO billStock (bID, sID, quantity) VALUES (28, 30, 8.0); -- Zucchini

INSERT INTO bill (total, `date`, uID) VALUES (33.20, '2024-08-29 23:45:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (29, 26, 3.0); -- Zucchini
INSERT INTO billStock (bID, sID, quantity) VALUES (29, 18, 4.0); -- Rice

INSERT INTO bill (total, `date`, uID) VALUES (24.80, '2024-08-29 23:59:00', 2);
INSERT INTO billStock (bID, sID, quantity) VALUES (30, 14, 7.0); -- Noodles
INSERT INTO billStock (bID, sID, quantity) VALUES (30, 7, 5.0);  -- Grapes




