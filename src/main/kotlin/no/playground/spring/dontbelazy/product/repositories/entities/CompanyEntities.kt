package no.playground.spring.dontbelazy.product.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "mother_organisations")
data class MotherOrganisationEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var name: String,

   var motherOrgNr: String,

   var description: String?

)

@Entity
@Table(name = "companies")
data class CompanyEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var motherOrgId: Long?,

   var name: String,

   var companyOrgNr: String
)

@Entity
@Table(name = "products")
data class ProductEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var companyId: Long,

   var name: String,

   var description: String?
)
