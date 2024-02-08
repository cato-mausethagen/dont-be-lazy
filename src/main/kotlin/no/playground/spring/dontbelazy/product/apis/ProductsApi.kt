package no.playground.spring.dontbelazy.product.apis

import no.playground.spring.dontbelazy.product.apis.models.ProductModel
import no.playground.spring.dontbelazy.product.repositories.entities.ProductEntity
import no.playground.spring.dontbelazy.product.services.ProductsService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductsApi(val productsService: ProductsService) {

   private val log = LoggerFactory.getLogger(javaClass)

   @GetMapping
   fun findAllProducts(): List<ProductEntity> {
      return productsService.findAllProducts()
   }

   @GetMapping("/company/orgnr/{companyOrgNr}")
   fun findProductsByCompanyId(@PathVariable companyOrgNr: String): List<ProductEntity> {
      return productsService.findProductsByCompanyOrgNr(companyOrgNr = companyOrgNr)
   }

}
