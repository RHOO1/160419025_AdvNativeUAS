package com.example.a160419025_advnativeuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160419025_advnativeuts.R
import com.example.a160419025_advnativeuts.model.Recipe
import com.example.a160419025_advnativeuts.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val recipeListAdapter = RecipeListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = recipeListAdapter

        observeViewModel()

        fabAddRecipe.setOnClickListener {
            val action = MainFragmentDirections.actionAddRecipeFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            recipeListAdapter.updateRecipeList(it)
        })
    }
}