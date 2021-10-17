package id.metacorporation.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.SixteenByNineFrameLayout

class SixTeenByNineFrameLayout(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :SixteenByNineFrameLayout(context, attrs, defStyleAttr) {
    constructor(context: Context): this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet? = null): this(context, attrs, 0)

}