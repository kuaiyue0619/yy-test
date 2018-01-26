###(1)注释要求。
类注释模版
/**
  * <ul>
  * <li>描述类的作用</li>
  * <li>方法一说明</li>
  * <li>方法二说明</li>
  * <li>User:${USER} Date:${DATE} Time:${TIME}</li>
  * </ul>
  */
步骤：settings-->file and code Templates-->选择incudes 进行配置

序列化要求
通过接口传递的对象必须序列化，且务必加上serialVersionUID；
1、setting->Inspections->Serialization issues，将serialzable class without "serialVersionUID"打上勾；

2、将光标放到类名上，按atl＋enter键，就会提示生成serialVersionUID了。

###(2)test 项目结构
dal 数据库映射模块，包含功能为单表映射，增删改查功能
manager 管理模块。
service 接口服务模块。
service-facade 对外接口模块，定义所有对外的接口，以及接口的输入输出model，对外的错误码，异常，枚举等，该模块无任何实现。

dal 模块为最底层，向上提供服务，不引用任何其他模块
manager 在dal层上，依赖下层dal的功能向上提供服务
service 依赖manager层，多个manager功能点形成一个service服务，同时service层是基于service-facade的实现，所以依赖service-facade。
service-facade 不依赖任何模块

dal 模块的输入输出model 应该定义在dal 模块内
manager 模块的输入输出model 应该定义在manager模块内
service 模块的输入输出model 如果是对外的定义在service-facade内，如果是对内的应该定义在service模块内部


(3)、程序数据类型定义
dal层 定义mode的数据类型与数据库字段类型一致
其他层 定义mode数据类型
金额：定义为long
日期类型：定义为Date

(4)
1.  每个表必须要有主键，列名是ID，类型必须是 number 。
2.  每个表必须要有4个字段： CREATED_TIME（创建时间）, UPDATED_TIME（最后修改时间）, CREATED_BY（创建人），UPDATED_BY（最后修改人），注意是过去式 updated 和 created。
3.  INSERT 的时候必须填写 CREATED_TIME ，必须是用DB的时间 SYSDATE 不得由Java填充；UPDATE 语句必须更新 UPDATED_TIME ，统一用DB时间 SYSDATE ，不能由Java填充。
4.  表名长度不得超过 26 个字符。
