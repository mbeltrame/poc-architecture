package com.example.poc_architecture.views.custom

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.poc_architecture.R
import com.example.poc_architecture.models.HighlightDeal
import com.example.poc_architecture.models.Label
import com.example.poc_architecture.utils.setLeftDrawable
import kotlinx.android.synthetic.main.highlight_layout.view.*

class HighlightView(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private var tvAux: TextView
    private var textSize: Float

    init {
        LayoutInflater.from(context).inflate(R.layout.highlight_layout, this, true)
        tvAux = findViewById(R.id.tv_aux)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HighlightView)
        textSize = typedArray.getDimension(R.styleable.HighlightView_text_size, context.resources.getDimension(R.dimen.highlight_view_text_size_default))
        typedArray?.recycle()
        createLayout(createHighlights())
    }

    private fun createLayout(highlight: HighlightDeal) {
        setAuxTexView(highlight)

        val listViews = ArrayList<TextView>()

        viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                viewTreeObserver.removeOnGlobalLayoutListener(this)

                var i = 0
                while (i < tvAux.lineCount) {
                    tvAux.layout?.let {
                        val string = tvAux.text.subSequence(it.getLineStart(i), it.getLineEnd(i))

                        val textView = createTextView(string, i, highlight)
                        listViews.add(textView)
                    }
                    i++
                }
                listViews.forEach {
                    container_highlight.addView(it)
                }
            }
        })

        container_highlight.visibility = VISIBLE
    }

    private fun setAuxTexView(highlight: HighlightDeal) {
        tvAux.text = highlight.label?.text
        tvAux.setLeftDrawable(0, highlight.iconId)
    }

    private fun createTextView(string: CharSequence, position: Int, highlight: HighlightDeal): TextView {
        val textView = TextView(context)
        textView.layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            bottomMargin = resources.getDimensionPixelOffset(R.dimen.bottom_margin)
        }
        textView.background = ContextCompat.getDrawable(context, R.drawable.background_peel)
        textView.background.setColorFilter(Color.parseColor(highlight.label?.background), PorterDuff.Mode.SRC_ATOP)
        textView.text = string
        textView.gravity = Gravity.CENTER
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        textView.setTextColor(Color.parseColor(highlight.label?.color))
        textView.setLeftDrawable(position, highlight.iconId)
        return textView
    }

    private fun createHighlights(): HighlightDeal {
        return HighlightDeal(Label("NUEVO ALSJDLASKJDLA ALKSJD LASKD JALSKD A", "#FFFFFF", "#3483FA"), "ic_test", null)
    }
}