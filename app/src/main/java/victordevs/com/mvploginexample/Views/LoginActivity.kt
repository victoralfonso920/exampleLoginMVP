package victordevs.com.mvploginexample.Views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import victordevs.com.mvploginexample.Interfaces.Login
import victordevs.com.mvploginexample.Presenters.LoginPresenterImpl
import victordevs.com.mvploginexample.R

class LoginActivity : AppCompatActivity(), Login.LoginView {

    //iniciar presentador
    var presenter:Login.LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenterImpl(this)
        btnIngresar.setOnClickListener { validacion() }
    }

    override fun showProgress() {
        progresbar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progresbar.visibility = View.GONE
    }

    override fun setErrorUser() {
        userEdit.error = "Campo obligatorio"
    }

    override fun setErrorPass() {
        userPass.error = "Campo obligatorio"
    }

    override fun navigateToHome() {
        startActivity(Intent(this@LoginActivity,PrincipalActivity::class.java))
    }

    fun validacion(){
        presenter!!.validarUsuario(userEdit.text.toString(),userPass.text.toString())
    }
}
