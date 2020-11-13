package com.articles.controller

import com.articles.model.Article
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import java.net.URI


@SpringBootTest(webEnvironment = RANDOM_PORT)
class ArticleControllerTest(@LocalServerPort val port: Int, @Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Test to create a new articles`() {
        val baseUrl = "http://localhost:$port/api/articles"
        val uri = URI(baseUrl)
        val article = Article(1001, "Mock Title", "Mock Content")
        val headers = HttpHeaders()
        headers.set("X-COM-PERSIST", "true")
        val request: HttpEntity<Article> = HttpEntity(article, headers)
        val result: ResponseEntity<String> = this.restTemplate.postForEntity(uri, request, String::class.java)
        assertThat(result.statusCodeValue).isEqualTo(200)
    }

}
