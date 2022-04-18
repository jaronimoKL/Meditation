package com.example.meditation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.*
import com.example.meditation.recapters.FeelRecycler
import retrofit2.Call
import retrofit2.Response
import java.net.URI.create

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val recycler: RecyclerView = root.findViewById(R.id.feel_rec)
        val ret = MyRetrofit().getRetrofit()
        val interf = ret.create(MyInterface::class.java)
        val api_ret = quotes.create(ApiRet::class.java)
        val quotes_call = retrofit2.Call<qoutes> = api_ret.getQuotes()
        val call = interf.postLogin()
            .enqueue(object : retrofit2.Callback<feelings> {
                override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                    recycler.adapter = FeelRecycler(requireContext(), response.body()!!)
                }

                override fun onFailure(call: Call<feelings>, t: Throwable) {
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()

                }
            })
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
//        val call = interf.postLogin()
//            .enqueue(object : retrofit2.Callback<feelings> {
//                override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
//                    recycler.adapter = FeelRecycler(this@HomeFragment, response.body()!!)
//                }
//
//                override fun onFailure(call: Call<feelings>, t: Throwable) {
//                    Toast.makeText(this@HomeFragment, t.localizedMessage, Toast.LENGTH_SHORT).show()
//                }
//            })
//    }
//}