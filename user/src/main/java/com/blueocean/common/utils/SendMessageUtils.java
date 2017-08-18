package com.blueocean.common.utils;


import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.impl.Transparent.Notification;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

public class SendMessageUtils {
	private static String appId = "vXUTjolEk68TA0WyVwCDx4";
	private static String appKey = "RVLpMBarYr6Hq2CCwcTiX3";
	private static String masterSecret = "ywHQklvhtV5OkP3ZywGOlA";
	private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

	public static void send(String cid, String title, String test) {
		IGtPush push = new IGtPush(url, appKey, masterSecret);
		//LinkTemplate template = linkTemplateDemo(title, test);
		NotificationTemplate template=notificationTemplateDemo(title, test);
		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		// 离线有效时间，单位为毫秒，可选
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setData(template);
		// 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
		message.setPushNetWorkType(0);
		Target target = new Target();
		target.setAppId(appId);
		target.setClientId(cid);
		IPushResult ret = null;
		try {
			ret = push.pushMessageToSingle(message, target);
		} catch (RequestException e) {
			e.printStackTrace();
			ret = push.pushMessageToSingle(message, target, e.getRequestId());
		}
		if (ret != null) {
			System.out.println(ret.getResponse().toString());
		} else {
			System.out.println("服务器响应异常");
		}
	}

	public static LinkTemplate linkTemplateDemo(String title, String test) {
		LinkTemplate template = new LinkTemplate(); // 设置APPID与APPKEY
		template.setAppId(appId);
		template.setAppkey(appKey);
		Style0 style = new Style0(); // 设置通知栏标题与内容
		style.setTitle(title);
		style.setText(test); // 配置通知栏图标
		// style.setLogo("icon.png"); // 配置通知栏网络图标
		// style.setLogoUrl(""); // 设置通知是否响铃，震动，或者可清除
		style.setRing(true);
		style.setVibrate(true);
		style.setClearable(true);
		template.setStyle(style); 
		// 设置打开的网址地址
		template.setUrl("http://www.baidu.com");
		return template;
	}	
	public static NotificationTemplate notificationTemplateDemo(String title, String test) {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(1);
        template.setTransmissionContent("打开应用立即启动");
        // 设置定时展示时间
        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(test);
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);

        return template;
    }
	
}
