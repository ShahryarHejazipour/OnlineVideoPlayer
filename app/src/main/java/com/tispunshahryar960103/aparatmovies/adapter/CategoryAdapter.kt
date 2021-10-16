package com.tispunshahryar960103.aparatmovies.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.tispunshahryar960103.aparatmovies.R
import com.tispunshahryar960103.aparatmovies.databinding.RowCategoryBinding
import com.tispunshahryar960103.aparatmovies.models.Category
import com.tispunshahryar960103.aparatmovies.utils.Constants

class CategoryAdapter(val categoryList: List<Category>):
    RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {

    lateinit var bundle: Bundle




    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {

        val binding:RowCategoryBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.row_category,parent,false)

        return CategoryVH(binding)


    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {

        val category=categoryList[position]
        holder.binding.category=category
        holder.binding.cardRowCategory.setOnClickListener(View.OnClickListener {

            bundle= Bundle()
           // bundle.putString("title",category.title)
           // bundle.putString("description",category.description)
            bundle.putParcelable("category",category)

            Navigation.findNavController(it).navigate(R.id.action_categoryFragment_to_categoryVideosFragment,bundle)

        })
    }

    override fun getItemCount(): Int {
       return categoryList.size
    }



    class CategoryVH(val binding:RowCategoryBinding):RecyclerView.ViewHolder(binding.root)






}