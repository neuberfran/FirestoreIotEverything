package neuberfran.firestoreioteverything.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

import java.io.Serializable

@IgnoreExtraProperties
class Product : Serializable {

    @get:Exclude
    var id: String? = null
    var userId: String? = null
    var alarmstate: Boolean = false
    var garagestate: Boolean = false

    companion object {
        val COLLECTION = "products"
        val FIELD_userId = "userId"
        val FIELD_alarmstate  = "alarmstate"
        val FIELD_garagestate = "garagestate"
    }
}