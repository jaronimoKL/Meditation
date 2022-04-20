package com.example.meditation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.create
import com.example.meditation.*
import com.example.meditation.recapters.FeelRecycler
import com.example.meditation.recapters.FeelRecycler2
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recycler: RecyclerView = root.findViewById(R.id.feel_rec)
        val recycler2: RecyclerView = root.findViewById(R.id.feel_rec2)
        val quotes = MyRetrofit().getRetrofit()
        val interf = quotes.create(MyInterface::class.java)
        val quotes_call = interf.getQuotes()
        val feelings = interf.getFeel()
        quotes_call.enqueue(object : retrofit2.Callback<quotes>{
            override fun onResponse(call: Call<quotes>, response: Response<quotes>){
                if (response.isSuccessful){
                    recycler2.adapter =
                        response.body()?.let { FeelRecycler2(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<quotes>, t: Throwable) {

        }})
        feelings.enqueue(object : retrofit2.Callback<feelings>{
            override fun onResponse(call: Call<feelings>, response: Response<feelings>){
                if (response.isSuccessful){
                    recycler.adapter =
                        response.body()?.let { FeelRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<feelings>, t: Throwable) {

            }})
        return root
    }
}
//class HomeFragment : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_home)
//        val recycler: RecyclerView = findViewById(R.id.feel_rec)
//        val ret = MyRetrofit().getRetrofit()
//        val interf = ret.create(MyInterface::class.java)

//    }
//}