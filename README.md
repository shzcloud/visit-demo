# visit-demo

##### 创建visit库

执行项目 https://github.com/shzcloud/visit resources目录中的init_visit.sql脚本

##### 创建本项目库xxx_demo

执行本项目resources目录中已生成好的数据源脚本sys_ds.sql

##### 启动项目

访问接口即可生成分库分表访问记录

##### 记录器

1. shz.visit.recorder.VisitRecorder 访问记录器，必须
2. shz.visit.recorder.VisitDataRecorder 访问请求及响应数据记录器，非必须