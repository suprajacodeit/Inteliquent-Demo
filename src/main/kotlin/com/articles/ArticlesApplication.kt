package com.articles

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients
class ArticlesApplication

fun main(args: Array<String>) {
    runApplication<ArticlesApplication>(*args)
}


