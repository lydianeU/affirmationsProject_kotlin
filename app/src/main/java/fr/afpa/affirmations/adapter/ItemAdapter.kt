package fr.afpa.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.afpa.affirmations.R
import fr.afpa.affirmations.model.Affirmation

class ItemAdapter(
        private val context: Context,
        private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // nested class
    //Since ItemViewHolder is only used by ItemAdapter, creating it inside ItemAdapter shows this relationship
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // 3 méthodes à implémenter car la classe extends de l'abstract class RecyclerView.Adapter

    // is called by the layout manager to create new view holders for the RecyclerView
    // (when there are no existing view holders that can be reused)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //obtain an instance of LayoutInflater from the provided context
        //create a new Wiew
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        //return a new ItemViewHolder instance where the root view is adapterLayout
        return ItemViewHolder(adapterLayout)
    }

    //This method is called by the layout manager in order to replace the contents of a list item view.
    //The onBindViewHolder() method has two parameters, an ItemViewHolder previously created by the onCreateViewHolder() method,
    // and an int that represents the current item position in the list.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        // this line of code updates the view holder to show the affirmation string.
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    //return the size of your dataset
    override fun getItemCount(): Int {
        return dataset.size
    }


}

