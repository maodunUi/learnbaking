package cn.ymt.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016093000633301";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRUpY6xZYig2xyjdcZvq5xbZYANNfBaOn2jcF9cPr6iz0CsU9INKLc7"
    		+ "0SvjXX6Mw0u0jOLVmdR2aeRaZLvwhX/tHTD0SB0Biaq5GdDLxgMeqdkN9Bp40RyPxqxNZigiPxmnUiQYs1Br3gW4RZW6z0CUeKf+i+br+EJAq6a6VqmZ/ZKXCxUKhllaqXkBfDhAMQ/LDNRV"
    		+ "wqz2LwsF2wcHPgDE0JZE67+oOL6/iVVLjgcLFKFm4p5zEGu8PVwSHHpV04bM1UTfKTXrJdVAE04JqWqb48Ugi0nlht/QpEvUMrZLruskyobo4vo856hhTOSjJONPGV2b9qqu2zdj5C5sqpnAg"
    		+ "MBAAECggEAT1vnWE8AbvaQKXqV5aRAxQaQLKquzBsL8S12ZZdmJ54UAj1ry0WbTsWHH8tDiw+H+nKl3UihAYy3umwJ5s55jvsv7KNuco3NXfN/BKxaGK5+bPch5EFM5orZe76GC9zi4PKxZs/d"
    		+ "wSoejXf76BlsZrDq7mwExaNlY7NIQKaAb3BxnoxzxJAdZlHF2Wl1GLeKMyuFSxDWNbWoAFX6v9kveik7/n2Dc56kUw5K0XyTTnI5ZKqFKqEf0g2kHOW39bLWf01GYqqrxfqlkOpl/fT89mffYouBx"
    		+ "lJha/+vq4LSTSh5J9dtggBLXg6d4C1NwYim2LbhAaord41YySlyRYnCsQKBgQDKq+Y/wARGrWnvpdFQga5oRCELqIAphfvQLP1aFJWBVpJJs8aT1/SdiHV6aMUR3UztaXaKWTPbXaQUFVxJ2befAym"
    		+ "4M4Ez9PkBt51HaxnsJeH4WTPZeMwfdWa4QlpotAFG+t7ARlCQD9ZwXJxZ9kKnG8fLoMBPUpbSQvEcWADj7wKBgQC3j5/ugLTl/jrkurAKkn1ve10nbSr2KYlOEI4tio1BVMfxTS+8caSrAiQVI/cueo"
    		+ "ScGm+B+a5DZv/TnD7Ga0qXDTH3HjhpCLWw0FLmfyrnZtVZfACbW395Ip8vUY8oxVfBs5Tx2F9ta+bL88HQ/9lVBJhrDMqcRwxub//gOIzJCQKBgQCRYVup0TCADncWTAjoyg10h6J4vWcp4g1vGEaobmm"
    		+ "MPLB1I/tHJDs5IaC7rRnoJanAB83bkf9L1VEUgvoPk5hO/TLZCkEdJxXTsIWmrGIM7mO5BSvXTPqHemyzsg0uXCkqZFyS6h1yKZo2QYh6U9ceDiR0ohwxClpb+17/aPVCiwKBgCTQkWrsNVvLWVR2fMgiCTZ"
    		+ "Kr6wwoOUt/3PArkND/oCT2GX07RYGVNhXXZU/2VthByenxaVzxheOmNCADbcN3a/d3Z+KWBX4wTftEDNaXeh7H18LF7QQ7cgFwZdj7CppKeiXc8/tbXYspeVRxhV8usHqYgdWUWx2c2/S1qbJsLLBAoGAFR0"
    		+ "N7+l6yiEyyACvZxXwfJ97BXEUzaip+Ibs"
    		+ "IdrwKGyvcbTkufI2uZ4HyVbczwNEG92mk1Jbqc/+P1/mbp6XNOwMf9d+//ic39MDYCa79+RRE6WD4NOB/QF+3K/T8eGUAMJZr3FqXKqJyKC7/wJ8PPLOzpYBkpu3HXcfhZmcshE=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgR5C0KpxDf/062p2vFO5fF4/1BPcm8hhkORDdnkdOtI5rnqexJ4vdLiC4if0urH65MBlJkwO27"
    		+ "IV24mOaQ6vUm6j08oV1iDzBvPkc2HQqoaUA/O+XW8Mpl/rlKbUFuZ3k/jLsKe9JqWrH5uvIJLvaGW6smooYJcXKQYWE1wD0OcPx9xTeo1qrhYpkZCfBUFyW2RRvSKXvHIOdN5YBYh+BWbIgST9S3JZNbmwGYZnzm"
    		+ "Nz9l0JjH8CnaToGxly9lo468YFanDm11r5IFXpQKwoscUZyeDGL3hxOlDfNXdDm/uQpEpkMtd0K0LLdCTY2JZQsY36ZVIBzXL1a60X49UzkwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/AliPay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String return_url = "http://localhost:8080/AliPay/return_url.jsp";
	public static String return_url = "http://127.0.0.1:8091/payApp/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	public static String FORMAT = "json";
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

