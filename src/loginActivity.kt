fun main() {
    frontPage()
}

fun frontPage() {
    while(true) {
        println("Choose the role to enter login credentials: ")
        println()
        println("1) Admin")
        println("2) Chef")
        println("3) User")
        println("Press 0 to Exit")
        println()

        var input = -1
        while (input !in 0..3) {
            input = readLine()?.toInt()!!
        }
        when(input) {
            0 -> break
            else -> login(input - 1)
        }
    }
}

fun login(userType: Int) {
    println("Enter Email/username: ")
    val userid = readLine() as String
    println("Enter Password: ")
    val pass = readLine() as String

    val user = Person(userid, pass, userType)
    when(UserDatabase.authenticate(user)) {
        -1 -> println("No such user exists.")
        0 -> println("Wrong password.")
        1 -> nextPage(user)
    }
}

fun nextPage(user: Person) {
    when(user.userType) {
        0 -> Admin.displayOptions()
        1 -> Chef.displayOptions()
        2 -> User(user.userId).displayOptions()
    }
}
