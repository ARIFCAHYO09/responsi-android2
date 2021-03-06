package com.example.cahyo.fpandroid.helper

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.os.Parcel
import android.support.annotation.RequiresApi
import android.support.v4.widget.CircularProgressDrawable
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.example.cahyo.fpandroid.helper.ModelMapperUtils
import com.example.cahyo.fpandroid.R
import com.example.cahyo.fpandroid.repository.DatabaseUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.modelmapper.ModelMapper
import java.lang.IndexOutOfBoundsException
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun MenuItem.visible() {
    isVisible = true
    enable()
}

fun MenuItem.invisible() {
    isVisible = false
    disable()
}

fun MenuItem.enable() {
    isEnabled = true
}

fun MenuItem.disable() {
    isEnabled = false
}

fun ImageView.loadImageUrl(url: String) {
    val circularProgressDrawable = CircularProgressDrawable(this.rootView.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setColorSchemeColors(R.color.darkGray)
    circularProgressDrawable.start()
    Glide.with(this.rootView.context)
            .load(url)
            .apply(RequestOptions().placeholder(circularProgressDrawable))
            .into(this)
}

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

val mapper: ModelMapper
    get() = ModelMapperUtils.configuration()

val objectMapper = ObjectMapper()

fun convertObjectToPair(ob: Any): ContentValues {
    val parcel: Parcel = Parcel.obtain()
    parcel.writeMap(objectMapper.convertValue(ob, Map::class.java))
    parcel.setDataPosition(0)
    return ContentValues.CREATOR.createFromParcel(parcel)
}

fun convertMapToContentValues(map: Map<*, *>): ContentValues {
    val parcel: Parcel = Parcel.obtain()
    parcel.writeMap(map)
    parcel.setDataPosition(0)
    return ContentValues.CREATOR.createFromParcel(parcel)
}

val Context.database: DatabaseUtils
    get() = DatabaseUtils.getInstance(applicationContext)

@SuppressLint("SimpleDateFormat")
fun dateFormating(strDate: String?): String? {
    return try {
        val localeId = Locale("in", "ID")
        SimpleDateFormat("yyyy-MM-dd").parse(strDate)
                .let(SimpleDateFormat("EEE, d MMM yyyy", localeId)::format)
    } catch (e: Exception) {
        strDate
    }
}

fun dateFormating(dateEvent: Date?): String {
    return try {
        val localeId = Locale("in", "ID")
        dateEvent.let { SimpleDateFormat("EEE, d MMM yyyy", localeId).format(it) }
    } catch (e: Exception) {
        dateEvent.toString()
    }
}

@SuppressLint("SimpleDateFormat")
fun timeFormating(time: String): String? {
    return try {
        val localeId = Locale("in", "ID")
        SimpleDateFormat("hh:mm:ssXXX").parse(time)
                .let(SimpleDateFormat("hh:mm", localeId)::format)
    } catch (e: Exception) {
        try {
            time.substring(0, 5)
        } catch (e: IndexOutOfBoundsException) {
            time
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun String?.toDate(): Date {
    return try {
        val localeId = Locale("in", "ID")
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd.hh:mm:ssXXX", localeId)
        simpleDateFormat.parse(this)
    } catch (e: Exception) {
        Date()
    }
}