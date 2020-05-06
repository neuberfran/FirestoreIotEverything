package neuberfran.firestoreioteverything.viewmodel

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import neuberfran.firestoreioteverything.model.Product
import neuberfran.firestoreioteverything.repository.FakeRepository

class EstadoViewModel() : ViewModel() {

 //   val iotEstadoLiveData = MutableLiveData<seila<products>>()
    private var product: MutableLiveData<Product>? = null
    private var products: MutableLiveData<List<Product>>? = null

    val allProducts: MutableLiveData<List<Product>>
        get() {
            if (products == null) {
                products = FakeRepository.getInstance().products
            }
            return products as MutableLiveData<List<Product>>
        }

    val currentRandomFruitName: MutableLiveData<List<Product>>
        get() = FakeRepository.getInstance().currentRandomFruitName

 //   fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

 //   val editTextContent = MutableLiveData<String>()

    fun getProductById(productId: String): MutableLiveData<Product> {
        if (product == null) {
            product = FakeRepository.getInstance().getProductById(productId)
        }
        return product as MutableLiveData<Product>
    }

}