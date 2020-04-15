package cn.eskyzdt.modules.aliyun;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

/**
 * <p>
 * 阿里云服务 实现类
 * </p>
 *
 * @author dongtian
 * @since 2019-12-11
 */
@Component
// @Service
public class AliyunServiceImpl/* implements AliyunService*/ {
/*
    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.appKeyId}")
    private String accessKeyId;
    @Value("${oss.appKeySecret}")
    private String accessKeySecret;
    @Value("${oss.bucketName}")
    private String bucketName;
    @Value("${oss.parentUrl}")
    private String parentUrl;

    public CloudStorageConfig getAliyunConfig() {
        CloudStorageConfig cloudStorageConfig = new CloudStorageConfig();
        cloudStorageConfig.setAliyunAccessKeyId(accessKeyId);
        cloudStorageConfig.setAliyunAccessKeySecret(accessKeySecret);
        cloudStorageConfig.setAliyunBucketName(bucketName);
        cloudStorageConfig.setAliyunEndPoint(endpoint);
        return cloudStorageConfig;
    }*/

    public String uploadToAliyun(List<?> params) {
        try {
            String fileName = IdWorker.get32UUID();
            // 创建一个放错误文件的文件夹
            String rootPath = System.getProperty("user.dir") + "/faultfile";
            File dstPath = new File(rootPath);
            dstPath.mkdir();
            // 创建文件
            File file = new File(rootPath + "/" + fileName);
            file.createNewFile();
            // 写入ObjectOutputStream
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(params);
            // 转换为FileInputStream
            FileInputStream fileInputStream = new FileInputStream(file);
            // 创建OSSClient
       //     OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            String relativePath = "faultfile/" + fileName;
      //      ossClient.putObject(bucketName, relativePath, fileInputStream);
            // 关闭OSSClient。
    //        ossClient.shutdown();
            // 关闭各种流
            fileOut.close();
            out.close();
            // 删除已上传的文件
            file.delete();
            fileInputStream.close();
            return null;
           // return R.ok().put("fileName", fileName);
        } catch (IOException e) {
           // return R.error("上传文件发生错误,请重试");
            return null;
        }
    }
}
