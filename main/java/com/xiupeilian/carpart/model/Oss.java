package com.xiupeilian.carpart.model;

public class Oss {


	private  String endpoint = "oss-cn-shanghai.aliyuncs.com";;



	private  String accessKeyId= "LTAIKC6khyg2pq7h";;

	private  String accessKeySecret= "plWMJ1W5S0qONHsQkbmyO3Z8yNl3SB";;

	private  String bucketName= "xiupeilian";;

	//ÎÄ¼þ´æ´¢Ä¿Â¼
	private  String filedir = "images/";

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getFiledir() {
		return filedir;
	}

	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}
}
