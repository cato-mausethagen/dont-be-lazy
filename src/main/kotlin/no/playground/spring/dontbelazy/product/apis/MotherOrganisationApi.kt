package no.playground.spring.dontbelazy.product.apis

import no.playground.spring.dontbelazy.product.repositories.entities.MotherOrganisationEntity
import no.playground.spring.dontbelazy.product.services.MotherOrganisationsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/motherOrganisations")
class MotherOrganisationApi(val motherOrganisationsService: MotherOrganisationsService) {

   @GetMapping("/orgnr/{motherOrgNr}")
   fun findByOrganisationNumber(@PathVariable motherOrgNr: String): MotherOrganisationEntity? {
      return motherOrganisationsService.findByOrganisationNumber(motherOrgNr = motherOrgNr) ?: throw ResponseStatusException(
         HttpStatus.NOT_FOUND,
         "No mother organisation found with organisation number: '$motherOrgNr'"
      )
   }

}
