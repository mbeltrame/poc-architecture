package com.example.poc_architecture.utils

import android.content.Context
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat.getColor
import com.example.poc_architecture.R
import com.example.poc_architecture.R.styleable
import com.example.poc_architecture.R.styleable.*
import com.example.poc_architecture.utils.TransitionType.CHANGE_BOUNDS

class ShowMoreTextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    private var mainText: String = text.toString()
    private var amountLines: Int
    private var textShowMore: String
    private var colorClickableText: Int
    private var thresholdActivation: Int

    var iCallbackShowMore: ICallbackShowMore? = null
    var position: Int? = null
    var isExpanded: Boolean = true
    var extraText: String? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, styleable.ShowMoreTextView)
        amountLines = typedArray.getInt(ShowMoreTextView_amountLines, DEFAULT_AMOUNT_LINES)
        thresholdActivation =
            typedArray.getInt(ShowMoreTextView_thresholdActivation, DEFAULT_THRESHOLD_ACTIVATION)
        textShowMore = typedArray.getString(ShowMoreTextView_showMoreText) ?: "Show more"
        colorClickableText = typedArray.getColor(
            ShowMoreTextView_colorClickableText,
            getColor(context, R.color.background_ads)
        )
        setAmountLines()
        typedArray?.recycle()
    }

    fun updateView(expanded: Boolean) {
        isExpanded = expanded
        if (isExpanded) {
            setExpanded()
        } else {
            setCollapsed()
        }
    }

    private fun addShowMore() {
        addOnLayoutChangeListener(object : OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View?, left: Int, top: Int, right: Int, bottom: Int,
                oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int
            ) {
                removeOnLayoutChangeListener(this)
                if (amountLines >= lineCount) {
                    getSpanExtraText()?.let {
                        text = SpannableStringBuilder(text).append(it)
                    }
                    return
                }

                layout?.let {
                    mainText = text.toString()

                    var showingText = ""
                    var start = 0
                    var end: Int
                    for (i in 0 until amountLines) {
                        end = layout.getLineEnd(i)
                        showingText += text.substring(start, end)
                        start = end
                    }

                    val sizeExtraText = extraText?.length ?: 0
                    val lengthExtraText =
                        THREE_DOTS.length + textShowMore.length + thresholdActivation + sizeExtraText
                    var cutPosition = showingText.length - lengthExtraText

                    if (cutPosition <= lengthExtraText) {
                        setExpanded()
                        return
                    }
                    if (cutPosition - 1 > 0 && showingText[cutPosition - 1] == ' ') {
                        cutPosition -= 1
                    }

                    var newText = showingText.substring(0, cutPosition)
                    newText += THREE_DOTS + textShowMore
                    text = newText
                    setShowMoreListener()
                }
            }
        })
    }

    private fun setShowMoreListener() {
        val spannableBuilder = SpannableStringBuilder()
        val spannableString = SpannableString(text)
        spannableString.setSpan(
            object : ClickableSpan() {
                override fun updateDrawState(ds: TextPaint) {
                    ds.isUnderlineText = false
                    ds.color = colorClickableText
                }

                override fun onClick(view: View?) {
                    setExpanded()
                    val container = parent.parent as? ViewGroup
                    TransitionUtils.showTransition(container, CHANGE_BOUNDS)
                    iCallbackShowMore?.onClickSeeMore(position)
                }
            },
            text.length - textShowMore.length,
            text.length, 0
        )
        movementMethod = LinkMovementMethod.getInstance()

        spannableBuilder.append(spannableString)
        getSpanExtraText()?.let { spannableBuilder.append(it) }

        this@ShowMoreTextView.text = spannableBuilder
    }

    private fun setAmountLines() {
        maxLines = if (amountLines <= 0) {
            Int.MAX_VALUE
        } else {
            amountLines
        }
    }

    private fun setExpanded() {
        maxLines = Int.MAX_VALUE
        isExpanded = true
        if (mainText.isNotEmpty()) {
            text = mainText
        }

        getSpanExtraText()?.let {
            val spannableBuilder = SpannableStringBuilder(text).append(it)
            this@ShowMoreTextView.text = spannableBuilder
        }
    }

    private fun setCollapsed() {
        isExpanded = false
        maxLines = amountLines
        addShowMore()
    }

    private fun getSpanExtraText(): SpannableStringBuilder? {
        return extraText?.let {
            val textSize = context.resources.getDimensionPixelSize(R.dimen.text_size_show_more)
            val spannableString = SpannableStringBuilder(SPAN_SEPARATOR)
            spannableString.append(SpannableString(it.toSpannableString(context, textSize)))
        }
    }

    companion object {
        private const val DEFAULT_AMOUNT_LINES = 2
        private const val DEFAULT_THRESHOLD_ACTIVATION = 5
        private const val THREE_DOTS = "... "
        private const val SPAN_SEPARATOR = "   "
    }
}