package no.playground.spring.dontbelazy.product.repositories.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "mother_organisations")
data class MotherOrganisationEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var name: String,

   var motherOrgNr: String,

   var description: String?,

   @OneToOne(fetch = FetchType.LAZY, mappedBy = "motherOrganisation")
   @JsonIgnoreProperties("motherOrganisation")
   var company: CompanyEntity

)

@Entity
@Table(name = "companies")
data class CompanyEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var name: String,

   var companyOrgNr: String,

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "mother_org_id")
   var motherOrganisation: MotherOrganisationEntity,

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
   @JsonIgnoreProperties("company")
   var products: List<ProductEntity>

)

@Entity
@Table(name = "products")
data class ProductEntity(
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Long,

   var name: String,

   var description: String?,

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "company_id")
   @JsonIgnoreProperties("products")
   var company: CompanyEntity?
)
