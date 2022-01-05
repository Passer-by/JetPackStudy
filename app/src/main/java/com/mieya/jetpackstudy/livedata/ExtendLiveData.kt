package com.mieya.jetpackstudy.livedata

import androidx.lifecycle.LiveData

/**
 * 扩展[LiveData]
 * 我们可以在[onActive]和[onInactive] 来进行对数据源的绑定。减少在没有活动观察者的情况下，不必要的开销
 */
class ExtendLiveData<T>:LiveData<T>() {
    /**
     * 有活动观察者时会进行调用  （活动观察者指的是生命周期处在活动情况下的观察者）
     */
    override fun onActive() {
        super.onActive()
    }

    /**
     * 没有活动观察者时会调用
     * 注意 [onActive] 和[onInactive] 都是只判断有没有活动的观察者
     * 而不是说没有观察者
     */
    override fun onInactive() {
        super.onInactive()
    }
    
}