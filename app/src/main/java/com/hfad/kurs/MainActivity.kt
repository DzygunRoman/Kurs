package com.hfad.kurs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = "sofa"
        val title = "Диван"
        val desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
        val text = "Sed do eiusmod tempor incididunt ut laboris nist ut aliguip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor prodient, sunt in culpa aui officia deserunt mollit anim id est laborum."
        val price = 999
        val product1 = Product(image, title, desc, text, price)
        val db = DbHelper(this, null)
        db.addProducts(product1)

        val image2 = "light"
        val title2 = "Свет"
        val desc2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
        val text2 = "Sed do eiusmod tempor incididunt ut laboris nist ut aliguip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor prodient, sunt in culpa aui officia deserunt mollit anim id est laborum."
        val price2 = 399
        val product2 = Product(image2, title2, desc2, text2, price2)
        val db2 = DbHelper(this, null)
        db2.addProducts(product2)

        val image3 = "kitchen"
        val title3 = "Кухня"
        val desc3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
        val text3 = "Sed do eiusmod tempor incididunt ut laboris nist ut aliguip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolor prodient, sunt in culpa aui officia deserunt mollit anim id est laborum."
        val price3 = 2999
        val product3 = Product(image3, title3, desc3, text3, price3)
        val db3 = DbHelper(this, null)
        db3.addProducts(product3)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(login == "" || email == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}