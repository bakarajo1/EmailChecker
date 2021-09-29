package com.example.emailchecker

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.contracts.contract


class MainActivity : AppCompatActivity() {
    lateinit var  a: Button
    lateinit var b: Button
    lateinit var c: Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var editText5: EditText
    lateinit var imageView: ImageView


    lateinit var defaultPerson: Person
    lateinit var sharedPreferences: SharedPreferences
    var editor: SharedPreferences.Editor? = null


    lateinit var textView: TextView
    lateinit var s: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("sfname", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        var checkString: String?
        init()
        setListeners()



    }

    fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


 /*   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.g, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun coursemenu(item: MenuItem?) {
        Toast.makeText(this, "course selected", Toast.LENGTH_SHORT).show()

    }

    fun sabasana(item: MenuItem?) {
        Toast.makeText(this, "saba ra?", Toast.LENGTH_SHORT).show()
        val i = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(i)
    }

    fun alrt(item: MenuItem?) {
        val dia = AlertDialog.Builder(this@MainActivity)
        dia.setTitle("awesoem")
        dia.setMessage("ypu passe the icon")
        dia.setIcon(android.R.drawable.star_on)
        dia.setPositiveButton("yes") { dialog, which -> Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_SHORT).show() }
        dia.setNegativeButton("cancel", null)
        dia.setNeutralButton("nothing", null)
        dia.show()
    }

    fun kkk(view: View?) {
        val d = Dialog(this@MainActivity)
        d.setContentView(R.layout.customlayoout)
        d.show()
    }

*/
    fun setListeners(){

       a.setOnClickListener(View.OnClickListener {
            sharedPreferences.getString("name",s)
            Toast.makeText(this@MainActivity, "$s", Toast.LENGTH_SHORT).show()


        })
     /*
        b.setOnClickListener(View.OnClickListener {
            val m = editText2.getText().toString()
            Toast.makeText(this@MainActivity, "btn2$m", Toast.LENGTH_SHORT).show()
            textView.setText(m)
            // Syntax for creating object for a class
            //Classname obj= new classname;
        })*/
        c.setOnClickListener(View.OnClickListener {




            val i = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(i)

       /*    registerForActivityResult(ActivityResultContracts.StartActivityForResult()){


            }.launch(intent)
*/
        })
    }

    override fun onResume() {
        super.onResume()

        sharedPreferences.getString("name", checkString)

        checkString?.let { toast(it) }


      //  if(checkString!==null) {

            textView.setText("jjj")




            getFromShared()

        val keys: Map<String, *> = sharedPreferences.getAll()
           toast(keys.toString())

            textView.setText(name)
            editText1.setHint(name)
            editText2.setHint(surname)
            editText3.setHint(birthYear)
            editText4.setHint(emaili)
            editText5.setHint(sex)

     //   }
    }

    fun getFromShared(){


        sharedPreferences.getString("name",name)
        sharedPreferences.getString("surname", surname)
        sharedPreferences.getString("email", emaili)
        sharedPreferences.getString("weli", birthYear)
        sharedPreferences.getString("sex",sex)

    }

    fun init(){


        a = findViewById(R.id.button1)
        b = findViewById(R.id.button2)
        c = findViewById(R.id.button3)
        editText1 = findViewById(R.id.editTextTextPersonName1)
        editText2 = findViewById(R.id.editTextTextPersonName2)
        editText3 = findViewById(R.id.editTextTextPersonName3)
        editText4 = findViewById(R.id.editTextTextPersonName4)
        editText5 = findViewById(R.id.editTextTextPersonName5)

        textView = findViewById(R.id.textView1)


        editText1.setHint(name)
        editText2.setHint(surname)
        editText3.setHint(birthYear)
        editText4.setHint(emaili)
        editText5.setHint(sex)
    }

    override fun onDestroy() {
        super.onDestroy()

        editor?.clear()
        editor?.commit()
    }

    companion object {
        var name = "Bakar"
        var surname= "Zhgenti"
        var emaili= "bakarz@yahoo.com"
        var birthYear= "1999"
        var sex = "M"
        var checkString: String? = null


    }


}