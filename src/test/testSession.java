package test;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
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

public class testSession {
	public static void main(String[]args) throws ClientProtocolException, IOException{
		String loginurl = "http://mobiletest.ehaier.com:58082/mobile/member/memberLogin.html";
		String url = "http://mobiletest.ehaier.com:58082/mobile/item/buyImmediatelyNew.html?numbers=1&productIds=5031&flag=0";
		String url1 = "http://mobiletest.ehaier.com:58082/mobile/order/orderSubmitM.html?paytype=online&invoiceType=2&region=3091&billCompany=gggg&=0&=0&remark=";
		testSession s = new testSession();
		//查库存，到街道
		String urlstock = "http://mobiletest.ehaier.com:58082/mobile/item/checkStock.html?sku=AB2JD1007&regionId=12036611&prodId=5031";
		String username = "13313313313";// 登录用户
		String password = "222222";// 登录密码
		 
		        // 需要提交登录的信息
		String urlLogin = "http://mobiletest.ehaier.com:58082/mobile/member/memberLogin.html";
		 
		        // 登录成功后想要访问的页面 
		String urlAfter = "http://mobiletest.ehaier.com:58082/mobile/item/buyImmediatelyNew.html?numbers=1&productIds=5031&flag=0";
		 
		DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
		 
		        /**
		         * 第一次请求登录页面 获得cookie
		         * 相当于在登录页面点击登录，此处在URL中 构造参数，
		         * 如果参数列表相当多的话可以使用HttpClient的方式构造参数
		         * 此处不赘述
		         */
		List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
		param.add(new BasicNameValuePair("username","13313313313"));
		param.add(new BasicNameValuePair("password","222222"));
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(param,"UTF-8");
		  
		HttpPost post = new HttpPost(urlLogin);
		post.setEntity(uefEntity);
		HttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		if (entity!=null){
		   System.out.println("status_code:"+response.getStatusLine());
		   System.out.println("content:"+EntityUtils.toString(entity));
		  }
		 CookieStore cookieStore = client.getCookieStore();
		 List<Cookie> cookies = cookieStore.getCookies();
		 for(Cookie c : cookies){
		         System.out.println(c);
		         }
		 client.setCookieStore(cookieStore);
		 
		        /**
		         * 带着登录过的cookie请求下一个页面，可以是需要登录
		         * 
		         */
		  HttpGet get = new HttpGet(urlAfter);
		  response = client.execute(get);
		  entity = response.getEntity();
		  //if (entity!=null){
			  
		  //    System.out.println("status_code:"+response.getStatusLine());
		  //    System.out.println("content:"+EntityUtils.toString(entity));
		  //}
		  
		  
		  
		  HttpGet get1 = new HttpGet(url1);
		  response = client.execute(get1);
		  entity = response.getEntity();
          if (entity!=null){
			  
		      System.out.println("status_code:"+response.getStatusLine());
		      System.out.println("content:"+EntityUtils.toString(entity));
		  }
          
          
          HttpGet get2 = new HttpGet(urlstock);
          response = client.execute(get2);
          entity = response.getEntity();
          if (entity!=null){
			  
		      System.out.println("status_code:"+response.getStatusLine());
		      System.out.println("content:"+EntityUtils.toString(entity));
		  }
		 }

}
