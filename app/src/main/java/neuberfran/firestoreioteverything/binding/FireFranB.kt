package neuberfran.firestoreioteverything.binding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import neuberfran.firestoreioteverything.model.Parcelize

@Parcelize
class FireFranB() : BaseObservable() {
    @Bindable
    var id : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }


    @Bindable
    var alarmstate : Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.alarmstate)
        }

}