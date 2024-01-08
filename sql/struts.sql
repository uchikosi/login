set names utf8;
set foreign_key_checks = 0;
drop database if exists logindb;
create database logindb;
use logindb;

create table user(
	id int,
	user_name varchar(255),
	password varchar(255)
);

insert into user values
(1,"taro","123"),
(2,"jiro","123"),
(3,"hanako","123"),
(4,"saburo","123");

--「user」が
--「user」テーブルにデータを追加します。
--drop、create、useは、定型文なので必ずこの3行は書きましょう

--drop database if exists logindb;
--もしあれば、という条件付きで、1度データベースを削除します。

--create database logindb;
--新たにデータベースを作成します。必ず、１行目で削除したデータベース名と合わせます。

--use logindb
--作成したデータベースに移動します。
--ここも上記と同じデータベース名にします。

--「user」テーブルにデータを追加します。