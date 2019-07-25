package com.abid.confiados

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var fAuth: FirebaseAuth
    lateinit var dbRef: DatabaseReference
    lateinit var helperPref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        fAuth = FirebaseAuth.getInstance()
        helperPref = Preferences(this)

        tv_login.setOnClickListener {
            Intent(this, LoginActivity::class.java)
        }

        submit.setOnClickListener {
            var name = et_name.text.toString()
            var phone = et_phone.text.toString()
            var spinner = sp_gender.selectedItem.toString()
            var email = et_email.text.toString()
            var password = et_password.text.toString()
            if (name.isNotEmpty() || phone.isNotEmpty() || email.isNotEmpty() || password.isNotEmpty() || name.length == 6 ||
                phone.length == 6 || password.length == 6
            ) {
                fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            simpanToFirebase(name, email, password, spinner, phone)
                            Toast.makeText(this, "Register Berhasil!", Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        } else {
                            Toast.makeText(this, "Value must be 6 or more digit!", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "There's some empty input!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun simpanToFirebase(name: String, email: String, password: String, spinner: String, phone: String) {
        val uidUser = helperPref.getUID()
        val counterId = helperPref.getCounterId()
        dbRef = FirebaseDatabase.getInstance().getReference("dataUser/${fAuth.currentUser?.uid}/$counterId")
        dbRef.child("/id").setValue(uidUser)
        dbRef.child("/nama").setValue(name)
        dbRef.child("/email").setValue(email)
        dbRef.child("/password").setValue(password)
        dbRef.child("/phone").setValue(phone)
        dbRef.child("/gender").setValue(spinner)
        helperPref.saveCounterId(counterId + 1)
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
