package no.playground.spring.dontbelazy.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import no.playground.spring.dontbelazy.apis.companies.models.CompanyModel
import no.playground.spring.dontbelazy.apis.companies.models.EmployeeModel

@Entity
@Table(name = "company")
data class CompanyEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Long,

        var name: String,

        @OneToMany
        var employees: List<EmployeeEntity>
) {
        fun toModel(): CompanyModel {
                return CompanyModel(
                        id = id,
                        name = name,
                        employees = employees.map { it.toModel() }
                )
        }
}

@Entity
@Table(name = "employees")
data class EmployeeEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Long,

        var firstName: String,

        var familyName: String,

        @ManyToOne
        var company: CompanyEntity
) {
        fun toModel(): EmployeeModel {
                return EmployeeModel(
                        id = id,
                        firstName = firstName,
                        familyName = familyName,
                        company = company.toModel()
                )
        }
}