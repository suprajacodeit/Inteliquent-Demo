package com.articles.repository

import com.articles.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * This interface extends JPARepository to provide CRUD Operations.
 */
@Repository
interface ArticleRepository : JpaRepository<Article, Long> {

    @Query("FROM Article WHERE title = :title")
    fun findAllByTitle(@Param("title") title: String): List<Article>

}