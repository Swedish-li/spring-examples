package com.lrs.common.service;

import com.lrs.common.pojo.HttpResult;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HttpService {

	@Autowired
	private CloseableHttpClient httpClient;

	@Autowired
	private RequestConfig requestConfig;

	/**
	 * 指定GET请求
	 * 
	 * @param url
	 * @return 如果请求成功，返回具体内容，如果失败，返回null
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String doGet(String url) throws IOException {
		// 创建http GET请求
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
			// 执行请求
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
			return null;
		}
	}

	/**
	 * 带有参数的GET请求
	 *
	 */
	public String doGet(String url, Map<String, Object> params) throws IOException,
			URISyntaxException {
		// 定义请求的参数
		URIBuilder builder = new URIBuilder(url);
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			builder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
		}
		return this.doGet(builder.build().toString());
	}

	/**
	 * 执行不带参数的POST请求
	 *
	 */
	public HttpResult doPost(String url) throws IOException {
		return this.doPost(url, null);
	}

	/**
	 * 执行POST请求
	 * 
	 * @param url
	 * @param params
	 */
	public HttpResult doPost(String url, Map<String, Object> params) throws
            IOException {
		// 创建http POST请求
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		if (null != params) {
			// 设置post参数
			List<NameValuePair> parameters = new ArrayList<>(0);
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (null == entry.getValue()) {
					// 忽略该参数
					continue;
				}
				parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
			}

			// 构造一个form表单式的实体
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
			// 将请求实体设置到httpPost对象中
			httpPost.setEntity(formEntity);
		}
		try (CloseableHttpResponse response = this.httpClient.execute(httpPost)) {
			// 执行请求
			HttpResult httpResult = new HttpResult();
			httpResult.setCode(response.getStatusLine().getStatusCode());
			if (response.getEntity() != null) {
				// 如果响应中有内容就设置到HttpResult，无需考虑状态码
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				httpResult.setData(content);
			}
			return httpResult;
		}
	}

}
