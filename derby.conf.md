

DERBY_HOME D:\dev_tools\db-derby-10.11.1.1-bin
path %DERBY_HOME%\bin;
classpath %DERBY_HOME%\lib\derbyrun.jar

测试数据库安装 C:\>sysinfo  

连接

 C:\>ij  
 ij 版本 10.10  
 ij> CONNECT 'jdbc:derby:D:\derbyDB\leehill;create=true';（如果数据库testdb不存在，则创建改数据库）  
 ij> CONNECT 'jdbc:derby:D:\derbyDB\leehill';          （连接testdb数据库）  
 ij(CONNECTION1)> CREATE TABLE HILL(ID INT PRIMARY KEY,NAME VARCHAR(12));（创建表）  
 已插入/更新/删除 0 行  
 ij(CONNECTION1)> INSERT INTO HILL VALUES(10,'TEN'),(20,'TWENTY'),(30,'THIRTY');（插入数据）  
 已插入/更新/删除 3 行  
 ij(CONNECTION1)> SELECT * FROM HILL;  
 ID |NAME  
 ------------------------  
 10 |TEN  
 20 |TWENTY  
 30 |THIRTY  
 已选择 3 行  
 ij(CONNECTION1)>exit;（退出）

说明

1. sysinfo工具用于显示Java环境信息和Derby的版本信息。
2. ij工具来进行数据库交互，执行SQL脚本，如查询、增删改、创建表等

运行SQL脚本
 run '<SQL脚本文件的路径>'；
 
 