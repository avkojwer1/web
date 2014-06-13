/*查询某个拥有某个角色*/
select u.name,r.name
from users u inner join roleuser ru on u.id=ru.uid
             inner join roles r on ru.rid=r.id;
             
/*某角色拥有某菜单*/
select r.name,m.name
from roles r inner join rolemenu rm on r.id=rm.rid
             inner join menus m on rm.mid=m.id;

             
/*查询某人拥有某个菜单*/
select m.*
from users u inner join roleuser ru on u.id=ru.uid
             inner join roles r on ru.rid=r.id
             inner join rolemenu rm on r.id=rm.rid
             inner join menus m on rm.mid=m.id;