package com.articles.events

import com.articles.model.Article
import com.articles.repository.ArticleRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

/**
 * To class provide a mock data on the start up of the spring boot application.
 */
@Component
class ApplicationStartup(private val articleRepository: ArticleRepository) : ApplicationListener<ApplicationReadyEvent> {

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val article1 = Article(id = 1001, title = "Java Programming", content = "Java is a best programming language")
        val article2 = Article(id = 1002, title = "Kotlin Programming", content = "Kotlin can make our life better")
        articleRepository.saveAll(listOf(article1, article2))
    }
}