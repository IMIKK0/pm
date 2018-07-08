package com.pm.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class MobileAuthentication {  
	private int random; 
    public  void SendCode(String PhoneNumbers) throws Exception{   	
       // ���ó�ʱʱ��-�����е���  
       System.setProperty("sun.net.client.defaultConnectTimeout", "10000");  
       System.setProperty("sun.net.client.defaultReadTimeout", "10000");  
       // ��ʼ��ascClient��Ҫ�ļ�������  
       final String product = "Dysmsapi";// ����API��Ʒ���ƣ����Ų�Ʒ���̶��������޸ģ�  
       final String domain = "dysmsapi.aliyuncs.com";// ����API��Ʒ�������ӿڵ�ַ�̶��������޸ģ�  
       // �滻�����AK  
       final String accessKeyId = "wads";// ���accessKeyId LTAI8eNHHJgPtOC7 
       final String accessKeySecret = "1ozAWfh2PJ1NYYrfrNT5rgEuvYEjtq";// ���accessKeySecret  
       // ��ʼ��ascClient,��ʱ��֧�ֶ�region  
       IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId, accessKeySecret);  
       DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,  
               domain);  
       IAcsClient acsClient = new DefaultAcsClient(profile);  
       // ��װ�������  
       SendSmsRequest request = new SendSmsRequest();  
       // ʹ��post�ύ  
       request.setMethod(MethodType.POST);  
       // ����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ1000���ֻ�����,������������ڵ������ü�ʱ   �������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ  
       request.setPhoneNumbers(PhoneNumbers);  
       // ����:����ǩ��-���ڶ��ſ���̨���ҵ�  
       request.setSignName("��־��");  
       // ����:����ģ��-���ڶ��ſ���̨���ҵ�  
       request.setTemplateCode("SMS_135860001");  
       //request.setTemplateCode("SMS_116580423");  
       // ��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ  
       // ������ʾ:���JSON����Ҫ�����з�,����ձ�׼��JSONЭ��Ի��з���Ҫ��,������������а���\r\n�������JSON����Ҫ��ʾ��\\r\\n,����ᵼ��JSON�ڷ���˽���ʧ��  
       //�������һ����λ��������֤��  
       
       random = (int) ((Math.random()*9+1)*100000); 
       System.out.println(random);
       //System.out.println(random+"00000");
       request.setTemplateParam("{\"code\":\"" + random + "\"}");  
       // ��ѡ-���ж�����չ��(�����������û�����Դ��ֶ�)  
       // request.setSmsUpExtendCode("90997");  
       // ��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������  
        request.setOutId("yourOutId");  
       //����ʧ���������ClientException�쳣  
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);  
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {  
        //����ɹ�  
           System.out.println(sendSmsResponse.getMessage());  
        }  
    }  
	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	
    
}  