//Funktion readInt von GordonLucas SyntaxInstitut
fun readInt(erlaubteZahlen: IntRange): Int {
    /* Können wir alle Laufzeitfehler verhindern?
        - Leere Eingabe
        - Eingabe enthält nicht nur Zahlen?
        - Zahl zu groß für Int?      (größte mögliche Zahl ist 2147483647)
        - Eingabe nicht eine der Möglichkeiten?  (hier zB 1..7)
     */
    val eingabe: String = readln()

    if (eingabe.length == 0) {
        println(" Sie haben eine leere Eingabe gemacht, versuchen sie es nochmal")
        return readInt(erlaubteZahlen)
    }

    if (eingabe.any { !it.isDigit() }) {
        println(" Sie können nur ganze Zahlen eingeben, versuchen sie es nochmal")
        return readInt(erlaubteZahlen)
    }

    if (eingabe.length > 9) {
        println(" Sie haben eine zu große Zahl eingegeben, versuchen sie es nochmal")
        return readInt(erlaubteZahlen)
    }

    val zahl = eingabe.toInt()

    if (zahl !in erlaubteZahlen) {
        println(" Sie haben eine ungültige Zahl eingegeben, versuchen sie es nochmal")
        return readInt(erlaubteZahlen)
    }

    return zahl
}


