package com.tispunshahryar960103.aparatmovies.view.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.FragmentPrivacyPolicyBinding
import com.tispunshahryar960103.aparatmovies.utils.Constants


class PrivacyPolicyFragment : Fragment() {

    companion object{
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str)
        }
    }

    lateinit var binding:FragmentPrivacyPolicyBinding


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPrivacyPolicyBinding.inflate(inflater,container,false)



        binding.webView.settings.loadsImagesAutomatically = true
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        binding.webView.loadUrl(privacyPolicyLink())

        binding.imgBack.setOnClickListener(View.OnClickListener {

            Navigation.findNavController(it).navigate(R.id.settingFragment)
        })













        return binding.root
    }


    private external fun privacyPolicyLink():String

}