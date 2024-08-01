open class Account(
    val benutzername: String,
    protected var passwort: String,//das passwist geschutzt die eigenschaft wird mit vererbt
    var alter: Int
) {
    //LogIn für Admin- oder Kunden-Account
    fun logIn(inputPasswort: String): Boolean {
        if (inputPasswort == passwort) {
            return true
        } else {
            return false
        }
    }

    //LogOut für Admin- oder Kunden-Account
    open fun logOut() {
        println("Benutzername $benutzername ausgeloggt...")
    }
}