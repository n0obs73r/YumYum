object DishMenu {
    val menu = mutableMapOf<Int, Dish>()

    fun getDish(dishId: Int): Dish? {
        return menu[dishId]
    }

    fun display() {
        println("=====================================")
        println("\t\t\t\tMenu")
        println("=====================================")
        println("Dish ID\t\t Dish Name\t\t Price")
        println("=====================================")
        println()
        for(dish in menu.values) {
            println("${dish.dishId}\t\t ${dish.dishName}\t\t${dish.dishPrice}")
        }
        println("=====================================")
        println()
    }

    fun addDish(newDish: Dish) {
        menu[newDish.dishId] = newDish
    }

    fun removeDish(dishId: Int) {
        menu.remove(dishId)
    }
}
