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