package no.playground.spring.dontbelazy.product.repositories

import no.playground.spring.dontbelazy.product.repositories.entities.CompanyEntity
import no.playground.spring.dontbelazy.product.repositories.entities.MotherOrganisationEntity
import no.playground.spring.dontbelazy.product.repositories.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompaniesRepository : JpaRepository<CompanyEntity, Long> {

   fun findByCompanyOrgNr(companyOrgNr: String): CompanyEntity?

}

interface MotherOrganisationsRepository : JpaRepository<MotherOrganisationEntity, Long> {

   fun findByMotherOrgNr(motherOrgNr: String): MotherOrganisationEntity?

}

interface ProductsRepository : JpaRepository<ProductEntity, Long> {

   fun findByCompanyId(companyId: Long): List<ProductEntity>

}
