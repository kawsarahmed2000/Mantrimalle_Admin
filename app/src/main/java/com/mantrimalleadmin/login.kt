package com.mantrimalleadmin

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.mantrimalleadmin.databinding.ActivityLoginBinding
import java.util.concurrent.TimeUnit

class login : AppCompatActivity() {

    lateinit var dialog: Dialog

    lateinit var sharedPrefference: SharedPreferences
    var phnNo = ""
    var vId = ""
    var tkn = ""
    var clickState = 0
    private var mAuth: FirebaseAuth? = null
    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefference = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        mAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            if (binding.userIdET.text.toString().trim().isNotEmpty()) {
                if (binding.passwordET.text.toString().isNotEmpty()) {
                    val editor: SharedPreferences.Editor = sharedPrefference.edit()
                    editor.putString("authenticated", "true")
                    editor.apply()
                    Toast.makeText(applicationContext, "Everything alright", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this,MainActivity::class.java))
                } else {
                    binding.passwordET.error="Password Required"
                    binding.passwordET.showSoftKeyboard()
                    binding.passwordET.requestFocus()
                }
            } else {
                binding.userIdET.error="User Id Required"
                binding.userIdET.showSoftKeyboard()
                binding.userIdET.requestFocus()
            }
        }
    }

    fun EditText.showSoftKeyboard() {
        (this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
            .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }

    protected fun hideSoftKeyboard(input: EditText) {
        val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(input.windowToken, 0)
    }

    private fun dialogView(title: String, message: String, btn: String) {

        dialog = Dialog(this, R.style.BottomSheetDialogTheme)
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(false)
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.dialoge_layout_design)
        val titleTV = dialog.findViewById<TextView>(R.id.headerTVDialog)
        val messageTV = dialog.findViewById<TextView>(R.id.messageDialog)
        val actionBtn = dialog.findViewById<TextView>(R.id.actionBtnDialog)
        titleTV.text = title.toString()
        messageTV.text = message.toString()
        actionBtn.text = btn.toString()

        actionBtn.setOnClickListener {
            dialog.hide()
        }
        dialog.show()

    }
}