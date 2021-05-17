data class Employee(val name: String, val age: Int)

interface EmployeeRepository {
    fun listEmployees(): List<Employee>
}

class EmployeeReport(
    private val employeeRepository: EmployeeRepository
) {
    fun list(): List<Employee> {
        return employeeRepository.listEmployees().filter {
            it.age >= 18
        }.sortedBy {
            it.name
        }.map {
            it.copy(name = it.name.toUpperCase())
        }
    }
}

