package ch_class

interface PersonInfoProvider {
    // field cannot have default value and must be overridden.
    val providerInfo: String

    fun printInfo(person: Person)

    // fun has default implementation that is not required to override in the subclass
    fun printName(person: Person) {
        println(providerInfo)
        println("print name")
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}


open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    override fun printInfo(person: Person) {
        println("basic info: $person")
    }

    override fun printName(person: Person) {
        super.printName(person)
        println("additioonal print statement")
    }

    open val sessionIdPrefix = "Session"
    override fun getSessionId(): String {
        return sessionIdPrefix
    }

}

fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())

    provider.printName(Person())

    provider.getSessionId()

    checkTypes(provider)

    val fProfiver = FancyInfoProviderSub()
    fProfiver.printInfo(Person())
    fProfiver.getSessionId()
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if ( infoProvider is SessionInfoProvider) {
        println("is SessionInfoProvider")

        // as works like "cast" in java
        println((infoProvider as SessionInfoProvider).getSessionId())
    } else  {
        println("is not SessionInfoProvider")
    }
}