package cn.eskyzdt.modules.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

@RestController
@RequestMapping("/oss")
public class OssController {

    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.appKeyId}")
    private String accessKeyId;
    @Value("${oss.appKeySecret}")
    private String accessKeySecret;
    @Value("${oss.bucketName}")
    private String bucketName;

/*    public CloudStorageConfig getAliyunConfig() {
        CloudStorageConfig cloudStorageConfig = new CloudStorageConfig();
        cloudStorageConfig.setAliyunAccessKeyId(accessKeyId);
        cloudStorageConfig.setAliyunAccessKeySecret(accessKeySecret);
        cloudStorageConfig.setAliyunBucketName(bucketName);
        cloudStorageConfig.setAliyunEndPoint(endpoint);
        return cloudStorageConfig;
    }*/

    @RequestMapping("/upload")
    public R uploadToAliyun(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = IdWorker.get32UUID();
            //写入ObjectOutputStream
            FileOutputStream fileOut = new FileOutputStream(fileName);

            fileOut.write(file.getBytes());
            //转换为FileInputStream
            FileInputStream fileInputStream = new FileInputStream(fileName);
            //创建OSSClient
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            ossClient.putObject(bucketName, "dev/fileName", fileInputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            //关闭各种流
            fileOut.close();
            fileOut.close();
            fileInputStream.close();
            return R.ok("okk");
        } catch (IOException e) {
            return R.failed("上传文件发生错误,请重试");
        }
    }
}
