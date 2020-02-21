package Buildings


fun main(args: Array<String>)
{
    Building(Wood()).build()
    Building(Brick()).build()
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood() : BaseBuildingMaterial(numberNeeded = 4)
class Brick() : BaseBuildingMaterial(numberNeeded = 8)

class Building<T: BaseBuildingMaterial>(var material: T)
{
    val baseMaterialsNeeded = 100
    fun actualMaterialsNeeded() = material.numberNeeded * baseMaterialsNeeded

    fun build()
    {
        val typeName = material::class.simpleName
        println("Building requires ${actualMaterialsNeeded()} ${typeName}")
    }
}