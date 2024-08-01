open class Produkt(
    val name: String,
    val preis: Double,
    val produktnummer: Int,
    var verfuegbar: Boolean,
    var anzahl: Int
) {
    //sekundärer Konstuktor dafür da, wenn man ein neues Produkt hinzufügt.
    constructor(name: String,preis: Double,produktnummer: Int,anzahl: Int):this(name,preis,produktnummer,true,anzahl){
    }

    //Methode, die Eigenschaften von Produkte aus allen Kategorien anzeigen kann.
    open fun produktAnzeigen() {//this. benutzen sonst kommt Kotlin.unit raus
        println("Name: ${this.name} | Preis: ${this.preis}\uD83D\uDCB6 | Produktnummer: ${this.produktnummer} |Verfügbar:${this.verfuegbar()} | Anzahl:${this.anzahl}")
    }

    //Verfügbarkeit in Produktliste ändert sich automatisch auf False.
    fun verfuegbar(): Boolean {
        return this.anzahl > 0
    }


}

