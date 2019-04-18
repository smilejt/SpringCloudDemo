/**
 * @FileName: WebAdminFeignFallbackProvider.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @createDate: 2019/4/17 21:44
 * @author: LY
 * @Description: 路由失败回调配置
 */
@Component
public class WebAdminFeignFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        // ServiceId，如果需要所有调用都支持回退，则 return "*" 或 return null
//        return "SpringCloudWebAdminFeign";//return具体的ID时,只有访问这个ID出错才会调用错误处理
        return "*";
    }

    /**
     * zuul网关对调用错误返回处理
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 网关向 api 服务请求失败了，但是浏览器向服务器网关发起的请求是成功的，
             * 不应该把 api 的 404,500 等问题抛给浏览器
             * 网关和 api 服务集群对于浏览器来说是黑盒
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> map = new HashMap<>();
                map.put("status", 200);
                map.put("message", "请求无法连接,请稍后再试!");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                // 和 getBody 中的内容编码一致
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
