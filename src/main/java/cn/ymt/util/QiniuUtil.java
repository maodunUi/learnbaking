package cn.ymt.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

public class QiniuUtil {

	// 在七牛注册后获得的accessKey和secretKey（改为自己的）
	//private static String accessKey = "Bv6YMexamG1xyMcos8sHjhWE6MwyBGbWMfeotjFu";
	private static String accessKey = "UqcPMKw3HJ9lUaOqAifkFmyFif9oMueprmGQvvAP" ; //自己的
	//private static String secretKey = "oDMUveZbL1lEOeZZ5lWbPgfL9FFPFLWptj-cQVxU";
	private static String secretKey = "iiUQh9kALRTVSACT59KBdodaFxrdHTi56BTgjQXd" ;
	private static String bucket = "mall"; // 七牛空间名（改为自己的）

	// 获取覆盖同名文件的上传凭证
	public static String getToken(String key) {
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket, key, 3600, null, true); // 生成覆盖相同key文件的上传Token
		return upToken;
	}

	// 删除七牛中指定key的文件
	public static void delFile(String key) throws QiniuException {
		// 构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		Auth auth = Auth.create(accessKey, secretKey);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		bucketManager.delete(bucket, key);
	}

}
