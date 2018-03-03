package motion.studio.kotlinrecyclerview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
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
            try {
                toast("Position " + (it+1) + " Clicked")
                var playstoreuri: Uri = Uri.parse("https://play.google.com/store/apps/details?id=motion.studio.jadwalshalat&hl=in")
                var playstoreIntent: Intent = Intent(Intent.ACTION_VIEW, playstoreuri)
                startActivity(playstoreIntent)
            } catch (exp:Exception) {
                toast(exp.toString())
            }
        }
    }

    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    fun dummyData(): ArrayList<String>{
        val datas: ArrayList<String> = ArrayList()
        (1..7).mapTo(datas) { it.toString() }
        return datas
    }
}
