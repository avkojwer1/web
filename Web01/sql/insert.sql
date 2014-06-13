
insert into users values('U001','Jack','1234');
insert into users values('U002','张三','4321');
insert into users values('U003','Tom','1111');

insert into roles values('R001','管理员','');
insert into roles values('R002','教师','');

insert into roleuser values('U001','R001');
insert into roleuser values('U002','R002');

insert into menus values('M001','系统管理','/sys.jsp');
insert into menus values('M002','用户管理','/user.jsp');
insert into menus values('M003','角色管理','/role.jsp');

insert into rolemenu values('M001','R001');
insert into rolemenu values('M002','R001');
insert into rolemenu values('M003','R001');
insert into rolemenu values('M003','R002');