package no.playground.spring.dontbelazy.product.apis.models

data class CompanyModel(
   val id: Long,
   val motherOrgId: Long?,
   val name: String,
   val companyOrgNr: String,
   val products: List<ProductModel>
)

data class ProductModel(
   val id: Long,
   val companyId: Long,
   val name: String,
   val description: String,
   val company: CompanyModel
)
