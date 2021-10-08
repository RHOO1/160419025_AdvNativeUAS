package com.example.a160419025_advnativeuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a160419025_advnativeuts.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val url = DetailFragmentArgs.fromBundle(requireArguments()).thumbnail
            val foodname = DetailFragmentArgs.fromBundle(requireArguments()).foodName
            val publishedBy = DetailFragmentArgs.fromBundle(requireArguments()).publishedBy
            val recipeDetail = DetailFragmentArgs.fromBundle(requireArguments()).recipeDetail

            Picasso.get().load(url).into(imgDetailRecipePicture)

            txtDetailFoodTitle.text = foodname
            txtDetailPublishedBy.text = "Published By " + publishedBy
            txtDetailRecipe.text = recipeDetail
        }
    }
}