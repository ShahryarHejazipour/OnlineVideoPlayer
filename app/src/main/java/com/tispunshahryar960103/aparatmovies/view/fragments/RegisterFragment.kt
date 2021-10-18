package com.tispunshahryar960103.aparatmovies.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.FragmentRegisterBinding
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.RegisterViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.RegisterViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService
import org.json.JSONObject

class RegisterFragment : Fragment() {

    lateinit var binding:FragmentRegisterBinding

    lateinit var iService: IService
    lateinit var repository: MyRepository

    lateinit var registerViewModelFactory: RegisterViewModelFactory
    lateinit var registerViewModel: RegisterViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRegisterBinding.inflate(inflater,container,false)


        iService = ApiClient.getClient()
        repository = MyRepository(iService)


        registerViewModelFactory= RegisterViewModelFactory(repository)
        registerViewModel=ViewModelProvider(requireActivity(),registerViewModelFactory).get(
            RegisterViewModel::class.java)

        binding.btnRegister.setOnClickListener(View.OnClickListener {

            registerViewModel.register(binding.edtUsername.text.toString(),binding.edtPassword.text.toString())

            registerViewModel.mutableLiveData.observe(requireActivity(), Observer {

                //Parsing json ResponseBody to getting its Int value -> key = code & value = 0 or 1
                val jsonObject = JSONObject(it.string())
                val result=jsonObject.getInt("code")

                if (result>0){
                    Toast.makeText(requireActivity(), getString(R.string.register_success), Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(binding.btnRegister).navigate(R.id.loginFragment)


                }else{
                    Toast.makeText(requireActivity(), getString(R.string.register_failed), Toast.LENGTH_SHORT).show()
                }

            })
        })














        binding.btnSkip.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment)
        })

        binding.btnLogin.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.loginFragment)
        })


        return  binding.root
    }


}