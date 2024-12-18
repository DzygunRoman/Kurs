package com.hfad.kurs

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        val query2 = "CREATE TABLE products (id INT PRIMARY KEY, image TEXT, title TEXT, descript TEXT, text TEXT, price INT)"
        db!!.execSQL(query)
        db!!.execSQL(query2)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addProducts(product: Product){
        val values = ContentValues()
        values.put("image", product.image)
        values.put("title", product.title)
        values.put("descript", product.descript)
        values.put("text", product.text)
        values.put("price", product.price)
        val db = this.writableDatabase
        db.insert("products", null, values)
        db.close()
    }

    fun getProducts(): Boolean {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM products", null)
        return result.moveToFirst()
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }
    fun getUser(login: String, pass: String): Boolean{
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)
        return result.moveToFirst()
    }
}