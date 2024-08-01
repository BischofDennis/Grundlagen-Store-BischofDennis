class Action(
    name: String,
    preis: Double,
    produktnummer: Int,
    verfuegbar: Boolean,
    anzahl: Int,
    regisseur: String,
    val beschreibung: String//Parameter Genre wurde mit Default-Wert angegeben wegen Objektinstanziierung Klasse Action,
) : Film(name, preis,produktnummer, verfuegbar,anzahl,"Action", regisseur)// muss nicht jedes mal neu Definiert werden.