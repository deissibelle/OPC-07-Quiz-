package org.example


import kotlin.system.exitProcess

fun main() {
    print("\n**================================================================================================****\n")
    println("**                                   Bienvenue dans le Quiz Kotlin !                              ****")
    println("*****=============================================================================================****")

    // Enregistrement de l'utilisateur

    print("Entrez votre nom : ")
    val userName = readLine().orEmpty()
    println(" salut😊 $userName, prêt pour le quiz ? ")

    // Sélection du domaine
    val domains = listOf("Mathématiques", "Science", "Histoire", "Géographie")
    println("\n Choisissez un domaine parmi les suivants :")
    domains.forEachIndexed { index, domain -> println("${index + 1}. $domain") }
    print("Votre choix (1-${domains.size}) : ")
    val domainChoice = readLine()?.toIntOrNull() ?: 1
    val selectedDomain = domains.getOrElse(domainChoice - 1) { "Mathématiques" }
    println("Vous avez choisi le domaine : $selectedDomain\n")

    // Questions par domaine (10 questions par catégorie)
    val questions = mapOf(
        "Mathématiques" to listOf(
            "Combien font 2 + 2 ?" to "4",
            "Combien font 5 x 5 ?" to "25",
            "Quelle est la racine carrée de 16 ?" to "4",
            "Combien font 10 - 7 ?" to "3",
            "Quel est le résultat de 7 x 6 ?" to "42",
            "Combien font 9 + 8 ?" to "17",
            "Combien font 100 ÷ 4 ?" to "25",
            "Combien font 12 x 12 ?" to "144",
            "Quelle est la valeur de Pi approximativement ?" to "3.14",
            "Combien font 15 - 8 ?" to "7"
        ),
        "Science" to listOf(
            "Quelle est la formule chimique de l'eau ?" to "H2O",
            "Quelle planète est connue comme la planète rouge ?" to "Mars",
            "Quelle est la principale source d'énergie sur Terre ?" to "Soleil",
            "Quelle est l'unité de mesure de la force ?" to "Newton",
            "Quel est l'état de l'eau à 100°C ?" to "Gaz",
            "Quel organe pompe le sang dans le corps ?" to "Cœur",
            "Quel gaz les plantes absorbent-elles ?" to "Dioxyde de carbone",
            "Quel est l'élément chimique ayant pour symbole 'O' ?" to "Oxygène",
            "Quel est le métal liquide à température ambiante ?" to "Mercure",
            "Quelle est la vitesse de la lumière ?" to "300 000 km/s"
        ),
        "Histoire" to listOf(
            "Qui a été le premier président des États-Unis ?" to "Washington",
            "Quelle année a marqué la fin de la Seconde Guerre mondiale ?" to "1945",
            "En quelle année la Révolution française a-t-elle commencé ?" to "1789",
            "Qui était le chef de l'Empire romain ?" to "César",
            "Quel pays a construit la Grande Muraille ?" to "Chine",
            "Quelle civilisation a construit les pyramides ?" to "Égyptienne",
            "Qui a découvert l'Amérique ?" to "Christophe Colomb",
            "Quand l'Union européenne a-t-elle été créée ?" to "1993",
            "Qui était connu comme le Roi-Soleil ?" to "Louis XIV",
            "Quelle guerre a eu lieu entre 1914 et 1918 ?" to "Première Guerre mondiale"
        ),
        "Géographie" to listOf(
            "Quel est le plus grand océan du monde ?" to "Pacifique",
            "Quelle est la capitale de l'Australie ?" to "Canberra",
            "Quel désert est le plus grand du monde ?" to "Sahara",
            "Quel est le fleuve le plus long du monde ?" to "Nil",
            "Quel pays a le plus de population ?" to "Chine",
            "Quelle chaîne de montagnes est la plus haute ?" to "Himalaya",
            "Quel pays est surnommé le Pays du Soleil Levant ?" to "Japon",
            "Quel est le plus grand continent ?" to "Asie",
            "Quelle mer borde la Grèce ?" to "Mer Méditerranée",
            "Quelle ville est connue comme la Ville Éternelle ?" to "Rome"
        )
    )

    // Sélection des 10 questions du domaine choisi
    val selectedQuestions = questions[selectedDomain]?.shuffled()?.take(10)
    if (selectedQuestions.isNullOrEmpty()) {
        println("Désolé, aucune question disponible pour ce domaine. 😞")
        exitProcess(0)
    }

    // Variables de score
    var score = 0

    // Démarrage du quiz
    println("\nLe quiz commence ! Vous avez 10 secondes par question. Bonne chance ! 🍀\n")
    selectedQuestions.forEachIndexed { index, (question, correctAnswer) ->
        val wrongAnswers = questions.values.flatten().mapNotNull { it.second }.filter { it != correctAnswer }.shuffled().take(3)
        val allAnswers = (wrongAnswers + correctAnswer).shuffled()

        println("Question ${index + 1}: $question")
        allAnswers.forEachIndexed { i, answer -> println("${i + 1}. $answer") }

        print("Votre réponse (1-${allAnswers.size}) : ")
        val userAnswer = readLine()?.toIntOrNull()
        if (userAnswer != null && allAnswers.getOrNull(userAnswer - 1) == correctAnswer) {
            println("✅ Bonne réponse !\n")
            score++
        } else {
            println("❌ Mauvaise réponse. La bonne réponse était : $correctAnswer\n")
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
