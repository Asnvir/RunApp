package com.example.runapp.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runapp.database.Run
import com.example.runapp.databinding.ItemRunBinding
import com.example.runapp.other.TrackingUtility
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class RunAdapter : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    lateinit var binding: ItemRunBinding

    inner class RunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Run>() {
        override fun areItemsTheSame(oldItem: Run, newItem: Run) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Run, newItem: Run) =
            oldItem.hashCode() == newItem.hashCode()
    }

    var differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Run>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        binding = ItemRunBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RunViewHolder(binding.root)
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @SuppressLint("LogNotTimber")
    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val run = differ.currentList[position]


        holder.itemView.apply {
            Glide.with(this).load(run.image).into(binding.ivRunImage)

            Log.d("RunAdapter", "onBindViewHolder: ${run.image}")

            val calendar = Calendar.getInstance().apply {
                timeInMillis = run.timestamp
            }

            val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
            binding.tvDate.text = dateFormat.format(calendar.time)

            val avgSpeed = "${run.avgSpeedInKMH}km/h"
            binding.tvAvgSpeed.text = avgSpeed

            val distanceInKm = "${run.distanceInMeters / 1000f}km"
            binding.tvDistance.text = distanceInKm

            binding.tvTime.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

            val caloriesBurned = "${run.caloriesBurned}kcal"
            binding.tvCalories.text = caloriesBurned
        }
    }

}