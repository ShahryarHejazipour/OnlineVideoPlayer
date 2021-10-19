package com.tispunshahryar960103.aparatmovies.view.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    lateinit var binding:FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSettingBinding.inflate(inflater,container,false)


        binding.cardPrivacyPolicy.setOnClickListener(View.OnClickListener {

            Navigation.findNavController(it).navigate(R.id.privacyPolicyFragment)

        })

        binding.imgBack.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeFragment)
        })

        binding.cardMoreApps.setOnClickListener(View.OnClickListener {

            val uri = Uri.parse("market://details?id=Brighter future")
            val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
            try {
                startActivity(myAppLinkToMarket)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), "Impossible to find an application for the market", Toast.LENGTH_LONG).show()
            }


        })

        binding.cardAboutUs.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(it).navigate(R.id.aboutUsFragment)
        })













        return binding.root
    }


}