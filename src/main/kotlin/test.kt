fun main() {
    val kotlinStore: OnlineStore = OnlineStore() // Online-Store Onjektinstanziierung
    val dennisAdmin: Adminaccount = Adminaccount("Dennis", "12345", 26) //Adminaccount Onjektinstanziierung
    kotlinStore.adminAccountListe.add(dennisAdmin)

    if (kotlinStore.adminAccountListe.isEmpty()) { // Kontrolle ob schon ein Admin erstellt wurde
        kotlinStore.adminAccountErstellen() //Methode Admin erstellen
    }

    //kotlinStore.kundenAccountErstellen()
    val leon: Kundenaccount = Kundenaccount("Leon", "1234", 26) // Kundenaccount Objektinstanziierung
    kotlinStore.kundenAccountListe.add(leon)

    for (kunde in kotlinStore.kundenAccountListe) { // Alle Kudenaccounts auflisten
        println("Alle Kundenaccounts : ${kunde.kundeAnzeigen()}")
    }

    do {
//        println("1: LogIn, 2: neuer Benutzer erstellen, 3: beenden"){
//            val input: Int = readln().toInt()
//            when(input){
//                1->
//            }
//
//        }
        if (kotlinStore.aktuellerLogIn == null) { // Kontrolle ob schoon jemand eingeloggt ist
            kotlinStore.kundenAccountErstellen()
            kotlinStore.logIn() // Metode logIn
        } else {
            print("Wilkommen im KotlinStore!") // willkomenBilschirm funktion fehlt noch
            kotlinStore.produkteAnzeigen()//alle Produkte anzeigen integriert For schleife
        }

        val eingeloggterAccount = kotlinStore.aktuellerLogIn

        when (eingeloggterAccount) { //Kontrolle wer eingeloggt ist Admin/Kunde
            is Adminaccount -> kotlinStore.adminOptionen()//Konsole auswahl
            is Kundenaccount -> kotlinStore.kundenOptionen(eingeloggterAccount)
        }

        if (kotlinStore.aktuellerLogIn == null) {
            continue
        }
    } while (true)


    //kotlinStore.produkteAnzeigen() //alle Produkte drucken

    //kotlinStore.logIn() for schelfie logIn bilschirm
    //println("Benutzername von Account Dennis: ${dennis.benutzername}")
    //println(dennis.produkteansehen())
    //kotlinStore.kundenAccountListe[0].zahlungsMethodehinzufügen("PayPal")
    //println("Zahlungsmethode von ${kotlinStore.kundenAccountListe[0].benutzername}: ${kotlinStore.kundenAccountListe[0].zahlungsmethoden}")
    //kotlinStore.printAlleProdukte()
    //dennis.zahlungsmethoden


}