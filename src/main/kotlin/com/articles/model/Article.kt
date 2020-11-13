package com.articles.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty

/**
 * The Article Entity Model.
 */
@Entity
data class Article(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotEmpty(message = "Please provide a valid Title")
        val title: String = "",

        @get: NotEmpty(message = "Please provide a valid Content")
        val content: String = ""
)