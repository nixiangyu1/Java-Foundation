#### 28.1数据库

数据库是存储数据的仓库

数据管理系统DBMS：操作和管理数据库的大型软件

##### 28.1.1数据表和Java类中的对应关系

![1559442364057](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559442364057.png)

##### 28.1.2数据类型

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30776\wps1.jpg)

详细的数据类型如下(不建议详细阅读！)

| **分类**             | **类型名称**                                                 | **说明**           |
| -------------------- | ------------------------------------------------------------ | ------------------ |
| **整数类型**         | tinyInt                                                      | 很小的整数         |
| smallint             | 小的整数                                                     |                    |
| mediumint            | 中等大小的整数                                               |                    |
| int(integer)         | 普通大小的整数                                               |                    |
| **小数类型**         | float                                                        | 单精度浮点数       |
| double               | 双精度浮点数                                                 |                    |
| decimal（m,d）       | 压缩严格的定点数                                             |                    |
| **日期类型**         | year                                                         | YYYY  1901~2155    |
| time                 | HH:MM:SS  -838:59:59~838:59:59                               |                    |
| date                 | YYYY-MM-DD 1000-01-01~9999-12-3                              |                    |
| datetime             | YYYY-MM-DD HH:MM:SS 1000-01-01 00:00:00~ 9999-12-31 23:59:59 |                    |
| timestamp            | YYYY-MM-DD HH:MM:SS  1970~01~01 00:00:01 UTC~2038-01-19 03:14:07UTC |                    |
| **文本、二进制类型** | CHAR(M)                                                      | M为0~255之间的整数 |
| VARCHAR(M)           | M为0~65535之间的整数                                         |                    |
| TINYBLOB             | 允许长度0~255字节                                            |                    |
| BLOB                 | 允许长度0~65535字节                                          |                    |
| MEDIUMBLOB           | 允许长度0~167772150字节                                      |                    |
| LONGBLOB             | 允许长度0~4294967295字节                                     |                    |
| TINYTEXT             | 允许长度0~255字节                                            |                    |
| TEXT                 | 允许长度0~65535字节                                          |                    |
| MEDIUMTEXT           | 允许长度0~167772150字节                                      |                    |
| LONGTEXT             | 允许长度0~4294967295字节                                     |                    |
| VARBINARY(M)         | 允许长度0~M个字节的变长字节字符串                            |                    |
| BINARY(M)            | 允许长度0~M个字节的定长字节字符串                            |                    |

#### 28.2SQL语句

##### 28.2.1主键约束

1. 创建表

~~~mysql
create table 表名(

   字段名 类型(长度) 约束,

   字段名 类型(长度) 约束

);
~~~

​	2.主键约束

 在创建表时创建主键，在字段后面加上  primary key.

~~~mysql
create table tablename(	
id int primary key,
.......
)
~~~

 在创建表时创建主键，在表创建的最后来指定主键	

~~~mysql
create table tablename(						
id int，
.......，
primary key(id)
)
~~~



​	3.删除主键：alter table 表名 drop primary key;

~~~mysql
alter table sort drop primary key;
~~~

​	4.主键自动增长：一般主键是自增长的字段，不需要指定。

~~~mysql
实现添加自增长语句,主键字段后加auto_increment(只适用MySQL)
~~~

##### 28.1.2查看表

查看数据库中的所有表

~~~mysql
show tables;
~~~

查看表结构

~~~mysql
desc 表名;
~~~

##### 28.1.3删除表

格式：drop table 表名;

~~~mysql
drop table sort;
~~~

##### 28.1.4修改表结构

添加列

~~~mysql
ALTER TABLE users ADD tel INT
~~~

修改列的数据类型

~~~mysql
ALTER TABLE users MODIFY tel VARCHAR(50)
~~~

修改列名称

~~~mysql
ALTER TABLE users CHANGE tel newtel DOUBLE
~~~

删除列

~~~mysql
ALTER TABLE users DROP 	newtel
~~~

修改表名

 ~~~mysql
RENAME TABLE users TO newusers
 ~~~

修改表的字符集

~~~mysql
ALTER TABLE users CHARACTER SET gbk
~~~

##### 28.1.5添加数据

向数据表中添加数据 insert

~~~mysql


INSERT INTO product (id,pname,price) VALUES (1,'笔记本',5555.99);


~~~

添加数据格式,不考虑主键
   格式:
     insert into 表名 (列名) values (值)

~~~java
INSERT INTO product (pname,price) VALUES('洗衣机',800);
~~~

添加数据格式,所有值全给出
   格式:
     insert into 表名 values (全列值)

~~~java
INSERT INTO product VALUES (4,'微波炉',300.25);
~~~

 添加数据格式,批量写入
   格式:
     insert into 表名 (列名1,列名2,列名3) values (值1,值2,值3),(值1,值2,值3)

~~~java
INSERT INTO product (pname,price) VALUES 
('智能机器人',25999.22),
('彩色电视',1250.36),
('沙发',5899.02)
~~~

##### 28.1.6更新数据

对数据进行更新操作
   数据在原有的基础上修改
   格式:
     UPDATE 表名 set 列1=值1,列2=值2 WHERE 条件
     WHERE 条件: 数据中的唯一性

-- 修改彩色电视,名字改为黑白电视机,价格,100

~~~mysql
UPDATE product SET pname='黑白电视机', price=100 WHERE id = 6
~~~

在数据库中

与    AND

或  OR

非   NOT

~~~MYSQL
-- 将笔记本的价格,和空调的价格,全部修改为2000
UPDATE product SET price = 2000 WHERE id = 1 OR id = 7;
~~~

##### 28.1.7删除数据

格式:
   DELETE FROM表名 WHERE 条件

   ~~~MYSQL
DELETE FROM product WHERE id=8;
   ~~~

  **MySQL中有两种删除表中记录的方法，一种是delete from语句，另一种是truncate table语句**。 
（1）delete from语句可以使用where对要删除的记录进行选择。而使用truncate table将删除表中的所有记录。因此，delete语句更灵活。 
（2）如果要清空表中的所有记录，可以使用下面的两种方法：  
delete from tablename  
truncate table tablename 
其中第二条记录中的table是可选的。 
（3）如果要删除表中的部分记录，只能使用delete语句。 
delete FROM table1 WHERE ; 
如果delete不加WHERE子句，那么它和truncate table是一样的，但它们有一点不同，那就是delete可以返回被删除的记录数，而truncate table返回的是0。 
（4）如果一个表中有自增字段，使用truncate table和没有WHERE子句的delete删除所有记录后，这个自增字段将起始值恢复成1.如果你不想这样做的话，可以在delete语句中加上永真的WHERE，如WHERE 1或WHERE true。 
delete FROM table1 WHERE 1; 
上面的语句在执行时将扫描每一条记录。但它并不比较，因为这个WHERE条件永远为true。这样做虽然可以保持自增的最大值，但由于它是扫描了所有的记录，因此，它的执行成本要比没有WHERE子句的delete大得多。

**delete和truncate table的最大区别**是delete可以通过WHERE语句选择要删除的记录。但执行得速度不快。而且还可以返回被删除的记录数。而truncate table无法删除指定的记录，而且不能返回被删除的记录。但它执行得非常快。

#### 28.3SQL查询语句

##### 28.3.1查询语法

 创建账务表:

~~~mysql
use mybase;
CREATE TABLE zhangwu (
  id INT PRIMARY KEY AUTO_INCREMENT, -- 账务ID
  zname VARCHAR(200), -- 账务名称
  zmoney DOUBLE -- 金额
);
~~~

~~~mysql
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (1,'吃饭支出',247);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (2,'工资收入',12345);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (3,'服装支出',1000);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (4,'吃饭支出',325);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (5,'股票收入',8000);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (6,'打麻将支出',8000);
INSERT  INTO zhangwu(id,zname,zmoney) VALUES (7,NULL,5000);
~~~

查询指定列的数据
   格式:
     select 列名1,列名2 from 表名

~~~mysq
SELECT zname,zmoney FROM zhangwu;
~~~

查询所有列的数据
  格式:
    select * from 表名

~~~mysql
SELECT * FROM zhangwu;
~~~

distinct 去掉重复记录

~~~mysql
*
   查询去掉重复记录
   DISTINCT 关键字 FROM 列名
*/
SELECT  DISTINCT zname FROM zhangwu
~~~

查询重新命名列

~~~mysql
/*
  查询重新命名列
  as 关键字
*/
SELECT zname AS 'name' FROM zhangwu 
~~~

查询数学运算

~~~mysql
*
  查询数据中,直接进行数学计算
  列对数字进行计算
*/
SELECT zname,zmoney+1000 AS'sum' FROM zhangwu
~~~

##### 28.3.2条件查询

where语句表条件过滤。满足条件操作，不满足不操作，多用于数据的查询与修改。

格式 :select 字段  from 表名  where 条件;	

while条件的种类如下：

![1559479807711](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559479807711.png)

~~~mysql
-- 查询所有的吃饭支出
SELECT * FROM zhangwu WHERE zname='吃饭支出'
~~~

~~~mysql
-- 查询金额大于1000
SELECT * FROM zhangwu WHERE zmoney>1000
~~~

```mysql
-- 查询金额在2000到5000之间 
SELECT * FROM zhangwu WHERE zmoney >= 2000 AND zmoney <= 5000
-- 改造成between and 方式
SELECT * FROM zhangwu WHERE zmoney BETWEEN 2000 AND 5000
```



~~~mysql
-- 查询金额是 1000,3500,5000 其中一个
SELECT * FROM zhangwu WHERE zmoney = 1000 OR zmoney=3500 OR zmoney=5000
-- 改造成in方式
SELECT * FROM zhangwu WHERE zmoney  IN (1000,3500,5000)
~~~



```mysql

-- like 模糊查询 配合通配符
-- 查询所有的支出
SELECT * FROM zhangwu WHERE zname LIKE '%支出%'
```



```mysql
-- 查询账务名字,五个字符的
SELECT * FROM zhangwu WHERE zname LIKE'_____'
```



```mysql
-- 查询账务名,不为空的
SELECT * FROM zhangwu WHERE zname IS NOT NULL
SELECT * FROM zhangwu WHERE   NOT ( zname IS NU)
```

##### 28.3.3排序查询

~~~mysql
/*
  查询,对结果集进行排序
  升序,降序,对指定列排序
  order by 列名 [desc][asc]
  desc 降序
  asc  升序排列,可以不写
*/
-- 查询账务表,价格进行升序
SELECT * FROM zhangwu ORDER BY zmoney ASC

-- 查询账务表,价格进行降序
SELECT * FROM zhangwu ORDER BY zmoney DESC

-- 查询账务表,查询所有的支出,对金额降序排列
-- 先过滤条件 where 查询的结果再排序
SELECT * FROM zhangwu WHERE zname LIKE'%支出%' ORDER BY zmoney DESC
~~~

##### 28.3.4聚合函数

~~~mysql
/*
   使用聚合函数查询计算
*/

-- count 求和,对表中的数据的个数求和  count(列名)
-- 查询统计账务表中,一共有多少条数据
SELECT COUNT(*)AS'count' FROM zhangwu

-- sum求和,对一列中数据进行求和计算 sum(列名)
-- 对账务表查询,对所有的金额求和计算
SELECT SUM(zmoney) FROM zhangwu
-- 求和,统计所有支出的总金额
SELECT SUM(zname) FROM zhangwu WHERE zname LIKE'%收入%'

INSERT INTO zhangwu (zname) VALUES ('彩票收入')

-- max 函数,对某列数据,获取最大值
SELECT MAX(zmoney) FROM zhangwu

-- avg 函数,计算一个列所有数据的平均数
SELECT AVG(zmoney)FROM zhangwu
~~~

##### 28.3.5分组查询

~~~mysql
/*
    查询所有的数据
    吃饭支出 共计多少
    工资收入 共计多少
    服装支出 共计多少
    股票收入 共计多少
    打麻将支出 共计多少钱
    
    分组查询:  group by 被分组的列名
    必须跟随聚合函数
    select 查询的时候,被分组的列,要出现在select 选择列的后面
*/
  SELECT SUM(zmoney),zname FROM zhangwu GROUP BY zname
  
-- 对zname内容进行分组查询求和,但是只要支出
SELECT SUM(zmoney)AS 'getsum',zname FROM zhangwu WHERE zname LIKE'%支出%'
GROUP BY zname
ORDER BY getsum DESC

-- 对zname内容进行分组查询求和,但是只要支出, 显示金额大于5000
-- 结果集是分组查询后,再次进行筛选,不能使用where, 分组后再次过滤,关键字 having
SELECT SUM(zmoney)AS 'getsum',zname FROM zhangwu WHERE zname LIKE'%支出%'
GROUP BY zname HAVING getsum>5000

~~~

