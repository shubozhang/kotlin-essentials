package ch_class

import java.util.*

enum class EntityType {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

// Create thread-safe singleton
object EntityFactory {
    fun create(type: EntityType): Entity2 {
        val name = when (type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        val id = UUID.randomUUID().toString()
        return Entity2(id, name)
    }
}
class Entity2 constructor(val id: String, val name: String) {

    override fun toString(): String {
        return "id:$id name:$name"
    }
}

fun main() {
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)
}