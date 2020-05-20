package neuberfran.firestoreioteverything.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import neuberfran.firestoreioteverything.viewmodel.EstadoViewModel

import java.io.Serializable

class Product {

    companion object Factory {
        fun create() : EstadoViewModel=EstadoViewModel()
        val COLLECTION = "products"
        val FIELD_userId = "userId"
        val FIELD_alarmstate  = "alarmstate"
        val FIELD_garagestate = "garagestate"
    }

    var id: String? = null
    var userId: String? = null

    var alarmstate: Boolean = false
    var garagestate: Boolean = false

//
//        companion object {
//        val COLLECTION = "products"
//        val FIELD_userId = "userId"
//        val FIELD_alarmstate  = "alarmstate"
//        val FIELD_garagestate = "garagestate"
    }

//@IgnoreExtraProperties
//class Product : Serializable {
//
//    @get:Exclude
//    var id: String? = null
//    var userId: String? = null
//    var alarmstate: Boolean = false
//    var garagestate: Boolean = false
//
//    companion object {
//        val COLLECTION = "products"
//        val FIELD_userId = "userId"
//        val FIELD_alarmstate  = "alarmstate"
//        val FIELD_garagestate = "garagestate"
//    }
//}