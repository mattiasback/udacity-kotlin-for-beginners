package Aquarium

class Aquarium
{
    var width: Int = 40
    var height: Int = 20
    var length: Int = 100

    var volume: Int
        get() = width * height * length / 1000
        set(value) {height = (value * 1000) / (width * length)}
}