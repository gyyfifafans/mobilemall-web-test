package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.opera.core.systems.scope.protos.HttpLoggerProtos.Header;

import test.testSession;

/* 
1. 创建HttpClient对象。
2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。
3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。
4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。
5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。
6. 释放连接。无论执行方法是否成功，都必须释放连接
 * 
 * */
//重新构造工具类

public class HttpRes {
	private HttpGet Hget; 
	private HttpPost Hpost;
	private DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
	private CloseableHttpResponse respons;
	private HttpEntity entity;
	
	public HttpRes(String url){
		Hget = new HttpGet(url);
		Hpost  = new HttpPost(url);
		
	}
	public CloseableHttpResponse get() throws IOException{
		try {
			respons = client.execute(Hget);
			entity = respons.getEntity();
			if (entity!=null){
				System.out.println("status_code:"+respons.getStatusLine());
				System.out.println("content:"+EntityUtils.toString(entity));
				return respons;
			}
			respons.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
		return null;
		
	}
	
	public CloseableHttpResponse get(CookieStore cookiestore) throws IOException{
		try {
			client.setCookieStore(cookiestore);
			respons = client.execute(Hget);
			entity = respons.getEntity();
			if (entity!=null){
				System.out.println("status_code:"+respons.getStatusLine());
				System.out.println("content:"+EntityUtils.toString(entity));
				return respons;
			}
			respons.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
		
		return null;
	}
	
	

	//BasicNameValuePair存储键值对类
	public CloseableHttpResponse post(List<BasicNameValuePair> param) throws IOException{
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(param,"UTF-8");
			Hpost.setEntity(uefEntity);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			respons = client.execute(Hpost);
			entity = respons.getEntity();
			if (entity!=null){
				System.out.println("status_code:"+respons.getStatusLine());
				System.out.println("content:"+EntityUtils.toString(entity));
				return respons;
			}
			respons.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
		return null;
	}
	
	
	public CloseableHttpResponse post(List<BasicNameValuePair> param,CookieStore cookiestore) throws IOException{
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(param,"UTF-8");
			Hpost.setEntity(uefEntity);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			client.setCookieStore(cookiestore);
			respons = client.execute(Hpost);
			entity = respons.getEntity();
			if (entity!=null){
				System.out.println("status_code:"+respons.getStatusLine());
				System.out.println("content:"+EntityUtils.toString(entity));
				return respons;
			}
			respons.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
		return null;
	}
	
	public CookieStore getcookie(){
		return client.getCookieStore();
	}
	
	public static void main(String[]args) throws IOException{
		
		List<BasicNameValuePair> formparam = new ArrayList<BasicNameValuePair>();
		formparam.add(new BasicNameValuePair("username","13313313313"));
		formparam.add(new BasicNameValuePair("password","222222"));
		String loginurl = "http://mobiletest.ehaier.com:58082/mobile/member/memberLogin.html";
		String url = "http://mobiletest.ehaier.com:58082/mobile/item/buyImmediatelyNew.html?numbers=1&productIds=5031&flag=0";
		String url1 = "http://mobiletest.ehaier.com:58082/mobile/order/orderSubmitM.html?paytype=online&invoiceType=2&region=3091&billCompany=gggg&=0&=0&remark=";
		//查库存，到街道
		String urlstock = "http://mobiletest.ehaier.com:58082/mobile/item/checkStock.html?sku=AB2JD1007&regionId=12036611&prodId=5031";
		HttpRes test = new HttpRes(loginurl);
		test.post(formparam);
		CookieStore cookiestore = test.getcookie();
		
		HttpRes test1 = new HttpRes(url);
		test1.get(cookiestore);
		
		
	}
}
