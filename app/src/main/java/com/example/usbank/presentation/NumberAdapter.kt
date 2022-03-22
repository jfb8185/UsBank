package com.example.usbank.presentation

import com.robinhood.spark.SparkAdapter

class NumberAdapter : SparkAdapter() {

    private val numbers = mutableListOf<Int>()

    override fun getCount(): Int {
        return numbers.size
    }

    override fun getItem(index: Int): Any {
        return numbers[index]
    }

    override fun getY(index: Int): Float {
        return numbers[index].toFloat()
    }

    fun submitList(nums: List<Int>) {
        numbers.clear()
        numbers.addAll(nums)
        notifyDataSetChanged()
    }
}