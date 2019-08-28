package furhatos.app.demoleeuwarden.flow

import furhatos.nlu.common.*
import furhatos.flow.kotlin.*
import furhatos.app.demoleeuwarden.nlu.*

val Aanspreek : State = state(TerugNaarState) {

    onEntry {
        furhat.say{
            random {
                + "Pppssst, jij daar! Verzekering kopen?"
                + "Welkom bij Achmea, in het mooie Leeuwarden"
                + "Hi Collega, It giet Oan"
                + "Teteteteddd innovatie evenement tijd"
                + "Hallo daar"
            }
        }
        goto(VraagAanRobot)
    }

}

val VraagAanRobot :State = state (IkWeetNiet) {

    onEntry {
        furhat.ask {
            random {
                + "Collega, je kan mij een aantal vragen stellen"
                + "Wat wil je graag over mij te weten komen?"
                + "Check het lijstje hiernaast, en vraag maar raak"
                + "Je kan me gerust een vraag stellen"
                + "Nou kom maar op met die brandende vraag"
            }
        }

    }

    onReentry {
        furhat.ask {
            random {
                + "Collega, je kan mij een aantal vragen stellen"
                + "Wat wil je graag over mij te weten komen?"
                + "Check het lijstje hiernaast, en vraag maar raak"
                + "Je kan me gerust een vraag stellen"
                + "Nou kom maar op met die brandende vraag"
            }
        }
    }

    onResponse<NameRobotIntent> {
        furhat.say {
            random {
                + "Fred"
                + "Fred de Robot"
                + "Fred uw eerste E I collega"
                + "Voor nu Fred, maar noem mij zoals jij wilt schat"
            }
        }
    }

}