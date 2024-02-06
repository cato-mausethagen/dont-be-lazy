package no.playground.spring.dontbelazy.api.models

import no.playground.spring.dontbelazy.repository.entities.CompanyEntity
import no.playground.spring.dontbelazy.repository.entities.EmployeeEntity

data class CompanyModel(
        var id: Long,
        var name: String,
        var employees: List<EmployeeModel>
) {
    fun toEntity(): CompanyEntity {
        return CompanyEntity(
                id = id,
                name = name,
                employees = employees.map { it.toEntity() })
    }
}

data class EmployeeModel(
        var id: Long,
        var firstName: String,
        var familyName: String,
        var company: CompanyModel
) {
    fun toEntity(): EmployeeEntity {
        return EmployeeEntity(
                id = id,
                firstName = firstName,
                familyName = familyName,
                company = company.toEntity()
        )
    }
}