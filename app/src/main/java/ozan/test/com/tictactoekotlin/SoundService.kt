package morteza.packag.com.tictactoekotlin

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

/**
 * Created by mortezasaadat on 2/23/18.
 */
class SoundService: Service() {



    var player: MediaPlayer? = null


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()


        player = MediaPlayer.create(this, R.raw.music)
        player?.setLooping(true)

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        player?.start()
        return Service.START_NOT_STICKY


    }

    override fun onDestroy() {
        player?.stop()
        player?.release()
        stopSelf()
        super.onDestroy()
    }


}