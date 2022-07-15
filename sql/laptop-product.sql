VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-macbook-149x40.png', 'Macbook') --11
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-asus-149x40.png', 'Asus') --12
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-hp-149x40-1.png', 'HP') --13
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-lenovo-149x40.png', 'Lenovo') --14
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-acer-149x40.png', 'Acer') --15
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-dell-149x40.png', 'DELL') --16
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-msi-149x40.png', 'MSI') --17
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-surface-149x40-1.png', 'Surface') --18
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-lg-149x40.png', 'LG') --19
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-gigabyte-149x40.png', 'Gigabyte') --20
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-intel-149x40.png', 'Intel') --21
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-chuwi-149x40.png', 'CHUWI') --22
INSERT INTO manufacturer (description, logo_url, name)
VALUES ('', 'cdn.tgdd.vn/Brand/1/logo-itel-149x40.png', 'Itel') --23

INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(11,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(12,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(13,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(14,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(15,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(16,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(17,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(18,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(19,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(20,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(21,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(22,2)
INSERT INTO manufacturer_category (manufacturer_id, category_id) VALUES(23,2)

INSERT INTO product (name, is_actived, category_id, manufacturer_id)--7
VALUES ('MacBook Pro 16 M1 Pro 2021', 1, 2, 11)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--8
VALUES ('MacBook Pro 14 M1 Max 2021/24-core GPU', 1, 2, 11)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--9
VALUES ('Asus Vivobook 15 X1502ZA i5 1240P (EJ120W)', 1, 2, 12)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--10
VALUES ('Asus ZenBook UX425EA i5 1135G7 (KI839W)', 1, 2, 12)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--11
VALUES ('HP EliteBook X360 1040 G8 i7 1165G7 (3G1H4PA)', 1, 2, 13)
INSERT INTO product (name, is_actived, category_id, manufacturer_id)--12
VALUES ('HP ZBook Firefly 14 G8 i5 1135G7 (275V5AV)', 1, 2, 13)

INSERT INTO version (name, video_url, product_id) --14
VALUES ('10-core CPU/32GB/512GB/24-core GPU (Z15G)', '',  7) 
INSERT INTO version (name, video_url, product_id)--15
VALUES ('512GB/16 core-GPU (MK1E3SA/A)', '',  8)
INSERT INTO version (name, video_url, product_id)--16
VALUES ('1TB/16 core-GPU (MK1E3SA/A)', '',  8)
INSERT INTO version (name, video_url, product_id)--17
VALUES ('i5 1240P/8GB/512GB/Win11 (EJ120W)', '',  9)
INSERT INTO version (name, video_url, product_id)--18
VALUES ('i5 1135G7/8GB/512GB/Cáp/Túi/Win11 (KI839W)', '',  10)
INSERT INTO version (name, video_url, product_id)--19
VALUES ('i7 1165G7/16GB/512GB/Touch/Pen/Win10 Pro (3G1H4PA) ', '',  11)
INSERT INTO version (name, video_url, product_id)--20
VALUES ('i5 1135G7/16GB/512GB/4GB Quadro T500/Win10 Pro (275V5AV) ', '',  12)

INSERT INTO color (name, manufacturer_id)--21
VALUES (N'Xám', 11)
INSERT INTO color (name, manufacturer_id)--22
VALUES (N'Bạc', 11)
INSERT INTO color (name, manufacturer_id)--23
VALUES (N'Bạc', 12)
INSERT INTO color (name, manufacturer_id)--24
VALUES (N'Xám', 12)
INSERT INTO color (name, manufacturer_id)--25
VALUES (N'Bạc', 13)
INSERT INTO color (name, manufacturer_id)--26
VALUES (N'Xám', 13)

INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'MacBook Pro 16 M1 Pro 2021/512GB/16 core-GPU  ', 64990000, 22, 15, 0, 'cdn.tgdd.vn/Products/Images/44/253636/apple-macbook-pro-16-m1-pro-2021-1.jpg') --- 512 mau bac
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'MacBook Pro 16 M1 Pro 2021/512GB/16 core-GPU  ', 64990000, 21, 15, 0, 'cdn.tgdd.vn/Products/Images/44/253636/apple-macbook-pro-16-m1-pro-2021-1-1.jpg') --- 512 mau xam
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'MacBook Pro 16 M1 Pro 2021/1TB/16 core-GPU  ', 64990000, 21, 16, 0, 'cdn.tgdd.vn/Products/Images/44/253636/apple-macbook-pro-16-m1-pro-2021-1-1.jpg') --- 1tb mau xam
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'MacBook Pro 14 M1 Max 2021/24-core GPU  ',  76900000, 21, 14, 0, 'cdn.tgdd.vn/Products/Images/44/263914/macbook-pro-14-m1-max-2021-10-core-cpu-xam-1.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Asus Vivobook 15 X1502ZA i5 1240P (EJ120W)  ',   17990000, 23, 17, 0, 'cdn.tgdd.vn/Products/Images/44/281483/asus-vivobook-15-x1502za-i5-ej120w-1-1.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'Asus ZenBook UX425EA i5 1135G7 (KI839W)  ',   22490000, 24, 18, 0, 'cdn.tgdd.vn/Products/Images/44/269582/asus-zenbook-ux425ea-i5-ki839w-1.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'HP EliteBook X360 1040 G8 i7 1165G7  ',   49590000, 25, 19, 0, 'cdn.tgdd.vn/Products/Images/44/242415/hp-elitebook-x360-1040-g8-i7-3g1h4pa-1-org.jpg')
INSERT INTO version_color (name, price, color_id, version_id, is_default, avartar)
VALUES (N'HP ZBook Firefly 14 G8 i5 1135G7  ',   39890000, 26, 20, 0, 'cdn.tgdd.vn/Products/Images/44/264438/hp-zbook-firefly-14-g8-i5-275v5av-1-2.jpg')