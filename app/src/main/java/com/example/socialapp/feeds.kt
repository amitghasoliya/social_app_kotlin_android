package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class feeds : AppCompatActivity() {

    val url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=293c7869cff6476983c74c0c7b83a3e9"

    private lateinit var mAdapter: NewsAdapter
    lateinit var recycler: RecyclerView
    lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.default_color)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)

        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        val madapter: NewsAdapter = NewsAdapter()
        recycler.adapter = madapter
        fetchData()

        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.setOnRefreshListener {
            fetchData()
//            swipeRefresh.isRefreshing = false
        }

    }
    private fun fetchData(){
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            {
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()
                for (i in 0 until newsJsonArray.length()){
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),
                    )
                    newsArray.add(news)
                }
                mAdapter.updateNews(newsArray)
            },
            {

            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }
}