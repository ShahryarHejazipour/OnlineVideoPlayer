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
import com.tispunshahryar960103.aparatmovies.databinding.FragmentLoginBinding
import com.tispunshahryar960103.aparatmovies.repository.MyRepository
import com.tispunshahryar960103.aparatmovies.utils.AppConfig
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.LoginViewModel
import com.tispunshahryar960103.aparatmovies.viewModel.remoteViewModels.LoginViewModelFactory
import com.tispunshahryar960103.aparatmovies.webService.ApiClient
import com.tispunshahryar960103.aparatmovies.webService.IService
import org.json.JSONObject

class LoginFragment : Fragment() {

    lateinit var binding:FragmentLoginBinding

    lateinit var iService: IService
    lateinit var repository: MyRepository

    lateinit var loginViewModel: LoginViewModel
    lateinit var loginViewModelFactory: LoginViewModelFactory
    lateinit var appConfig: AppConfig

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentLoginBinding.inflate(inflater,container,false)

        appConfig=AppConfig(requireActivity())

        iService = ApiClient.getClient()
        repository = MyRepository(iService)

        loginViewModelFactory= LoginViewModelFactory(repository)
        loginViewModel=ViewModelProvider(requireActivity(),loginViewModelFactory).get(LoginViewModel::class.java)
        binding.btnLogin.setOnClickListener(View.OnClickListener {

            loginViewModel.login(binding.edtUsername.text.toString(),binding.edtPassword.text.toString())
            loginViewModel.mutableLiveData.observe(requireActivity(), Observer {


                //Parsing json ResponseBody to getting its Int value -> key = code & value = 0 or 1
                val jsonObject = JSONObject(it.string())
                val code=jsonObject.getInt("code")


                if (code>0){
                    Toast.makeText(requireActivity(), getString(R.string.login_success), Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(binding.btnRegister).navigate(R.id.homeFragment)
                    appConfig.setUserId(code)


                }else{
                    Toast.makeText(requireActivity(), getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
                }






            })

        })















        binding.btnSkip.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment)
        })

        binding.btnRegister.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        })



        return binding.root
    }


}