package ch_class

class FancyInfoProviderSub : BasicInfoProvider() {
    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy info")
    }

    override val sessionIdPrefix: String
        get() = "Fancy session"
}