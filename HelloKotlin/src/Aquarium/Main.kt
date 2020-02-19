package aquarium

fun main (args: Array<String>)
{
    buildAquarium()
}

fun buildAquarium()
{
    val aquarium = Aquarium()

    println("Width: ${aquarium.width}")
    println("Height: ${aquarium.height}")
    println("Length: ${aquarium.length}")
    println("Volume: ${aquarium.volume}")

    aquarium.volume *= 2
    println("New Width: ${aquarium.width}")
    println("New Height: ${aquarium.height}")
    println("New Length: ${aquarium.length}")
    println("New Volume: ${aquarium.volume}")
}

