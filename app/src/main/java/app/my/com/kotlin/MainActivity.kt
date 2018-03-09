package app.my.com.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class MainActivity : AppCompatActivity() {

    lateinit var adapter : IAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter =  IAdapter(this)
        recyclerview.adapter =adapter
        getData()

    }

    fun getData(){

        var retrofit = Retrofit.Builder()
                .baseUrl("http://120.27.23.105")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        var iservice : IService =  retrofit.create(IService::class.java)

        iservice.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    next ->
                    var result =  next.string()
                    println(result)

                    var gson = Gson()
                    var bean = gson.fromJson(result,Bean::class.java)

                    adapter.addData(bean)

                } , {
                    t ->

                } )
    }

}