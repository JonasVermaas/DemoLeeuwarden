package furhatos.app.demoleeuwarden

import furhatos.app.demoleeuwarden.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class DemoleeuwardenSkill : Skill() {
    override fun start() {
        Flow().run(Idle)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
