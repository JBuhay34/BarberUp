package com.justlive.justinbuhay.barberup

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button

class SignInActivity : AppCompatActivity(), View.OnClickListener {


    private var signupLayoutGroup: ConstraintLayout? = null
    private var loginButton: Button? = null
    private var signUpButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signupLayoutGroup = findViewById(R.id.sign_up_constraint_layout)

        // Animates the layout on creation
        var anim = AnimationUtils.loadAnimation(this, R.anim.sign_up_animation)
        signupLayoutGroup!!.startAnimation(anim)

        loginButton = findViewById(R.id.login_button)
        loginButton!!.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {

        when(p0){

            loginButton!!-> {
                var intent = Intent(this, UserProfile::class.java)
                startActivity(intent)
            }

        }

    }

}
