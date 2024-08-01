open class Film(
    name: String,
    preis: Double,
    produktnummer: Int,
    verfuegbar: Boolean,
    anzahl: Int,
    val genre: String, //enum Klasse Klasse Action/Fantasy fällt weg
    val regisseur: String,
) : Produkt(name, preis, produktnummer, verfuegbar, anzahl) {

    //Mit .super werden die Eigenschaften/Methoden der Basis-Klasse abgerufen
    override fun produktAnzeigen() {
        super.produktAnzeigen()
        println("Genre: ${this.genre}")
    }
}
