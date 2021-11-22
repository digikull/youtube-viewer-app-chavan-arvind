package dev.arvindchavan.youtubeviewer.ui

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import dev.arvindchavan.youtubeviewer.databinding.ActivityVideoPlayerBinding
import dev.arvindchavan.youtubeviewer.utils.Constants
import dev.arvindchavan.youtubeviewer.utils.makeStatusBarTransparent

class VideoPlayer : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    lateinit var binding : ActivityVideoPlayerBinding
    private var videoId : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeStatusBarTransparent()

        val intent = intent
        videoId = intent.getStringExtra("id").toString()

        if (videoId.isNotEmpty()){
            initializeYoutubePlayer()
        }else{
            onBackPressed()
            Toast.makeText(this, "Invalid video Id", Toast.LENGTH_SHORT).show()
        }


    }

    private fun initializeYoutubePlayer() {

        binding.youtubePayerView.initialize(Constants.API_KEY,this)

    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        b: Boolean
    ) {
        player?.loadVideo(videoId)
        player?.play()
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        onBackPressed()
        Toast.makeText(this, "Error in loading video", Toast.LENGTH_SHORT).show()
    }
}