package com.epicdevler.practice.mediaplayerimpl.utils

import android.content.Context
import android.util.Log
import com.epicdevler.practice.mediaplayerimpl.R
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.metadata.Metadata
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.text.Cue
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.video.VideoSize

class MediaHandler(val player: ExoPlayer) {


    val TAG = "MediaHandler"

    fun initDefault() {
        val audioItem = RawResourceDataSource.buildRawResourceUri(R.raw.play)
        val item1 = MediaItem.fromUri(audioItem)
        player.addMediaItem(item1)
        player.prepare()

    }

    fun startPlayer() {
        player.play()
        player.playWhenReady = true


        Log.e(TAG, "startPlayer Loading: ${player.isLoading}")
        Log.e(TAG, "startPlayer Playing: ${player.isPlaying}")
        Log.e(TAG, "startPlayer Loading: ${player.isLoading}")
        Log.e(TAG, "startPlayer DeviceMuted: ${player.isDeviceMuted}")
    }

    fun pausePlayer() {
        player.pause()
        Log.e(TAG, "startPlayer Playing: ${player.isPlaying}")
    }

    fun stopPlayer() {
        player.stop()
        Log.e(TAG, "startPlayer Playing: ${player.isPlaying}")
    }

    fun skip(length: Int) {
        player.seekTo(length.toLong())
        Log.e(TAG, "startPlayer Loading: ${player.isLoading}")
        Log.e(TAG, "startPlayer Playing: ${player.isPlaying}")
        Log.e(TAG, "startPlayer Seek Params: ${player.seekParameters}")
        Log.e(TAG, "startPlayer Skip: $length")
    }


}