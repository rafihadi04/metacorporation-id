package id.metacorporation.contract

import android.app.Activity
import android.content.Context
import id.metacorporation.models.ProgramModel

/**
 * Garap belakangan aja ngab
 * Capek bikin MVP :)*/
interface HomeContract {

    /**
     * Garap belakangan aja ngab
     * Capek bikin MVP :)*/
    interface View{

        fun showBanner (context: Context, arrayImage :ArrayList<String>)

        fun showTopProgram (arrayRadio :ArrayList<ProgramModel>, arrayTV :ArrayList<ProgramModel>)

        fun onError(msg :String)

        fun onSuccess()

        fun myContext() :Context

        fun myActivity() :Activity

    }

    /**
     * Garap belakangan aja ngab
     * Capek bikin MVP :)*/
    interface Presenter {

        fun init()

        fun onError(msg :String)

        fun onSuccess()
    }

}