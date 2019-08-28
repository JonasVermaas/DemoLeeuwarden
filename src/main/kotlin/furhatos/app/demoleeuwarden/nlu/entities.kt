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

class ListOfNameRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("heet", "naam", "noemem", "noem", "genoemd", "aangesproken", "aanspreken")
    }
}

class ListOfWorkRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("doe", "werk", "werkzaamheden", "titel")
    }
}