---------------------------------MANUFACTURER_LAPTOP---------------------------------------
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Casio7264-b_39.jpg', 'Casio') --40
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Citizen7264-b_41.jpg', 'Citizen') --41
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/ORIENTl-220x48.jpg', 'Orient') --42
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/MVW7264-b_58.jpg', 'MVW') --43
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/G-shock7264-b_36.jpg', 'G-shock') --44
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/Baby-G7264-b_39.jpg', 'Baby-G') --45
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/TITANl-220x48.png', 'TITAN') --46
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'https://cdn.tgdd.vn/Brand/1/DANIELWELLINGTONl-220x48.jpg', 'DANIELWELLINGTON') --47
---------------------------------END_MANUFACTURER_LAPTOP---------------------------------------




---------------------------------MANUFACTURER_CATEGORY----------------------------------
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(40,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(41,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(42,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(43,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(44,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(45,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(46,6)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(47,6)
---------------------------------END_MANUFACTURER_LAPTOP----------------------------------



---------------------------------PRODUCTS-----------------------------------------
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--19
VALUES ('CASIO 44.5 mm Nam WS-1400H-1BVDF', 1, 6, 40)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--20
VALUES ('CASIO 32.7 mm Unisex A100WE-7BDF', 1, 6, 40)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--21
VALUES ('CITIZEN C7 40 mm Nam NH8391-51X', 1, 6, 41)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--22
VALUES ('CITIZEN 30 mm Nữ ER0216-59D', 1, 6, 41)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--23
VALUES ('ORIENT SK 41.7 mm Nam RA-AA0B05R19B', 1, 6, 42)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--24
VALUES ('ORIENT Star 41 mm Nam RE-AY0003S00B', 1, 6, 42)
---------------------------------END_PRODUCT------------------------------------



---------------------------------COLOR------------------------------------------
INSERT INTO color (name, manufacturer_id)--52
VALUES (N'Đen', 40)
INSERT INTO color (name, manufacturer_id)--53
VALUES (N'Bạc', 40)
INSERT INTO color (name, manufacturer_id)--54
VALUES (N'Đen', 41)
INSERT INTO color (name, manufacturer_id)--55
VALUES (N'Đen', 41)
INSERT INTO color (name, manufacturer_id)--56
VALUES (N'Bạc', 42)
INSERT INTO color (name, manufacturer_id)--57
VALUES (N'Bạc', 42)
---------------------------------END_COLOR--------------------------------------



---------------------------------VERSION_COLOR---------------------------------------------
--CASIO 44.5 mm Nam WS-1400H-1BVDF
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'CASIO 44.5 mm Nam WS-1400H-1BVDF', 1086000, 52, 3, 1, 'https://cdn.tgdd.vn/Products/Images/7264/283082/casio-ws-1400h-1bvdf-nam-thumb-600x600.jpg')

--CASIO 32 mm Unisex A100WE-7BDF
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'CASIO 32 mm Unisex A100WE-7BDF', 1555000, 53, 3, 1, 'https://cdn.tgdd.vn/Products/Images/7264/281610/casio-a100we-7bdf-unisex-thumb-1-600x600.jpg')

--CITIZEN C7 40 mm Nam NH8391-51X
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'CITIZEN C7 40 mm Nam NH8391-51X', 8570000, 54, 3, 1, 'https://cdn.tgdd.vn/Products/Images/7264/274239/citizen-c7-nh8391-51x-nam-thumb-600x600.jpg')

--CITIZEN 30 mm Nữ ER0216-59D
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'CITIZEN 30 mm Nữ ER0216-59D', 4370000, 55, 3, 1, 'https://cdn.tgdd.vn/Products/Images/7264/241154/citizen-er0216-59d-nuava-600x600.jpg')

--ORIENT SK 41.7 mm Nam RA-AA0B05R19B
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'ORIENT SK 41.7 mm Nam RA-AA0B05R19B', 8000000, 56, 3, 1, 'https://cdn.tgdd.vn/Products/Images/7264/275058/orient-ra-aa0b05r19b-thumb-1-600x600.jpg')

--ORIENT Star 41 mm Nam RE-AY0003S00B
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'ORIENT Star 41 mm Nam RE-AY0003S00B', 49000000, 57, 3, 1, 'https://cdn.tgdd.vn/Products/Images/7264/270253/orient-star-re-ay0003s00b-nam-060422-101329-600x600.jpg')
---------------------------------END_VERSION_COLOR-------------------------------------------
