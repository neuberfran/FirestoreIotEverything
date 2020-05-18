package neuberfran.firestoreioteverything.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

import java.util.ArrayList

import neuberfran.firestoreioteverything.model.Product

class EstadoRepository private constructor() {
    private val mFirestore : FirebaseFirestore

    val products : MutableLiveData<List<Product>>
        get() {
            val liveProducts = MutableLiveData<List<Product>>()

            mFirestore.collection(Product.COLLECTION)

                .whereEqualTo(Product.FIELD_userId , mFirebaseAuth!!.uid)
                .orderBy("population" , Query.Direction.ASCENDING)
                .addSnapshotListener { snapshot , e ->
                    if (e != null) {
                        Log.w(TAG , "Listen failed." , e)
                        return@addSnapshotListener
                    }

                    val products = ArrayList<Product>()
                    if (snapshot != null && !snapshot.isEmpty) {
                        for (documentSnapshot in snapshot.documents) {
                            val product = documentSnapshot.toObject(Product::class.java)
                            product!!.id = documentSnapshot.id

                            products.map { product ->
                                product.alarmstate
                                product.garagestate
                            }

                            products.add(product)
                        }
                    }
                    liveProducts.postValue(products)
                }

            return liveProducts
        }

    init {
        mFirestore = FirebaseFirestore.getInstance()
    }

    fun getProductById(productId : String) : MutableLiveData<Product> {
        val liveProject = MutableLiveData<Product>()

        val docRef = mFirestore.collection(Product.COLLECTION).document(productId)
        docRef.addSnapshotListener { snapshot , e ->
            if (e != null) {
                Log.w(TAG , "Listen failed." , e)
                return@addSnapshotListener //docRef.addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val product = snapshot.toObject(Product::class.java)
                product!!.id = snapshot.id
                liveProject.postValue(product)
            } else {
                Log.d(TAG , "Current data: null")
            }
        }

        return liveProject
    }

    fun saveProduct(product : Product) : String {
        val document : DocumentReference
        if (product.id != null) {
            document = mFirestore.collection(Product.COLLECTION).document(product.id!!)
        } else {
            product.userId = mFirebaseAuth!!.uid
            document = mFirestore.collection(Product.COLLECTION).document()
        }
        document.set(product)

        return document.id
    }

    fun deleteProduct(productId : String) {
        val docRef = mFirestore.collection(Product.COLLECTION).document(productId)
        docRef.delete()
    }

    companion object {
        private val TAG = "EstadoRepository"
        private var mFirebaseAuth : FirebaseAuth? = null

        private var instance : EstadoRepository? = null

        @Synchronized
        fun getInstance(param : (Any) -> Unit) : EstadoRepository {
            if (instance == null) {
                instance = EstadoRepository()
                mFirebaseAuth = FirebaseAuth.getInstance()
            }
            return instance as EstadoRepository
        }
    }
}
