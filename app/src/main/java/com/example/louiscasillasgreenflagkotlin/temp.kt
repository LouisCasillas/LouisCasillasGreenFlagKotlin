/*
package com.example.louiscasillasgreenflagkotlin

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.Button

class InformationActivity2 : AppCompatActivity() {
    private var back_button: Button? = null
    private var next_button: AppCompatButton? = null
    private var email_text: EditText? = null
    private var password1_text: EditText? = null
    private var password2_text: EditText? = null
    private var email_error_message: TextView? = null
    private var password_error_message: TextView? = null
    private var email_good = false
    private var password_good = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        back_button = findViewById<View>(R.id.create_account_back_button) as Button
        next_button = findViewById<View>(R.id.next_button) as AppCompatButton
        email_text = findViewById<View>(R.id.email_address_text) as EditText
        password1_text = findViewById<View>(R.id.password1_text) as EditText
        password2_text = findViewById<View>(R.id.password2_text) as EditText
        email_error_message = findViewById<View>(R.id.email_error) as TextView
        password_error_message = findViewById<View>(R.id.password_error) as TextView
        back_button!!.setOnClickListener {
            val intent = Intent(this@InformationActivity, MainActivity::class.java)
            startActivity(intent)
        }
        next_button!!.setOnClickListener { v ->
            Toast.makeText(
                v.context,
                "You have been registered!",
                Toast.LENGTH_LONG
            ).show()
        }
        email_text!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                email_changed()
                validate_next_button()
            }
        })
        password1_text!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                password_changed()
                validate_next_button()
            }
        })
        password2_text!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                password_changed()
                validate_next_button()
            }
        })
    }

    private fun email_changed() {
        if (email_text!!.text.toString().matches(EMAIL_REGEX)) {
            email_good = true
            email_text!!.setBackgroundResource(R.drawable.thick_good_highlight)
            val check_image = email_text!!.context.resources.getDrawable(R.drawable.tick, null)
            email_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, check_image, null)
            email_error_message!!.visibility = View.INVISIBLE
        } else {
            email_good = false
            email_text!!.setBackgroundResource(R.drawable.thick_error_highlight)
            email_text.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            email_error_message!!.visibility = View.VISIBLE
        }
    }

    private fun password_changed() {
        val password1 = password1_text!!.text.toString()
        password_good = true
        if (password1 != password2_text!!.text.toString()) {
            password_good = false
            password_error_message!!.text = "Your passwords don't match"
        } else {
            if (password1.length < 8 ||
                !password1.matches(".*[0-9]+.*") ||
                !password1.matches(".*[a-z]+.*") ||
                !password1.matches(".*[A-Z]+.*")
            ) {
                password_good = false
                password_error_message!!.text = "One of the passwords you entered wasn't valid"
            }
        }
        if (password_good) {
            password_error_message!!.visibility = View.INVISIBLE
            password1_text!!.setBackgroundResource(R.drawable.thick_good_highlight)
            password2_text!!.setBackgroundResource(R.drawable.thick_good_highlight)
            val check_image = password1_text!!.context.resources.getDrawable(R.drawable.tick, null)
            password1_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, check_image, null)
            password2_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, check_image, null)
        } else {
            password_error_message!!.visibility = View.VISIBLE
            password1_text!!.setBackgroundResource(R.drawable.thick_error_highlight)
            password2_text!!.setBackgroundResource(R.drawable.thick_error_highlight)
            password1_text.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            password2_text.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        }
    }

    private fun validate_next_button() {
        // if             email_good and password_good
        // enable next button and add click listener
        // send registration message
        if (email_good && password_good) {
            next_button!!.isEnabled = true
        } else {
            next_button!!.isEnabled = false
        }
    }

    companion object {
        private const val EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"
    }
}

*/