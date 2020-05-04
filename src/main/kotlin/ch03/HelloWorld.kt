package ch03


typealias  EmployeeSet = Set<Employee>

fun main() {
    val age = 10
    println(age)

    // example 1
    val employee = Employee("John", 30)
    // name is mutable, but id is immutable
    employee.name = "Doe"
    println(employee.name)
    // wrong: assign employee to another instance since employee is val (immutable)

    // example 2
    val employee2: Employee
    var meanAge = 40

    employee2 = if (age < meanAge) {
        Employee("Abby", 35)
    } else {
        Employee("Bourne", 45)
    }


    // example 3
    val employees: EmployeeSet
}


class Employee(var name: String, val id: Int) {

}