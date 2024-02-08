package no.playground.spring.dontbelazy.product.apis

import no.playground.spring.dontbelazy.product.repositories.entities.NextGenCompanyEntity
import no.playground.spring.dontbelazy.product.services.NextGenCompaniesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/nextGenCompanies")
class NextGenCompanyApi(val nextGenCompaniesService: NextGenCompaniesService) {

   @GetMapping
   fun findAllNextGenCompanies(): List<NextGenCompanyEntity> {
      return nextGenCompaniesService.findAllCompanies()
   }

}
