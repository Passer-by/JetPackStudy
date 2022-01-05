package com.mieya.jetpackstudy.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mieya.jetpackstudy.bean.User

class LiveDataViewModel : ViewModel() {
    //创建一个 User类的LiveData
    private val _userLiveData = MutableLiveData<User>()

    /**
     *  利用Transformations.map 来对 [_userLiveData]的值执行处理并赋值给[userDetailLiveData]。
     */
     val userDetailLiveData = Transformations.map(_userLiveData) { user ->
        "name:${user.name},phone:${user.phone}"
    }

    /**
     * 异步设置livedata的值
     * [user]
     */
    fun setUserAsync(user: User) {
        _userLiveData.postValue(user)
    }

    /**
     * 同步设置livedata的值。主线程运行
     * [user]
     */
    fun setUser(user: User) {
        _userLiveData.value = user
    }

    /**
     *  [_switchLiveData] 的值 0：[_manUser] 1：[_womenUser] 2: [_kindUser]
     * 利用 [Transformations.switchMap] 来对所需要观察的livedata进行切换
     */

    private val _manUser = MutableLiveData<User>()
    private val _womenUser = MutableLiveData<User>()
    private val _kindUser = MutableLiveData<User>()
    private val _switchLiveData = MutableLiveData(0)
    val userLiveData = Transformations.switchMap(_switchLiveData) {
        return@switchMap when (it) {
            0 -> _manUser
            1 -> _womenUser
            2 -> _kindUser
            else -> _manUser
        }
    }

    fun changeObserverUser(i:Int){
        _switchLiveData.value=i
    }

}