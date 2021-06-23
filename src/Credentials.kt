object UserDatabase {
    private var db = HashMap<String, Person>()

    init {
        val p1 = Person("user", "password", 2)
        val p2 = Person("chef", "password", 1)
        val p3 = Person("admin", "password", 0)
        db[p1.userId] = p1
        db[p2.userId] = p2
        db[p3.userId] = p3
    }

    fun addUser(user: Person) {
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
            println("${user.userId}\t ${user.userType}")
        }
    }

    fun authenticate(user: Person): Int {
        if (db.containsKey(user.userId)) {
            val temp = db[user.userId]
            if (user.userType != temp?.userType)
                return -1
            if (user.password == temp.password)
                return 1
            return 0
        }
        return -1
    }
}