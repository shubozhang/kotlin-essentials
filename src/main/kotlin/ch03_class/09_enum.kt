package ch03_class

// semi-colon is required after the last enum member
enum class Department(val fullName: String, val numOfEmployees: Int) {
    HR("Human Resoures", 5),
    IT("Information technology", 100),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 50);


    fun getDeptInfo() = "Department full name is $fullName and number of employees is $numOfEmployees"
}


fun main() {
    println(Department.IT.getDeptInfo())
}
