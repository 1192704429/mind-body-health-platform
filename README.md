# 基于 Java 8 与 Spring Boot 的心理健康与身体健康数据分析平台（管理端·教师端·微信小程序）的设计与实现

> 本文围绕高校心理健康与身体健康数据的管理、分析及测评需求，构建了一个包含管理端、教师端与微信小程序的多端协同平台。

## 一、项目背景

- 高校学生心理与身体健康数据分散，缺乏统一的数字化管理工具。
- 管理员需要审核用户注册、管理档案与资讯，教师需自定义测评试卷与评分规则。
- 学生端需便捷查看健康数据、参与心理测评并获取反馈。
- 现有系统无法支持多角色协同、数据审核与自动邮件提醒，亟需一体化解决方案。

## 二、功能模块介绍

该系统分为三个端：管理员端（PC）、教师端（PC）、用户端（微信小程序）。

| 角色 | 所属端 |
| --- | --- |
| 管理员 | 管理员端 |
| 教师 | 教师端 |
| 学生 | 用户端 |


![功能模块图](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/azhou_promotion/img/module_structure/func_module_9d3f3abef8fd4fbca23634a0211a7309.png)


## 三、技术栈说明

前端：Vue2 + Element UI（管理员 PC、教师 PC）、uni-app + uView（微信小程序）

后端：Spring Boot、MyBatis-Plus、Druid

数据库与中间件：MySQL

## 四、核心模块介绍

###### 管理员端

###### 管理员

- 登录后台，维护管理员账号
- 审核学生与心理老师注册（待审不可登录，通过/停用控制账号状态）
- 维护资讯分类、健康资讯、系统公告
- 管理学生档案、教师档案及学生身体健康数据（含数据查询与 Excel 相关能力）

##### 界面展示

登录页：管理员输入账号密码登录健康管理后台

![登录页：管理员输入账号密码登录健康管理后台](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/d40a494b-47f7-4733-8f6e-98b09a4bca95.png)

教师管理页：管理员查看并维护平台内的教师信息

![教师管理页：管理员查看并维护平台内的教师信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/192bcf3c-7d5d-4092-8913-ada4ec71a6bc.png)

公告管理页：管理平台系统公告，可进行增删改操作

![公告管理页：管理平台系统公告，可进行增删改操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/a296c0a3-e6bc-4156-8801-b7842ba5124a.png)

知识分类管理页：管理员对健康知识分类进行增删改管理

![知识分类管理页：管理员对健康知识分类进行增删改管理](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/36628f59-0228-4654-862c-4ef835dcdaa3.png)

健康资讯管理页：管理员管理各类科普健康知识资讯

![健康资讯管理页：管理员管理各类科普健康知识资讯](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/183e5fc4-b6ac-4d0d-82c9-968c60b0d7c4.png)

健康资讯编辑页：修改已有的健康科普资讯内容

![健康资讯编辑页：修改已有的健康科普资讯内容](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/62adffab-70ad-43d2-8a9a-84786ecd1bae.png)

学生档案管理页：管理员查询管理平台内的学生档案信息

![学生档案管理页：管理员查询管理平台内的学生档案信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/8a6487bc-f3e1-417f-8bb3-5313c2ff06d2.png)

学生健康数据列表页：展示学生张三的月度身体健康监测数据

![学生健康数据列表页：展示学生张三的月度身体健康监测数据](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/4ced72fa-f680-4591-85ba-28d1fb07fbaa.png)

健康数据管理页：管理学生健康数据，支持Excel导入与AI分析

![健康数据管理页：管理学生健康数据，支持Excel导入与AI分析](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/d553f650-5684-4633-8885-3260ddfd88f0.png)

健康数据分析页：展示各类身体健康指标的变化趋势

![健康数据分析页：展示各类身体健康指标的变化趋势](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/66be2308-3f04-4e02-8b96-92da2cdd3b65.png)


###### 教师端

###### 老师

- 账号须经管理员审核通过后方可登录，停用账号不可登录
- 维护试卷、试题与评分区间规则，支撑测评打分与结果说明
- 查看学生测评建档记录
- 学生提交成绩后按规则生成文字反馈，并邮件提醒对应教师跟进

##### 界面展示

个人信息页：教师可编辑个人资料，修改账号登录密码

![个人信息页：教师可编辑个人资料，修改账号登录密码](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/4be3e59e-6a46-4e82-8d55-194d42afc10f.png)

学生信息列表页：浏览查询学生的基本档案信息

![学生信息列表页：浏览查询学生的基本档案信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/daa9f96a-7244-48ad-852b-cdb12a6cfb60.png)

测试记录列表页：查看学生心理测评记录，支持删除操作

![测试记录列表页：查看学生心理测评记录，支持删除操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/1a09e846-f5c6-4621-8d0f-5638adbf5f2e.png)

试题管理页：查看维护心理试题，支持增删改查操作

![试题管理页：查看维护心理试题，支持增删改查操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/4642cf5b-a880-4bed-81b7-70a2aa51105c.png)

试卷管理页：管理心理测评试卷，支持增删改查与预览

![试卷管理页：管理心理测评试卷，支持增删改查与预览](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/d079549b-317d-4351-8e4c-1415e4981485.png)

判断规则管理页：管理心理测评评分判断规则，支持增删改查

![判断规则管理页：管理心理测评评分判断规则，支持增删改查](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/1c97e352-2f98-438f-8f3f-35d105c58988.png)


###### 用户端

###### 用户端

- 手机号注册，待管理员审核通过后登录
- 浏览首页公告与健康资讯详情
- 维护身体健康数据、查看心理相关展示与图表
- 参与心理测评、查看测评记录与个人中心（修改资料、密码等）

##### 界面展示

注册页：填写信息完成健康管理小程序账号注册

![注册页：填写信息完成健康管理小程序账号注册](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/7071b379-7dcf-45b5-8dba-53ea49c1f240.png)

首页：展示轮播与健康资讯，供用户浏览查看

![首页：展示轮播与健康资讯，供用户浏览查看](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/3f896874-cedf-42f5-8b3b-a3bbc1239227.png)

资讯列表页：展示健康资讯列表，支持搜索分类浏览

![资讯列表页：展示健康资讯列表，支持搜索分类浏览](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/44e51107-ade6-40cf-8ea0-7a6ba3dd7271.png)

资讯详情页：展示诺如病毒预防相关的健康资讯

![资讯详情页：展示诺如病毒预防相关的健康资讯](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/9074f946-cdda-49c4-8728-9db97414180a.png)

公告详情页：展示健康小程序平台的系统维护公告详情

![公告详情页：展示健康小程序平台的系统维护公告详情](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/c04d6473-3818-4818-85bc-a18b378fb38b.png)

心理测评列表页：展示可供用户参与的各类心理测评

![心理测评列表页：展示可供用户参与的各类心理测评](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/7cab47b4-13e5-4b1e-8c2c-c28edf4b7541.png)

心理测评页：展示明尼苏达多相人格测验试题供用户作答

![心理测评页：展示明尼苏达多相人格测验试题供用户作答](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/f1e10c1f-0641-48ed-880b-b5c44c7b174e.png)

身体健康数据页：查看个人血压、脉率心率等身体健康数据趋势

![身体健康数据页：查看个人血压、脉率心率等身体健康数据趋势](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/b286f5b6-0486-416e-8bcb-688b3f5d413b.png)

健康数据记录页：按月展示用户的历史身体健康数据记录

![健康数据记录页：按月展示用户的历史身体健康数据记录](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/4bbf7190-14f0-4eff-8ca3-a897d15c6c7d.png)

健康数据记录页：浏览按月分类的个人历史身体健康数据

![健康数据记录页：浏览按月分类的个人历史身体健康数据](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/b0933261-c6ad-4365-86a0-37c259992120.png)

健康数据查看页：查看个人血压、脉率心率的健康数据趋势

![健康数据查看页：查看个人血压、脉率心率的健康数据趋势](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/fc2ecb21-85ad-42f4-88cd-3062670ad4da.png)

身体健康数据分析页：展示个人身高体重与视力的健康数据变化趋势

![身体健康数据分析页：展示个人身高体重与视力的健康数据变化趋势](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/5031304a-17d3-44d4-84b7-84a26e0668ca.png)

个人中心页：展示个人中心相关功能选项，供用户操作

![个人中心页：展示个人中心相关功能选项，供用户操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/cbeaf1cd-141a-4506-86c0-8eb0c8dba3e5.png)

个人资料修改页：修改个人资料，提交后更新个人信息

![个人资料修改页：修改个人资料，提交后更新个人信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/bebdf88b-0946-4a0a-806d-898f2a38bbe0.png)

修改资料页：修改个人的基本信息与资料

![修改资料页：修改个人的基本信息与资料](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-05-08/8ffe0581-f502-4e48-8cd4-ea3a372634f7.png)


## 五、主要业务流程

1. 管理员登录后台，创建并维护管理员账号。
2. 学生与心理老师通过小程序或 PC 注册，管理员审核账号状态。
3. 审核通过后，教师登录教师端维护试卷、试题与评分规则。
4. 学生登录小程序维护身体健康数据、浏览资讯与公告。
5. 学生参与心理测评并提交成绩。
6. 系统根据评分规则自动生成文字反馈，并通过邮件提醒对应教师跟进。
7. 教师查看学生测评建档记录，进行后续干预或指导。

## 六、项目拓展性

- 可接入第三方健康设备数据，丰富身体健康数据维度。
- 可扩展数据可视化大屏，为管理层提供决策支持。
- 可增加考试模块，支持多类型题库与自动组卷。
- 可对接学校教务系统，实现学生与教师数据的自动同步。

## 代码说明 
本仓库为项目的 **后端核心代码部分** 主要用于展示系统的业务设计思路与后端实现方式 出于学习展示与版权保护考虑 前端实现、完整数据库脚本及部署配置未在本仓库中公开 

##  项目交流 
本项目用于学习展示 如需项目完整功能演示、答辩说明或技术交流 请前往作者 GitHub 主页查看联系方式