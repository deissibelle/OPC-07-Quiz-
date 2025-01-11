package org.example

import kotlin.system.exitProcess

fun main() {
    println("Bienvenue dans le Quiz Kotlin ! 🎉")

    // Enregistrement de l'utilisateur
    print("Entrez votre nom : ")
    val userName = readLine().orEmpty()
    println("Bonjour $userName, prêt pour le quiz ? 🚀")

    // Sélection du domaine
    val domains = listOf("Mathématiques", "Science", "Histoire", "Géographie")
    println("\nChoisissez un domaine parmi les suivants :")
    domains.forEachIndexed { index, domain -> println("${index + 1}. $domain") }
    print("Votre choix (1-${domains.size}) : ")
    val domainChoice = readLine()?.toIntOrNull() ?: 1
    val selectedDomain = domains.getOrElse(domainChoice - 1) { "Mathématiques" }
    println("Vous avez choisi le domaine : $selectedDomain\n")

    // Questions par domaine (10 questions par catégorie)
    val questions = mapOf(
        "Mathématiques" to listOf(
            "Combien font 2 + 2 ?" to listOf("3", "4", "5", "6"),
            "Combien font 5 x 5 ?" to listOf("20", "25", "30", "35"),
            "Quelle est la racine carrée de 16 ?" to listOf("3", "4", "5", "6"),
            "Combien font 10 - 7 ?" to listOf("2", "3", "4", "5"),
            "Quel est le résultat de 7 x 6 ?" to listOf("41", "42", "43", "44"),
            "Combien font 9 + 8 ?" to listOf("16", "17", "18", "19"),
            "Combien font 100 ÷ 4 ?" to listOf("24", "25", "26", "27"),
            "Combien font 12 x 12 ?" to listOf("140", "144", "148", "152"),
            "Quelle est la valeur de Pi approximativement ?" to listOf("2.14", "3.14", "4.14", "5.14"),
            "Combien font 15 - 8 ?" to listOf("6", "7", "8", "9")
        ),
        "Science" to listOf(
            "Quelle est la formule chimique de l'eau ?" to listOf("H2O", "CO2", "O2", "H2"),
            "Quelle planète est connue comme la planète rouge ?" to listOf("Terre", "Mars", "Jupiter", "Saturne"),
            "Quelle est la principale source d'énergie sur Terre ?" to listOf("Lune", "Soleil", "Vent", "Eau"),
            "Quelle est l'unité de mesure de la force ?" to listOf("Joule", "Newton", "Watt", "Pascal"),
            "Quel est l'état de l'eau à 100°C ?" to listOf("Solide", "Liquide", "Gaz", "Plasma"),
            "Quel organe pompe le sang dans le corps ?" to listOf("Poumon", "Cœur", "Foie", "Reins"),
            "Quel gaz les plantes absorbent-elles ?" to listOf("Oxygène", "Dioxyde de carbone", "Azote", "Hélium"),
            "Quel est l'élément chimique ayant pour symbole 'O' ?" to listOf("Or", "Oxygène", "Os", "Osmium"),
            "Quel est le métal liquide à température ambiante ?" to listOf("Mercure", "Plomb", "Fer", "Aluminium"),
            "Quelle est la vitesse de la lumière ?" to listOf("300 000 km/s", "150 000 km/s", "1 000 km/s", "3 000 km/s")
        ),
        "Histoire" to listOf(
            "Qui a été le premier président des États-Unis ?" to listOf("Lincoln", "Washington", "Jefferson", "Roosevelt"),
            "Quelle année a marqué la fin de la Seconde Guerre mondiale ?" to listOf("1940", "1945", "1950", "1960"),
            "En quelle année la Révolution française a-t-elle commencé ?" to listOf("1776", "1789", "1804", "1815"),
            "Qui était le chef de l'Empire romain ?" to listOf("César", "Napoléon", "Alexandre", "Clovis"),
            "Quel pays a construit la Grande Muraille ?" to listOf("Japon", "Chine", "Inde", "Corée"),
            "Quelle civilisation a construit les pyramides ?" to listOf("Grecque", "Égyptienne", "Maya", "Romaine"),
            "Qui a découvert l'Amérique ?" to listOf("Magellan", "Christophe Colomb", "Vasco de Gama", "Marco Polo"),
            "Quand l'Union européenne a-t-elle été créée ?" to listOf("1945", "1957", "1993", "2000"),
            "Qui était connu comme le Roi-Soleil ?" to listOf("Louis XIV", "Louis XVI", "Napoléon", "Charlemagne"),
            "Quelle guerre a eu lieu entre 1914 et 1918 ?" to listOf("Première Guerre mondiale", "Deuxième Guerre mondiale", "Guerre froide", "Guerre de Sécession")
        ),
        "Géographie" to listOf(
            "Quel est le plus grand océan du monde ?" to listOf("Atlantique", "Pacifique", "Arctique", "Indien"),
            "Quelle est la capitale de l'Australie ?" to listOf("Sydney", "Melbourne", "Canberra", "Brisbane"),
            "Quel désert est le plus grand du monde ?" to listOf("Gobi", "Sahara", "Kalahari", "Atacama"),
            "Quel est le fleuve le plus long du monde ?" to listOf("Nil", "Amazon", "Yangzi Jiang", "Mississippi"),
            "Quel pays a le plus de population ?" to listOf("Inde", "Chine", "États-Unis", "Indonésie"),
            "Quelle chaîne de montagnes est la plus haute ?" to listOf("Alpes", "Himalaya", "Rocheuses", "Andes"),
            "Quel pays est surnommé le Pays du Soleil Levant ?" to listOf("Chine", "Japon", "Thaïlande", "Indonésie"),
            "Quel est le plus grand continent ?" to listOf("Afrique", "Asie", "Europe", "Amérique"),
            "Quelle mer borde la Grèce ?" to listOf("Mer Méditerranée", "Mer Noire", "Mer Baltique", "Mer Rouge"),
            "Quelle ville est connue comme la Ville Éternelle ?" to listOf("Athènes", "Rome", "Paris", "Londres")
        )
    )

    // Sélection des 10 questions du domaine choisi
    val selectedQuestions = questions[selectedDomain]?.take(10)
    if (selectedQuestions.isNullOrEmpty()) {
        println("Désolé, aucune question disponible pour ce domaine. 😞")
        exitProcess(0)
    }

    // Variables de score
    var score = 0

    // Démarrage du quiz
    println("\nLe quiz commence ! Vous avez 10 secondes par question. Bonne chance ! 🍀\n")
    selectedQuestions.forEachIndexed { index, (question, answers) ->
        println("Question ${index + 1}: $question")
        answers.forEachIndexed { i, answer -> println("${i + 1}. $answer") }

        print("Votre réponse (1-${answers.size}) : ")
        val userAnswer = readLine()?.toIntOrNull()
        if (userAnswer != null && answers.getOrNull(userAnswer - 1) == answers[1]) {
            println("✅ Bonne réponse !\n")
            score++
        } else {
            println("❌ Mauvaise réponse. La bonne réponse était : ${answers[1]}\n")
        }
    }

    // Résultats finaux
    println("\n🎯 Résultats finaux : $score/10")
    if (score >= 5) {
        println("Félicitations $userName, vous avez réussi le quiz ! 🎉")
    } else {
        println("Dommage $userName, vous avez échoué. Voulez-vous réessayer ? (oui/non)")
        val retry = readLine().orEmpty().lowercase()
        if (retry == "oui") main() else println("Merci d'avoir joué ! À bientôt. 👋")
    }
}
