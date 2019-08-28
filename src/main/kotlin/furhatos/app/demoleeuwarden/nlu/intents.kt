package furhatos.app.demoleeuwarden.nlu

import furhatos.nlu.Intent
import furhatos.util.Language

class NoIntent : Intent() {
    var no : ListOfNo? = null

    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "@no"
        )
    }
}

class YesIntent : Intent() {
    var yes : ListOfYes? = null

    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "@yes"
        )
    }
}

class NameRobotIntent : Intent() {
    var namerobot : ListOfNameRobot? = null

    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "@namerobot", "wie ben jij", "hoe @namerobot jij", "hoe kan ik jou @namerobot", "hoe @namerobot ik jou",
                "hoe wordt jij @namerbot", "hoe wordt je normaal @namerobot", "hoe kan ik jou @namerobot",
                "hoe wordt je @namerobot", "wat is jou @namerobot", "welke @namerobot heb jij", "wat is je @namerobot",
                "hoe spreek ik jou aan"
                )
    }
}

class NameWorkRobot : Intent() {
    var workrobot : ListOfWorkRobot? = null

    override fun getExamples(lang: Language): List<String> {
        return listOf(
                "@workrobot", "wat @workrobot bij Achmea" , "wat voor @workrobot "
        )
    }
}