package Buildings


fun main()
{
    var woodenBuilding = Building(Wood())
    woodenBuilding.build()
    var brickBuilding = Building(Brick())
    brickBuilding.build()

    isSmallBuilding(woodenBuilding)
    isSmallBuilding(brickBuilding)
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood() : BaseBuildingMaterial(numberNeeded = 4)
class Brick() : BaseBuildingMaterial(numberNeeded = 8)

class Building<out T: BaseBuildingMaterial>(val material: T)
{
    private val baseMaterialsNeeded = 100
    fun actualMaterialsNeeded() = material.numberNeeded * baseMaterialsNeeded

    fun build()
    {
        val typeName = material::class.simpleName
        println("Building requires ${actualMaterialsNeeded()} $typeName")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>)
{
    if (building.actualMaterialsNeeded() < 500) println("Small building")
    else println("Large building")
}