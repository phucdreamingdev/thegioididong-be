--Manufacturer la cac hang san xuat va cung cap cac san pham
-----------------------------------------MANUFACTURER--------------------------------------
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png', 'Iphone') --1
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png', 'SamSung') --2
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/OPPO42-b_5.jpg', 'OPPO') --3
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-xiaomi-220x48-5.png', 'Xiaomi') --4
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/vivo-logo-220-220x48-3.png', 'Vivo') --5
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Realme42-b_37.png', 'Realme') --6
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Nokia42-b_21.jpg', 'Nokia') --7
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Mobell42-b_19.jpg', 'Mobell') --8
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Itel42-b_54.jpg', 'Itel') --9
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Masstel42-b_0.png', 'Masstel') --10
-----------------------------------------END_MANUFACTURER-------------------------------------


--------------------------------MANUFACTURER_CATEGORY-----------------------------------------
--Moi manufacturer co the cung cap nhieu loai category
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(1,1)
--------------------------------END_MANUFACTURER_CATEGORY-------------------------------------

--
--------------------------------PRODUCT-------------------------------------------------------
INSERT INTO product (name, is_actived, category_id, manufacturer_id)
VALUES ('iPhone 13', 1, 1, 1)
--------------------------------END_PRODUCT---------------------------------------------------

--------------------------------VERSION-------------------------------------------------------
INSERT INTO version (name, video_url, product_id)
VALUES ('128GB', '',  1)
INSERT INTO version (name, video_url, product_id)
VALUES ('256GB', '',  1)
INSERT INTO version (name, video_url, product_id)
VALUES ('512GB', '',  1)
--------------------------------END_VERSION---------------------------------------------------

--------------------------------COLOR---------------------------------------------------------
INSERT INTO color (name, manufacturer_id)
VALUES (N'Trắng', 1)
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh dương', 1)
INSERT INTO color (name, manufacturer_id)
VALUES (N'Hồng', 1)
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đen', 1)
INSERT INTO color (name, manufacturer_id)
VALUES (N'Xanh lá', 1)
INSERT INTO color (name, manufacturer_id)
VALUES (N'Đỏ', 1)
--------------------------------END_COLOR------------------------------------------------------

------------------------------------------VERSION_COLOR------------------------------------------------------------------------------------------
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 2499000, 1, 1, 1, 'https://cdn.tgdd.vn/Products/Images/42/223602/TimerThumb/iphone-13-(4).jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-blue-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 2499000, 4, 1, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-midnight-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 2499000, 5, 1, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-xanh-la-thumb-new-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 128GB  ', 2499000, 6, 1, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 2799000, 1, 2, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-blue-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 2799000, 3, 2, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 2799000, 4, 2, 1, 'https://cdn.tgdd.vn/Products/Images/42/250258/iphone-13-midnight-1-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 2799000, 5, 2, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-xanh-la-thumb-new-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 256GB  ', 2799000, 6, 2, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 1, 3, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 2, 3, 1, 'https://cdn.tgdd.vn/Products/Images/42/250257/iphone-13-blue-1-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 3, 3, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-pink-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB', 32490000, 4, 3, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-midnight-2-200x200.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Điện thoại iPhone 13 512GB  ', 32490000, 6, 3, 0, 'cdn.tgdd.vn/Products/Images/42/223602/iphone-13-red-1-200x200.jpg') 
------------------------------------------------------END_VERSION_COLOR------------------------------------------------------------------------







