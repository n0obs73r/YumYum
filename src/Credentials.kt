enum class UserType {
    ADMIN, CHEF, USER
}

data class Record(
    val userId: String,
    val password: String,
    val type: UserType,
    val name: String
)

object UserDatabase {
    private var db = HashMap<String, Record>()

    init {
        val p1 = Record("user", "password", UserType.USER, "Aryan")
        val p2 = Record("chef", "password", UserType.CHEF, "Aryan")
        val p3 = Record("admin", "password", UserType.ADMIN, "Aryan")
        db[p1.userId] = p1
        db[p2.userId] = p2
        db[p3.userId] = p3
    }

    fun addUser(user: Record) {
        db[user.userId] = user
    }

    fun removeUser(username: String) {
        db.remove(username)
    }

    fun display() {
        println("\t\t\t\tUsers")
        println()
        println("UserID\t UserType")
        println()
        for(user in db.values) {
            println("${user.userId}\t ${user.type}")
        }
    }

    fun authenticate(userId: String, pass: String, userType: Int): Record? {
        if(db.containsKey(userId)) {
            val rec = db.getValue(userId)
            if(userType == rec.type.ordinal && pass == rec.password) {
                return rec
            }
            println("Wrong credentials")
            return null
        } else {
            println("No such user exists.")
            return null
        }
    }
}