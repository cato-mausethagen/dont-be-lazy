package no.playground.spring.dontbelazy.product.apis.models

import no.playground.spring.dontbelazy.product.repositories.entities.CompanyEntity
import no.playground.spring.dontbelazy.product.repositories.entities.MotherOrganisationEntity
import no.playground.spring.dontbelazy.product.repositories.entities.ProductEntity

data class MotherCompanyModel(
   val id: Long,
   val name: String,
   val motherOrgNr: String,
   val description: String?
) {
   fun toEntity(): MotherOrganisationEntity {
      return MotherOrganisationEntity(
         id = id,
         name = name,
         motherOrgNr = motherOrgNr,
         description = description
      )
   }
}

data class CompanyModel(
   val id: Long,
   val motherOrgId: Long?,
   val name: String,
   val companyOrgNr: String,
   val products: List<ProductModel>
) {
   fun toEntity(): CompanyEntity {
      return CompanyEntity(
         id = id,
         name = name,
         motherOrgId = motherOrgId,
         companyOrgNr = companyOrgNr
      )
   }
}

data class ProductModel(
   val id: Long,
   val companyId: Long,
   val name: String,
   val description: String,
   val company: CompanyModel
) {
   fun toEntity(): ProductEntity {
      return ProductEntity(
         id = id,
         name = name,
         companyId = companyId,
         description = description
      )
   }
}
