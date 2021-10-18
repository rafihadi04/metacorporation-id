package id.metacorporation.usecase

interface MainActivityUseCase {
    fun onSwitch(idFragment: Int)
    fun blackNavBar()
    fun whiteNavBar()
    fun onError(msg:String)
}