package motion.studio.kotlinrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Afriwan Ahda
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: MainRecyclerAdapter = MainRecyclerAdapter(dummyData())
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
        adapter.setOnClickListener {
            Toast.makeText(this, "Position " + (it+1) + " Clicked" , Toast.LENGTH_SHORT).show();
        }
    }

    fun dummyData(): ArrayList<String>{
        val datas: ArrayList<String> = ArrayList()
        (1..7).mapTo(datas) { it.toString() }
        return datas
    }
}
