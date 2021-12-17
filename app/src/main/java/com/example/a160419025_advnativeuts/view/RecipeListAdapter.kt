package com.example.a160419025_advnativeuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160419025_advnativeuts.R
import com.example.a160419025_advnativeuts.databinding.RecipeListItemBinding
import com.example.a160419025_advnativeuts.model.Recipe
import com.example.a160419025_advnativeuts.util.loadImage
import com.example.a160419025_advnativeuts.viewmodel.ListRecipeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipe_list_item.view.*
import java.util.*

class RecipeListAdapter (val recipeList: ArrayList<Recipe>) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>(), RecipeReadMoreClick {
    class RecipeViewHolder (var view: RecipeListItemBinding) : RecyclerView.ViewHolder(view.root)

    fun updateRecipeList (newRecipeList: List<Recipe>) {
        recipeList.clear()
        recipeList.addAll(newRecipeList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecipeListItemBinding>(inflater, R.layout.recipe_list_item, parent, false)

        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.view.recipeList = recipeList[position]
        holder.view.readMoreListener = this
    }

    override fun getItemCount() = recipeList.size

    override fun onReadMoreClick(v: View) {
        val action = MainFragmentDirections.actionDetailFragment(v.tag.toString().toInt())

        Navigation.findNavController(v).navigate(action)
    }
}