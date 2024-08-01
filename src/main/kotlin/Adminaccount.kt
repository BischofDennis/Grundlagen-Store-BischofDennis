class Adminaccount(
    benutzername: String,
    passwort: String,
    alter: Int
) : Account(benutzername, passwort, alter) {

    constructor() : this(benutzername = "", passwort = "", alter = 0) {
    }

    init {
        println("Es wird ein Adminaccount erstellt")
    }

    override fun logOut() {
        println("Adminaccount $benutzername ausgeloggt...")
    }

}