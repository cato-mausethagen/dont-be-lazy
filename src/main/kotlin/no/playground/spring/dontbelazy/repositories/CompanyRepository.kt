package no.playground.spring.dontbelazy.repositories

import no.playground.spring.dontbelazy.repositories.entities.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<CompanyEntity, Long> {

    fun findByName(name: String): CompanyEntity?

}