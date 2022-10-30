package com.example.ussdmobile.fragments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.ussdmobile.databinding.FragmentBeelineBinding
import io.paperdb.Paper

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BeelineFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(requireContext())
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentBeelineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeelineBinding.inflate(layoutInflater, container, false)

        binding.balance.setOnClickListener { call("*102", it) }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BeelineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun calls(s: String) {
        val calling: Intent = Intent(Intent.ACTION_CALL)
        calling.setData(Uri.parse("tel:$s"))
        ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE)
        startActivity(calling)
    }

//    fun call(n: String, view: View) {
//        val a: String = Uri.encode("#")
//        val call: Intent = Intent(Intent.ACTION_CALL)
//        call.setData(Uri.parse("tel:$n$a"))
//        if (ActivityCompat.checkSelfPermission(
//                view.context,
//                Manifest.permission.CALL_PHONE
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        view.context.startActivity(call)
//    }

    fun call(num: String, view: View) {
        val a = Uri.encode("#")
        val call = Intent(Intent.ACTION_CALL)
        call.data = Uri.parse("tel:$num$a")
        if (ActivityCompat.checkSelfPermission(
                view.context,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        view.context.startActivity(call)
    }
}