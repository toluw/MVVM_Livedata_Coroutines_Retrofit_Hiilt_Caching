package com.up.cleanarchitecture.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.up.cleanarchitecture.Adapter.MyAdapter
import com.up.cleanarchitecture.R
import com.up.cleanarchitecture.ViewModels.CharacterViewModel
import com.up.cleanarchitecture.data.model.Results
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
       private  val characterViewModel: CharacterViewModel by viewModels()


   lateinit var results: List<Results>
    lateinit var dialog: ProgressBar
    lateinit var myRecycler: RecyclerView
    var name = ArrayList<String>()
    var image = ArrayList<String>()
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        dialog = findViewById<ProgressBar>(R.id.dialog)
        myRecycler = findViewById<RecyclerView>(R.id.myRecycler)
        myRecycler.setHasFixedSize(true)
        layoutManager = GridLayoutManager(applicationContext, 2)
        myRecycler.setLayoutManager(layoutManager)


         getData()

        
    }

    fun getData(){
        characterViewModel.data.observe(this, Observer {
           val data: List<Results> = it
            dialog.visibility = View.GONE
            if(data.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "An error occured, please try again",
                    Toast.LENGTH_LONG
                ).show()

            }else{
                for(value in data){
                    name.add(value.name)
                    image.add(value.image)
                }
                mAdapter = MyAdapter(name, image)
                myRecycler.setAdapter(mAdapter)
            }
        })

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }






}