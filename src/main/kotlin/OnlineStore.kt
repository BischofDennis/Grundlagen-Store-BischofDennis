class OnlineStore() {
    val mindestalter: Int = 12
    val produktListe: MutableList<Produkt> = mutableListOf()
    val adminAccountListe: MutableList<Adminaccount> = mutableListOf()
    val kundenAccountListe: MutableList<Kundenaccount> = mutableListOf()
    val warenkorb: MutableMap<Kundenaccount, MutableMap<Produkt, Int>> = mutableMapOf()
    val zahlungsmethoden: MutableMap<Kundenaccount, MutableList<String>> = mutableMapOf()
    val kundenrezensionen: MutableMap<Kundenaccount, MutableMap<Produkt, Double>> = mutableMapOf()
    var aktuellerLogIn: Account? = null

    // init_Block der bei der Objektinstanziierung von OnlineStore ausgeführt wird.
    init {
        produktListe.add(Elektronik("iPhone 12", 699.99 , 10000, true, 10, "Handy", "Apple", 24))
        produktListe.add(Elektronik("Samsung Galaxy S21", 399.99, 10001, true, 10, "Handy", "Samsung", 24))
        produktListe.add(Elektronik("Sony PlayStation 5", 499.99, 10002, true, 10, "Spiele Konsole", "Sony", 24))
        produktListe.add(Monitor("Samsung QLED Monitor", 179.99, 20000, true, 10, "Samsung", 24, 19, "QLED Monitor mit beeindruckender Bildqualität"))
        produktListe.add(Monitor("ASUS Gaming Monitor", 99.99, 20001, true, 10, "ASUS", 24, 19, "Gaming Monitor mit schneller Reaktionszeit"))
        produktListe.add(Monitor("Fujitsu 4K UHD Monitor", 199.99, 20002, true, 10, "Fujitsu", 24, 22, "Professioneller 4K UHD Monitor für den professionellen Einsatz"))
        produktListe.add(Laptop("MacBook Air M2", 1299.99, 30000, true, 10, "Apple", 24, 13, "Leichtes MacBook mit M2 Chip für hohe Leistung"))
        produktListe.add(Laptop("MacBook Pro M3", 1699.99, 30001, true, 10, "Apple", 24, 14, "Leichtes MacBook mit M3 Chip für hohe Leistung"))
        produktListe.add(Laptop("Lenovo ThinkPad", 1099.99, 30002, true, 10, "Lenovo", 24, 16, "Zuverlässiges ThinkPad-Laptop für den professionellen Einsatz"))
        produktListe.add(Film("Interstellar", 19.99, 30000, true, 10, "Science Fiction", "Christopher Nolan"))
        produktListe.add(Film("Pulp Fiction", 14.99, 30001, true, 10, "Crime", "Quentin Tarantino"))
        produktListe.add(Film("John Wick", 16.99, 30002, true, 10, "Action", "Chad Stahelski"))
        ///Enum Objektinstanziierung Action würde stehen als Parameter val Genre.Action
        produktListe.add(Action("Guardians of the Galaxy", 21.99, 40000, true, 10, "James Gunn", "Ein actiongeladener Superheldenfilm im Marvel-Universum"))
        produktListe.add(Action("Matrix", 18.99, 40001, true, 10, "Wachowski Sisters", "Ein bahnbrechender Action-Science-Fiction-Film"))
        produktListe.add(Action("Venom", 20.99, 40002, true, 10, "Ruben Fleischer", "Ein Superhelden-Actionfilm über den Charakter Venom"))
        produktListe.add(Fantasy("Hellboy", 16.99, 50000, true, 10, "Guillermo del Toro", "Fantays Film"))
        produktListe.add(Fantasy("Herr der Ringe: Die Gefährten", 20.99, 50001, true, 10, "Peter Jackson", "Das epische Fantasy-Abenteuer beginnt"))
        produktListe.add(Fantasy("Harry Potter und der Stein der Weisen", 18.99, 50002, true, 10, "Chris Columbus", "Die magische Welt von Harry Potter beginnt"))
    }

    fun wilkommenBildschirm() {
        println("\u001B[35m".padEnd(100, '-'))
        println(
            """
            
                                                                           /^\/^\
                                                                         _|__|  O|
                                                                \/     /~     \_/ \
                                                                 \____|__________/  \
                                                                        \_______      \
                                                                                `\     \                 \
                                                                                  |     |                  \
                                                                                 /      /                    \
                                                                                /     /                       \\
                                                                              /      /                         \ \
                                                                             /     /                            \  \
                                                                           /     /             _----_            \   \
                                                                          /     /           _-~      ~-_         |   |
                                                                         (      (        _-~    _--_    ~-_     _/   |
                                                                          \      ~-____-~    _-~    ~-_    ~-_-~    /
                                                                            ~-_           _-~          ~-_       _-~
                                                                               ~--______-~                ~-___-~

        """.trimIndent()
        )
        println("\u001B[35m Wilkommen im KotlinStore!\u001B[0m")
        println()
        println("\u001B[35m".padEnd(100, '-') + "\u001B[0m")
    }

    //Wird benötigt falls kein Admin erstellt wurde.
    fun adminAccountErstellen(): Adminaccount {
        println("Bitte geben sie einen Namen ein.")
        val name: String = readln()
        do {
            println("Bitte geben sie ein Passwort ein:")
            val passwort1: String = readln()
            println("Bitte wiederholen sie ihre Passwort eingabe:")
            val passwort2: String = readln()
            if (passwort1 == passwort2) {
                println("Passwort wurde akzeptiert...")
                println("Bitte geben sie ihr Alter ein:")
                val alter: Int = readln().toInt()
                println("Adminaccount $name wird erstellt.")
                //Objekt-Instanziierung Adminaccount
                val adminaccount: Adminaccount = Adminaccount(name, passwort2, alter)
                adminAccountListe.add(adminaccount)
                return adminaccount
            } else {
                println("Passwörter stimmen nicht überein!")
                return adminAccountErstellen()
            }
            return Adminaccount()
            //Wird solange gemacht bis die Passwörter übereinstimmen.
        } while (passwort1 == passwort2)

    }

    //In Main.kt ist eine When-Verzweigung, die kontrolliert ob man sich einloggen möchte oder ein Kundenaccount erstellen will.
    //oder einfach so Kundenaccount erstellen
    fun kundenAccountErstellen(): Kundenaccount? {
        println("Kundenaccount erstellen")
        println("Bitte geben sie einen Namen ein.")
        val name: String = readln()

        do {
            println("Bitte geben sie ein Passwort ein")
            val passwort1: String = readln()
            println("Bitte wiederholen sie ihre Passwort eingabe")
            val passwort2: String = readln()
            if (passwort1 == passwort2) {
                println("Passwort wurde akzeptiert...")
                println("Bitte geben sie ihr Alter ein:")
                val alterEingabe: String = readln()
                val alter: Int
                try {
                    alter = alterEingabe.toInt()
                } catch (e: Exception) {
                    println("Falsche Eingabe")
                    return null
                }

                println("Kundenaccount $name wird erstellt.")
                val kundenaccount: Kundenaccount = Kundenaccount(name, passwort2, alter)
                kundenAccountListe.add(kundenaccount)
                return kundenaccount
            } else {
                println("Passwörter stimmen nicht überein!")
                return kundenAccountErstellen()
            }
            return Kundenaccount()
            //Wird solange gemacht bis die Passwörter übereinstimmen.
        } while (passwort1 == passwort2)
    }

    //AltersKontrolle für Methode logIN
    fun mindestAlterTesten(alter: Int): Boolean {
        if (alter >= mindestalter) {
            return true
        } else return false
    }

    //Main.kt ist eine When-Verzweigung, die kontrolliert ob man sich einloggen möchte ein Kundenaccount erstellen will.
    // Der RückgabeWert wird in der When-Verzweigung nicht benötigt.
    fun logIn(): Account? {
        println("Log-In")
        println("Benutzername eingeben:")
        val benutzername: String = readln()
        println("Passwort eingeben:")
        val passwort: String = readln()

        //für jeden Admin aus Liste wird Benutzername und Passwort verglichen
        for (admin in adminAccountListe) {
            //Kontrolle ob der Admin in der Liste ist und ob der Name und das gespeicherte Passwort Klasse Account übereinstimmt.
            //Klasse account hat ein LogIn, der das übergebene Passwort mit dem protected Passwort kontrolliet und false oder true zurück gibt.
            if (admin.benutzername == benutzername && admin.logIn(passwort)) {
                //Aktueller LogIn wird auf Admin gesetzt
                aktuellerLogIn = admin
                println("Admin ${admin.benutzername} erfolgreich eingeloggt!")
                wilkommenBildschirm()
                return admin
            }
            //für jeden Kunden aus Liste wird Benutzername und Passwort verglichen
            for (kunde in kundenAccountListe) {
                //Kontrolle Benutzername und Passwort übereinstimmen
                //Klasse account hat ein LogIn, der das übergebene Passwort mit dem protected Passwort kontrolliet und false oder true zurück gibt.
                if (kunde.benutzername == benutzername && kunde.logIn(passwort)) {
                    //Mindestalter 12 Jahre testen
                    if (mindestAlterTesten(kunde.alter)) {
                        aktuellerLogIn = kunde
                        println("Kunde ${kunde.benutzername} erfolgreich eingeloggt!")
                        wilkommenBildschirm()
                        return kunde
                    } else {
                        println("Sie sind nicht alt genug, um sich anzumelden.")
                        return null
                    }

                }
            }
        }
        println("Account nicht vorhanden oder falsches Passwort...")
        return null
    }

    //Log-Out und für Adminoptionen und Kundenoptionen
    fun logOut() {
        aktuellerLogIn?.logOut() //Methode von Klasse Account
        aktuellerLogIn = null
        println("Ausgeloggt!")
    }

    // In der Main.kt ist eine When Verzweigung die aktuellerLogin auf Admin oder Kunde kontrolliert.
    // Die jeweilige Funktion wird ausgeführt je nach Kunde oder Admin.
    // Funtkion adminOptionen die alle Methoden hat, die der Admin benötigt.
    fun adminOptionen() {
        do {
            Thread.sleep(100)
            println("Admin-Option:")
            Thread.sleep(100)
            println("1 -> Produkte anzeigen")
            Thread.sleep(100)
            println("2 -> Produkt hinzufügen")
            Thread.sleep(100)
            println("3 -> Produkt nachbestellen")
            Thread.sleep(100)
            println("4 -> Produkt löschen ")
            Thread.sleep(100)
            println("5 ->\u001B[31m Ausloggen\u001B[0m")
            // readInt Funktion von Gordon Lucas
            val input: Int = readInt(1..5)
            var exit: Boolean = false

            when (input) {
                1 -> {
                    produkteAnzeigen()
                }

                2 -> {
                    produktHinzufuegen()
                }

                3 -> {
                    produktNachbestellen()
                }

                4 -> {
                    produktLoeschen()
                }

                5 -> {
                    logOut()
                    //wenn der Admin sich ausloggt wird der exit auf false gesetzt und somit die Do-While Schleife beendet.
                    exit = true
                }

                else -> {
                    println("Falsche eingabe.")
                }
            }
            // DO-While Schleife solange jemand eingeloggt ist.
        } while (!exit)
    }

    // In der Main.kt ist eine When Verzweigung die aktuellerLogin auf Admin oder Kunde kontrolliert.
    // Die jeweilige Funktion wird ausgeführt je nach Kunde oder Admin.
    // Funktion kundenOptionen die alle Methoden hat, die der Kunde benötigt.
    fun kundenOptionen(kunde: Kundenaccount) {
        var exit: Boolean = false
        do {
            Thread.sleep(100)
            println("Kunden-Optionen:")
            Thread.sleep(100)
            println(" 1 -> Produkte anzeigen")
            Thread.sleep(100)
            println(" 2 -> Produkte nach Unter-Kategorie filtern")
            Thread.sleep(100)
            println(" 3 -> Produkte nach Preis sortieren")
            Thread.sleep(100)
            println(" 4 -> Produkte nach Alphabet sortieren")
            Thread.sleep(100)
            println(" 5 -> Warenkorb Produkt hinzufügen")
            Thread.sleep(100)
            println(" 6 -> Warenkorb anzeigen")
            Thread.sleep(100)
            println(" 7 -> Warenkorb Produkt löschen")
            Thread.sleep(100)
            println(" 8 -> Warenkorb leeren")
            Thread.sleep(100)
            println(" 9 -> Warenkorb Gesamtpreis anzeigen")
            Thread.sleep(100)
            println("10 -> Zahlungsmethode hinzufügen")
            Thread.sleep(100)
            println("11 -> Warenkorb bezahlen")
            Thread.sleep(100)
            println("12 -> Produkt bewerten")
            Thread.sleep(100)
            println("13 -> Gekaufte Produkte anzeigen")
            Thread.sleep(100)
            println("14 ->\u001B[31m Ausloggen\u001B[0m")
            // readInt Funktion von Gordon Lucas
            val input: Int = readInt(1..14)

            when (input) {
                1 -> {
                    produkteAnzeigen()
                }

                2 -> {
                    filternNachUnterKategorie()
                }

                3 -> {
                    sortierenNachPreis()
                }

                4 -> {
                    sortierenNachAlphabet()
                }

                5 -> {
                    warenkorbProduktHinzufuegen(kunde)
                }

                6 -> {
                    warenkorbAnzeigen(kunde)
                }

                7 -> {
                    warenkorbProduktLoeschen(kunde)
                }

                8 -> {
                    warenkorbLeeren(kunde)
                }

                9 -> {
                    //Kontrolle ob der gesamtPreis nicht null ist ansonsten bedeutet das der Warenkorb leer ist.
                    val gesamtPreis = warenkorbGesamtpreis(kunde)
                    if (gesamtPreis != null) {
                        println("Gesamtpreis : $gesamtPreis €")
                    } else {
                        println("Warenkorb ist leer.")
                    }
                }

                10 -> {
                    println("Bitte geben sie die Zahlungsmethode ein:")
                    val zahlungsMethode = readln()
                    //Kundenoptionen ist auf Aktuellen Login bezogen, deswegen muss nur die Zahlugsmethode eingegeben werden.
                    zahlungsMethodehinzufuegen(kunde, zahlungsMethode)
                }

                11 -> {
                    //Kundenoptionen ist auf Aktuellen Login bezogen.
                    warenkorbBezahlen(kunde)
                }

                12 -> {
                    produktBewerten()
                }

                13 -> {
                    kunde.gekaufteProdukteAnzeigen()
                }

                14 -> {
                    logOut()
                    //wenn der Kunde sich ausloggt wird der exit auf false gesetzt und somit die Do-While Schleife beendet.
                    exit = true
                }

                else -> {
                    println("Falsche Eingabe")
                }
            }
            // DO-While Schleife solange jemand eingeloggt ist.
        } while (!exit)
    }

    fun produkteAnzeigen() {
        //für jedes Produkt in ProduktListe wird die Methode produktAnzeigen aus Klasse Produkt ausgeführt.
        for (produkt in produktListe) {
            produkt.produktAnzeigen()
            Thread.sleep(250)
        }
    }

    fun produktHinzufuegen() {
        println("Produkt hinzufügen:")
        println("Name des Produkts:")
        val name: String = readln()
        println("Preis von $name:")
        val preis: Double = readln().toDouble()
        println("Produktnummer:")
        val produktNummer: Int = readln().toInt()
        println("Anzahl:")
        val anzahl: Int = readln().toInt()
        //Objekt-Instanziierung Produkt
        val produkt: Produkt = Produkt(name, preis, produktNummer, anzahl)
        produktListe.add(produkt)
        println("Produkt hinzugefügt: ${produkt.name}")
    }

    fun produktNachbestellen() {
        println("Produkt nachbestellen:")
        println("Produktnummer eingeben:")
        var produktNummer: Int = 0
        //Try Catch weil es darf nur Int eingegeben werden.
        try {
            produktNummer = readln().toInt()
        } catch (e: Exception) {
            println("Falsche Eingabe:")
        }
        //Es wird das Produkt aus der Produktnummer zurück gegeben.
        val produkt: Produkt? = produktNachProduktNummer(produktNummer)
        //Wenn das die Produktnummer auf ein Produkt zugewiesen ist, wird die Menge gefragt.
        if (produkt != null) {
            println("Anzahl eingeben:")
            var anzahl: Int = 0
            //Es darf nur Integer eingeben werden.
            try {
                anzahl = readln().toInt()
            } catch (e: Exception) {
                println("Falsche Eingabe")
            }
            //Finde die Das Produkt aus der ProduktListe über die eingegebene Produktnummer.
            val vorhandenesProdukt = produktListe.find { it.produktnummer == produkt.produktnummer }
            //Wenn das Produkt in der Produktliste vorhanden ist.
            if (vorhandenesProdukt != null) {
                //Die Menge des Produktes aud der Produkt liste wird um die eingegeben Anzahl erhöht.
                vorhandenesProdukt.anzahl += anzahl
                //Wenn das vorhandene Produkt ausverkauft ist, wird die verfügbarkeit auf true gesetzt.
                //Weil wenn das Produkt ausverkauft ist wird es gar nicht aus der Liste gelöscht.
                //Es existiert eine Methode in Klasse Produkt die automatisch auf false setzt wenn die Produktmenge 0 ist.
                if (!vorhandenesProdukt.verfuegbar) {
                    vorhandenesProdukt.verfuegbar = true
                }
                println("$anzahl Stück ${produkt.name} wurden nachbestellt!")
            } else {
                println("Produkt mit Produktnummer $produktNummer nicht gefunden.")
            }
        } else {
            println("Produkt mit Produktnummer $produktNummer nicht gefunden.")
        }

    }

    fun produktLoeschen() {
        println("Produkt löschen:")
        println("Produktnummer eingeben:")
        val input: Int = readln().toInt()
        // Produkt Rückgabe über Produktnummer
        val produkt: Produkt? = produktNachProduktNummer(input)
        //wenn Produkt vorhanden ist
        if (produkt != null) {
            val index = produktListe.indexOf(produkt)
            //indexOf gibt -1 zurück wenn das Produkt nicht gefunden wird
            //produkt muss da sein sonst -1
            if (index != -1) {
                //Wenn Produkt da, wird die Azahl auf 0 gesetzt und verfügbarkeit auf False
                produktListe[index].anzahl = 0
                produktListe[index].verfuegbar = false
                println("Produkt ${produkt.name} entfernt.")
            } else {
                println("Produkt mit der Produktnummer $input nicht gefunden.")
            }

        } else {
            println("Produkt mit der Produktnummer $input nicht gefunden.")
        }

    }

    //Produkt Rückgabewert über Produktnummer
    fun produktNachProduktNummer(produktNummer: Int): Produkt? { //damit ich produkt löschen kann
        //Durchsucht das Produkt in der Produktliste und gibt aus, ob das Produkt in der ProduktListe ist, ansonsten Null.
        for (produkt in produktListe) {
            if (produkt.produktnummer == produktNummer) {
                return produkt
            }
        }
        return null
    }

    fun filternNachUnterKategorie() {
        println("Bitte gib eine Unterkategorie ein:")
        val unterkategorie: String = readln()
        //Separate Liste für die gefilterten Produkte.
        val gefilterteProdukte = mutableListOf<Produkt>()
        //für jedes Produkt in produktListe
        for (produkt in produktListe) {
            // nach Elekltronik filtern und nach Produkt filtern
            // Wenn Produkt in Klasse Elektronik ist und der Typ (Laptop/Monitor) der Eingabe entspricht,
            // Oder wenn Produkt in Klasse Film ist und der Typ (Action/Fantasy) der Eingabe entspricht,
            //dann wird das Produkt in die gefilterte Produktliste eingefügt/implementiert.
            if ((produkt is Elektronik && produkt.typ == unterkategorie) || (produkt is Film && produkt.genre == unterkategorie)) {
                gefilterteProdukte.add(produkt)

            }
        }
        //Kontrolle ob in der gefilterten ProduktListe was drin ist.
        if (gefilterteProdukte.isNotEmpty()) {
            println("Produkte in der Unterkategorie $unterkategorie:")
            //Ausgabe für jedes Produkt in der ProduktListe.
            for (produkt in gefilterteProdukte) {
                //Methode produktAnzeigen aus Klasse Produkt.
                produkt.produktAnzeigen()
                Thread.sleep(250)
            }
        } else {
            println("Keine Produkte in der UnterKategorie")
        }
    }


    fun sortierenNachPreis() {
        //Unterschied zu sortby sie gibt keine neue Liste wieder.
        //Es wird nach Eigenschaft preis sortiert.
        val sortierteProduktListe = produktListe.sortedBy { it -> it.preis }
        println("Produkte nach Preis sortiert:")
        //für jedes Produkt in der sortierten Produktliste alle Eigenschaften ausdrucken.
        //methode .produktAnzeigen aus Klasse Produkt sonst kommt nur die Referenz raus
        for (produkt in sortierteProduktListe) {
            produkt.produktAnzeigen()
            Thread.sleep(250)
        }
    }


    fun sortierenNachAlphabet() {
        //Unterschied zu sortByDescending keine neue Liste
        //sortedByDescending absteigend sortieren
        //sortedBy nach kriterum sortieren
        // Es wird nach Eigenschaft name sortiert
        val sortierteProduktListe = produktListe.sortedBy { it -> it.name.lowercase() }// mit kleinem i in der Sortierung,funktioniert!!! :)
        println("Produkte nach Alphabet sortiert:")
        //Methode produktAnzeigen aus Klasse Produkt, sonst kommt nur die Referenz raus.
        for (produkt in sortierteProduktListe) {
            produkt.produktAnzeigen()
            Thread.sleep(250)
        }
    }

    //aktueller LogIn ist Kundenaccount
    fun warenkorbProduktHinzufuegen(kunde: Kundenaccount) {
        println("Produktnummer eingeben:")

        val produktNummer: Int = readln().toInt()
        //Produkt Rückgabe über Produktnummer
        val produkt: Produkt? = produktNachProduktNummer(produktNummer)
        //Kontrolle ob Produkt vorhanden in der Produktliste (Produktlager) ist.
        if (produkt != null) {
            println("Menge eingeben:")
            val menge: Int = readln().toInt()
            //Kontrolle ob eine Menge eingeben wurde
            if (menge > 0) {
                //Kontrolle ob der Kunde ein Warenkorb besitzt, wenn nicht wird ein neuer erstellt.
                //Dabei ist der Key der Kunde und das Value die MutableMap aus Produkt und Produktmenge.
                if (!warenkorb.containsKey(kunde)) {
                    //Kunde bekommt ein neuen Warenkorb.
                    warenkorb[kunde] = mutableMapOf()
                }
                //Warenkorb gespeichert, ist aufjedenfall da, wurde oben erstellt.
                val warenkorbKunde = warenkorb[kunde]!!
                //Kontrolle ob die Menge die man hinzufügen will, auf Lager ist.
                if (produkt.anzahl >= menge) {
                    //Kontrolle ob das Produkt bereits im Warenkorb ist, weil dann muss nur die Menge hinzugefügt werden.
                    if (warenkorbKunde.containsKey(produkt)) {
                        warenkorbKunde[produkt] = warenkorbKunde[produkt]!! + menge
                    } else {
                        //Wenn der Warenkorb des Kunden noch nicht von dem Produkt was im Warenkorb hat, wird eine Produkt+Menge in der MutableMap angelegt.
                        warenkorbKunde[produkt] = menge
                    }
                    //Aus dem Produktliste wird die Menge abgezogen, die in den Warenkorb gelegt wurde.
                    produkt.anzahl -= menge

                    println("$menge Stück ${produkt.name} wurde zum Warenkorb von ${kunde.benutzername} hinzugefügt.")

                } else {
                    println("Nicht genügend Produkte auf Lager.")
                }

            } else {
                println("Die Menge muss größer als 0 sein.")
            }
        } else {
            println("Produkt mit der Produktnummer $produktNummer nicht gefunden.")
        }

    }

    //aktueller LogIn ist Kundenaccount
    fun warenkorbAnzeigen(kunde: Kundenaccount) {
        //Kunde ist der key und Value das Produkt und die Menge
        //Weil das eine Map mit Kundenaccounts ist muss zuerst der Kunde ausgewählt werden.
        val warenkorbKunde = warenkorb[kunde]
        //Wenn der Kunde ein Warenkorb besitzt und der Warenkorb nicht null ist, wird der Warenkorb angezeigt.
        if (warenkorbKunde != null && warenkorbKunde.isNotEmpty()) {
            println("Warenkorb für ${kunde.benutzername}:")
            //Es wird für jedes Produkt mit Eigenschaften Name/Anzahl ausgedruckt.
            for ((produkt, menge) in warenkorbKunde) {
                println("Produkt: ${produkt.name} | Menge: $menge")
            }
            //Ansosnten ist der Warenkorb leer oder Kunde hat noch kein Warenkorb.
        } else {
            println("Der Warenkorb für ${kunde.benutzername} ist leer.")
        }
    }

    //aktueller LogIn ist Kundenaccount
    fun warenkorbProduktLoeschen(kunde: Kundenaccount) {
        println("Geben Sie die Produktnummer ein:")
        val input: String = readln()
        //Produkt Rückgabe über Produktnummer
        val produkt: Produkt? = produktSuchen(input)
        //Kontrolle ob die Produktnumer existiert.
        if (produkt != null) {
            //Warenkorb des Kunden wird abgerufen.
            val warenkorbKunde = warenkorb[kunde]
            //Kontrolle ob Warenkorb existiert.
            if (warenkorbKunde != null) {
                //Kontrolle ob das gesuchte Produkt im Warenkorb des Kunden enthalten ist.
                if (warenkorbKunde.containsKey(produkt)) {
                    println("Aktuellle Menge im Warenkorb für ${produkt.name}: ${warenkorbKunde[produkt]}")
                    println("Geben sie die Menge ein, die sie etnfernen möchten:")
                    //Funktion von Gordon Lucas
                    val mengeLoeschen: Int = readInt(0..10)
                    //Wenn die eningegebe Menge die gelsöcht werden soll, größer als 0 ist und kleiner gleich als die Menge im Warenkorb
                    //Die zu löschende Menge darf nicht größer sein, als die Menge im Warenkorb des Kunden.
                    if (mengeLoeschen > 0 && mengeLoeschen <= warenkorbKunde[produkt]!!) {
                        //Das Produkt wird neu eingefügt mit der gelöschten menge als Value die von alten Value aus Warenkorb subtrahiert wurde.
                        warenkorbKunde[produkt] = warenkorbKunde[produkt]!! - mengeLoeschen
                        //Wenn das Produkt danach Menge 0 hat
                        //falls das Produkt Menge 0 hat wird komplett raugeslöscht
                        if (warenkorbKunde[produkt] == 0) {
                            warenkorbKunde.remove(produkt)
                        }
                        //Anzeige was gelöscht wurde
                        println("$mengeLoeschen Stück von ${produkt.name} wurde aus dem Warenkorb entfernt.")
                        //Die Menge ist zu groß oder kleiner als 0
                    } else {
                        println("Ungültige Menge, bitte geben sie eine gültige Menge ein.")
                    }
                } else {
                    println("Das Produkt befindet sich nicht im Warenkorb ")
                }
            } else {
                println("Der Warenkorb des Kunden ist leer.")
            }
        } else {
            println("Das Produkt wurde nicht gefunden.")
        }

    }

    //aktueller LogIn ist Kundenaccount
    fun warenkorbLeeren(kunde: Kundenaccount) {
        val warenkorbKunde = warenkorb[kunde]
        //Kontrolle ob aufgerufener Warenkorb vorhanden ist.
        if (warenkorbKunde != null) {
            //Warenkorb löschen
            warenkorbKunde.clear()
            println("Warenkorb von ${kunde.benutzername} wurde geleert.")
        } else {
            println("Warenkorb von ${kunde.benutzername} ist bereits leer.")
        }
    }

    //aktueller LogIn ist Kundenaccount
    fun warenkorbGesamtpreis(kunde: Kundenaccount): Double? {
        val warenkorbKunde = warenkorb[kunde]
        //Kontrolle ob aufgerufener Warenkorb vorhanden ist.
        if (warenkorbKunde != null) {
            //Variable erstellen
            var gesamtpreis = 0.0
            //Für jedes Produkt im Warenkorb wird die Eigenschaft Preis von Podukte mit ihren Mengen multipliziert
            //das läuft für jedes Produkt so.
            for ((produkt, menge) in warenkorbKunde) {
                gesamtpreis += produkt.preis * menge
            }
            return gesamtpreis
        }
        return null
    }

    //aktueller LogIn ist Kundenaccount und die Zahlungsmethode wird in der When-Verzweigung abgefragt.
    fun zahlungsMethodehinzufuegen(kunde: Kundenaccount, zahlungsmethode: String) {
        //Kontrolle ob Map Zahlungsmethoden den Kunden NICHT mit der Zahkungsmethode vorhande ist.
        if (!zahlungsmethoden.containsKey(kunde)) {
            //Es wird eine neuer Key Kunde mit eine leeren MutableList als Value erstellt
            zahlungsmethoden[kunde] = mutableListOf()
        }
        //Zahlungsmethode wird als value zum key des Kunden hinzugefügt.
        zahlungsmethoden[kunde]?.add(zahlungsmethode)
        println("Zahlungsmethode $zahlungsmethode wurde für Kunde ${kunde.benutzername} hinzugefügt. ")
    }

    //aktueller LogIn ist Kundenaccount.
    fun warenkorbBezahlen(kunde: Kundenaccount) {
        //Der geforderte Warenkorb wird abgerufen.
        val warenkorbKunde = warenkorb[kunde]
        //Kontrolle ob Warenkorb vorhanden ist
        if (warenkorbKunde != null) {
            //Die geforderte Zahlungsmethode wird des Kunden wird abgerufen.
            val zahlungsmethodeKunde = zahlungsmethoden[kunde]
            //Kontrolle ob Zahlungsmethode zum Kunden zugewiesen ist und die die Zahlungsmethode leer ist.
            if (zahlungsmethodeKunde != null && zahlungsmethodeKunde.isNotEmpty()) {
                //Es wird die erste gespeicherte Zahlungsmethode aus der Liste genommen
                val zahlungsmethode = zahlungsmethodeKunde.first()
                println("Bitte geben sie die Zahlungsmethode ein:")
                val inputZahlungsmethode = readln()
                //Kontrolle ob was eingegeben wurde und ob die Zahlungsmethode schon hinterelgt ist.
                if (inputZahlungsmethode != null && inputZahlungsmethode == zahlungsmethode) {
                    //für jedes produkt aus dem Warenkorb des Kunden wird name/menge angezigt und für jedes Produkt
                    //aus dem Warenkorb wird die Menge im Lager angezeigt. Für die Kontrolle
                    for ((produkt, menge) in warenkorbKunde) {
                        println("Produkt: ${produkt.name}, Menge im Warenkorb: $menge, Lagerbestand: ${produkt.anzahl}")
                        //Methode gekauftePrdukte aus Klasse Kundenaccount fügt das Produkt und die Menge von Warenkorb
                        //in die gekaufte Produktliste
                        kunde.gekaufteProdukteHinzufuegen(produkt, menge)
                    }
                    println("Der Warenkorb wurde bezahlt!")
                    //Methode die den value was eine Map ist vom Key des kunden aus dem Warenkorb entfernt
                    warenkorbLeeren(kunde)
                } else {
                    println("Ungültige Zahlungsmethode.")
                }
                //ansonten wird eine neue Zahlungsmethode hinzugefügt.
            } else {
                println("Es sind keine Zahlungsmethoden hinterlegt.")
                println("Möchten Sie eine Zahlungsmethode hinzufügen? (Ja/Nein)")
                val antwort = readln()
                //Kontrolle ob was eingegeben wurde und ob die antwort ja ist
                if (antwort != null && antwort == "JA" || antwort == "ja" || antwort == "Ja") {
                    println("Bitte geben sie die Zahlungsmethode ein:")
                    val input: String = readln()
                    //Methode Zahlungsmethode hinzufügen
                    zahlungsMethodehinzufuegen(kunde, input)
                    // Nach dem die Zahlungsmethode hinzugefügt wurde, wird wider von vorne begnonnen mit dem Bezahlvorgang
                    warenkorbBezahlen(kunde) // Wiederholen Sie den Bezahlvorgang nach dem Hinzufügen der Zahlungsmethode
                } else {
                    println("Bezahlvorgang abgebrochen.")
                }
            }
        } else {
            println("Warenkorb des Kunden ist leer.")
        }
    }

    //produktSuchen für Methode warenkorbProduktloeschen und produktBewerten
    private fun produktSuchen(input: String): Produkt? {
        //für jedes Produkt aus der Produktliste
        for (produkt in produktListe) {
            //wenn der Produkt name dem Input entspricht
            //wird produkt zurück gegeben also das gesuchte Produkt ist in der Produktlute vorhanden
            if (produkt.name == input) {
                return produkt
            }
        }
        //Kontrolle ob der input direkt eine Produktnummer ist und ob es ein Integer ist.
        try {
            val produktnummer = input.toInt()
            //für jedes produkt in der Produktliste
            for (produkt in produktListe) {
                //wenn die Produktnummeer dem Input entspricht
                //wird produkt zurück gegeben also das gesuchte Produkt ist in der Produktlute vorhanden
                if (produkt.produktnummer == produktnummer) {
                    return produkt

                }
            }
        } catch (e: Exception) {
            println("Falsche Eingabe")
        }
        //anosnten exisrtiert das Produkt nicht
        return null
    }

    fun produktBewerten() {
        //Kontrolle ob jemand eingeloggt ist
        if (aktuellerLogIn != null) {
            println("Geben Sie die Produktnummer ein oder Produktnamen ein :")
            val produktInput = readln()
            //Es wird nach das gesuchte Produkt aus der Produkliste als Konstante gespeichert.
            val produkt: Produkt? = produktSuchen(produktInput)
            //Kontrolle ob Produkt in der Produktliste vorhanden ist
            if (produkt != null) {
                println("Bewerten Sie mit Sternen von 1.0 - 5.0")
                val bewertung: Double = readln().toDouble()
                //Kontrolle ob die Bewertung zwischen 0.0 und 5.0 liegt.
                if (bewertung <= 0.0 || bewertung > 5.0) {
                    println("Ungültige Bewertung. Die Bewertung muss zwischen 0.0 und 5.0 liegen.")
                } else {
                    //Kundenrezension ist eine Map mit Kundenaccount als Key und Value eine Map aus Produkt und Bewertung Double.

                    //Es wird eine Konstante kundBewertung hinterlegt die die Bewertung des aktuellen Nutzers für verschiedene Produkte enthält
                    // Es wird überprüft ob kundenrezensionen eine Bewertung für den Aktuellen Kundenaccount enhät
                    val kundeBewertung = if (kundenrezensionen.containsKey(aktuellerLogIn as Kundenaccount)) {
                        //Wenn Der Kunde als Key in der MutableMap der Kundenrenzionen vorhanden ist, dann wird nach if übersprungen
                        kundenrezensionen[aktuellerLogIn as Kundenaccount]!!
                    } else {
                        //Es wird ein Kundenaccount als Key erstellt mit einer leeren mutableMap für die Kundenrezensionen
                        kundenrezensionen[aktuellerLogIn as Kundenaccount] = mutableMapOf()
                        //damit wird auf die gerade eben erstellt Map zugegriffen also das val KundenBewertung
                        kundenrezensionen[aktuellerLogIn as Kundenaccount]!!
                    }
                    //Hier wird die Bewertung für das ausgewählte Produkt gespeichert als value des key ist der Kunde
                    kundeBewertung[produkt] = bewertung
                    //hier wird der Durschnitt aller Bewertung des Kunden ausgerechnet.
                    val durchscnitt = kundeBewertung.values.average()
                    println("Produkt ${produkt.name} wurde bewertet. Durchschnittliche Bewertung: $durchscnitt")
                }
            } else {
                println("Produkt nicht gefunden")
            }
        } else {
            println("Niemand ist eingeloggt")
        }
    }
}