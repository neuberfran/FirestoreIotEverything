package neuberfran.firestoreioteverything.model

import neuberfran.firestoreioteverything.viewmodel.FireViewModel


class FireFran {

    companion object Factory {
        fun create() :FireViewModel = FireViewModel()
        var COLLECTION = "products"
        var DOCUMENT = "tutorial"
        var FIELD_userId = "userId"
        var FIELD_alarmstate  = "alarmstate"
        var FIELD_garagestate = "garagestate"
    }

    var id: String? = null
    var userId: String? = null

    var alarmstate: Boolean = true
    var garagestate: Boolean = false

}
