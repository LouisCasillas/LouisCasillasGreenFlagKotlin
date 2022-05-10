package com.example.louiscasillasgreenflagkotlin

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import android.view.View

class InformationActivity : AppCompatActivity() {
    private var back_button : Button? = null

    private val EMAIL_REGEX : Regex = """^[\w-_\.+]*[\w-_\.]\@([\w]+\.)+[\w]+[\w]$""".toRegex()

    private var email_good : Boolean = false
    private var password_good : Boolean = false

    private var next_button : AppCompatButton? = null

    private var email_text : EditText? = null
    private var password1_text : EditText? = null
    private var password2_text : EditText? = null

    private var email_error_message : TextView? = null
    private var password_error_message : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        back_button = findViewById<Button>(R.id.create_account_back_button)
        next_button = findViewById<AppCompatButton>(R.id.next_button)

        email_text = findViewById<EditText>(R.id.email_address_text)
        password1_text = findViewById<EditText>(R.id.password1_text)
        password2_text = findViewById<EditText>(R.id.password2_text)

        email_error_message = findViewById<TextView>(R.id.email_error)
        password_error_message = findViewById<TextView>(R.id.password_error)

        back_button?.setOnClickListener() {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        next_button?.setOnClickListener() {
            Toast.makeText(this, "You have been registered!", Toast.LENGTH_SHORT).show()
        }

        email_text?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s : Editable?) {
                email_changed()
                validate_next_button()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        password1_text?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s : Editable?) {
                password_changed()
                validate_next_button()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        password2_text?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s : Editable?) {
                password_changed()
                validate_next_button()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun email_changed()
    {
        val email_address : String = email_text!!.text.toString()

        if (email_address.matches(EMAIL_REGEX))
        {
            email_good = true

            email_text!!.setBackgroundResource(R.drawable.thick_good_highlight)

            val check_image : Drawable = email_text!!.getContext().getResources().getDrawable( R.drawable.tick, null )
            email_text!!.setCompoundDrawablesWithIntrinsicBounds( null, null, check_image, null)

            email_error_message!!.visibility = View.INVISIBLE
        }
        else
        {
            email_good = false

            email_text!!.setBackgroundResource(R.drawable.thick_error_highlight)
            email_text!!.setCompoundDrawablesWithIntrinsicBounds( null, null, null, null)

            email_error_message!!.visibility = View.VISIBLE
        }
    }

    fun password_changed()
    {
        val password1 : String = password1_text!!.text.toString()
        val password2 : String = password2_text!!.text.toString()

        password_good = true

        if (! password1.equals(password2)) {
            password_good = false

            password_error_message!!.setText("Your passwords don't match")
        }
        else
        {
            if ( (password1.length < 8) ||
                (! password1.matches(".*[0-9]+.*".toRegex())) ||
                (! password1.matches(".*[a-z]+.*".toRegex())) ||
                (! password1.matches(".*[A-Z]+.*".toRegex())))
            {
                password_good = false

                password_error_message!!.setText("One of the passwords you entered wasn't valid")
            }
        }

        if (password_good) {
            password_error_message!!.visibility = View.INVISIBLE

            password1_text!!.setBackgroundResource(R.drawable.thick_good_highlight)
            password2_text!!.setBackgroundResource(R.drawable.thick_good_highlight)

            val check_image : Drawable = password1_text!!.getContext().getResources().getDrawable(R.drawable.tick, null)
            password1_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, check_image, null)
            password2_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, check_image, null)
        }
        else
        {
            password_error_message!!.visibility = View.VISIBLE
            password1_text!!.setBackgroundResource(R.drawable.thick_error_highlight)
            password2_text!!.setBackgroundResource(R.drawable.thick_error_highlight)

            password1_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            password2_text!!.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        }
    }

    fun validate_next_button()
    {
        if (email_good && password_good)
        {
            next_button!!.setEnabled(true)
        }
        else
        {
            next_button!!.setEnabled(false)
        }

    }

}