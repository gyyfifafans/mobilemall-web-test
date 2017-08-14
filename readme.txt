1.	11个页面
首页
商品页
列表页
搜索列表页
订单填写页
购物车页
支付工具选择页
活动页
评论页

2.	数据初始化
检查商品库存
创建优惠券、H码、下单立减、订单满减、分期（花呗、建行）
检查商品是否包含套装等
进程清理

3.  logger还有问题

4.商品更换（每天下单次数只有3次）

5.清理进程phantomjs--cancel

6.报告修改配置

7.问题
1)File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
2)RemoteWebDriver.getScreenshot 有时候截不到图
8.更改abstractPage-----后期
将WebElement初始加进去----后期

9.提交订单
GET：
http://mobiletest.ehaier.com:58082/mobile/order/orderSubmitM.html?proRegion=%24%7BordersCommitWrapM.region%7D&paytype=online&invoiceType=2&region=944&billCompany=gyy&=0&=0&remark=

JSON:
{"success":true,"errorCode":null,"data":{"order":{"id":21554349,"siteId":1,"isTest":0,"hasSync":1,"isBackend":0,"isBook":0,"isCod":0,"notAutoConfirm":0,"isPackage":0,"packageId":0,"orderSn":"D17072316185503587","relationOrderSn":"","memberId":138231245,"predictId":0,"memberEmail":"hhahahahah@126.com","addTime":1500797935,"syncTime":1500797935,"orderStatus":200,"payTime":0,"paymentStatus":100,"receiptConsignee":"","receiptAddress":"","receiptZipcode":"","receiptMobile":"","productAmount":5399.00,"orderAmount":5399.00,"paidBalance":0,"giftCardAmount":0,"paidAmount":0,"shippingAmount":0,"totalEsAmount":0,"usedCustomerBalanceAmount":0,"customerId":0,"bestShippingTime":"","paymentCode":"alipaymobile","payBankCode":"","paymentName":"支付宝","consignee":"gyy","originRegionName":"","originAddress":"","province":2,"city":716,"region":944,"street":12024719,"markBuilding":0,"poiId":"","poiName":"","regionName":"北京 北京 海淀区 羊坊店街道","address":"dsfsdfsfasdfsadfasf","zipcode":"","mobile":"13313313313","phone":"","receiptInfo":"a:9:{s:5:\"title\";s:3:\"gyy\";s:11:\"receiptType\";i:2;s:10:\"taxSpotNum\";s:0:\"\";s:11:\"needReceipt\";i:1;s:8:\"regPhone\";s:0:\"\";s:10:\"regAddress\";s:0:\"\";s:4:\"bank\";s:0:\"\";s:11:\"companyName\";s:3:\"gyy\";s:11:\"bankAccount\";s:0:\"\";};","delayShipTime":0,"remark":"","bankCode":"","agent":"","confirmTime":0,"firstConfirmTime":0,"firstConfirmPerson":"","finishTime":0,"tradeSn":"","signCode":"888331","source":"MOBILE","sourceOrderSn":"","onedayLimit":0,"logisticsManner":0,"afterSaleManner":0,"personManner":0,"visitRemark":"","visitTime":0,"visitPerson":"","sellPeople":"","sellPeopleManner":0,"orderType":0,"hasReadTaobaoOrderComment":0,"memberInvoiceId":15691889,"taobaoGroupId":0,"tradeType":"","stepTradeStatus":"","stepPaidFee":0,"depositAmount":0,"balanceAmount":0,"autoCancelDays":0,"isNoLimitStockOrder":0,"ccbOrderReceivedLogId":0,"ip":"172.16.180.12","isGiftCardOrder":0,"giftCardDownloadPassword":"","giftCardFindMobile":"","autoConfirmNum":0,"codConfirmPerson":"","codConfirmTime":0,"codConfirmRemark":"","codConfirmState":0,"paymentNoticeUrl":"","addressLon":0,"addressLat":0,"smConfirmStatus":1,"smConfirmTime":0,"smManualTime":0,"smManualRemark":"","isTogether":0,"isNotConfirm":0,"tailPayTime":0,"points":0,"modified":1500797935035,"channelId":0,"addTimeStr":null,"isProduceDaily":0,"couponCode":"","couponCodeValue":0,"ckCode":"","isCoupon":null}},"message":null,"totalCount":0}



http://mobiletest.ehaier.com:58082/mobile/item/buyImmediatelyNew.html?numbers=1&productIds=5031&flag=0   跳转订单填写页+抓包部分可以提交订单
http://mobiletest.ehaier.com:58082/mobile/item/checkStock.html?sku=AB2JD1007®ionId=12036611&prodId=5031  查街道库存

一开始，抓包，之后怀疑保存在cache里，chrome://cache，查找相关地址，跟商品id有关的地址，找到第一个地址


GET:
http://mobiletest.ehaier.com:58082/mobile/order/toOrderSubmitSuccess.html?orderSn={D17072316135525115}


COOKIE_SESSIONID = COOKIE_DOMAIN + "_ehaier_sessionid"



1.H码输入完就post了
2.优惠券领个不同金额的选择看如何提交
3.选择地址
4.search and orderlist and personal and pay  Page
7.提交订单单独类，处理不同活动商品/不同种类商品 看源码

8.excel按照页面分开，包含动作和页面数据
9.增加了wap，pc，app页面包，增加了driver封装，增加了ios、android的配置文件