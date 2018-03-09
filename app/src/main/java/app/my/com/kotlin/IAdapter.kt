package app.my.com.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * Created by lenovo on 2017/12/14.
 */
class IAdapter(context1 : Context) : RecyclerView.Adapter<IAdapter.IViewHodler>() {

    var context : Context = context1

    var list : ArrayList<Data> = ArrayList()


    fun addData(bean: Bean) {

        list.addAll(bean.data)

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): IViewHodler {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false)
        return IViewHodler(view)

    }


    override fun onBindViewHolder(holder: IViewHodler?, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        holder!!.item_textview.setText(list.get(position).name)

        Glide.with(context).load(list.get(position).icon).into(holder!!.item_imageview)

    }


    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.size
    }


    class IViewHodler(view : View) : RecyclerView.ViewHolder(view) {

        lateinit var item_imageview : ImageView
        lateinit var item_textview : TextView

        init {
            item_imageview = view.findViewById(R.id.item_imageview)
            item_textview = view.findViewById(R.id.item_textview)
        }

    }

}