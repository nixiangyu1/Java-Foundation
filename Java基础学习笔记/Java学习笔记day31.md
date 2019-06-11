#### 31.1管家婆家庭记账软件

##### 31.1.1业务分层

 view层作用: 视图层,即项目中的界面

controller层作用: 控制层, 获取界面上的数据,为界面设置数据; 将要实现的功能交给业务层处理

service层作用: 业务层, 功能的实现, 与controller控制层和数据访问层DAO交互, 将对数据库的操作交给DAO数据访问层来处理

dao层作用: 数据访问层, 用来操作数据库表的数据

db数据库: 这里指MySQL

domain 实体包: 存放JavaBean

tools工具包:存放项目中使用到的工具类

test 测试包: 存放项目功能测试的代码

![1559794939070](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559794939070.png)

