package com.abid.confiados.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.abid.confiados.R

class UploadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false)
    }

    companion object {
        fun newInstance(): UploadFragment {
            val fragment = UploadFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
