package com.jake.archstudy.ui.tickers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jake.archstudy.R
import com.jake.archstudy.data.model.Ticker
import com.jake.archstudy.databinding.ItemTickerBinding

class TickersAdapter : RecyclerView.Adapter<TickersAdapter.ViewHolder>() {

    private val items = mutableListOf<Ticker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_ticker,
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun set(list: List<Ticker>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: ItemTickerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Ticker) {
            binding.run {
                tvName.text = item.market
                tvTradePrice.text = item.tradePrice
                tvChangeRate.text = item.signedChangeRate
                val color = root.context.getColor(item.colorRes)
                tvChangeRate.setTextColor(color)
                tvAccTradePrice.text = item.accTradePrice24h
            }
        }

    }
}