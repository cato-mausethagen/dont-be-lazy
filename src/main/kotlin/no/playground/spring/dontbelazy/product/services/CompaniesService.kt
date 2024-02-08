package no.playground.spring.dontbelazy.product.services

import no.playground.spring.dontbelazy.product.repositories.CompaniesRepository
import no.playground.spring.dontbelazy.product.repositories.entities.CompanyEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CompaniesService(val companiesRepository: CompaniesRepository) {

   private val log = LoggerFactory.getLogger(javaClass)

   fun findCompanyByOrgNr(orgNr: String): CompanyEntity? {
      return companiesRepository.findByCompanyOrgNr(companyOrgNr = orgNr)
   }

}
