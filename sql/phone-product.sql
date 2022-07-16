--Manufacturer la cac hang san xuat va cung cap cac san pham
-----------------------------------------MANUFACTURER--------------------------------------
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png', 'Iphone') --1
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png', 'SamSung') --2
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/OPPO42-b_5.jpg', 'OPPO') --3
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/logo-xiaomi-220x48-5.png', 'Xiaomi') --4
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/vivo-logo-220-220x48-3.png', 'Vivo') --5
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Realme42-b_37.png', 'Realme') --6
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Nokia42-b_21.jpg', 'Nokia') --7
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Mobell42-b_19.jpg', 'Mobell') --8
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Itel42-b_54.jpg', 'Itel') --9
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Masstel42-b_0.png', 'Masstel') --10
-----------------------------------------END_MANUFACTURER-------------------------------------


--------------------------------MANUFACTURER_CATEGORY-----------------------------------------
--Moi manufacturer co the cung cap nhieu loai category
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(1,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(2,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(3,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(4,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(5,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(6,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(7,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(8,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(9,1)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(10,1)
--------------------------------END_MANUFACTURER_CATEGORY-------------------------------------

--
--------------------------------PRODUCT-------------------------------------------------------
--Đức 1-6
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--1
VALUES ('iPhone 13', 1, 1, 1)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--2
VALUES ('iPhone 11', 1, 1, 1)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--3
VALUES ('Samsung Galaxy A03', 1, 1, 2)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--4
VALUES ('Samsung Galaxy A52s 5G', 1, 1, 2)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--5
VALUES ('OPPO Reno7 series', 1, 1, 3)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--6
VALUES ('OPPO A55', 1, 1, 3)
--------------------------------END_PRODUCT---------------------------------------------------

--------------------------------VERSION-------------------------------------------------------
--Đức 1-12
--iphone 13
INSERT INTO version (name, video_url, product_id)--1
VALUES ('128GB', '',  1)
INSERT INTO version (name, video_url, product_id)--2
VALUES ('256GB', '',  1)
INSERT INTO version (name, video_url, product_id)--3
VALUES ('512GB', '',  1)
--iphone 11
INSERT INTO version (name, video_url, product_id)--4
VALUES ('64GB', '',  2)
INSERT INTO version (name, video_url, product_id)--5
VALUES ('128GB', '',  2)
--Samsung Galaxy A03
INSERT INTO version (name, video_url, product_id)--6
VALUES ('3GB', '',  3)
INSERT INTO version (name, video_url, product_id)--7
VALUES ('4GB', '',  3)
--Samsung Galaxy A52s 5G
INSERT INTO version (name, video_url, product_id)--8
VALUES ('128GB', '',  4)
--OPPO Reno7 series
INSERT INTO version (name, video_url, product_id)--9
VALUES ('Reno7 Z 5G', '',  5)
INSERT INTO version (name, video_url, product_id)--10
VALUES ('Reno7 4G', '',  5)
INSERT INTO version (name, video_url, product_id)--11
VALUES ('Reno7 5G', '',  5)
INSERT INTO version (name, video_url, product_id)--12
VALUES ('Reno7 Pro 5G', '',  5)
--OPPO A55
INSERT INTO version (name, video_url, product_id)--13
VALUES ('64GB', '',  6)
--------------------------------END_VERSION---------------------------------------------------

--------------------------------COLOR---------------------------------------------------------
--iPhone color
INSERT INTO color (name, manufacturer_id)
VALUES (N'Trắng', 1)--color_id:1
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh dương', 1)--color_id:2
INSERT INTO color (name, manufacturer_id)
VALUES (N'Hồng', 1)--color_id:3
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đen', 1)--color_id:4
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh lá', 1)--color_id:5
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đỏ', 1)--color_id:6
--iphone 11
INSERT INTO color (name, manufacturer_id)
VALUES (N'Tím', 1)--color_id:7
INSERT INTO color (name, manufacturer_id)
VALUES (N'Vàng', 1)--color_id:8

--Samsung color
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh Dương', 2)--color_id:9
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đen', 2)--color_id:10
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đỏ', 2)--color_id:11
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh lá', 2)--color_id:12
INSERT INTO color (name, manufacturer_id)
VALUES (N'Tím', 2)--color_id:13
INSERT INTO color (name, manufacturer_id)
VALUES (N'Trắng', 2)--color_id:14

--Oppo color
INSERT INTO color (name, manufacturer_id)
VALUES (N'Bạc', 3)--color_id:15
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đen', 3)--color_id:16
INSERT INTO color (name, manufacturer_id)
VALUES (N'Cam', 3)--color_id:17
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh dương', 3)--color_id:18
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh dương nhạt', 3)--color_id:19
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh lá', 3)--color_id:20
--------------------------------END_COLOR------------------------------------------------------

------------------------------------------VERSION_COLOR------------------------------------------------------------------------------------------
--Đức
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 24990000, 1, 1, 1, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 24990000, 2, 1, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-blue-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 24990000, 3, 1, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 24990000, 4, 1, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-midnight-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 24990000, 5, 1, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-xanh-la-thumb-new-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 24990000, 6, 1, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg') 
--iphone 13 256GB
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 27990000, 1, 2, 1, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 27990000, 2, 2, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-blue-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 27990000, 3, 2, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 27990000, 4, 2, 0, 'https://cdn.tgdd.vn/Products/Images/42/250258/iphone-13-midnight-1-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 27990000, 5, 2, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-xanh-la-thumb-new-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 27990000, 6, 2, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg')
--iphone 13 512GB
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 1, 3, 1, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 2, 3, 0, 'https://cdn.tgdd.vn/Products/Images/42/250257/iphone-13-blue-1-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 3, 3, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 4, 3, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-midnight-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB  ', 32490000, 6, 3, 0, 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg') 
--iphone 11 64GB
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 64GB  ', 14990000, 4, 4, 1, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-den-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 64GB  ', 14990000, 5, 4, 0, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-xanhla-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 64GB  ', 14990000, 7, 4, 0, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-tim-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 64GB  ', 14990000, 8, 4, 0, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-vang-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 64GB  ', 14990000, 1, 4, 0, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-trang-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 64GB  ', 14990000, 6, 4, 0, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-do-200x200.jpg') 
--iphone 11 128GB
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 128GB  ', 16990000, 4, 5, 1, 'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-xi-do-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 128GB  ', 16990000, 5, 5, 0, 'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-tim-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 128GB  ', 16990000, 7, 5, 0, 'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-xanhla-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 128GB  ', 16990000, 8, 5, 0, 'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-vang-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 128GB  ', 16990000, 1, 5, 0, 'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-trang-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 11 128GB  ', 16990000, 6, 5, 0, 'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-do-200x200.jpg') 
--Samsung Galaxy A03 3GB
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A03 3GB  ', 2990000, 9, 6, 1, 'https://cdn.tgdd.vn/Products/Images/42/251856/samsung-galaxy-a03-xanh-thumb-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A03 3GB', 2990000, 10, 6, 0, 'https://cdn.tgdd.vn/Products/Images/42/251856/samsung-galaxy-a03-den-thumb-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A03 3GB', 2990000, 11, 6, 0, 'https://cdn.tgdd.vn/Products/Images/42/251856/samsung-galaxy-a03-do-thumb-200x200.jpg') 
--Samsung Galaxy A03 4GB
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A03 3GB  ', 3490000, 9, 7, 1, 'https://cdn.tgdd.vn/Products/Images/42/251856/samsung-galaxy-a03-xanh-thumb-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A03 3GB', 3490000, 10, 7, 0, 'https://cdn.tgdd.vn/Products/Images/42/251856/samsung-galaxy-a03-den-thumb-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A03 3GB', 3490000, 11, 7, 0, 'https://cdn.tgdd.vn/Products/Images/42/251856/samsung-galaxy-a03-do-thumb-200x200.jpg ') 
--Samsung Galaxy A52s 5G
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A52s 5G 128GB', 10990000, 12, 8, 1, 'https://cdn.tgdd.vn/Products/Images/42/247507/samsung-galaxy-a52s-5g-mint-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A52s 5G 128GB', 10990000, 13, 8, 0, 'https://cdn.tgdd.vn/Products/Images/42/247507/samsung-galaxy-a52s-5g-violet-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại Samsung Galaxy A52s 5G 128GB', 10990000, 14, 8, 0, 'https://cdn.tgdd.vn/Products/Images/42/247507/samsung-galaxy-a52s-5g-white-200x200.jpg') 
--Oppo Reno7 Z 5G 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 Z 5G', 10490000, 15, 9, 1, 'https://cdn.tgdd.vn/Products/Images/42/271717/oppo-reno7-z-5g-thumb-1-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 Z 5G', 10490000, 16, 9, 0, 'https://cdn.tgdd.vn/Products/Images/42/271717/oppo-reno7-z-5g-thumb-2-1-200x200.jpg') 
--Oppo Reno7 4G
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 4G', 8990000, 17, 10, 1, 'https://cdn.tgdd.vn/Products/Images/42/274721/OPPO-Reno7-4G-Thumb-cam-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 4G', 8990000, 16, 10, 0, 'https://cdn.tgdd.vn/Products/Images/42/274721/OPPO-Reno7-4G-Thumb-den-1-200x200.jpg') 
--Oppo Reno7 5G
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 5G', 12990000, 16, 11, 1, 'https://cdn.tgdd.vn/Products/Images/42/247361/oppo-reno7-5g-den-thumb-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 5G', 12990000, 18, 11, 0, 'https://cdn.tgdd.vn/Products/Images/42/247361/oppo-reno7-5g-xanh-thumb-200x200.jpg') 
--Oppo Reno7 Pro 5G
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 Pro 5G', 18990000, 16, 12, 1, 'https://cdn.tgdd.vn/Products/Images/42/251964/OPPO-Reno7-Pro-5G-thumb-xanh-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO Reno7 Pro 5G', 18990000, 19, 12, 0, 'https://cdn.tgdd.vn/Products/Images/42/251964/OPPO-Reno7-Pro-5G-thumb-den-200x200.jpg') 
--OPPO A55
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO A55', 4990000, 20, 13, 1, 'https://cdn.tgdd.vn/Products/Images/42/249944/oppo-a55-4g-thumb-new-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO A55', 4990000, 16, 13, 0, 'https://cdn.tgdd.vn/Products/Images/42/249944/oppo-a55-4g-black-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại OPPO A55', 4990000, 18, 13, 0, 'https://cdn.tgdd.vn/Products/Images/42/249944/oppo-a55-4g-blue-200x200.jpg') 




------------------------------------------------------END_VERSION_COLOR------------------------------------------------------------------------







