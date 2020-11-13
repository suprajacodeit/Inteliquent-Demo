package com.articles.service

import com.articles.client.FeignClientService
import com.articles.client.IpResult
import com.articles.model.Article
import com.articles.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

/**
 * This the service class which holds all the business logics
 */
@Service
class ArticleService(private val articleRepository: ArticleRepository, private val feignClientService: FeignClientService) {

    fun createNewArticle(article: Article): Article = articleRepository.save(article)

    fun getAllArticles(): List<Article> = articleRepository.findAll()

    fun getArticleById(articleId: Long): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun updateArticleById(articleId: Long, newArticle: Article): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map { existingArticle ->
            val updatedArticle: Article = existingArticle
                    .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun deleteArticleById(articleId: Long): ResponseEntity<Void> {
        return articleRepository.findById(articleId).map { article ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun getAllArticlesByTitle(title: String): List<Article> = articleRepository.findAllByTitle(title)

    fun getIpAddress(): IpResult = feignClientService.getIp()


}