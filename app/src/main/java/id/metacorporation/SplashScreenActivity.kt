package id.metacorporation

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Animatable
import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class SplashScreenActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_layout)

        val logoAnim :ImageView = findViewById(R.id.logoSplashAnim)
        val anim = (AppCompatResources.getDrawable(this,R.drawable.abstract_anim2) as AnimatedVectorDrawable)
        /*anim.callback=object : Animatable2Compat.AnimationCallback(){

        }*/
        anim.registerAnimationCallback(object :Animatable2.AnimationCallback(){
            override fun onAnimationEnd(drawable: Drawable?) {
                super.onAnimationEnd(drawable)
                (logoAnim.drawable as Animatable).start()
            }
        })

        logoAnim.setImageDrawable(
            anim
        )

        (logoAnim.drawable as Animatable).start()

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(this,MainActivity::class.java)
            )

            finish()
        }, 2000)
    }
}