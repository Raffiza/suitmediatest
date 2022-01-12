package com.example.suitmediatest.ui.thirdscreen

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmediatest.data.model.Data
import com.example.suitmediatest.databinding.CardviewBinding
import java.util.*

class Adapter(private val context : Context, private val listener : OnItemClickListener) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var dataset : List<Data> = Collections.emptyList()

    fun setData(data: List<Data>){
        this.dataset = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: CardviewBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        @SuppressLint("SetTextI18n")
        fun bind(data : Data){
            with(binding){
                cvName.text = data.first_name + " " + data.last_name
                cvEmail.text = data.email
                Glide.with(context)
                    .load(data.avatar)
                    .into(cvImg)
            }
        }
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemclick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            bind(dataset[position])
        }
    }

    override fun getItemCount(): Int = dataset.size

    interface OnItemClickListener {
        fun onItemclick(position: Int)
    }
}