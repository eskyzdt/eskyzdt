package cn.eskyzdt.modules.picture;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.*;

import static com.aliyun.oss.common.utils.CodingUtils.assertParameterNotNull;
import static com.aliyun.oss.common.utils.IOUtils.safeClose;
import static com.aliyun.oss.common.utils.LogUtils.logException;
import static com.aliyun.oss.internal.OSSConstants.DEFAULT_BUFFER_SIZE;
import static com.aliyun.oss.internal.OSSUtils.OSS_RESOURCE_MANAGER;

/**
 * 阿里云的下载文件
 */
public class Aliyun {

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) throws OSSException, ClientException {

        assertParameterNotNull(file, "file");

        // 这里我置为null了
        OSSObject ossObject = null;

        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = ossObject.getObjectContent().read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            /*if (isCrcCheckEnabled() && !hasRangeInRequest(getObjectRequest)) {
                Long clientCRC = IOUtils.getCRCValue(ossObject.getObjectContent());
                OSSUtils.checkChecksum(clientCRC, ossObject.getServerCRC(), ossObject.getRequestId());
            }
*/
            return ossObject.getObjectMetadata();
        } catch (IOException ex) {
            logException("Cannot read object content stream: ", ex);
            throw new ClientException(OSS_RESOURCE_MANAGER.getString("CannotReadContentStream"), ex);
        } finally {
            safeClose(outputStream);
            safeClose(ossObject.getObjectContent());
        }
    }

}
