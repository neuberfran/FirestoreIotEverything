package neuberfran.firestoreioteverything.repository

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import neuberfran.firestoreioteverything.model.Filme

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query

class MainRepository() {

    private val mFirestore: FirebaseFirestore

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "Titulo 01"),
                    Filme(2, "Titulo 02")
                )
            )
        }).start()
    }

    init {
        mFirestore = FirebaseFirestore.getInstance()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "Titulo 01"),
                Filme(2, "Titulo 02")
            )

        }

    }
}

