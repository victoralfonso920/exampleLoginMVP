package victordevs.com.mvploginexample.Interfaces

interface Login {

    interface LoginPresenter{
        fun validarUsuario(user:String,pass:String)
    }
    interface LoginView{
        fun showProgress()
        fun hideProgress()

        fun setErrorUser()
        fun setErrorPass()

        fun navigateToHome()
    }
    interface LoginInteractor{
        fun validarUser(user:String, pass:String,listener:Login.OnLoginFinishListener)
    }

    interface OnLoginFinishListener{
        fun usernameError()
        fun passwordError()

        fun sucess()
    }
}