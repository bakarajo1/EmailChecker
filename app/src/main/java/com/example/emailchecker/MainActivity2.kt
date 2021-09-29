package com.example.emailchecker

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    lateinit var s: String
    lateinit var textView: TextView

    lateinit var a: Button

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var editText5: EditText
    lateinit var imageView: ImageView

    lateinit var defaultPerson: Person
    lateinit var sharedPreferences: SharedPreferences
    var editor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView = findViewById(R.id.textView3)
          s = intent.getStringExtra("pasVal").toString()
        textView.setText(s)

        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        init()
        lis()

    }


    fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


    fun init() {


        a = findViewById(R.id.save_button)

        editText1 = findViewById(R.id.editSaxeli)
        editText2 = findViewById(R.id.editGvari)
        editText3 = findViewById(R.id.editWeli)
        editText4 = findViewById(R.id.editEmail)
        editText5 = findViewById(R.id.editSex)

        textView = findViewById(R.id.textView3)


        editText1.setHint(MainActivity.name)
        editText2.setHint(MainActivity.surname)
        editText3.setHint(MainActivity.birthYear)
        editText4.setHint(MainActivity.emaili)
        editText5.setHint(MainActivity.sex)
    }

    fun lis(){
    a.setOnClickListener(View.OnClickListener {
        textView.setText("ada")
        editor?.putString("name", editText1.text.toString())
        editor?.putString("surname", editText2.text.toString())
        editor?.putString("year", editText3.text.toString())
        editor?.putString("email", editText4.text.toString())
        editor?.putString("sex", editText5.text.toString())


        editor!!.commit()

    //    val keys: Map<String, *> = sharedPreferences.getAll()
     //   toast(keys.toString())
        finish()
    })

    }



}