----------------------Manufacturer------------------------------------------------------------------------
--32-39-Linh 
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo01.png', 'AppleWatch') 
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo02b.png', 'SamSung')
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo03.png', 'Germin')
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo04-1.png', 'Befit')
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo05.png', 'Xiaomi')
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo06.png', 'Kidcare')
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logoAMZ.png', 'Amazfit')
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/mwgcart/mwgcore/ContentMwg/images/smartwatch/logo08.png', 'Oppo')


-----------------------------------------END_MANUFACTURER-------------------------------------

--------------------------------MANUFACTURER_CATEGORY-----------------------------------------
--Linh
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(32,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(33,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(34,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(35,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(36,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(37,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(38,5)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(39,5)
--------------------------------END_MANUFACTURER_CATEGORY-------------------------------------

--
--------------------------------PRODUCT-------------------------------------------------------
--Linh 25-30
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--25
VALUES ('Apple Watch Series 7 GPS 41mm', 1, 5, 32)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--26
VALUES ('Apple Watch SE 40mm viền nhôm dây silicone', 1, 5, 32)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--27
VALUES ('Samsung Galaxy Fit2', 1, 5, 33)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--28
VALUES ('Samsung Galaxy Watch 4 LTE Classic 42mm', 1, 5, 33)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--29
VALUES ('Garmin Forerunner 255S', 1, 5, 34)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--30
VALUES ('Garmin Forerunner 255', 1, 5, 34)

--------------------------------END_PRODUCT---------------------------------------------------

--------------------------------VERSION-------------------------------------------------------

--Linh
 
INSERT INTO version (name, video_url, product_id) --35
VALUES ('41mm', '',  25)
INSERT INTO version (name, video_url, product_id) --36
VALUES ('45mm', '',  25)
INSERT INTO version (name, video_url, product_id) --37
VALUES ('40mm', '',  26)
INSERT INTO version (name, video_url, product_id) --38
VALUES ('44mm', '',  26)
INSERT INTO version (name, video_url, product_id) --39
VALUES ('Fit2', '',  27)
INSERT INTO version (name, video_url, product_id) --40
VALUES ('Watch 4 LTE', '',  28)
INSERT INTO version (name, video_url, product_id) --41
VALUES ('255S', '',  29)
INSERT INTO version (name, video_url, product_id) --42
VALUES ('255', '',  30)


--------------------------------END_VERSION---------------------------------------------------

--------------------------------COLOR---------------------------------------------------------
--Linh
INSERT INTO color (name, manufacturer_id)--40
VALUES (N'Vàng', 32)
INSERT INTO color (name, manufacturer_id)--41
VALUES (N'Xanh dương', 32)
INSERT INTO color (name, manufacturer_id)--42
VALUES (N'Đen', 32)
INSERT INTO color (name, manufacturer_id)--43
VALUES (N'Đỏ', 32)
INSERT INTO color (name, manufacturer_id)--44
VALUES (N'Xanh lá', 32)
INSERT INTO color (name, manufacturer_id)--45
VALUES (N'Xanh đen', 32)
INSERT INTO color (name, manufacturer_id)--46
VALUES (N'Trắng - Kem', 32)
INSERT INTO color (name, manufacturer_id)--47
VALUES (N'Đen xanh', 32)
INSERT INTO color (name, manufacturer_id)--48
VALUES (N'Hồng', 32)
INSERT INTO color (name, manufacturer_id)--49
VALUES (N'Đen', 33)
INSERT INTO color (name, manufacturer_id)--50
VALUES (N'Xám', 34)
INSERT INTO color (name, manufacturer_id)--51
VALUES (N'Xanh dương', 34)
--------------------------------END_COLOR------------------------------------------------------

------------------------------------------VERSION_COLOR------------------------------------------------------------------------------------------
--Linh
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 41mm', 11990000, 41, 35, 1, 'https://cdn.tgdd.vn/Products/Images/7077/249906/apple-watch-s7-41mm-gps-xanh-duong-1-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 41mm', 11990000, 42, 35, 0, 'https://cdn.tgdd.vn/Products/Images/7077/249906/apple-watch-s7-41mm-gps-den-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 41mm', 11990000, 40, 35, 0, 'https://cdn.tgdd.vn/Products/Images/7077/249906/apple-watch-s7-41mm-1-5.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 41mm', 11990000, 43, 35, 0, 'https://cdn.tgdd.vn/Products/Images/7077/249906/apple-watch-s7-41mm-gps-do-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 45mm', 12990000, 42, 36, 1, 'https://cdn.tgdd.vn/Products/Images/7077/250638/apple-watch-s7-45mm-gps-den-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 45mm', 12990000, 41, 36, 0, 'https://cdn.tgdd.vn/Products/Images/7077/250638/apple-watch-s7-45mm-2-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 45mm', 12990000, 40, 36, 0, 'https://cdn.tgdd.vn/Products/Images/7077/250638/apple-watch-s7-45mm-1-2.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 45mm', 12990000, 44, 36, 0, 'https://cdn.tgdd.vn/Products/Images/7077/250638/apple-watch-s7-45mm-gps-xanh-la-1-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch Series 7 GPS 45mm', 12990000, 43, 36, 0, 'https://cdn.tgdd.vn/Products/Images/7077/250638/apple-watch-s7-45mm-gps-do-1.jpg')

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch SE 40mm', 12990000, 45, 37, 1, 'https://cdn.tgdd.vn/Products/Images/7077/234918/se-40mm-vien-nhom-day-cao-su-xanh-den-01.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch SE 40mm', 12990000, 40, 37, 0, 'https://cdn.tgdd.vn/Products/Images/7077/234918/se-40mm-vien-nhom-day-cao-su-vang-01.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch SE 40mm', 12990000, 48, 37, 0, 'https://cdn.tgdd.vn/Products/Images/7077/234918/se-40mm-vien-nhom-day-cao-su-hong-glr-1-org.jpg')

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch SE 44mm', 12990000, 47, 38, 1, 'https://cdn.tgdd.vn/Products/Images/7077/229063/apple-watch-se-44mm-vien-nhom-day-cao-su-1-1.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch SE 44mm', 12990000, 48, 38, 0, 'https://cdn.tgdd.vn/Products/Images/7077/229063/apple-watch-se-44mm-vien-nhom-day-cao-su-1-org.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Apple Watch SE 44mm', 12990000, 42, 38, 0, 'https://cdn.tgdd.vn/Products/Images/7077/229063/apple-watch-se-44mm-vien-nhom-day-cao-su-2-org.jpg')

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Watch 4 LTE', 9490000, 49, 39, 1, 'https://cdn.tgdd.vn/Products/Images/7077/248764/samsung-galaxy-watch-4-lte-classic-42mm1-org.jpg')

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Fit2', 990000, 49, 40, 1, 'https://cdn.tgdd.vn/Products/Images/7077/231312/samsung-galaxy-fit2-den-1-2.jpg')

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Garmin Forerunner 255S', 8990000, 50, 41, 1, 'https://cdn.tgdd.vn/Products/Images/7077/283642/garmin-forerunner-255s-day-silicone-1.jpg')

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Garmin Forerunner 255', 990000, 50, 42, 0, 'https://cdn.tgdd.vn/Products/Images/7077/283208/garmin-forerunner-255-day-silicone-1-2.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Garmin Forerunner 255', 990000, 51, 42, 1, 'https://cdn.tgdd.vn/Products/Images/7077/283208/garmin-forerunner-255-day-silicone-1-3.jpg')
------------------------------------------------------END_VERSION_COLOR------------------------------------------------------------------------






