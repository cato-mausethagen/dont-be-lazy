package no.playground.spring.dontbelazy.product.apis.models

data class MotherCompanyModel(
   val id: Long,
   val name: String,
   val motherOrgNr: String,
   val description: String?
)

data class CompanyModel(
   val id: Long,
   val motherOrgId: Long?,
   val name: String,
   val companyOrgNr: String,
   val products: List<ProductModel>
)

data class ProductModel(
   val id: Long,
   val name: String,
   val description: String?,
   val company: CompanyModel?
)
