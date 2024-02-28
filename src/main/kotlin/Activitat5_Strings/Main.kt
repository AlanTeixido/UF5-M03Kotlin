package org.example.Activitat5_Strings
fun main() {
    // 1
    val exemples = listOf(
        "Amor a Roma",
        "Dábale arroz a la zorra el abad",
        "¿Será lodo o dólares?",
        "Sara Baras",
        "Llepa la pell",
        "A dit, sorprès, a l'obert avenc nevat, rebo la serp rostida.",
        "Malfia't, animal, astut rival. La virtut: salami, nata i flam.",
        "Truca'm a casa, camacurt!"
    )

    for (exemple in exemples) {
        println("$exemple és un palíndrom? ${esPalindrom(exemple)}")
    }

    println()

    // 2
    val frase2 = "Hola, com estàs avui?"
    val caracter = 'a'

    val aparicions = comptarAparicions(frase2, caracter)
    println("El caràcter '$caracter' apareix $aparicions vegades a la frase.")

    println()

    // 3
    val frase3 = "Això és una frase amb algunes paraules."
    val nombreParaules = comptarParaules(frase3)
    println("La frase té $nombreParaules paraules.")

    println()

    // 4
    val nifExemple = "12345678A"
    println("El NIF $nifExemple és correcte? ${validarNIF(nifExemple)}")

    println()

    // 5
    val textExemple = "Hola! Com anem? Cauen moltes coses, com ara iodes i iogurts, " +
            "a més d'una hiena i moltes joies"
    trobarDiftongs(textExemple)

    println()

    // 6
    val contrasenyaExemple = "P@ssw0rd"
    println("La contrasenya és vàlida? ${validarContrasenya(contrasenyaExemple)}")
}

fun esPalindrom(frase: String): Boolean {
    val fraseProcessada = frase
        .replace(Regex("[^a-z]"), "")

    return fraseProcessada == StringBuilder(fraseProcessada).reverse().toString()
}

fun comptarAparicions(frase: String, caracter: Char): Int {
    return frase.count { it == caracter }
}

fun comptarParaules(frase: String): Int {
    val paraules = frase.split(Regex("\\s+"))
    return paraules.size
}

fun validarNIF(nif: String): Boolean {
    return nif.matches(Regex("\\d{8}[A-Za-z]"))
}

fun trobarDiftongs(text: String) {
    val paraules = text.split(Regex("\\s+"))

    val diftongCreixentRegex = Regex("(?i)^[iu][aeiouáéíóúü]+")

    val paraulesAmbDiftongs = paraules.filter { paraula ->
        diftongCreixentRegex.find(paraula) != null
    }

    paraulesAmbDiftongs.forEach { println(it) }
}

fun validarContrasenya(contrasenya: String): Boolean {
    val digitRegex = Regex("\\d")
    val puntuacioRegex = Regex("[.,;:!?\\-_'\"()]")
    val majusculaRegex = Regex("[A-Z]")

    return contrasenya.length >= 6 &&
            digitRegex.containsMatchIn(contrasenya) &&
            puntuacioRegex.containsMatchIn(contrasenya) &&
            majusculaRegex.containsMatchIn(contrasenya)
}