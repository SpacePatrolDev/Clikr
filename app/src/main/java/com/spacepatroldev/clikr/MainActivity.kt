package com.spacepatroldev.clikr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var countNumber = 0
    private var totalCapacity = 1000
    private var occupiedPercent = 0.0
    private var availableCap = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCounter(countNumber, totalCapacity)

        btnPlus.setOnClickListener {
            countNumber += 1
            if (countNumber > totalCapacity) countNumber -= 1 else setCounter(countNumber, totalCapacity)
        }

        btnMinus.setOnClickListener {
            countNumber -= 1
            if (countNumber > -1) setCounter(countNumber, totalCapacity) else countNumber += 1
        }

        btnRefresh.setOnClickListener {
            countNumber = 0
            setCounter(countNumber, totalCapacity)
        }
    }

    private fun setCounter(count: Int, totalCap: Int){
        counterText.text = String.format("%04d",count)

        totalCapNumber.text = totalCap.toString()

        occupiedPercent = if (count == 0) 0.0 else (count  * 100.0 / totalCap)
        occupiedPerNum.text = String.format("%.1f",occupiedPercent)

        availableCap = totalCap - count
        availableNum.text = availableCap.toString()
    }
}
