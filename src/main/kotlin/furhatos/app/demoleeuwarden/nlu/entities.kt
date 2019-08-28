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

class ListOfHomeRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("vandaan", "land", "geboren", "gebouwd", "woonplaats", "geboorteplaats")
    }
}

class ListOfNeedRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("aangeschaft", "gekocht")
    }
}



class ListOfDrinkRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("drinken", "drankje", "bier", "wijn", "koffie", "thee", "cappucino")
    }
}

class ListOfFilmRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("film", "serie", "filmpje", "video", "netflix", "youtubu")
    }
}

class ListOfSingRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("zing", "zingen", "liedje")
    }
}

class ListOfJokeRobot : EnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("grap", "mop")
    }
}