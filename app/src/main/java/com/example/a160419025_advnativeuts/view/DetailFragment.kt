package com.example.a160419025_advnativeuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419025_advnativeuts.R
import com.example.a160419025_advnativeuts.databinding.FragmentDetailBinding
import com.example.a160419025_advnativeuts.util.loadImage
import com.example.a160419025_advnativeuts.viewmodel.DetailRecipeViewModel
import com.example.a160419025_advnativeuts.viewmodel.ListRecipeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailRecipeViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)

        val uuid = DetailFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        observeViewModel()

        fabEdit.setOnClickListener {
            val action = DetailFragmentDirections.actionEditRecipeFragment(it.tag.toString().toInt())

            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observeViewModel() {
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            binding.recipe = it

            imgDetailRecipePicture.loadImage(it.thumbnail)
        })
    }
}