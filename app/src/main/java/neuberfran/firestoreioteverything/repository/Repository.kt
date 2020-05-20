package neuberfran.firestoreioteverything.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import neuberfran.firestoreioteverything.model.Product

class Repository {

    object NetworkRepository {
        fun registerAttendee(map : Map<String , Any?>) : LiveData<Boolean> {
            val mutableLiveData = MutableLiveData<Boolean>()

            FirebaseFirestore.getInstance().collection(Product.COLLECTION)
                .document(map.getValue(Product.FIELD_alarmstate).toString())
                .set(map)
                .addOnCompleteListener {
                    mutableLiveData.value = it.isSuccessful
                }
            return mutableLiveData
        }
    }


}