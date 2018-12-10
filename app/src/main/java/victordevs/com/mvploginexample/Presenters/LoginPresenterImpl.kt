package victordevs.com.mvploginexample.Presenters

import android.support.v7.app.AppCompatActivity
import victordevs.com.mvploginexample.Interactors.LoginInteractorImpl
import victordevs.com.mvploginexample.Interfaces.Login

class LoginPresenterImpl(view: Login.LoginView) : AppCompatActivity(), Login.LoginPresenter,
    Login.OnLoginFinishListener {


    //llamar a model o interactor y llamar a vista
    val view: Login.LoginView = view
    val interactor: Login.LoginInteractor = LoginInteractorImpl(this)

    override fun validarUsuario(user: String, pass: String) {
        if(view != null){
            view.showProgress()
            interactor.validarUser(user,pass,this)
        }
    }

    override fun usernameError() {
        if (view != null) {
            view.hideProgress()
            view.setErrorUser()
        }
    }

    override fun passwordError() {
        if (view != null) {
            view.hideProgress()
            view.setErrorPass()
        }
    }

    override fun sucess() {
        if (view != null) {
            view.hideProgress()
            view.navigateToHome()
        }
    }
}