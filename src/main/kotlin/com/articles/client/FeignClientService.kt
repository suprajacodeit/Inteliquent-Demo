package com.articles.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping

/**
 * This consumes the request from the 'https://httpbin.org/' using the OpenFeign client
 */
@FeignClient(value = "httpService", url = "\${feign.httpService.url}")
interface FeignClientService {

    @RequestMapping("/ip")
    fun getIp(): IpResult
}

data class IpResult(val origin: String)