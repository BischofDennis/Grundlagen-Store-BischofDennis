fun main() {
    //Objektinstanziierung OnlineStore
    val kotlinStore: OnlineStore = OnlineStore()
    //Objektinstanziierung Adminaccount
    val dennisAdmin: Adminaccount = Adminaccount("Dennis", "1", 26)
    //add Objekt Admin in Accountliste
    kotlinStore.adminAccountListe.add(dennisAdmin)

    // Kontrolle ob schon ein Admin erstellt falls vorhin kein Admin instanziiert wurde.
    if (kotlinStore.adminAccountListe.isEmpty()) {
        kotlinStore.adminAccountErstellen()
    }
    //Objektinstanziierung Kundenaccount
    val lambert: Kundenaccount = Kundenaccount("Lambert", "1", 26)
    kotlinStore.kundenAccountListe.add(lambert)
    val leon: Kundenaccount = Kundenaccount("Leon", "2", 26)
    kotlinStore.kundenAccountListe.add(leon)
    val friedrich: Kundenaccount = Kundenaccount("Friedrich", "3", 53)
    kotlinStore.kundenAccountListe.add(friedrich)
    val klaus: Kundenaccount = Kundenaccount("Klaus", "4", 63)
    kotlinStore.kundenAccountListe.add(klaus)
    val konstantin: Kundenaccount = Kundenaccount("Konstantin", "5", 55)
    kotlinStore.kundenAccountListe.add(konstantin)
    val siegfried: Kundenaccount = Kundenaccount("Siegfried", "6", 3)
    kotlinStore.kundenAccountListe.add(siegfried)
    // print alle Kundenaccounts
    println("\u001B[32mKundenaccounts:\u001B[0m")//Farbe grün
    //für jeden Kunden in der Kundenaccountliste
    for (kunde in kotlinStore.kundenAccountListe) {
        //Methode kundeAnzeigen returnt die .Eigenschaften.
        println(kunde.kundeAnzeigen())
        Thread.sleep(250)
    }
    //While schleife das Programm soll nicht beendet werden!
    while (true) {
        //Log-In oder Kundenaccount erstellen
        var input: Int? = null
        do {
            //Kontrolle ob niemand eingeloggt ist
            if (kotlinStore.aktuellerLogIn == null) {
                println("Möchten sie sich neu\u001B[32m einloggen(1)\u001B[0m oder ein\u001B[34m Kundenaccount erstellen(2)\u001B[0m?")
                //Funktion readInt die nur erlaubt 1 oder 2 einzugeben, von Gordon Lucas.
                input = readInt(1..2)
                when (input) {
                    1 -> {//Log-In
                        kotlinStore.logIn()
                        //wenn LogIn fehlschlägt wird auf null gestetzt, Programmfluss fängt wieder von oben an wegen do while Schleife
                        if (kotlinStore.aktuellerLogIn == null)
                            println("Login fehlgeschlagen. Bitte erneut versuchen.")
                    }

                    2 -> {
                        //Account erstellen
                        val erstellerAccount = kotlinStore.kundenAccountErstellen()
                        //Kontrolle ob Kundenaccount erstellt wurde
                        if (erstellerAccount != null) {
                            kotlinStore.logIn()
                        } else {
                            println("Kudenaccount erstellen fehlgeschlagen")
                        }
                    }
                    //denke braucht man nicht mehr wegen Funktion readInt
                    null -> {
                        println("Falsche Eingabe.")
                    }
                }
                //Wilkommenbildschirm bei erfolgreichem LogIn
                //kotlinStore.wilkommenBildschirm()
                val name = kotlinStore.aktuellerLogIn
                println("Wilkommen im KotlinStore ${name?.benutzername}!")
            } else {
                println("Es ist schon jemand eingeloggt.")
            }
            //Do-While schleife solange niemand eingeloggt ist
        } while (kotlinStore.aktuellerLogIn == null)

        //Konstante erstellt damit es Datentyp Kundenaccount hat es geht auch "as Kundenaccount" sonst steht
        val eingeloggterAccount = kotlinStore.aktuellerLogIn//weil es könnten sich ja mehrere Kunden einloggen
        do {
            //Kontrolle ob Admin oder Kunde eingeloggt ist
            when (eingeloggterAccount) {
                //Admin-Menü
                is Adminaccount -> kotlinStore.adminOptionen()//nur ein Admin kann sich einloggen
                //Kunden-Menü
                is Kundenaccount -> kotlinStore.kundenOptionen(eingeloggterAccount)//Eigenschaft übergabe welcher Kunde genau
                //is Kundenaccount -> kotlinStore.kundenOptionen(kotlinStore.aktuellerLogIn as Kundenaccount)
            }
            // Do-While schleife bis jemand eingeloggt ist.
        } while (kotlinStore.aktuellerLogIn != null)

    }//While Schleife wird nicht beendet.
}
