--Manufacturer la cac hang san xuat va cung cap cac san pham
-----------------------------------------MANUFACTURER--------------------------------------
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/iPad-(Apple)522-b_4.jpg', 'Ipad') --24

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/samsungnew-220x48-3.png', 'SamSung') --25

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Tablet-xiaomi-220x48-1.png', 'Xiaomi') --26

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Lenovo522-b_6.jpg', 'Lenovo') --27

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Masstel522-b_7.png', 'Masstel') --28

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logonokia-220x48-1.jpg', 'Nokia') --29

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/Huawei522-b_4.jpg', 'Huawei') --30

INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logoalcatel-220x48-1.png', 'Alcatel') --31
-----------------------------------------END_MANUFACTURER-------------------------------------


--------------------------------MANUFACTURER_CATEGORY-----------------------------------------
--Moi manufacturer co the cung cap nhieu loai category
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(24,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(25,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(26,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(27,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(28,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(29,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(30,3)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(31,3)

--------------------------------END_MANUFACTURER_CATEGORY-------------------------------------

--
--------------------------------PRODUCT-------------------------------------------------------
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--13
VALUES ('iPad Pro M1 11 inch 5G', 1, 3, 24)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--14
VALUES ('iPad Air 5 M1 WiFi Cellular', 1, 3, 24)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--15
VALUES ('Samsung Galaxy Tab S8 5G', 1, 3, 25)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--16
VALUES ('Samsung Galaxy Tab A7 Lite 4G', 1, 3, 25)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--17
VALUES ('Lenovo Yoga Tab 11 4G', 1, 3, 27)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--18
VALUES ('Lenovo Tab P11 Plus 4G', 1, 3, 27)

--------------------------------END_PRODUCT---------------------------------------------------

--------------------------------VERSION-------------------------------------------------------
INSERT INTO version (name, video_url, product_id)--21
VALUES ('128GB', '',  1)
INSERT INTO version (name, video_url, product_id)--22
VALUES ('256GB', '',  1)
INSERT INTO version (name, video_url, product_id)--23
VALUES ('512GB', '',  1)
INSERT INTO version (name, video_url, product_id)--24
VALUES ('1TB', '',  1)
INSERT INTO version (name, video_url, product_id)--25
VALUES ('2TB', '',  1)
INSERT INTO version (name, video_url, product_id)--26
VALUES ('64GB', '',  1)
INSERT INTO version (name, video_url, product_id)--27
VALUES ('256GB', '',  1)
INSERT INTO version (name, video_url, product_id)--28
VALUES ('S8+', '',  1)
INSERT INTO version (name, video_url, product_id)--29
VALUES ('S8', '',  1)
INSERT INTO version (name, video_url, product_id)--30
VALUES ('A7 Lite', '',  1)
INSERT INTO version (name, video_url, product_id)--31
VALUES ('128GB', '',  1)
INSERT INTO version (name, video_url, product_id)--32
VALUES ('256GB', '',  1)
INSERT INTO version (name, video_url, product_id)--33
VALUES ('Yoga Tab 11 ', '',  1)
INSERT INTO version (name, video_url, product_id)--34
VALUES ('Tab P11 Plus', '',  1)

--------------------------------END_VERSION---------------------------------------------------

--------------------------------COLOR---------------------------------------------------------
INSERT INTO color (name, manufacturer_id)--27
VALUES (N'Bạc', 24)
INSERT INTO color (name, manufacturer_id)--28
VALUES (N'Xám', 24)
INSERT INTO color (name, manufacturer_id)--29
VALUES (N'Tím', 24)
INSERT INTO color (name, manufacturer_id)--30
VALUES (N'Xanh Dương', 24)
INSERT INTO color (name, manufacturer_id)--31
VALUES (N'Hồng', 24)
INSERT INTO color (name, manufacturer_id)--32
VALUES (N'Tím Nhạt', 24)
INSERT INTO color (name, manufacturer_id)--33
VALUES (N'Trắng', 24)
INSERT INTO color (name, manufacturer_id)--34
VALUES (N'Xám', 25)
INSERT INTO color (name, manufacturer_id)--35
VALUES (N'Bạc', 25)
INSERT INTO color (name, manufacturer_id)--36
VALUES (N'Xám', 26)
INSERT INTO color (name, manufacturer_id)--37
VALUES (N'Trắng', 26)
INSERT INTO color (name, manufacturer_id)--38
VALUES (N'Xám', 27)
INSERT INTO color (name, manufacturer_id)--39
VALUES (N'Xanh Ngọc', 27)
--------------------------------END_COLOR------------------------------------------------------

------------------------------------------VERSION_COLOR------------------------------------------------------------------------------------------

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng iPad Pro M1 11 inch WiFi Cellular 128GB (2021)', 2499000, 28, 21, 1, 'cdn.tgdd.vn/Products/Images/522/238624/ipad-pro-2021-11-inch-gray-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 128GB  ', 2499000, 27, 21, 0, 'cdn.tgdd.vn/Products/Images/522/238624/ipad-pro-m1-11-inch-wifi-cellular-bac-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 128GB  ', 2499000, 28, 21, 0, 'cdn.tgdd.vn/Products/Images/522/238624/ipad-pro-m1-11-inch-wifi-cellular-128gb-2021-1-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 256GB  ', 2799000, 27, 22, 1, 'cdn.tgdd.vn/Products/Images/522/238626/ipad-pro-2021-11-inch-silver-600x600.jpg') 


INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 512GB', 32490000, 28, 23, 1, 'cdn.tgdd.vn/Products/Images/522/261710/TimerThumb/ipad-pro-m1-11-inch-wifi-cellular-512gb-2021-(10).jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 512GB', 32490000, 27, 23, 0, 'cdn.tgdd.vn/Products/Images/522/261710/ipad-pro-m1-11-inch-wifi-cellular-512gb-2021-bac-1.jpeg') 



INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 1TB', 32490000, 2, 3, 1, 'cdn.tgdd.vn/Products/Images/522/269329/TimerThumb/ipad-pro-m1-11-inch-wifi-cellular-1tb-2021.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 1TB', 32490000, 3, 3, 0, 'cdn.tgdd.vn/Products/Images/522/269329/ipad-pro-m1-11-inch-wifi-cellular-bac-1.jpeg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 1TB', 32490000, 4, 3, 0, 'cdn.tgdd.vn/Products/Images/522/269329/ipad-pro-m1-11-inch-wifi-cellular-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 2TB', 32490000, 2, 3, 1, 'cdn.tgdd.vn/Products/Images/522/269330/pad-pro-m1-11-inch-wifi-cellular-1tb-2021-xam-thumb-600x600.jpeg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 2TB', 32490000, 3, 3, 0, 'cdn.tgdd.vn/Products/Images/522/269330/ipad-pro-m1-11-inch-wifi-cellular-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Pro M1 11 inch 5G 2TB', 32490000, 4, 3, 0, 'cdn.tgdd.vn/Products/Images/522/269330/ipad-pro-m1-11-inch-wifi-cellular-bac-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular  ', 2499000, 1, 1, 1, 'cdn.tgdd.vn/Products/Images/522/274155/ipad-air-5-wifi-cellular-tim-thumb-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 64GB  ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/522/274155/ipad-air-5-m1-wifi-cellular-tim-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-m1-wifi-cellular-xam-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-m1-wifi-cellular-tim-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-m1-wifi-cellular-trang-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-m1-wifi-cellular-xanh-duong-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-m1-wifi-cellular-hong-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-wifi-cellular-tim-thumb-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'iPad Air 5 M1 WiFi Cellular 256GB  ', 2799000, 2, 2, 0, 'cdn.tgdd.vn/Products/Images/522/274156/ipad-air-5-wifi-cellular-tim-thumb-600x600.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Tab S8 5G ', 2499000, 1, 1, 1, 'cdn.tgdd.vn/Products/Images/522/247510/Samsung-Galaxy-Tab-s8-white-thumb-1-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Tab S8 5G S8  ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/522/247510/samsung-galaxy-tab-s8-white-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Tab S8 5G S8  ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/247510/samsung-galaxy-tab-s8-1-2.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Tab S8 5G S8+  ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/522/247512/samsung-galaxy-tab-s8-plus-1-3.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Samsung Galaxy Tab S8 5G S8+  ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/247512/samsung-galaxy-tab-s8-plus-1-4.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng Samsung Galaxy Tab A7 Lite  ', 2499000, 1, 1, 1, 'cdn.tgdd.vn/Products/Images/522/237325/TimerThumb/samsung-galaxy-tab-a7-lite-(2).jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng Samsung Galaxy Tab A7 Lite  ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/522/237325/samsung-galaxy-tab-a7-lite-1-2-org.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng Samsung Galaxy Tab A7 Lite  ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/237325/samsung-galaxy-tab-a7-lite-1-3-org.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Xiaomi Pad 5 WiFi ', 2499000, 1, 1, 1, 'cdn.tgdd.vn/Products/Images/522/250934/xiaomi-pad-5-grey-600x600.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Xiaomi Pad 5 WiFi 128GB ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/522/239210/xiaomi-pad-5-1-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Xiaomi Pad 5 WiFi 128GB ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/239210/xiaomi-pad-5-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Xiaomi Pad 5 WiFi 256GB ', 2499000, 2, 1, 0, 'cdn.tgdd.vn/Products/Images/522/250934/xiaomi-pad-5-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Xiaomi Pad 5 WiFi 256GB ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/250934/xiaomi-pad-5-1-1.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Lenovo Yoga Tab 11 4G ', 2499000, 1, 1, 1, 'cdn.tgdd.vn/Products/Images/522/244565/TimerThumb/lenovo-yoga-tab-11.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Lenovo Yoga Tab 11 4G ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/244565/lenovo-yoga-tab-11-1-2.jpg') 

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng Lenovo Tab P11 Plus ', 2499000, 1, 1, 1, 'cdn.tgdd.vn/Products/Images/522/244684/lenovo-tab-p11-plus-2-600x600.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng Lenovo Tab P11 Plus ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/244684/lenovo-tab-p11-plus-1-1.jpg') 
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Máy tính bảng Lenovo Tab P11 Plus ', 2499000, 3, 1, 0, 'cdn.tgdd.vn/Products/Images/522/244684/lenovo-tab-p11-plus-1-2.jpg') 

------------------------------------------------------END_VERSION_COLOR------------------------------------------------------------------------







