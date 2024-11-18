package com.abadock.projectellistaclase.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abadock.projectellistaclase.R

class AlumnesAdapter (private val mList: List<AlumnesViewModel>) : RecyclerView.Adapter<AlumnesAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.llista_alumnes, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val AlumnesViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.FotoAlumne.setImageResource(R.drawable.logo_lila)

        // sets the text to the textview from our itemHolder class
        holder.NomAlumne.text = AlumnesViewModel.nom

        holder.EdatAlumne.text = AlumnesViewModel.edat.toString()

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val FotoAlumne: ImageView = itemView.findViewById(R.id.FotoAlumne)
        val NomAlumne: TextView = itemView.findViewById(R.id.VarTextNom)
        val EdatAlumne: TextView = itemView.findViewById(R.id.VarTextEdat)
    }
}