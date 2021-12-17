package com.example.a160419025_advnativeuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419025_advnativeuts.R
import com.example.a160419025_advnativeuts.databinding.FragmentDetailBinding
import com.example.a160419025_advnativeuts.databinding.FragmentEditRecipeBinding
import com.example.a160419025_advnativeuts.model.Recipe
import com.example.a160419025_advnativeuts.util.loadImage
import com.example.a160419025_advnativeuts.viewmodel.DetailRecipeViewModel
import com.example.a160419025_advnativeuts.viewmodel.EditRecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_recipe.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_edit_recipe.*

class EditRecipeFragment : Fragment() {
    private lateinit var viewModel: DetailRecipeViewModel
    private lateinit var viewModelEdit: EditRecipeViewModel
    private lateinit var binding: FragmentEditRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)

        val uuid = DetailFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        observeViewModel()

        btnEditSubmit.setOnClickListener {
            viewModelEdit = ViewModelProvider(this).get(EditRecipeViewModel::class.java)
            viewModelEdit.update(txtEditName.text.toString(), txtEditRecipe.text.toString(), txtEditPhotoLink.text.toString(), txtEditPublishedBy.text.toString(), uuid)

            Toast.makeText(view.context, "Recipe Changed", Toast.LENGTH_SHORT).show()

            Navigation.findNavController(it).popBackStack()
        }
    }

    fun observeViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            binding.recipe = it
        })
    }
}