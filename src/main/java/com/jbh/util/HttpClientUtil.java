package com.jbh.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtil {

	public static String post(String url, Map params, String encoding) {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpPost post = new HttpPost(url);
			List<NameValuePair> paramlist = convertParam(params);
			ResponseHandler<String> rh = new BasicResponseHandler();
			
			return client.execute(post, rh);
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}finally {
			client.getConnectionManager().shutdown();
		}
	}
	
	public static String post(String url, Map params) {
		return post(url, params, "UTF-8");
	}
	
	
	public static String get(String url, Map params, String encoding) {
		HttpClient client = new DefaultHttpClient();
		try {
			List<NameValuePair> paramlist = convertParam(params);
			HttpGet get = new HttpGet(url+"?"+URLEncodedUtils.format(paramlist, encoding));
			ResponseHandler<String> rh = new BasicResponseHandler();
			return client.execute(get, rh);
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}finally {
			client.getConnectionManager().shutdown();
		}
	}
	
	public static String get(String url, Map params) {
		return get(url, params, "UTF-8");
	}
	
	public static String get(String url, String encoding) {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpGet get = new HttpGet(url);
			ResponseHandler<String> rh = new BasicResponseHandler();
			return client.execute(get, rh);
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}finally {
			client.getConnectionManager().shutdown();
		}
	}
	public static String get(String url) {
		return get(url, "UTF-8");
	}
	

	private static List<NameValuePair> convertParam(Map params) {
		List<NameValuePair> paramlist = new ArrayList<>();
		Iterator<String> keys = params.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			paramlist.add(new BasicNameValuePair(key, params.get(key).toString()));
		}
		return paramlist;
	}
	
	public static String getIp(HttpServletRequest request) {
		 
        String ip = request.getHeader("X-Forwarded-For");
 
        System.out.println(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            System.out.println(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        System.out.println(">>>> Result : IP Address : "+ip);
 
        return ip;
    }
}
