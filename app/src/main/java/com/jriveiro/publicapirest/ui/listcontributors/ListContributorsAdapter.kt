package com.jriveiro.publicapirest.ui.listcontributors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jriveiro.publicapirest.R
import com.jriveiro.publicapirest.model.api.Contributors
import com.squareup.picasso.Picasso

class ListContributorsAdapter: RecyclerView.Adapter<ListContributorsAdapter.ContributorHolder>() {

     var contributor : List<Contributors> = ArrayList()
    lateinit var context: Context

    fun ListContributorsAdapter(contributor: List<Contributors>, context: Context) {
        this.contributor = contributor
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ContributorHolder(layoutInflater.inflate(R.layout.card_contributor, parent, false))
    }

    override fun getItemCount(): Int {
        return contributor.size
    }

    override fun onBindViewHolder(holder: ContributorHolder, position: Int) {
       val item = contributor.get(position)
        holder.bind(item, context)
    }

    class ContributorHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(contPerson: Contributors, context: Context){
            val txtLogin = view.findViewById(R.id.nameContributor) as TextView
            val imgProfile = view.findViewById(R.id.imageContributor) as ImageView
            txtLogin.text = contPerson.login
           imgProfile.loadUrl(contPerson.avatar_url)
        }
        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }

}