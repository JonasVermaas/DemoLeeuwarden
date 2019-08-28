package furhatos.app.demoleeuwarden.flow

import furhatos.flow.kotlin.*
import furhatos.util.*
import kotlin.system.exitProcess

val Idle: State = state {

    init {
        furhat.setVoice(Language.DUTCH, Gender.MALE) // setVoice to Dutch and Male voice
        furhat.setTexture("Geremy") // Set mask to Geremy (Male with beard)
        if (users.count > 0) {
            furhat.attend(users.random)
            goto(Start)
        }
    }

    onEntry {
        furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Start)
    }
}

val Interaction: State = state {

    var nomatches = 0 // create variable nomatches and start with 0
    var silences = 0 // create variable silences and start with 0

    onUserLeave(instant = true) {
        if (users.count > 0) {
            if (it == users.current) {
                furhat.attend(users.other)
                goto(Start)
            } else {
                furhat.glance(it)
            }
        } else {
            goto(Idle)
        }
    }

    onUserEnter(instant = true) {
        furhat.glance(it)
    }

    // Create in the Interaction state the onResponse, onNoResponse and onResponseFailed

    onResponse {
        nomatches++ // increment variable nomatches

        when(nomatches) {
            // if there are no matches do the following
            1 -> {
                reentry() // go back to the state
            }
        }
    }

    onNoResponse {
        silences++ // increment silences

        when(silences) {
            // if silences is true do the following

            1 -> {
                reentry()
            }
        }
    }

    onResponseFailed {
        furhat.say("Sorry ik moet even rusten. Stel je vragen maar aan mijn menselijke collega's.")

        exitProcess(0)
    }

}