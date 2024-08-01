class Laptop(
    name: String,
    preis: Double,
    produktnummer: Int,
    verfuegbar: Boolean,
    anzahl: Int,
    marke: String,
    garantie: Int,
    val bildschirmgroesse: Int,
    val beschreibung: String
) : Elektronik(name, preis, produktnummer, verfuegbar, anzahl, "Laptop", marke, garantie)