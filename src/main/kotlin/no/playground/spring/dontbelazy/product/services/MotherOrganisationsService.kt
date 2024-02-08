package no.playground.spring.dontbelazy.product.services

import no.playground.spring.dontbelazy.product.repositories.MotherOrganisationsRepository
import no.playground.spring.dontbelazy.product.repositories.entities.MotherOrganisationEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MotherOrganisationsService(val motherOrganisationsRepository: MotherOrganisationsRepository) {

   private val log = LoggerFactory.getLogger(javaClass)

   fun findByOrganisationNumber(motherOrgNr: String): MotherOrganisationEntity? {
      return motherOrganisationsRepository.findByMotherOrgNr(motherOrgNr = motherOrgNr)
   }

}
