package fr.afpa.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.afpa.affirmations.adapter.ItemAdapter
import fr.afpa.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //display the size of the returned list of affirmations in the TextView
       // val textView: TextView = findViewById(R.id.textview)
       // textView.text = Datasource().loadAffirmations().size.toString()

        //set up a RecyclerView to display the list of Affirmations
        //RecyclerView = item + Adapter + ViewHolders + RecyclerView

        //Store the returned list of affirmations in a val named myDataset
        val myDataset = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        //To tell the recyclerView to use the ItemAdapter class you created, create a new ItemAdapter instance.
        // ItemAdapter expects two parameters: the context (this) of this activity, and the affirmations in myDataset
        recyclerView.adapter = ItemAdapter(this, myDataset)
        //This setting is only needed to improve performance.
        // Use this setting if you know that changes in content do not change the layout size of the RecyclerView.
        recyclerView.setHasFixedSize(true)



    }
}