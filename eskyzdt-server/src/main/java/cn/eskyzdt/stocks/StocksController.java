package cn.eskyzdt.stocks;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dongtian.zhang
 * @since 6/4/2021
 */
public class StocksController {

    public static void main(String[] args) {
        try {

            get();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static final String now = LocalDate.now().toString();

    public static void get() throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("money.finance.sina.com.cn")
                .setPath("/quotes_service/api/json_v2.php/CN_MarketData.getKLineData")
                // 名称
                .addParameter("symbol", "sz300122")
                // 多少分钟 可选 30, 15
                .addParameter("scale", "15")
                .addParameter("ma", "5")
                // 几组数据
                .addParameter("datalen", "30");

        URI uri = uriBuilder.build();
        URI uri2 = uriBuilder.addParameter("symbol", "sh601985").build();
        exe(uri);
        exe(uri2);
    }

    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();

    /**
     * 打印结果
     * @param uri
     */
    private static void exe(URI uri) {
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            response = HTTP_CLIENT.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity httpEntity = response.getEntity();
        try {
//            long contentLength = httpEntity.getContentLength();
//            Header contentType = httpEntity.getContentType();
//            Header contentEncoding = httpEntity.getContentEncoding();
//            InputStream content = httpEntity.getContent();
//            Object jsonObject = JSONObject.parse(strResult);

            String strResult = EntityUtils.toString(httpEntity);

            List<SinaRes> jsonArray = JSONObject.parseArray(strResult, SinaRes.class);
            jsonArray.forEach(var -> {
            });
            // 过滤今天的数据
            List<SinaRes> array = jsonArray.stream().filter(var -> {
                return var.getDay().startsWith(now);
            }).collect(Collectors.toList());

            array.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=========================================================================");
    }
}
