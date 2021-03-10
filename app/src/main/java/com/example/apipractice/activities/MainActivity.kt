package com.example.apipractice.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apipractice.R
import com.example.apipractice.helpers.GameAdapter
import com.example.apipractice.models.GameDeals
import com.example.apipractice.services.GameService
import com.example.apipractice.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadCountries()
    }

    private fun loadCountries() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(GameService::class.java)
        val requestCall =destinationService.getDeals("1", 15)
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<GameDeals>>{
            override fun onResponse(call: Call<List<GameDeals>>, response: Response<List<GameDeals>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val dealList  = response.body()!!
                    Log.d("Response", "dealList size : ${dealList.size}")
                    deal_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = GameAdapter(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<GameDeals>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
