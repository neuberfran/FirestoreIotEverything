package neuberfran.firestoreioteverything.fragment

import android.content.Context
import android.os.Bundle
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import neuberfran.firestoreioteverything.R
import neuberfran.firestoreioteverything.databinding.IotEstadoBinding

import neuberfran.firestoreioteverything.model.FireFran
import neuberfran.firestoreioteverything.viewmodel.FireViewModel

class FireFragment : Fragment() {

    private var iotestadoViewModel :FireViewModel? = null

    lateinit var binding :IotEstadoBinding

    override fun onCreateView(
        inflater :LayoutInflater , container :ViewGroup? ,
        savedInstanceState :Bundle?
    ) :View? {
        val iotestadoViewModel = ViewModelProviders.of(this).get(FireViewModel::class.java)

        binding = IotEstadoBinding.inflate(inflater , container , false)

        iotestadoViewModel!!.getFireFranById("tutorial").observe(viewLifecycleOwner , Observer { firefran ->
            if (firefran != null) {
                //       productAdapter?.setProducts(products)
                binding.setLifecycleOwner(getActivity())
                //          productAdapter?.setProducts(products)
                binding.viewmodel = iotestadoViewModel
            }
        })

        hideKeyboard()  // nao sei pra que isso

        return binding.root

    }

    override fun onResume() {
        super.onResume()

//        iotestadoViewModel!!.allProducts.observe(this , Observer { products ->
//            if (products != null) {
//         //       productAdapter?.setProducts(products)
//                binding.setLifecycleOwner(getActivity())
//                binding.viewmodel = iotestadoViewModel
//            }
//        })
    }

    private fun hideKeyboard() {
        if (activity != null) {
            val imm = activity!!
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (imm != null && activity!!.currentFocus != null &&
                activity!!.currentFocus!!.windowToken != null
            ) {
                imm.hideSoftInputFromWindow(activity!!.currentFocus!!.windowToken , 0)
            }
        }
    }

    companion object {
        private val TAG = "FireFragment"
    }
}