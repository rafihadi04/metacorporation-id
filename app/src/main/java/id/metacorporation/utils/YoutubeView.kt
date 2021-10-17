package id.metacorporation.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.SixteenByNineFrameLayout

/**
 * EXPERIMENTAL
 * */
class YouTubeView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :SixteenByNineFrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context): this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet? = null): this(context, attrs, 0)

    private val youtubeView = WebView(context)

    init{
        addView(youtubeView, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        //this.post {
            youtubeView.webViewClient = WebViewClient()
            @SuppressLint("SetJavaScriptEnabled")
            youtubeView.settings.javaScriptEnabled = true

            youtubeView.loadUrl("https://youtube.com/embed/9pKfnVuvLbw")
        //}
    }
}

