class User(userId: String) {

    private val currentOrder = Order(userId, orderList.size)

    fun displayOptions() {
        while (true) {
            println("Select your action: ")
            println("1) Select Dishes")
            println("2) Modify order")
            println("3) Display Current Order")
            println("4) Confirm and Execute Order")
            println("5) Show Dish Menu")
            println("--Press 0 to Exit--")

            var input = -1
            while (input !in 0..5) {
                input = readLine()?.toInt()!!
            }

            when (input) {
                0 -> break
                1 -> selectDish()
                2 -> modifyOrder()
                3 -> currentOrder.display()
                4 -> {
                    orderList[currentOrder.orderId] = currentOrder
                    currentOrder.clear()
                }
                5 -> DishMenu.display()
                else -> println("Invalid Input!")
            }
        }
    }

    private fun selectDish() {
        println("Enter the dish Number You want to add: ")
        val dishId: Int = Integer.valueOf(readLine())
        if(currentOrder.check(dishId))
            println("Selected dish is already in order.")
        else {
            println("Adding dish $dishId to order...")
            currentOrder.add(dishId)
        }
    }

    private fun modifyOrder() {
        println("Your current order: ")
        currentOrder.display()
        println()
        println("Enter Dish ID to update: ")
        val dishId = Integer.valueOf(readLine())
        println("Enter new quantity (0 to remove): ")
        val quantity = Integer.valueOf(readLine())

        if(quantity == 0)
            currentOrder.remove(dishId)
        else
            currentOrder.changeQuantity(dishId, quantity)
    }
}