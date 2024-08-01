class Fantasy(
    name: String,
    preis: Double,
    produktnummer: Int,
    verfuegbar: Boolean,
    anzahl: Int,
    regisseur: String,
    val beschreibung: String
) : Film(name, preis, produktnummer, verfuegbar, anzahl, "Fantasy", regisseur)