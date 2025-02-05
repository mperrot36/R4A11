package com.example.tp2

import java.util.Calendar

object AgeCalculator {
    fun calculateAge(birthYear: Int): Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return currentYear - birthYear
    }
}
