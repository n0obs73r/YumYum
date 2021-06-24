class Admin : Person() {
    override fun displayOptions() {
        while (true) {
            println("Welcome Admin! ")
            println()
            println("Select Your Action: ")
            println("1) Add User/Chef Account")
            println("2) Delete User/Chef Account ")
            println("3) Display all Accounts")
            println("--Press 0 to Exit--")

            var input: Int? = -1
            while (input !in 0..3) {
                input = readLine()?.toIntOrNull()
            }

            when (input) {
                0 -> break
                1 -> addNewUser()
                2 -> deleteUser()
                3 -> UserDatabase.display()
                else -> println("Invalid Input!")
            }
        }
    }

    private fun addNewUser() {
        println("Enter Account Details: ")

        println("UserId: ")
        val userid = readLine() as String
        println("Password: ")
        val pass = readLine() as String
        println("Name: ")
        val name = readLine() as String

        println("Enter User type: ")
        println("0 for Admin")
        println("1 for Chef")
        println("2 for User")
        val userType = readLine()!!.toInt()

        lateinit var type : UserType
        when(userType)
        {
            0 -> {type = UserType.ADMIN}
            1 -> {type = UserType.CHEF}
            2 -> {type = UserType.USER}
        }

        val user = Record(userid, pass, type, name)
        UserDatabase.addUser(user)
        println("---Account Added---")
    }

    private fun deleteUser() {
        println("Enter userId to remove: ")
        val userId = readLine()
        if (userId != null) {
            UserDatabase.removeUser(userId)
        }
        println("---Account Deleted---")
    }
}




