package com.giphy.android.util

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class Util {

    companion object{
        fun addFragment(
            activity: AppCompatActivity,
            fragment: Fragment?, content: Int, addToBackStack: Boolean
        ) {
            val fragmentManager: FragmentManager = activity.supportFragmentManager
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            if (!addToBackStack) {
                transaction.disallowAddToBackStack()
            } else {
                transaction.addToBackStack(null)
            }
            transaction.replace(content, fragment!!)
            transaction.commit()
        }

        fun clearEdtInput(view: EditText){
            view.text?.clear()
        }
    }



}


