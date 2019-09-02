package com.xiupeilian.carpart.util;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.aspectj.weaver.ast.Test;

public class SmsAli {

	public static void main(String[] args) {
		DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIKC6khyg2pq7h", "plWMJ1W5S0qONHsQkbmyO3Z8yNl3SB");
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("QuerySendDetails");
		request.putQueryParameter("RegionId", "default");
		request.putQueryParameter("PhoneNumber", "18738534316");
		request.putQueryParameter("SendDate", "20190826");
		request.putQueryParameter("PageSize", "1");
		request.putQueryParameter("CurrentPage", "1");
		try {
			CommonResponse response = client.getCommonResponse(request);
			System.out.println(response.getData());

			String personstr = response.getData();
			JSONObject Obj = JSONObject.parseObject(personstr);
			System.out.println(Obj.getString("SmsSendDetailDTO"));
			System.out.println(Obj.getString("Code"));

		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}



}
