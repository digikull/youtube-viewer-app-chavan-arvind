package dev.arvindchavan.youtubeviewer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.arvindchavan.youtubeviewer.adapter.RecyclerViewAdapter
import dev.arvindchavan.youtubeviewer.databinding.ActivityMainBinding
import dev.arvindchavan.youtubeviewer.model.Video

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnClickListener {

    lateinit var binding: ActivityMainBinding
    private var list_items: ArrayList<Video> = ArrayList()
    lateinit var latoutManager: LinearLayoutManager
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {

        list_items = ArrayList()
        latoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = RecyclerViewAdapter(list_items, this, this)
        binding.videoRecycler.layoutManager = latoutManager
        binding.videoRecycler.adapter = adapter

        getVideoData()
    }

    private fun getVideoData() {
        list_items.addAll(
            listOf(
                Video(
                    "ZOsNC7hu34M",
                    "Rahul Kumar Placed as Back-end Developer | Digikull Placement",
                    "https://i.ytimg.com/an_webp/ZOsNC7hu34M/mqdefault_6s.webp?du=3000&sqp=CN-V6IwG&rs=AOn4CLCz7GeoqNhu_CCGc-yJJmiSv8MtPg",
                    ""
                ),Video(
                    "WMXpxVwOEkU",
                    "BBA Student From Non Technical Background Become Back-end Developer | Digikull",
                    "https://i.ytimg.com/an_webp/WMXpxVwOEkU/mqdefault_6s.webp?du=3000&sqp=CNLz54wG&rs=AOn4CLBCu9p3EP6kZcKrSt1Vmh7ei-ziaQ",
                    ""
                ),
                Video(
                    "IXc0pTS6Rt4",
                    "How a College Dropout 12th Pass Student Became a Full Stack Developer | Digikull",
                    "https://i.ytimg.com/an_webp/IXc0pTS6Rt4/mqdefault_6s.webp?du=3000&sqp=CJzm6IwG&rs=AOn4CLBo3kaPx0vL5w_CJVyN6Ip_S7TZ_Q",
                    ""
                ),
                Video(
                    "uoa_qgsnjE8",
                    "Non-Technical Student Gets a job of 5.9 LPA in Just 2 Months After Joining Digikull?",
                    "https://i.ytimg.com/an_webp/uoa_qgsnjE8/mqdefault_6s.webp?du=3000&sqp=CKLV6IwG&rs=AOn4CLCUOBzeleSIudcApz2uwxys74Qeig",
                    ""
                )
            )
        )

        adapter.notifyDataSetChanged()
    }

    override fun onItemClick(position: Int) {
        val data = list_items[position]
        val intent = Intent(this, VideoPlayer::class.java)
        intent.putExtra("id", data.id)
        startActivity(intent)
    }
}