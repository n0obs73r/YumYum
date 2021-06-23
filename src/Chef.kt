object Chef {
    fun displayOptions() {
        while (true) {
            println("Select your action: ")
            println("1) Create a Dish")
            println("2) Delete Dish")
            println("3) Show Pending Orders")
            println("4) Display Dish List")
            println("--Press 0 to Exit--")

            var input = -1
            while (input !in 0..4) {
                input = readLine()?.toInt()!!
            }
            when (input) {
                0 -> break
                1 -> addDish()
                2 -> removeDish()
                3 -> showPendingOrders()
                4 -> DishMenu.display()
                else -> println("Invalid Input!")
            }
        }
    }

    private fun addDish() {
        println("Dish Name: ")
        val name = readLine() as String
        println("Dish Price: ")
        val price = Integer.valueOf(readLine())

        DishMenu.addDish(Dish(DishMenu.menu.size, name, price))
        println("Dish added")
    }

    private fun removeDish() {
        print("Enter Dish Id: ")
        val dishId = Integer.valueOf(readLine())
        DishMenu.removeDish(dishId)
        println("Dish Deleted!")
    }

    private fun showPendingOrders() {
        for(orderId in orderList.keys) {
            val order = orderList[orderId]
            println("Order ID: $order.orderId")
        }

        println("Select orderID: ")
        val orderID = Integer.valueOf(readLine())

        println("1) Accept")
        println("2) Reject")

        val choice = Integer.valueOf(readLine())
        if(choice == 1) {
            println("Order Accepted")
        } else {
            println("Order rejected")
        }
        orderList.remove(orderID)
    }
}
