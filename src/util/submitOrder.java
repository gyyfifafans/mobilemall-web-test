package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import test.testSession;

public class submitOrder {
	public static void main(String[]args) throws ClientProtocolException, IOException{
		String loginurl = "http://mobiletest.ehaier.com:58082/mobile/member/memberLogin.html";
		String url = "http://mobiletest.ehaier.com:58082/mobile/item/buyImmediatelyNew.html?numbers=1&productIds=5031&flag=0";
		String url1 = "http://mobiletest.ehaier.com:58082/mobile/order/orderSubmitM.html?paytype=online&invoiceType=2&region=3091&billCompany=gggg&=0&=0&remark=";
		submitOrder su = new submitOrder();
		//查库存，到街道
		String urlstock = "http://mobiletest.ehaier.com:58082/mobile/item/checkStock.html?sku=AB2JD1007&regionId=12036611&prodId=5031";
		String username = "13313313313";// 登录用户
		String password = "222222";// 登录密码
		 
		        // 需要提交登录的信息
		String urlLogin = "http://mobiletest.ehaier.com:58082/mobile/member/memberLogin.html";
		 
		        // 登录成功后想要访问的页面 
		String urlAfter = "http://mobiletest.ehaier.com:58082/mobile/item/buyImmediatelyNew.html?numbers=1&productIds=5031&flag=0";
		 
		
		 }

}
