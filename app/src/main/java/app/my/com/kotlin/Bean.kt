package app.my.com.kotlin

/**
 * Created by lenovo on 2017/12/14.
 */

data class Bean(
        val msg: String,
        val code: String, //0
        val data: List<Data>
)

data class Data(
        val cid: Int, //1
        val createtime: String, //2017-10-10T19:41:39
        val icon: String, //http://120.27.23.105/images/category/shop.png
        val ishome: Int, //1
        val name: String //京东超市
)