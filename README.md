# 编写目的
编写关于南京高校周边的商铺信息的交流平台的用户需求分析，对开发流程进行梳理，指导详细设计人员进行进一步的详细设计，以及业务人员、开发人员理解熟悉平台的运行原理。
最终读者：项目开发团队，项目公司，高校管理员。
# 	目标
**开发意图**：介绍南京高校周边店铺，给用户提供对店铺反馈信息交流的平台，以及记录用户光顾店铺的情况，推荐可能感兴趣的店铺。
预期目标：增加用户对附近店铺的了解程度，减小选择消费场所的风险，改善在周边消费的体验，发现可能感兴趣的店铺，提供交流吐槽的平台。


# 功能需求 
## 登录
### 游客登录
如果用户选择以游客身份登录，则跳转到首页，只能浏览帖子以及店铺，无法对店铺进行收藏，也无法对帖子进行点赞以及评论。
### 注册登录
如果用户选择注册登录，则需要填写昵称，手机号，密码，选择或者上传头像，选择性别，所在高校（具体到校区）。系统自动验证该账号是否已注册，若已注册，提示已经存在。在设置密码时需输入两次以确保没有输错。用户在注册成功后会自动跳转到首页。
### 第三方登录 
如果用户选择第三方登录，可以通过微信，QQ以及微博进行登录，只需同意授权，即可成功登录，跳转到首页。
## 	个人
### 个人信息设置
已注册用户进入个人信息设置功能后，输入需要修改的信息，比如昵称，头像，性别，生日，手机号，邮箱以及所在高校。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 我的消息
已注册用户进入我的消息功能后，可以查看系统提醒等信息。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 我的浏览记录
用户进入浏览记录功能后，可以查看最近浏览过的店铺。用户还可以删除浏览记录。
### 收藏的店铺
已注册用户进入个人收藏功能后，可查看收藏的店铺以及删除收藏的店铺。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 系统设置
用户可以设置在有新消息时是否需要提醒以及是否有声音。用户还可在该页面查看该软件是否有新的版本并更新。同时，用户可以查看开发团队的网站。
### 修改密码
已注册用户进入修改密码功能后，需要验证旧密码，输入新密码并确认新密码才可成功修改密码。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 注销账户
已注册用户进入账户注销功能后，退出当前账户，返回登录页面。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 消息提醒
用户可通过拖动按钮选择是否接受消息提醒。
### 声音提醒
用户可拖动按钮选择来消息时是否有声音提醒。
### 点击头像登录
用户可拖动按钮选择来消息时是否有声音提醒。
## 	动态
### 发动态
已注册用户进入发动态功能后，进入发动态页面，输入自己消费后的一些感想等等，还可添加图片。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 浏览动态
用户进入浏览动态页面后，可以查看所有的帖子。所有帖子以活跃的排序，越活跃（即评价的人很多或者发帖人更新频繁）的帖子排名越靠前。用户还可以给帖子点赞。
## 江山
### 勋章
用户进入勋章墙功能后，可查看自己的勋章。系统根据是否完成相应的任务（比如是否注册，是否完善个人信息等）颁发不同等级的勋章。
### 足迹
已注册用户进入所到之处功能后，可以以脚印的形式查看自己去过的店铺。如果去过某个店铺，则在地图上留下一个脚印。
游客则提示无法进入该页面，并询问是否注册。如果回答是，则跳转到注册页面，否则退回原有页面。
### 搜索
用户进入相关店铺功能后，输入需要查找的店铺，则会显示与输入关键字有关的店铺。
##	推荐
用户进入首页后，会看到系统根据浏览记录以及评分推荐的店铺。
## 浏览店铺
用户进入店铺介绍页面后，可以浏览店铺的简介，评分，电话，地址，评价等信息。用户可以对店铺进行点赞，点评或收藏。
# 软件接口
##  QQ登陆接口：
用户通过点击第三方授权登录，可以直接登陆授权APP，遵循OAuth协议，登陆后QQ会返回openid以及access_token两个重要信息以及QQ资料中你已经编辑的信息。
## 高德地图接口：
在查看店铺位置的时候，高德地图会返回使用者的位置以及可以显示该位置到查询店铺的路径并且通过地图显示出来。
##  数据库接口：
使用JDBC接口JDBC（Java Data Base Connectivity,java数据库连接）是一种用于执行SQL语句的Java API，可以为多种关系数据库提供统一访问，它