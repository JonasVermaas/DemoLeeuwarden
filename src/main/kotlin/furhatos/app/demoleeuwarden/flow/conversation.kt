package furhatos.app.demoleeuwarden.flow

import furhatos.nlu.common.*
import furhatos.flow.kotlin.*
import furhatos.app.demoleeuwarden.nlu.*

val Start : State = state(Interaction) {

    onEntry {
        furhat.ask("Hallo daar. Vind je robots leuk?")
    }

    onResponse<YesIntent>{
        furhat.say("I like humans.")
    }

    onResponse<NoIntent>{
        furhat.say("That's sad.")
    }

    onReentry {
        // Create reEntry such that the flow can go back from general.kt
        furhat.ask("Hallo daar. Vind je robots leuk?")
    }
}

