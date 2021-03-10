package com.example.apipractice.helpers

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice.R
import com.example.apipractice.activities.DetailActivity
import com.example.apipractice.models.GameDeals
import com.squareup.picasso.Picasso


class GameAdapter(private val countriesList: List<GameDeals>) :RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return countriesList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${countriesList.size} ")


        return holder.bind(countriesList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var imageView = itemView.findViewById<ImageView>(R.id.ivBanner)
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        var tvOGPrice = itemView.findViewById<TextView>(R.id.tvOGPrice)
        var tvSalePrice = itemView.findViewById<TextView>(R.id.tvSalePrice)
        fun bind(deals: GameDeals) {

            val normal ="Original :${deals.normalPrice}"
            val sale = "Sale :${deals.salePrice}"
            tvTitle.text = deals.title
            tvOGPrice.text = normal
            tvSalePrice.text = sale
            itemView.setOnClickListener {
                val clickedGame = Intent(itemView.context, DetailActivity::class.java)
                clickedGame.putExtra(DetailActivity.EXTRA_DEAL, deals)
                itemView.context.startActivity(clickedGame)
            }
            Picasso.get().load(deals.thumb).into(imageView)
        }

    }
}