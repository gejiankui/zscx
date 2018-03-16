package com.xt.weixinapi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * @author qinlei
 * @version v1.0
 * @category 微信工具类（https）
 */
public class CertificateUtil {
	private static Logger log = Logger.getLogger(CertificateUtil.class);

	/**
	 * 发起https请求并获取结果
	 *
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */

	public static String httpRequest(String requestUrl, String requestMethod,
			String outputStr) {
		StringBuffer buffer = null;

		try {
			buffer = new StringBuffer();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			// httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("POST".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
		} catch (MalformedURLException e) {
			log.error("requestUrl is wrong ");
			e.printStackTrace();
		} catch (ProtocolException e) {
			log.error("ProtocolException ");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			log.error("UnsupportedEncodingException ");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("UnsupportedEncodingException ");
			e.printStackTrace();
		}

		return buffer.toString();
	}

	public String httpRequest2(String requestUrl, String ip) {
		HttpClient httpClient = new DefaultHttpClient();

		// get method
		HttpGet httpGet = new HttpGet(requestUrl);

		// set header
		httpGet.setHeader("X-Forwarded-For", ip);

		//response
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//get response into String
		String temp = "";
		try {
			HttpEntity entity = response.getEntity();
			temp = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public int r(Integer min, Integer max) {
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}

	public String getRandomIp() {
		//ip地址随机的过分，大概率都是在国外
		return r(1, 255) + "." + r(1, 255) + "." + r(1, 255) + "." + r(1, 255);
	}

	private void doIt() {
		String url = "http://www.gzjiahewangluo.top/Home/index.php?m=Index&a=vote&vid=5320&id=76&tp=";
		CertificateUtil u = new CertificateUtil();
		List<String[]> ipPool = getIpPool();
		for (int i = 0; i < 10000; i++) {
			int index = r(0, 19);
			String[] ipRange = ipPool.get(index);
			String ip = u.ipGenerator(ipRange[0], ipRange[1]);
			System.out.println("模拟请求ip：" + ip);
			u.httpRequest2(url, ip);
			Integer milis = u.r(1, 1);
//			try {
				System.out.println("休眠：" + milis + "毫秒");
//				Thread.sleep(milis);
//			} catch (InterruptedException e) {
////				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) {

		CertificateUtil u = new CertificateUtil();
		u.doIt();
	}

	private List<String[]> getIpPool() {
		//蚌埠地区ip池
		List<String[]> ipPool = new ArrayList<String[]>();
		String[] p2 = new String[] { "58.242.160.1", "58.242.175.255" };
		String[] p3 = new String[] { "60.170.0.0", "60.170.255.255" };
		String[] p4 = new String[] { "61.132.140.0", "61.132.140.255" };
		String[] p7 = new String[] { "61.190.112.0", "61.190.127.255" };
		String[] p8 = new String[] { "61.191.184.0", "61.191.186.170" };
		String[] p9 = new String[] { "61.191.186.171", "61.191.191.255" };
		String[] p10 = new String[] { "61.241.138.0", "61.241.138.255" };
		String[] p11 = new String[] { "112.122.80.0", "112.122.95.255" };
		String[] p12 = new String[] { "112.123.80.0", "112.123.95.255" };
		String[] p13 = new String[] { "117.65.0.0", "117.65.66.255" };
		String[] p14 = new String[] { "117.65.68.0", "117.65.78.255" };
		String[] p15 = new String[] { "117.65.80.0", "117.65.121.255" };
		String[] p16 = new String[] { "117.65.123.0", "117.65.127.255" };
		String[] p17 = new String[] { "183.163.64.186", "183.163.127.255" };
		String[] p18 = new String[] { "202.102.196.0", "202.102.196.255" };
		String[] p19 = new String[] { "202.102.200.0", "202.102.200.255" };
		String[] p21 = new String[] { "211.91.104.0", "211.91.107.255" };
		String[] p22 = new String[] { "218.22.88.0", "218.22.111.255" };
		String[] p23 = new String[] { "218.23.128.0", "218.23.143.255" };
		String[] p24 = new String[] { "220.178.128.0", "220.178.159.255" };
		ipPool.add(p2);
		ipPool.add(p3);
		ipPool.add(p4);
		ipPool.add(p7);
		ipPool.add(p8);
		ipPool.add(p9);
		ipPool.add(p10);
		ipPool.add(p11);
		ipPool.add(p12);
		ipPool.add(p13);
		ipPool.add(p14);
		ipPool.add(p15);
		ipPool.add(p16);
		ipPool.add(p17);
		ipPool.add(p18);
		ipPool.add(p19);
		ipPool.add(p21);
		ipPool.add(p22);
		ipPool.add(p23);
		ipPool.add(p24);
		return ipPool;
	}

	private String ipGenerator(String bip, String eip) {
		String[] bipArray = bip.split("\\.");
		String[] eipArray = eip.split("\\.");
		int bsum = Integer.parseInt(bipArray[1]) * 256 * 256
				+ Integer.parseInt(bipArray[2]) * 256 + Integer.parseInt(bipArray[3]);
		int esum = Integer.parseInt(eipArray[1]) * 256 * 256
				+ Integer.parseInt(eipArray[2]) * 256 + Integer.parseInt(eipArray[3]);
		int sum = new Random().nextInt(esum - bsum) + bsum;

		int d = sum % 256;
		int c = (sum % (256 * 256) - d) / 256;
		int b = (sum % (256 * 256 * 256) - d - c * 256) / (256 * 256);
		//		int a = sum / (256 * 256 * 256);
		String ip = bipArray[0] + "." + b + "." + c + "." + d;
		System.out.println("生成的IP：" + ip);
		return ip;
	}
}
