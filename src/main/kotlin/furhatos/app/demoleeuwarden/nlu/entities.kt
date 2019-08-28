package furhatos.app.demoleeuwarden.nlu

import furhatos.nlu.EnumEntity
import furhatos.util.Language

class ListOfNo : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("nee")
    }
}

class ListOfYes : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("ja")
    }
}