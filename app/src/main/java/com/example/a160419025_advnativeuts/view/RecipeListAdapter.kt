package com.example.a160419025_advnativeuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419025_advnativeuts.R
import com.example.a160419025_advnativeuts.model.Recipe
import kotlinx.android.synthetic.main.recipe_list_item.view.*
import java.util.*

class RecipeListAdapter (val recipeList: ArrayList<Recipe>) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {
    class RecipeViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    fun updateRecipeList (newRecipeList: List<Recipe>) {
        recipeList.clear()
        recipeList.addAll(newRecipeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recipe_list_item, parent, false)

        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.view.txtListFoodName.text = recipeList[position].name
        holder.view.txtListFoodDescription.text = recipeList[position].description

        holder.view.btnListReadMore.setOnClickListener {
            val action = MainFragmentDirections.actionDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount() = recipeList.size
}