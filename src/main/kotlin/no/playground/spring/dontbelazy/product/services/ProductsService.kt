package no.playground.spring.dontbelazy.product.services

import no.playground.spring.dontbelazy.product.repositories.ProductsRepository
import no.playground.spring.dontbelazy.product.repositories.entities.ProductEntity
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductsService(
   val companiesService: CompaniesService,
   val productsRepository: ProductsRepository
) {

   private val log = LoggerFactory.getLogger(javaClass)

   fun findAllProducts(): List<ProductEntity> {
      return productsRepository.findAll()
   }

   fun findProductsByCompanyOrgNr(companyOrgNr: String): List<ProductEntity> {
      val company = companiesService.findCompanyByOrgNr(orgNr = companyOrgNr) ?: throw ResponseStatusException(
         HttpStatus.NOT_FOUND,
         "No company found with organisation number '$companyOrgNr'"
      )
      return productsRepository.findByCompanyId(companyId = company.id)
   }
}
