package study.architecture.mainjob

import study.architecture.vo.Ticker

interface MainContract {
    interface View {
        fun notifyAdapter(list: MutableList<Ticker>)
    }

    interface Presenter {
        fun onCreate()
        fun onResume()
        fun onPause()
    }
}