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

        var input: Int? = -1
        while (input !in 0..3) {
            input = readLine()?.toIntOrNull()
        }
        when(input) {
            0 -> break
            else -> if (input != null) {
                login(input - 1)
            }
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

fun nextPage(auth: Record) {
    val user: Person
    when(auth.type) {
        UserType.ADMIN -> {
            user = Admin()
            user.displayOptions()
        }
        UserType.CHEF -> {
            user = Chef()
            user.displayOptions()
        }
        UserType.USER -> {
            user = User(auth.name)
            user.displayOptions()
        }
    }
}
