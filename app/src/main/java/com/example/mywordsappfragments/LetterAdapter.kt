package com.example.mywordsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mywordsappfragments.LetterListFragmentDirections
import com.example.mywordsappfragments.R
import com.example.mywordsappfragments.WordListFragment

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
           val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(holder.button.text.toString())
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }
}