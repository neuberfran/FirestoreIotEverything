package neuberfran.firestoreioteverything.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.annotation.NonNull
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import neuberfran.firestoreioteverything.model.Product
import neuberfran.firestoreioteverything.repository.EstadoRepository
import neuberfran.firestoreioteverything.repository.ProductRepository
import neuberfran.firestoreioteverything.repository.Repository

class EstadoViewModel : ViewModel() {

    private val _registerAttendee = MutableLiveData<Map<String , Any?>>()
    val registerAttendee = _registerAttendee.map {


        Repository.NetworkRepository.registerAttendee(it)
    }

    fun setRegAttendeeInfo(map : Map<String , Any?>) {

        _registerAttendee.value = map
    }
}

//  // private val liveData = FirebaseQueryLiveData(query)
//
//    private val liveData = ProductRepository.getInstance().products
//
//    @get:NonNull
//    val hotStockLiveData =
//        Transformations.map(liveData, Deserializer() as androidx.arch.core.util.Function<QuerySnapshot , Product>)
//
////        Transformations.map(liveData, Deserializer() as androidx.arch.core.util.Function<DataSnapshot , Product>)
//
//     inner class Deserializer : Function<QuerySnapshot , Product> {
//        override fun apply(dataSnapshotxx: QuerySnapshot): Product? {
//
//            Log.i(ContentValues.TAG, "Volto K101 K101 K101")
//
//            return dataSnapshotxx
//
//        //    return dataSnapshot..getValue<Product>(Product::class.java)
//      //      return mFirestore.toString()
//        }
//    }
//
//    companion object {
//
//        private val mFirestore: FirebaseFirestore
//            get() {
//                TODO()
//            }
//
//        val estadoRef = mFirestore.collection(Product.COLLECTION)
//
//        val query = estadoRef // .whereEqualTo("alarmstate", true)
//
//    }
//
//}
