package furhatos.app.demoleeuwarden.flow

import furhatos.flow.kotlin.*
import furhatos.util.*
import kotlin.system.exitProcess

val Idle: State = state {

    init {
        furhat.setVoice(Language.DUTCH, Gender.MALE) // setVoice to Dutch and Male voice
        furhat.setTexture("Geremy") // Set mask to Geremy (Male with beard)
        furhat.setInputLanguage(Language.DUTCH) // Input language to Dutch
        if (users.count > 0) {
            furhat.attend(users.random)
            goto(Aanspreek)
        }
    }

    onEntry {
        furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Aanspreek)
    }
}

val TerugNaarState: State = state {

    var nomatches = 0 // create variable nomatches and start with 0
    var silences = 0 // create variable silences and start with 0

    onUserLeave(instant = true) {
        if (users.count > 0) {
            if (it == users.current) {
                furhat.attend(users.other)
                goto(Aanspreek)
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

val IkWeetNiet: State = state {

    var nomatches = 0 // create variable nomatches and start with 0
    var silences = 0 // create variable silences and start with 0

    onUserLeave(instant = true) {
        if (users.count > 0) {
            if (it == users.current) {
                furhat.attend(users.other)
                goto(Aanspreek)
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
                furhat.say {
                    random {
                        + "Deze vraag begrijp ik niet, kan je een andere vraag stellen?"
                        + "Wat zeg jij nou? Vraag eens wat anders astublieft"
                        + "Dat vraag je toch niet op de eerste date, stel maar een beschaafde vraag"
                        + "Sorry ik spreek alleen fries, je kan vragen naar m'n naam of mijn favoriete film"
                    }
                }
                reentry()
            }
        }
    }

    onNoResponse {
        silences++ // increment silences

        when(silences) {
            // if silences is true do the following

            1 -> {
                furhat.say {
                random {
                    + "Als je het even niet weet, hiernaast staat een lijstje met vragen die je mij kan stellen"
                    + "Niet zo zenuwachtig, je kan mij gerust wat vragen "
                    + "Ik bijt niet hoor, vraag maar raak"
                    + "Heb je het lijstje al gezien met vragen die je mij kan stellen"

                }
            }
                reentry()

            }
        }
    }

    onResponseFailed {
        furhat.setVoice(Language.ENGLISH_GB, Gender.MALE) // setVoice to Dutch and Male voice
        furhat.setTexture("Ivan") // Set mask to Ivan (Alien face)
        furhat.say("Error Error, Self destruction start in 10, 9, 8, 7, 6, ... Just kidding")

        exitProcess(0)
    }

}