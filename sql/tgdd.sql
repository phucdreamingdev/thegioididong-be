--1
CREATE TABLE category
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL,
  level INT NOT NULL,
  parent_name NVARCHAR(50) NOT NULL,
  status bit  NOT NULL
);

CREATE TABLE province
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL
);

CREATE TABLE manufacturer
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL,
  logo_url text  NOT NULL,
  description text NOT NULL
);

CREATE TABLE image
(
  id INT PRIMARY KEY IDENTITY,
  url text  NOT NULL
);

CREATE TABLE member
(
  id INT PRIMARY KEY IDENTITY,
  phone CHAR(10) NOT NULL,
  fullname NVARCHAR(50) NOT NULL
);

CREATE TABLE admin_account
(
  id INT PRIMARY KEY IDENTITY,
  username NVARCHAR(50) NOT NULL,
  password VARCHAR(64) NOT NULL,
  fullname NVARCHAR(50) NOT NULL
);

CREATE TABLE color
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL
);
--2
CREATE TABLE district
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL,
  province_id INT NOT NULL,
  FOREIGN KEY (province_id) REFERENCES province(id)
);
--3
CREATE TABLE ward
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL,
  district_id INT NOT NULL,
  FOREIGN KEY (district_id) REFERENCES district(id)
);

--4
CREATE TABLE member_adress
(
  id INT PRIMARY KEY IDENTITY,
  address_detail VARCHAR(200) NOT NULL,
  is_default bit NOT NULL,
  ward_id INT NOT NULL,
  member_id INT NOT NULL,
  FOREIGN KEY (ward_id) REFERENCES ward(id),
  FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE image_group
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL,
  category_id INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES category(id)
);



CREATE TABLE specification_group
(
  id INT PRIMARY KEY IDENTITY,
  name INT NOT NULL,
  category_id INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE product
(
  id INT PRIMARY KEY IDENTITY,
  name NVARCHAR(50) NOT NULL,
  status bit NOT NULL,
  manufacturer_id INT NOT NULL,
  category_id INT NOT NULL,
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id),
  FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE branch
(
  id INT PRIMARY KEY IDENTITY,
  address_detail VARCHAR(200) NOT NULL,
  status bit NOT NULL,
  ward_id INT NOT NULL,
  FOREIGN KEY (ward_id) REFERENCES ward(id)
);



--5
CREATE TABLE member_order
(
  id INT PRIMARY KEY IDENTITY,
  order_date DATE NOT NULL,
  delivery_date DATE NOT NULL,
  note TEXT  NOT NULL,
  delivery_status NVARCHAR(50) NOT NULL,
  total FLOAT NOT NULL,
  branch_id INT NOT NULL,
  member_id INT NOT NULL,
  FOREIGN KEY (branch_id) REFERENCES branch(id),
  FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE version
(
  id INT PRIMARY KEY IDENTITY,
  name VARCHAR(50) NOT NULL,
  product_id INT NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(id)
);
--6
CREATE TABLE order_detail
(
  id INT PRIMARY KEY IDENTITY,
  original_price FLOAT NOT NULL,
  promotion_price FLOAT NOT NULL,
  product_id INT NOT NULL,
  order_id INT NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(id),
  FOREIGN KEY (order_id) REFERENCES member_order(id)
);


CREATE TABLE version_color
(
  id INT PRIMARY KEY IDENTITY,
  is_default BIT NOT NULL,
  price INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  version_id INT NOT NULL,
  color_id INT NOT NULL,
  FOREIGN KEY (version_id) REFERENCES version(id),
  FOREIGN KEY (color_id) REFERENCES color(id)
);

CREATE TABLE specification
(
  id INT PRIMARY KEY IDENTITY,
  name INT NOT NULL,
  version_id INT NOT NULL,
  image_id INT NOT NULL,
  FOREIGN KEY (version_id) REFERENCES version(id),
  FOREIGN KEY (image_id) REFERENCES image(id)
);

CREATE TABLE image_group_detail
(
  id INT PRIMARY KEY IDENTITY,
  detail  TEXT,
  image_group_id INT NOT NULL,
  version_id INT NOT NULL,
  FOREIGN KEY (image_group_id) REFERENCES image_group(id),
  FOREIGN KEY (version_id) REFERENCES version(id)
);

CREATE TABLE video
(
  id INT PRIMARY KEY IDENTITY,
  name VARCHAR(200) NOT NULL,
  url TEXT NOT NULL,
  version_id INT NOT NULL,
  FOREIGN KEY (version_id) REFERENCES version(id)
);
--7
CREATE TABLE image_product
(
  version_color_id INT NOT NULL,
  image_id INT NOT NULL,
  FOREIGN KEY (version_color_id) REFERENCES version_color(id),
  FOREIGN KEY (image_id) REFERENCES image(id)
);



CREATE TABLE specification_detail
(
  id INT PRIMARY KEY IDENTITY,
  name VARCHAR(50) NOT NULL,
  content TEXT NOT NULL,
  group_id INT NOT NULL,
  sepecification_id INT NOT NULL,
  FOREIGN KEY (group_id) REFERENCES specification_group(id),
  FOREIGN KEY (sepecification_id) REFERENCES specification(id)
);



CREATE TABLE promotion
(
  id INT PRIMARY KEY IDENTITY,
  promotion_percent INT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  version_color_id INT NOT NULL,
  FOREIGN KEY (version_color_id) REFERENCES version_color(id)
);

CREATE TABLE product_branch_stock
(
  
  id INT PRIMARY KEY IDENTITY,
  branch_id INT NOT NULL,
  version_color_id INT NOT NULL,
  stock INT NOT NULL,
  FOREIGN KEY (branch_id) REFERENCES branch(id),
  FOREIGN KEY (version_color_id) REFERENCES version_color(id)
);

--8
CREATE TABLE promotion_branch
(
  promotion_id INT NOT NULL,
  branch_id INT NOT NULL,
  FOREIGN KEY (promotion_id) REFERENCES promotion(id),
  FOREIGN KEY (branch_id) REFERENCES branch(id)
);

CREATE TABLE product_branch_transaction
(
  id INT PRIMARY KEY IDENTITY,
  stock INT NOT NULL,
  transaction_date DATE NOT NULL,
  transaction_quantity INT NOT NULL,
  note TEXT,
  product_branch_stock_id INT NOT NULL,
  FOREIGN KEY (product_branch_stock_id) REFERENCES product_branch_stock(id)
);

