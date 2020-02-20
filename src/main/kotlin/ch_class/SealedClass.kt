package ch_class

import ch_class.Entity.Factory.id
import java.util.*

/*
* sealed class:
*
* "==" checks if two objects have the same data.
* "===" checks if two objects are the same object.
* */

enum class EntityType3 {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

// Create thread-safe singleton
object EntityFactory2 {
    fun create(type: EntityType3): Entity3 {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType3.EASY -> type.name
            EntityType3.MEDIUM -> type.getFormattedName()
            EntityType3.HARD -> "Hard"
            EntityType3.HELP -> type.getFormattedName()
        }
        return when (type) {
            EntityType3.EASY -> Entity3.Easy(id, name)
            EntityType3.MEDIUM -> Entity3.Medium(id, name)
            EntityType3.HARD -> Entity3.Hard(id, name, 2f)
            EntityType3.HELP -> Entity3.Help
        }
    }
}
sealed class Entity3  {
    object Help: Entity3(){
        val name = "help"
    }
    data class Easy(val id: String, val name: String): Entity3()
    data class Medium(val id: String, val name: String): Entity3()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity3()

}

fun main() {
    val entity: Entity3 = EntityFactory2.create(EntityType3.MEDIUM)

    val msg = when (entity) {
        Entity3.Help -> "help class"
        is Entity3.Easy -> "easy class"
        is Entity3.Medium -> "medium class"
        is Entity3.Hard -> "hard class"
    }

    println(msg)

    val entity1 = Entity3.Easy("id", "name")
    val entity2 = Entity3.Easy("id", "name")
    val entity3 = entity1.copy(name = "new name")

    if (entity1 == entity2) {
        println("they are equal")
    } else {
        println("Not equal")
    }

    println(entity3 == entity1)

}
