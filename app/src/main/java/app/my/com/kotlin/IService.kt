package app.my.com.kotlin

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Created by lenovo on 2017/12/14.
 */
interface IService {
    //http://120.27.23.105/product/getCatagory
    @GET("/product/getCatagory")
    fun getData() : Observable<ResponseBody>
}