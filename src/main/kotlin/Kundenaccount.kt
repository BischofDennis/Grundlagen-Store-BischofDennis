class Kundenaccount(
    benutzername: String,
    passwort: String,
    alter: Int
) : Account(benutzername, passwort, alter) {
    //Eigenschaft/Attribut das nicht im Primären Konstruktor vorkommen soll
    val gekaufteProdukte: MutableMap<Produkt, Int> = mutableMapOf()

    //sekundärer Konstruktor für Kundenaccount erstellen.
    //Wenn man seine Daten falsch eingibt,
    //damit die Methode "kundenAccountErstellen" returnt werden kann.
    constructor() : this(benutzername = "", passwort = "", alter = 0) {
    }

    //init-Block wird jedes mal bei Objektinstanziierung mit ausgeführt
    init {
        println("Es wird ein Kundenaccount erstellt")
    }

    //override damit beim LogOut steht, das der Kundenaccount wurde ausgeloggt.
    override fun logOut() {
        println("Kundenaccount $benutzername ausgeloggt...")
    }

    //Eigenschaften von Kunde anzeigen.
    fun kundeAnzeigen(): String {
        val anzeige: String = "Name: ${this.benutzername} | Alter: ${this.alter}"
        return anzeige
    }

    //gekaufte Produktliste von Kundenaccount
    fun gekaufteProdukteHinzufuegen(produkt: Produkt, zusätzlicheAnzahl: Int) {
        //Kontrolle ob die gekaufteProduktListe das Produkt bereits erhählt,sonst wird doppeltes Produkt erstellt.
        val aktuelleAnzahl = if (gekaufteProdukte.containsKey(produkt)) {
            //aufjedenfall da wurde vorher kontrolliert
            gekaufteProdukte[produkt]!!
        } else {
            0
        }
        //Aktualiesieren der Integerzahl Menge von gekaufteProduktListe
        val neueAnzahl = aktuelleAnzahl + zusätzlicheAnzahl
        //Menge wird aktualisiert
        gekaufteProdukte[produkt] = neueAnzahl
    }

    //gekaufte ProduktListe anzeigen
    fun gekaufteProdukteAnzeigen() {
        println("Gekaufte Produkte von $benutzername:")
        //Kontrolle ob in der Liste was drin ist, ansonsten "leer".
        if (gekaufteProdukte.isNotEmpty()) {
            //for-Schleife die für jedes Produkt die Eigenschaften Name/Anzahl ausdruckt.
            gekaufteProdukte.forEach { produkt, anzahl -> println("Produkt: ${produkt.name} ${anzahl}stk") }
        } else {
            println("Keine Produkte gekauft.")
        }
    }

}