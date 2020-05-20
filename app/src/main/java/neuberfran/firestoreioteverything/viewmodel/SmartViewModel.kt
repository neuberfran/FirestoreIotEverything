//package neuberfran.firestoreioteverything.viewmodel
//
//import FirestoreQueryLiveData
//import android.content.ContentValues
//import android.util.Log
//import androidx.annotation.NonNull
//import androidx.lifecycle.Transformations
//import androidx.lifecycle.ViewModel
//import neuberfran.firestoreioteverything.model.Product
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//import androidx.arch.core.util.Function
//import com.google.firebase.firestore.*

//class EstadoViewModel : ViewModel() {
//
//
//    private val liveData = FirestoreQueryLiveData(HOT_STOCK_REF)
//
//    @get:NonNull
//    val hotStockLiveData =
//        Transformations.map(liveData, Deserializer() as androidx.arch.core.util.Function<DataSnapshot, Product>)
//
//    private inner class Deserializer : Function<DataSnapshot, Product> {
//        override fun apply(dataSnapshot: DataSnapshot): Product? {
//
//            var products = Product.FIELD_alarmstate
//
//            Log.i(ContentValues.TAG, "Volto K101 K101 K101")
//
//            return dataSnapshot.getValue<Product>(Product::class.java)
//        }
//    }
//
//    companion object {
//
//        private val HOT_STOCK_REF = FirebaseDatabase.getInstance().getReference("/products")
//    }
//
//}