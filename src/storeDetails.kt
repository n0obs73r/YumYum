class DishMenu {
    val menu = mutableMapOf<Int, Dish>()

    init {
        val d1 = Dish(0, "Maggie", 30)
        val d2 = Dish(1, "Pasta", 50)
        val d3 = Dish(2, "Coffee", 20)
        menu[d1.dishId] = d1
        menu[d2.dishId] = d2
        menu[d3.dishId] = d3
    }
    fun getDish(dishId: Int): Dish? {
        return menu[dishId]
    }

    fun display() {
        println("===============================================")
        println("\t\t\t\tMenu")
        println("===============================================")
        println("Dish ID\t\t\t\t Dish Name\t\t\t\t Price")
        println("===============================================")
        println()
        for(dish in menu.values) {
            println("${dish.dishId}\t\t\t\t ${dish.dishName}\t\t\t\t ${dish.dishPrice}")
        }
        println("===============================================")
        println()
    }

    fun addDish(newDish: Dish) {
        menu[newDish.dishId] = newDish
    }

    fun removeDish(dishId: Int) {
        menu.remove(dishId)
    }
}
