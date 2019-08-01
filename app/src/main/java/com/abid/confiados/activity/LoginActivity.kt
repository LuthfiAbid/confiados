package com.abid.confiados.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.abid.confiados.data.Preferences
import com.abid.confiados.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 7
    private lateinit var mGoogleSignIn: GoogleSignInClient
    private lateinit var fAuth: FirebaseAuth
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fAuth = FirebaseAuth.getInstance()
        pref = Preferences(this)
        if (!pref.cekStatus()!!) {

        } else {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
            finish()
        }
        if (fAuth.currentUser != null) {
            startActivity(
                Intent(
                    this, MainActivity::class.java
                )
            )
            finish()
        } else {
//            startActivity(
//                Intent(
//                    this, MainActivity::class.java
//                )
//            )
        }
        tv_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_login.setOnClickListener {
            var email = et_email.text.toString()
            var password = et_password.text.toString()

            if (email.isNotEmpty() || password.isNotEmpty()) {
                pref.setStatus(true)
                fAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        FirebaseDatabase.getInstance().getReference("dataUser")
                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onCancelled(p0: DatabaseError) {

                                }
                                override fun onDataChange(p0: DataSnapshot) {
                                    val user = fAuth.currentUser
                                    updateUI(user)
                                }

                            })
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            this,
                            "LOGIN GAGAL Lur",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            } else {
                Toast.makeText(
                    this,
                    "LOGIN GAGAL",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        val googleSignInOptions = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken(
            getString(
                R.string.default_web_client_id
            )
        ).requestEmail().build()

        mGoogleSignIn = GoogleSignIn.getClient(
            this, googleSignInOptions
        )

        btn_login_google.setOnClickListener {
            pref.setStatusGoogle(true)
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignIn.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        fAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                val user = fAuth.currentUser
                updateUI(user)
            } else {
                Log.e("TAG_ERROR", "${it.exception}")
            }
        }
    }

    fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            pref.saveUID(user.uid) //save uid sharedpreferences
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Log.e("TAG_ERROR", "user tidak ada")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            Toast.makeText(this,"${task}",Toast.LENGTH_SHORT).show()
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (x: ApiException) {
                x.printStackTrace()
            }
        }
    }
}
