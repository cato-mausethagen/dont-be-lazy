package no.playground.spring.dontbelazy.repository

import no.playground.spring.dontbelazy.repository.entities.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<CompanyEntity, Long> {

    fun findByName(name: String): CompanyEntity?

}