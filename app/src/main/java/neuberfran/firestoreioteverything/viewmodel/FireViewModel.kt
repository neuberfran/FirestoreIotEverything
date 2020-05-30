package neuberfran.firestoreioteverything.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import neuberfran.firestoreioteverything.model.FireFran
import neuberfran.firestoreioteverything.repository.FireRepository


class FireViewModel : ViewModel() {

    private var firefran : MutableLiveData<FireFran>? = null

    fun getFireFranById(firefranId : String) :MutableLiveData<FireFran> {

        if (firefran == null) {
            firefran = FireRepository.getInstance().getFireFranById(firefranId)
        }

        return firefran as MutableLiveData<FireFran>
    }

}