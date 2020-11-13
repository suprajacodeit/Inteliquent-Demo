package com.articles.controller

import com.articles.client.IpResult
import com.articles.model.Article
import com.articles.service.ArticleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class ArticleController(private val articleService: ArticleService) {

    /**
     * This controller will retrieve all the articles from the database
     */
    @GetMapping("/articles")
    fun getAllArticles(): List<Article> = articleService.getAllArticles()

    /**
     * This controller will create a new article.
     */
    @PostMapping("/articles")
    fun createNewArticle(@Valid @RequestBody article: Article): Article = articleService.createNewArticle(article)

    /**
     * This controller will retrieve specific article base on the Id value.
     */
    @GetMapping("/articles/{id}")
    fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> = articleService.getArticleById(articleId)

    /**
     * This controller will retrieve all the articles based on the 'Title' name provided as a query parameter
     */
    @GetMapping("/articles/")
    fun getAllArticleByTitle(@RequestParam(value = "title") title: String): List<Article> = articleService.getAllArticlesByTitle(title)

    /**
     * This controller will updated the specific record in the Articles Table.
     */
    @PutMapping("/articles/{id}")
    fun updateArticleById(@PathVariable(value = "id") articleId: Long, @Valid @RequestBody newArticle: Article): ResponseEntity<Article> =
            articleService.updateArticleById(articleId, newArticle)

    /**
     * This controller will delete a specific record from the Article Table.
     */
    @DeleteMapping("/articles/{id}")
    fun deleteArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Void> = articleService.deleteArticleById(articleId);

    /**
     * This controller is an example implementation of feign client.
     */
    @GetMapping("/feign/client")
    fun getIpAddress(): IpResult = articleService.getIpAddress()
}