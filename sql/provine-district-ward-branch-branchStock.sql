
---------------------------------PROVINE---------------------------------------
INSERT INTO province(name)
VALUES ('Ho Chi Minh') 

---------------------------------DISTRICT---------------------------------------
INSERT INTO district(name, province_id)
VALUES ('Quan 1', 1) 

---------------------------------WARD-------------------------------------------
INSERT INTO ward(name, district_id)
VALUES ('5', 1) 

---------------------------------branch-------------------------------------------
INSERT INTO branch(address_detail, status, ward_id)
VALUES ('155/3', 'true', 1) 

---------------------------------branch-stock-------------------------------------------
INSERT INTO branch_stock(stock, branch_id, version_color_id)
VALUES ('200', 1, 1) 