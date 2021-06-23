package com.liu.cloud.controller;

import com.liu.cloud.domain.CommonResult;
import com.liu.cloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.JarURLConnection;
import java.util.List;

/**
 * @author lms
 * @date 2021-06-20 - 3:42
 */

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    // 实现微服务之间的远程调用
    @Resource
    private RestTemplate restTemplate;

    // 使用单一的生产者的方式
    // private static final String url = "http://localhost:8001";

    // 使用具体的微服务名称
    private static final String url = "http://springcloud-payment-service";

    @GetMapping("payment/create")
    public CommonResult create(Payment payment) {
        // 写操作，使用的是post请求的方式
        // 当前传到微服务中的是json形式的数据信息，无法直接转为对应的Payment对象，
        // 所以需要添加@RequestBody注解转为相应的对象
        return restTemplate.postForObject(url + "/payment/create", payment,
                CommonResult.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        // 读操作
        return restTemplate.getForObject(url + "/payment/get/" + id,
                CommonResult.class);
    }

    @GetMapping("payment/list")
    public CommonResult<List> getAll() {
        return restTemplate.getForObject(url + "/payment/list", CommonResult.class);
    }


    @GetMapping("payment/discovery")
    public CommonResult<Object> discovery(){
        return restTemplate.getForObject(url + "/payment/discovery", CommonResult.class);
    }

    @GetMapping("payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(url + "/payment/get/" + id,
                CommonResult.class);
        // is2xxSuccessful:表示查询返回的是code如果是2开头，代表成功
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(444, "操作失败");
        }
    }


}
