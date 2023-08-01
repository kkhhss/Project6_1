package kr.hs.emirim.kkhhss.project6_1

import android.graphics.Color
import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var chrono1 : Chronometer
    lateinit var btnStart : Button
    lateinit var btnDone : Button
    lateinit var rg : RadioGroup
    lateinit var radioCal : RadioButton
    lateinit var radioTime : RadioButton
    lateinit var datePick : DatePicker
    lateinit var timePick : TimePicker
    lateinit var textResult : TextView
    var selectedYear : Int = 0
    var selectedMonth : Int = 0
    var selectedDay : Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chrono1 = findViewById(R.id.chrono1)
        rg = findViewById(R.id.rg)
        radioCal = findViewById(R.id.radioDate)
        radioTime = findViewById(R.id.radioTime)
        datePick = findViewById(R.id.calendar)
        timePick = findViewById(R.id.timePick)
        textResult = findViewById(R.id.textResult)

        radioCal.visibility = View.INVISIBLE
        radioTime.visibility = View.INVISIBLE
        timePick.visibility = View.INVISIBLE
        datePick.visibility = View.INVISIBLE



        radioCal.setOnClickListener {
            timePick.visibility = View.INVISIBLE
            datePick.visibility = View.VISIBLE
        }
        radioTime.setOnClickListener {
            timePick.visibility = View.VISIBLE
            datePick.visibility = View.INVISIBLE
        }

        chrono1.setOnClickListener{
            chrono1.base = SystemClock.elapsedRealtime();
            chrono1.start()
            chrono1.setTextColor(Color.RED)
            radioTime.visibility = View.VISIBLE
            radioCal.visibility = View.VISIBLE
        }

        textResult.setOnClickListener{
            chrono1.stop()
            chrono1.setTextColor(Color.BLUE)
            textResult.setText("" + selectedYear + "년 " + selectedMonth + "월 " + selectedDay + "일 ")
            textResult.append("" + timePick.currentHour + "시 " + timePick.currentMinute + "분 ")
            textResult.append("예약됨")
            radioCal.visibility = View.INVISIBLE
            radioTime.visibility = View.INVISIBLE
            timePick.visibility = View.INVISIBLE
            datePick.visibility = View.INVISIBLE
        }

        datePick.setOnDateChangedListener { datePicker, year, month, day ->
            selectedYear = year
            selectedMonth = month+1
            selectedDay = day

        }

    }
}