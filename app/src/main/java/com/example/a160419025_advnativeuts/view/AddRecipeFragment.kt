package com.example.a160419025_advnativeuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419025_advnativeuts.R
import com.example.a160419025_advnativeuts.model.Recipe
import com.example.a160419025_advnativeuts.viewmodel.DetailRecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_recipe.*

class AddRecipeFragment : Fragment() {
    private lateinit var viewModel: DetailRecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)

        btnAddSubmit.setOnClickListener {
            var recipe = Recipe(txtAddFoodName.text.toString(), txtAddFoodRecipe.text.toString(), txtAddPhotosLink.text.toString(), txtAddPublishedBy.text.toString())
            var list = listOf(recipe)

            viewModel.addRecipe(list)

            Toast.makeText(view.context, "Recipe Added", Toast.LENGTH_SHORT).show()

            Navigation.findNavController(it).popBackStack()
        }
    }
}