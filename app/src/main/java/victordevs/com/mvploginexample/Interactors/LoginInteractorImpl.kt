package victordevs.com.mvploginexample.Interactors

import android.os.Handler
import android.support.v7.app.AppCompatActivity
import victordevs.com.mvploginexample.Interfaces.Login
import victordevs.com.mvploginexample.Presenters.LoginPresenterImpl

class LoginInteractorImpl(loginPresenterImpl: LoginPresenterImpl) :AppCompatActivity(), Login.LoginInteractor{

    val presenter = loginPresenterImpl

    override fun validarUser(user:String, pass:String, listener:Login.OnLoginFinishListener){
        if(user.isNotEmpty() && pass.isNotEmpty()){
            Handler().postDelayed({
                listener.sucess()

            }, 2000)
        }else{
            if(user.isEmpty()){
                listener.usernameError()
            }
            else if(pass.isEmpty()){
                listener.passwordError()
            }
        }

    }
}