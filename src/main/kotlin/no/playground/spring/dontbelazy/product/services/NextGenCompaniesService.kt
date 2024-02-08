package no.playground.spring.dontbelazy.product.services

import no.playground.spring.dontbelazy.product.repositories.NextGenCompaniesRepo
import no.playground.spring.dontbelazy.product.repositories.entities.NextGenCompanyEntity
import org.springframework.stereotype.Service

@Service
class NextGenCompaniesService(val nextGenCompaniesRepo: NextGenCompaniesRepo) {

   fun findAllCompanies(): List<NextGenCompanyEntity> {
      return nextGenCompaniesRepo.findAll()
   }

}
