package com.example.easycards

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.card.MaterialCardView

class EasyCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.materialCardViewStyle
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val container: View
    private val textContainer: LinearLayout
    private val titleView: TextView
    private val descriptionView: TextView
    private val imageView: ImageView
    
    private var cardBackgroundGradient: Pair<Int, Int>? = null
    private var cardBackgroundColor: Int? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.easy_card_layout, this, true)

        container = findViewById(R.id.card_background_container)
        textContainer = findViewById(R.id.card_text_container)
        titleView = findViewById(R.id.card_title)
        descriptionView = findViewById(R.id.card_description)
        imageView = findViewById(R.id.card_image)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.EasyCardView, defStyleAttr, 0)
            
            val title = typedArray.getString(R.styleable.EasyCardView_ec_title)
            setTitle(title)
            
            val description = typedArray.getString(R.styleable.EasyCardView_ec_description)
            setDescription(description)
            
            val imageUrl = typedArray.getString(R.styleable.EasyCardView_ec_imageUrl)
            val imageResId = typedArray.getResourceId(R.styleable.EasyCardView_ec_imageSrc, -1)
            
            if (imageUrl != null) {
                setImageUrl(imageUrl)
            } else if (imageResId != -1) {
                setImageResource(imageResId)
            }
            
            val titleColor = typedArray.getColor(R.styleable.EasyCardView_ec_titleColor, -1)
            if (titleColor != -1) setTitleColor(titleColor)
            
            val descColor = typedArray.getColor(R.styleable.EasyCardView_ec_descriptionColor, -1)
            if (descColor != -1) setDescriptionColor(descColor)
            
            val titleSize = typedArray.getDimensionPixelSize(R.styleable.EasyCardView_ec_titleTextSize, -1)
            if (titleSize != -1) titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize.toFloat())
            
            val descSize = typedArray.getDimensionPixelSize(R.styleable.EasyCardView_ec_descriptionTextSize, -1)
            if (descSize != -1) descriptionView.setTextSize(TypedValue.COMPLEX_UNIT_PX, descSize.toFloat())
            
            val bgColor = typedArray.getColor(R.styleable.EasyCardView_ec_backgroundColor, -1)
            if (bgColor != -1) {
                cardBackgroundColor = bgColor
            }
            
            val gradStart = typedArray.getColor(R.styleable.EasyCardView_ec_backgroundGradientStart, -1)
            val gradEnd = typedArray.getColor(R.styleable.EasyCardView_ec_backgroundGradientEnd, -1)
            if (gradStart != -1 && gradEnd != -1) {
                cardBackgroundGradient = Pair(gradStart, gradEnd)
            }

            applyBackgrounds()

            typedArray.recycle()
        }
    }

    fun setTitle(title: String?) {
        if (!title.isNullOrEmpty()) {
            titleView.text = title
            titleView.visibility = View.VISIBLE
        } else {
            titleView.visibility = View.GONE
        }
    }
    
    fun setDescription(description: String?) {
        if (!description.isNullOrEmpty()) {
            descriptionView.text = description
            descriptionView.visibility = View.VISIBLE
        } else {
            descriptionView.visibility = View.GONE
        }
    }

    fun setTitleColor(color: Int) = titleView.setTextColor(color)
    fun setDescriptionColor(color: Int) = descriptionView.setTextColor(color)

    fun setImageUrl(url: String) {
        imageView.visibility = View.VISIBLE
        Glide.with(context)
            .load(url)
            .transform(CenterCrop(), RoundedCorners(16f.dpToPx().toInt()))
            .into(imageView)
    }

    fun setImageResource(resId: Int) {
        imageView.visibility = View.VISIBLE
        Glide.with(context)
            .load(resId)
            .transform(CenterCrop(), RoundedCorners(16f.dpToPx().toInt()))
            .into(imageView)
    }

    fun setBackgroundGradient(startColor: Int, endColor: Int) {
        cardBackgroundGradient = Pair(startColor, endColor)
        cardBackgroundColor = null
        applyBackgrounds()
    }

    fun setCardBackgroundColorValue(color: Int) {
        cardBackgroundColor = color
        cardBackgroundGradient = null
        applyBackgrounds()
    }
    
    fun addCustomContentView(view: View) {
        textContainer.addView(view)
    }

    private fun applyBackgrounds() {
        if (cardBackgroundGradient != null) {
            val gradient = GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                intArrayOf(cardBackgroundGradient!!.first, cardBackgroundGradient!!.second)
            )
            gradient.cornerRadius = 0f 
            container.background = gradient
        } else if (cardBackgroundColor != null) {
            container.setBackgroundColor(cardBackgroundColor!!)
        }
    }

    private fun Float.dpToPx(): Float {
        val density = context.resources.displayMetrics.density
        return this * density
    }
}
