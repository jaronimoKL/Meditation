package com.example.meditation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.*
import com.example.meditation.databinding.FragmentHomeBinding
import com.example.meditation.recapters.FeelRecycler
import com.example.meditation.recapters.FeelRecycler2
import retrofit2.Call
import retrofit2.Response

//class HomeFragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val feel_recycler : RecyclerView = root.findViewById(R.id.feel_rec)
//        val state_recycler : RecyclerView = root.findViewById(R.id.feel_rec2)
//        feel_recycler.adapter = FeelRecycler(requireContext(),MyFeel().list)
//        state_recycler.adapter = FeelRecycler2(requireContext(),MyState().list)
//        return root
//    }
//}
class HomeFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        val recycler: RecyclerView = findViewById(R.id.feel_rec)
        val ret = MyRetrofit().getRetrofit()
        val interf = ret.create(MyInterface::class.java)
        val call = interf.postLogin()
            .enqueue(object : retrofit2.Callback<feelings> {
                override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                    recycler.adapter = FeelRecycler(this@HomeFragment, response.body()!!)
                }

                override fun onFailure(call: Call<feelings>, t: Throwable) {
                    Toast.makeText(this@HomeFragment, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
    }
}