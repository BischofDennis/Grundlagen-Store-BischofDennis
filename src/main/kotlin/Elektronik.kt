open class Elektronik(
    name: String,
    preis: Double,
    produktnummer: Int,
    verfuegbar: Boolean,
    anzahl: Int,
    val typ: String,
    val marke: String,
    val garantie: Int
) : Produkt(name, preis, produktnummer, verfuegbar, anzahl) {

    override fun produktAnzeigen() {
        super.produktAnzeigen()
        println("Typ: $typ")
    }
}