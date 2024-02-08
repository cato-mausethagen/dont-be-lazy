package no.playground.spring.dontbelazy.product.apis

import no.playground.spring.dontbelazy.product.apis.models.CompanyModel
import no.playground.spring.dontbelazy.product.repositories.entities.CompanyEntity
import no.playground.spring.dontbelazy.product.services.CompaniesService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/companies")
class CompanyApi(val companiesService: CompaniesService) {

   private val log = LoggerFactory.getLogger(javaClass)

   @GetMapping("/orgnr/{orgNr}")
   fun getCompanyByOrgNr(@PathVariable orgNr: String): CompanyEntity? {
      log.info("Find company by organisation number: '$orgNr'")
      return companiesService.findCompanyByOrgNr(orgNr = orgNr) ?: throw ResponseStatusException(
         HttpStatus.NOT_FOUND,
         "No company found with organisation number '$orgNr'"
      )
   }

}
