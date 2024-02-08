package no.playground.spring.dontbelazy.product.repositories

import no.playground.spring.dontbelazy.product.repositories.entities.NextGenCompanyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NextGenCompaniesRepo : JpaRepository<NextGenCompanyEntity, Long> {

   fun findByCompanyOrgNr(companyOrgNr: String): NextGenCompanyEntity?

}
