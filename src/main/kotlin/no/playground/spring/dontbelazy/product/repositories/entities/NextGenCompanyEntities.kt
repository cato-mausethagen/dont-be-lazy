package no.playground.spring.dontbelazy.product.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "companies")
data class NextGenCompanyEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var name: String,

   var companyOrgNr: String,

)
