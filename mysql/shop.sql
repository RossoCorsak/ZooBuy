--储存商品信息
DROP TABLE IF EXISTS goods;
CREATE TABLE goods  (
  gid int(7) NOT NULL AUTO_INCREMENT,
  gname varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  price decimal(7,2) unsigned NOT NULL,
  stocks int(4) unsigned NOT NULL,
  image varchar(30),
  PRIMARY KEY (gid) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic AUTO_INCREMENT=1000000;

INSERT INTO goods VALUES(NULL,'新款苹果14pro动物手机壳',15.99,100,'image/name.jpg');
INSERT INTO goods VALUES(NULL,'北京冬奥会官方纪念品',59.99,100,'image/name.jpg');
INSERT INTO goods VALUES(NULL,'2023新款专业跑步鞋竞速马拉松',1299,100,'image/name.jpg');

--储存用户信息
DROP TABLE IF EXISTS users;
CREATE TABLE users  (
  uid int(9) NOT NULL AUTO_INCREMENT,
  username varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  password varchar(20) NOT NULL,
  phone char(11) NOT NULL,
  PRIMARY KEY (uid) USING BTREE,
  unique index_users_phone(phone)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic AUTO_INCREMENT=100000000;

INSERT INTO users VALUES(NULL,'douyin_55612','5561123sda..','15119615112');

--购物车
DROP TABLE IF EXISTS cart;
CREATE TABLE cart  (
  uid int(9) NOT NULL,
  gid int(7) NOT NULL,
  PRIMARY KEY (uid,gid) USING BTREE,
  constraint fk_c_uid foreign key (uid) references users(uid),
  constraint fk_c_gid foreign key (gid) references goods(gid)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

--交易记录
DROP TABLE IF EXISTS tradingrecord;
CREATE TABLE tradingrecord (
  tid int(9) NOT NULL AUTO_INCREMENT,
  uid int(9) NOT NULL,
  gid int(7) NOT NULL,
  price decimal(7,2) unsigned NOT NULL,
  gname varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  image varchar(30),
  realname varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  phone char(11) NOT NULL,
  address varchar(60),
  pay decimal(7,2) unsigned NOT NULL,
  PRIMARY KEY (tid) USING BTREE,
  constraint fk_tr_uid foreign key (uid) references users(uid),
  constraint fk_tr_gid foreign key (gid) references goods(gid)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic AUTO_INCREMENT=100000000;

--浏览记录
DROP TABLE IF EXISTS browsingrecord;
CREATE TABLE browsingrecord (
  uid int(9) NOT NULL,
  gid int(7) NOT NULL,
  btime Datetime NOT NULL,
  constraint fk_br_uid foreign key (uid) references users(uid),
  constraint fk_br_gid foreign key (gid) references goods(gid)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

