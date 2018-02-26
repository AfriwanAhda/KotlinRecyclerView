package motion.studio.kotlinrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main.view.*

/**
 * Created by Afriwan Ahda
 */

open class MainRecyclerAdapter(var datas: ArrayList<String>): RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    var context: Context?= null
    var clickListener: OnClickListener? = null
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.itemView.item_main_text.text = datas.get(position)
        holder.itemView.setOnClickListener({ v -> clickListener?.onClick(position)})
        Glide.with(context).load("https://lh3.googleusercontent.com/qFifmzQxsukNo0DfJiH2SlBNtYOL3EZYU6uYmN1M0IzASF4EiREZt3hjaUAb6lo2UaQ=w300").into(holder.itemView.item_main_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
    }

    override fun getItemCount(): Int = datas.size

    fun setOnClickListener(listener: (Int) -> Unit){
        this.clickListener = object: OnClickListener {
            override fun onClick(position: Int) {
                listener(position)
            }
        }
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnClickListener{
        fun onClick(position: Int)
    }
}
