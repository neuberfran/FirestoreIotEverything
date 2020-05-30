package neuberfran.firestoreioteverything.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import neuberfran.firestoreioteverything.model.FireFran


class FireRepository private constructor() {
    private val mFirestore:FirebaseFirestore

    val firefrans:MutableLiveData<List<FireFran>>
        get() {

            val liveFireFrans = MutableLiveData<List<FireFran>>()  //() NAO TINHA

            mFirestore.collection(FireFran.COLLECTION)
                .whereEqualTo(FireFran.FIELD_userId , mFirebaseAuth!!.uid)
                .orderBy("position" , Query.Direction.ASCENDING)
                .addSnapshotListener { snapshot , e ->
                    if (e != null) {
                        Log.w(TAG , "Listen failed." , e)
                        return@addSnapshotListener // @mFirestore.collection(FireFran.Companion.COLLECTION)
                    }

                    val firefrans = ArrayList<FireFran>()
                    if (snapshot != null && !snapshot.isEmpty) {
                        for (documentSnapshot in snapshot.documents) {
                            val firefran = documentSnapshot.toObject(FireFran::class.java)
                            firefran!!.id = documentSnapshot.id
                            firefrans.add(firefran)
                        }
                    }
                    liveFireFrans.postValue(firefrans)
                }

            return liveFireFrans
        }

    init {
        mFirestore = FirebaseFirestore.getInstance()
    }

    fun getFireFranById(firefranId: String):MutableLiveData<FireFran> {
        val liveProject = MutableLiveData<FireFran>()

        val docRef = mFirestore.collection(FireFran.COLLECTION).document(firefranId)
        docRef.addSnapshotListener { snapshot , e ->
            if (e != null) {
                Log.w(TAG , "Listen failed." , e)
                return@addSnapshotListener //docRef.addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val firefran = snapshot.toObject(FireFran::class.java)
                firefran!!.id = snapshot.id
                liveProject.postValue(firefran)
            } else {
                Log.d(TAG , "Current data: null")
            }
        }

        return liveProject
    }

    fun saveFireFran(firefran: FireFran): String {
        val document:DocumentReference
        if (firefran.id != null) {
            document = mFirestore.collection(FireFran.COLLECTION).document(firefran.id!!)
        } else {
            firefran.userId = mFirebaseAuth!!.uid
            document = mFirestore.collection(FireFran.COLLECTION).document()
        }
        document.set(firefran)

        return document.id
    }

    fun deleteFireFran(firefranId: String) {
        val docRef = mFirestore.collection(FireFran.COLLECTION).document(firefranId)
        docRef.delete()
    }

    companion object {
        private val TAG = "FireRepository"
        private var mFirebaseAuth: FirebaseAuth? = null

        private var instance: FireRepository? = null

        @Synchronized
        fun getInstance(): FireRepository {
            if (instance == null) {
                instance = FireRepository()
                mFirebaseAuth = FirebaseAuth.getInstance()
            }
            return instance as FireRepository
        }
    }
}
