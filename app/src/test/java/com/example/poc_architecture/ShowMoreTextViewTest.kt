package com.example.poc_architecture

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider
import com.example.poc_architecture.utils.ShowMoreTextView
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.util.ReflectionHelpers


@RunWith(RobolectricTestRunner::class)
class ShowMoreTextViewTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun `test default values`() {

        val showMoreTextView = ShowMoreTextView(context, null)

        val text = ReflectionHelpers.getField<String>(showMoreTextView, "textShowMore")
        val threshold = ReflectionHelpers.getField<Int>(showMoreTextView, "thresholdActivation")
        val amountLines = ReflectionHelpers.getField<Int>(showMoreTextView, "amountLines")
        val colorClickableText =
            ReflectionHelpers.getField<Int>(showMoreTextView, "colorClickableText")

        assertNull(showMoreTextView.iCallbackShowMore)
        assertNull(showMoreTextView.position)
        assertEquals("Show more", text)
        assertEquals(5, threshold)
        assertEquals(2, amountLines)
        assertTrue(showMoreTextView.isExpanded)
        assertEquals(context.getColor(R.color.background_ads), colorClickableText)
    }

    @Test
    fun `test get extra text`() {

        val showMoreTextView = ShowMoreTextView(context, null)
        showMoreTextView.extraText = "30/07/2020"

        val onGetExtraTextMethod =
            ShowMoreTextView::class.java.getDeclaredMethod("getSpanExtraText")
        onGetExtraTextMethod.isAccessible = true
        val extraText = onGetExtraTextMethod.invoke(showMoreTextView) as SpannableStringBuilder
        val spans = extraText.getSpans(0, extraText.length, Any::class.java)
        val spanSize = spans[0] as AbsoluteSizeSpan
        val dateColor = spans[1] as ForegroundColorSpan

        assertEquals("   30/07/2020", extraText.toString())
        assertEquals(2, spans.size)
        assertEquals(ContextCompat.getColor(context, R.color.colorPrimary), dateColor.foregroundColor)
        assertEquals(context.resources.getDimensionPixelSize(R.dimen.text_size_show_more), spanSize.size)
    }

    @Test
    fun `test extra text added to main text`() {

        val showMoreTextView = ShowMoreTextView(context, null)
        showMoreTextView.text = "Lorem ipsum dolor sit amet"
        showMoreTextView.extraText = "30/07/2020"

        showMoreTextView.updateView(true)

        assertEquals("Lorem ipsum dolor sit amet   30/07/2020", showMoreTextView.text.toString())
    }

    @Test
    fun `test update view expanded`() {

        val showMoreTextView = ShowMoreTextView(context, null)
        showMoreTextView.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"

        showMoreTextView.updateView(false)

        assertFalse(showMoreTextView.isExpanded)

        showMoreTextView.updateView(true)

        assertTrue(showMoreTextView.isExpanded)
    }
}