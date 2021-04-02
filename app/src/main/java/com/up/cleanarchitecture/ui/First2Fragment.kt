package com.up.cleanarchitecture.ui

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.up.cleanarchitecture.Adapter.MyAdapter
import com.up.cleanarchitecture.Others.RecyclerItemClickListener
import com.up.cleanarchitecture.R
import com.up.cleanarchitecture.ViewModels.CharacterViewModel
import com.up.cleanarchitecture.data.model.Results
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first2.*

@AndroidEntryPoint
class First2Fragment : Fragment() {
    private  val characterViewModel: CharacterViewModel by viewModels()
    lateinit var results: List<Results>
    var name = ArrayList<String>()
    var gender = ArrayList<String>()
    var species = ArrayList<String>()
    var status = ArrayList<String>()

    var image = ArrayList<String>()
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         navController = Navigation.findNavController(view)
        myRecycler.setHasFixedSize(true)
        layoutManager = GridLayoutManager(context, 2)
        myRecycler.setLayoutManager(layoutManager)

        getData()

      /*  view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_First2Fragment_to_Second2Fragment)
        } */
    }

    fun getData(){
        characterViewModel.data.observe(viewLifecycleOwner, Observer {
            val data: List<Results> = it
            dialog.visibility = View.GONE
            if (data.isEmpty()) {
                Toast.makeText(
                        context,
                        "An error occured, please try again",
                        Toast.LENGTH_LONG
                ).show()

            } else {
                for (value in data) {
                    name.add(value.name)
                    image.add(value.image)
                    gender.add(value.gender)
                    species.add(value.species)
                    status.add(value.status)
                }
                mAdapter = MyAdapter(name, image)
                myRecycler.setAdapter(mAdapter)
               myRecycler.addOnItemTouchListener(
                        RecyclerItemClickListener(context,object: RecyclerItemClickListener.OnItemClickListener {
                            override fun onItemClick(view: View?, position: Int) {
                                val name1 = name.get(position)
                                val gender1 = gender.get(position)
                                val species1 = species.get(position)
                                val status1 = status.get(position)
                                val bundle = bundleOf("name" to name1,"gender" to gender1,
                                                        "species" to species1, "status" to status1)

                                        navController.navigate(R.id.action_First2Fragment_to_Second2Fragment,bundle)

                            }
                        })
                )
            }
        })

    }
}