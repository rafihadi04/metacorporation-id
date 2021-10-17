package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.system.Os.open
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.webkit.*
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.core.view.contains
import androidx.core.view.marginBottom
import androidx.core.view.postDelayed
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import id.metacorporation.R
import java.io.InputStream

class NewsFragment : Fragment() {
    lateinit var wvNews :WebView
    lateinit var wvLoading :ProgressBar
    lateinit var swipeRefresh: SwipeRefreshLayout

    private var callback: OnBackPressedCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wvNews = view.findViewById(R.id.webviewNews)
        swipeRefresh = view.findViewById(R.id.swipeRefresh)
        wvLoading = view.findViewById(R.id.webviewLoading)

        setOnBackWebView()

        with(wvNews) {
            postDelayed({
                loadUrl("https://alinea.mmtc.ac.id")
                settings.javaScriptEnabled=true
                settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
                webViewClient = object : WebViewClient(){
                    private var isError = false
                    private var isFirstError = true
                    private var errorCode :WebResourceError?= null
                    private var requestCode :WebResourceRequest?= null
                    override fun onReceivedSslError(
                        view: WebView?,
                        handler: SslErrorHandler?,
                        error: SslError?
                    ) {
                        super.onReceivedSslError(view, handler, error)
                        handler!!.proceed()
                    }

                    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)

                        //if(!isNetworkAvailable(context))  Snackbar.make(view!!,"No Internet Access",Snackbar.LENGTH_SHORT).show()
                    }


                    override fun onLoadResource(view: WebView?, url: String?) {
                        super.onLoadResource(view, url)
                        swipeRefresh.isRefreshing=false
                    }

                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        swipeRefresh.isRefreshing=false
                        callback!!.isEnabled = canGoBack()
                        wvLoading.visibility=View.GONE
                    }

                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onPageCommitVisible(view: WebView?, url: String?) {
                        super.onPageCommitVisible(view, url)
                        if(isError){
                            isError = false
                            //Log.e("ERROR")
                            evaluateJavascript(displayErrorContentCode){
                                evaluateJavascript("document.querySelector(\".error-code\").innerText=`${errorCode?.description.toString()}\nRequested url: ${requestCode?.url}`",null)
                                Log.d(this.javaClass.simpleName,it)
                            }
                        }
                    }

                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onReceivedError(
                        view: WebView,
                        request: WebResourceRequest,
                        error: WebResourceError
                    ) {
                        Log.d(this@with.javaClass.simpleName, "Error: ${error.errorCode}, ${error.description.toString()}")

                        //view.stopLoading()
                        wvLoading.visibility=View.GONE
                        val mSnackBar = Snackbar.make(this@with,"Error Occured, Please Check your Connection!",Snackbar.LENGTH_SHORT)
                            .setAction("Retry"){ reload() }
                        mSnackBar.view.setBackgroundColor(Color.WHITE)
                        mSnackBar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).setTextColor(Color.BLACK)
                        mSnackBar.view.translationY= -125F
                        mSnackBar.show()
                        if(isFirstError){
                            Log.d("FIRST ERROR", "TRUE")
                            isFirstError=false
                            isError=true
                            errorCode = error
                            requestCode = request
                        }else{
                            evaluateJavascript(displayErrorContentCode){
                                Log.d(this.javaClass.simpleName,it)
                                evaluateJavascript("document.querySelector(\".error-code\").innerText=`${error.description.toString()}\nRequested url: ${request.url}`",null)
                            }/*
                        view.post {
                            view.evaluateJavascript("document.querySelector(\".error-code\").innerText=`${error.description.toString()}\nRequested url: ${request.url}`",null)
                        }*/
                        }

                        super.onReceivedError(view, request, error)

                    }


                    /*override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {

                        return {
                            super.shouldOverrideUrlLoading(view, request)
                        }else{
                            Snackbar.make(view!!,"No Internet Access",Snackbar.LENGTH_SHORT).show()
                            false
                        }
                    }*/

                }
                settings.supportZoom()

                viewTreeObserver.addOnScrollChangedListener {
                    swipeRefresh.isEnabled = (scrollY == 0)
                }

                swipeRefresh.setOnRefreshListener {
                    reload()
                }

                webChromeClient = object : WebChromeClient(){
                    override fun onProgressChanged(view: WebView?, newProgress: Int) {
                        super.onProgressChanged(view, newProgress)
                        wvLoading.visibility=View.VISIBLE
                        wvLoading.progress=5+(newProgress*95/100)
                        /*for(prg in progress..newProgress){
                            wvLoading.progress=5+(newProgress*95/100)
                        }*/
                        if(newProgress==100) wvLoading.visibility=View.GONE
                    }
                }

            }, 200)
        }

    }

    override fun onResume() {
        super.onResume()
        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun setOnBackWebView() {
        callback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if(wvNews.canGoBack()){
                        wvNews.goBack()
                    }
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            callback!!
        )
    }

    fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getNetworkCapabilities(activeNetwork)?.run {
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                } ?: false
            } else {
                true
            }
        }

    private val displayErrorContentCode by lazy {
        val html = requireActivity().application.assets.open("html/error.dos.html")
            .bufferedReader()
            .readText()

        //Log.d(this.javaClass.simpleName,html)

        """document.documentElement.innerHTML = `$html`"""
    }

}