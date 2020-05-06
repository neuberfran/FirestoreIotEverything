package neuberfran.firestoreioteverything.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

import java.io.Serializable

@IgnoreExtraProperties
class Product : Serializable {

    @get:Exclude
    var id: String? = null
    var userId: String? = null
    var alarmstate: Boolean = true
    var garagestate: Boolean = true

    companion object {
        val alarmstate : Boolean? = true
        val garagestate : Boolean? = true

        val COLLECTION = "products"
        val FIELD_userId = "userId"
        val FIELD_alarmstate  = "alarmstate"
        val FIELD_garagestate = "garagestate"
    }
}