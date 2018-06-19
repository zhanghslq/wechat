package com.yb.util;

import java.io.IOException;

import com.yb.entity.RequestTempData;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;

import com.alibaba.fastjson.JSON;
import com.yb.entity.AccessToken;
import org.apache.http.entity.StringEntity;

public class AccessTokenUtil {
	public static AccessToken freshAccessToken() {
			AccessToken parseObject;
			String asString;
			try {
				asString = Request.Get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd8e55b753a567d41&secret=fd365e71704a8f1e8bc28f0f3f532314")
						.execute().returnContent().asString();
				parseObject = JSON.parseObject(asString, AccessToken.class);
				return parseObject;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("获取access_token异常");
		}
	}
	public static void main(String[] args) {
		//AccessToken freshAccessToken = freshAccessToken();
		//freshAccessTokenSystem.out.println(freshAccessToken);
		/*String id = getId();
		System.out.println(id);*/
		String id = getId();
		System.out.println(id);
	}
	//获取模板列表
	public static String getId(){
		RequestTempData requestTempData = new RequestTempData(0, 20);
		String s = JSON.toJSONString(requestTempData);
		HttpEntity entity = new StringEntity(s, "UTF-8");
		String asString ;
		//String token="10_lGEp5MtPcQoFM2Zk40nj3oENpfS-CFV1ww-Jbmcf0w5HvEqDAullx5XRXy0gZC0BFpmhPGjyWS0hjngpMnZk7kCYHBKjAQ0P1c_ydRGNVo6OAFCYJYzrGcdBA6SWe2uD18avIuUqzirY5UYTMXMaAJAITI";
		// String token="10_pvmb3ce3JrBqmmGL40nj3oENpfS-CFV1ww-Jbmcf0w5HvEqDAullx5XRXy1tDoE2bQZ9dagDJPUnHtpn4rx2adwXBL_9XB_KapW3BvWTyq2U4SqNb8d09qA3sB5ytfltcQ9UxigNIq7j5asKYLJaAJAUHF";
		//String token="10_vwcvQerPzTSC_bui40nj3oENpfS-CFV1ww-Jbmcf0w5HvEqDAullx5XRXy1tl90sFnItKn_5a4R8inoLHAzfDGdem2QqadNYoPIxqAK2UkUVypbgVrc5W3MXt9N3zl2S4PQqk0bThCJZ0LJlHZEaAJACUZ";
		//String token="10_LN74hHsn-fCdp70Q40nj3oENpfS-CFV1ww-Jbmcf0w5HvEqDAullx5XRXy0tDs5YpjMj9Y5OIxydU0TTQ2vyC0y1YuBV4n6mZATAiAT94Ee0_PqdOliOIKZKO6we4ldxPzdi_JR92WkM-0M3WCIaAJAMSY";
		//String token="10_8QuJXKtj9z8d3e5_40nj3oENpfS-CFV1ww-Jbmcf0w5HvEqDAullx5XRXy1Ui8yOkIPpdfxuY6yjxWPnojMcFTf8TatuVxM-aDxP8YN4IMdURh6VukwAy-6RWh7CLnLX1WyPGjqEHzqgsbMiNFEaAJAUML";
		String token="10__3gxt5_MihDhfGyvc_o7AXuSrcxD3FhbUziIQddX1RW3Uykuuu2gu9_UPhz9fAk3D_hGEpQ4tTZL0uOISg6R_Z-Le7bhEOqHEMO7sfRafjghs53630yvYYeD-QcAVHjAEAWRD";
		try {
			asString = Request.Post("https://api.weixin.qq.com/cgi-bin/wxopen/template/library/list?access_token="+token)
                    .body(entity).execute().returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
			return  "一场";
		}
		return asString;
	}
}
