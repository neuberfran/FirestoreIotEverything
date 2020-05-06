package neuberfran.firestoreioteverything.adapter

import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter

class TextViewBinding {

    companion object     {

        @BindingAdapter("android:text")
        @JvmStatic
        fun setIntToText(@NonNull textView: TextView, @NonNull anInt: Int){

            textView.text = anInt.toString()

        }

    }

}