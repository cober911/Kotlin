fun main(vararg args: String) {
    val modArgs = args.toMutableList()
    modArgs.add(434.toString())
    modArgs.add(11.1.toString())
    modArgs.add("asd")
    if (modArgs.size>=2){
        val a = modArgs[0].toIntOrNull()
        val b: Double = modArgs[1].toDouble()
        if (a != null && b != null){
            val sum = a+b
            println("Сумма: $sum")
        }
    }
    for (arg in modArgs){
        println(arg)
    }
}