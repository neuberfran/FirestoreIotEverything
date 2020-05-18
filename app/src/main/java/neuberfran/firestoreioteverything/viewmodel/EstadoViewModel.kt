package neuberfran.firestoreioteverything.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import neuberfran.firestoreioteverything.model.Product
import neuberfran.firestoreioteverything.repository.EstadoRepository

class EstadoViewModel() : ViewModel() {

    private var product: MutableLiveData<Product>? = null
    private var products: MutableLiveData<List<Product>>? = null

    var firefrans: MutableLiveData<Boolean>? =  null //MutableLiveData(false)

    val allProducts: MutableLiveData<List<Product>>
        get() {
            if (products == null) {
                products = Transformations.map(EstadoRepository.getInstance { xproducts ->
                }
                    )
//                products = EstadoRepository.getInstance().products
            }


            return products as MutableLiveData<List<Product>>
        }

    val firefran : MutableLiveData<Boolean> //= MutableLiveData(false)
        get() {

          var firefrans =     MutableLiveData(false)

          return firefrans as MutableLiveData<Boolean>

        }

     fun getProductById(productId: String): MutableLiveData<Product> {
        if (product == null) {
            product = EstadoRepository.getInstance { xproducts ->
            }.getProductById(productId)
        }
        return product as MutableLiveData<Product>
    }
}