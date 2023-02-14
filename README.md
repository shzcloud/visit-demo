# visit-demo

##### 数据源配置

1. 新建test-ds库
2. 修改表sys_ds中访问记录库的url为自己的访问记录库地址
3. 项目配置文件始终配置的是包含表sys_ds的库
4. 创建visit库（执行项目 https://github.com/shzcloud/visit resources目录中的init_visit.sql脚本）

##### 启动项目

访问接口即可生成分库分表访问记录

##### 记录器

1. shz.visit.recorder.VisitRecorder 访问记录器，必须
2. shz.visit.recorder.VisitDataRecorder 访问请求及响应数据记录器，非必须