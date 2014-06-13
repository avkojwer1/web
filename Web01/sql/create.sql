create database auth character set UTF8;
/*用户表*/
create table users(
  id varchar(32) primary key,
  name varchar(30),
  pwd varchar(32)
);
/*创建角色表*/
create table roles(
  id varchar(32) primary key,
  name varchar(30),
  des  varchar(100)
);

/*通过一个中间表映射多对多的关系,多对多就是多个一对多
	联合主键的特点是：两个列不能同时重复
*/
create table roleuser(
   uid varchar(32),
   rid varchar(32),
   constraint ru_pk primary key(uid,rid),
   constraint ru_fk1 foreign key(uid) references users(id),
   constraint ru_fk2 foreign key(rid) references roles(id)
);

/*创建菜单表*/
create table menus(
  id varchar(32) primary key,
  name varchar(50),
  url  varchar(100)
);
/*关联角色到菜单*/
create table rolemenu(
  mid varchar(32),
  rid varchar(32),
  constraint rm_pk primary key(mid,rid),
  constraint rm_fk1 foreign key(mid) references menus(id),
  constraint rm_fk2 foreign key(rid) references roles(id)
)
