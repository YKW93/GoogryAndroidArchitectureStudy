package study.architecture.mainjob

import io.reactivex.disposables.CompositeDisposable
import study.architecture.model.Repository
import study.architecture.vo.Ticker

/**
 * 1. 업비트 데이터를 가져와 View에게 알려준다.
 * 2. Observable 생명주기를 관리한다.
 * 3. Callback을 구현하여 발행된 데이터에 대한 행동을 한다. ( Presenter <-> Model 간의 의존성이 생긴다 ㅠㅠ... )
 */
class MainPresenter(private val view: MainContract.View, index: MainFragment.FragIndex) :
    MainContract.Presenter, Repository.ResultCallback {

    private val compositeDisposable = CompositeDisposable()
    private val parser = Repository(index, this@MainPresenter)

    override fun onCreate() {
        parser.paresMarketList()
    }

    override fun onResume() {
        compositeDisposable.add(parser.parseTickerList())
    }

    override fun successMarketList() {
        onResume()
    }

    override fun successTickerList(list: MutableList<Ticker>) {
        //TODO Coin Data Adapter의 데이터 관리를 여기서 한다.
        view.notifyAdapter(list)
    }

    override fun onPause() {
        compositeDisposable.clear()
    }
}