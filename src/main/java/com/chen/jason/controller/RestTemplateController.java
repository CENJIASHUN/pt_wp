package com.chen.jason.controller;

import com.chen.jason.model.UserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created on 2019/9/25. By CenJS
 */
@Api(tags = "【RestTemplate】")
@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {

    //    public static void main(String[] args) {
    @ApiOperation(value = "restTemplate1")
    @PostMapping("/restTemplate1")
    @ResponseBody
    public void restTemplate1(){


        //GET
        /*
        String url = "http://localhost:9996/UserDetails/userLogin?account=000000000&password=2813";
        //方式一： 构建请求实体 HttpEntity 对象，用于配置 Header 信息和请求参数
        RestTemplate restTemplate = new RestTemplate();
        LinkedMultiValueMap header = new LinkedMultiValueMap<>();
        header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Object> requestEntity = new HttpEntity<>(header);
        //方式二： 执行请求获取包含 UserDetails 实体对象 的响应实体 ResponseEntity 对象,用 getBody() 获取
        ResponseEntity<UserDetails> exchangeResult = restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserDetails.class);
        System.out.println("get_UserDetails返回结果：" + exchangeResult);
        //方式三： 根据 RequestCallback 接口实现类设置Header信息,用 ResponseExtractor 接口实现类读取响应数据
        String executeResult = restTemplate.execute(url, HttpMethod.GET, request -> {
            request.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        }, (clientHttpResponse) -> {
            InputStream body = clientHttpResponse.getBody();
            byte[] bytes = new byte[body.available()];
            body.read(bytes);
            return new String(bytes);
        }); // 备注：这里使用了 Java8 特性：Lambda 表达式语法，若未接触 Lambda 表达式后可以使用匿名内部类代替实现
        System.out.println("get_product1返回结果：" + executeResult);
        */
        /*
        String url = "http://localhost:9996/UserDetails/userLogin?account={account}&password={password}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDetails> responseEntity = restTemplate.getForEntity(url,UserDetails.class,"000000001","2813");
        System.out.println(responseEntity);
        */

        //POST
        /*
        //发送Content-Type为application/x-www-form-urlencoded的POST请求
        String url = "http://localhost:9996/UserDetails/selectUserById";
        RestTemplate restTemplate = new RestTemplate();
        UserDetails product = new UserDetails();
        product.setId(1);
        // 设置请求的 Content-Type 为 application/x-www-form-urlencoded
        LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap();
        header.add(HttpHeaders.CONTENT_TYPE, (MediaType.APPLICATION_FORM_URLENCODED_VALUE));
        //方式二： 将请求参数值以 K=V 方式用 & 拼接，发送请求使用
        String productStr = "id=" + product.getId();
        HttpEntity<String> request = new HttpEntity<>(productStr, header);
        ResponseEntity<String> exchangeResult = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("post_product1: " + exchangeResult);
        //方式一： 将请求参数以键值对形式存储在 MultiValueMap 集合，发送请求时使用
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("id", (product.getId()));
        HttpEntity<LinkedMultiValueMap> request2 = new HttpEntity<>(map, header);
        ResponseEntity<String> exchangeResult2 = restTemplate.exchange(url, HttpMethod.POST, request2, String.class);
        System.out.println("post_product1： " + exchangeResult2);
        */
        //发送Content-Type为application/json的POST请求
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9996/UserDetails/selectUserById";
        // 设置请求的 Content-Type 为 application/json
        LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap();
        header.put(HttpHeaders.CONTENT_TYPE, Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        // 设置 Accept 向服务器表明客户端可处理的内容类型
        header.put(HttpHeaders.ACCEPT, Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        // 直接将实体 Product 作为请求参数传入，底层利用 Jackson 框架序列化成 JSON 串发送请求
        UserDetails product = new UserDetails();
        product.setId(1);
        HttpEntity<UserDetails> request = new HttpEntity<>(product, header);
        ResponseEntity<String> exchangeResult = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("post_product2: " + exchangeResult);
    }

}
