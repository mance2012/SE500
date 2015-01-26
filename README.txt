# SE500

Name: Xinxin Ma
Date: 1/10/2015


项目的目标： 亚马逊商家猎手 根据ISBN及条件自动找到最优商家
项目的范围： NIV版圣经商家

项目的需求：

	1. 给定ISBN 编号
	2. Condition: New
	3. Rating 95%以上
	4. Total ratings 500 以上
	5. prime 标志
	6. Shipping from U.S
	7. In stock
	8. 商家库(不能选择的商家 或者 必选的商家)

项目的流程：

	1. 找到带有ISBN的网址
	2. 抓取该网页的文本信息
	3. 通过文本信息 解析 提取商家的信息
	4. 对商家信息进行考核
		a. 三页之内找不到可用的商家-----放弃
		b. 找到三个有用的商家后--停止---对商家进行排序(按照rating排序)
		c. 进入商家页面---对feedback history里面最近一个月的rating考核【rating 95% 以上, count 100以上】

项目编程工具： Eclipse Git

项目编程语言： Java


