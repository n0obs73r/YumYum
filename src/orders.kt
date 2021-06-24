class Order (private val customerId: String, val orderId: Int) {
    private val dishList = mutableMapOf<Int, Int>()

    fun add(dishId: Int) {
        dishList[dishId] = dishList.getOrDefault(dishId, 0) + 1
    }

    fun remove(dishId: Int) {
        dishList.remove(dishId)
    }

    fun changeQuantity(dishId: Int, quantity: Int) {
        dishList[dishId] = quantity
    }

    fun check(dishId: Int): Boolean {
        return dishList.contains(dishId)
    }

    fun clear() {
        dishList.clear()
    }

    fun display() {
        println("===============================================")
        println("Dish ID\t\tDish Name\t\tPrice\t\tQuantity")
        println()
        println("===============================================")
        for(dishId in dishList.keys) {
            val dish = DishMenu().getDish(dishId)
            if (dish != null) {
                println("${dish.dishId}\t\t ${dish.dishName}\t\t ${dish.dishPrice}\t\t ${dishList[dishId]}")
            }
        }
        println("===============================================")
        var sum = 0
        for (i in dishList.keys)
        {
            val dish = DishMenu().getDish(i)

            if (dish != null) {
                sum += dish.dishPrice * dishList[i]!!
            }
        }
        println("Total: \t\t\t\t\t$sum")
        println("===============================================")
        println("CustomerId: \t\t\t\t\t$customerId")
        println("===============================================")
    }
}

val orderList = mutableMapOf<Int, Order>()
