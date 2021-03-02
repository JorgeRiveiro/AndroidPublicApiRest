package com.jriveiro.publicapirest.ui.contributorinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jriveiro.publicapirest.R
import com.squareup.picasso.Picasso

class ContributorInfoActivity : AppCompatActivity() {
    lateinit var txtName: TextView
    lateinit var txtLogin: TextView
    lateinit var txtEmail: TextView
    lateinit var imgProfile : ImageView
    lateinit var viewModel: ContributorInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contributor_info)

        txtEmail = findViewById(R.id.txtEmail)
        txtName = findViewById(R.id.txtName)
        txtLogin = findViewById(R.id.txtLogin)
        imgProfile = findViewById(R.id.imageProfileInfo)

        viewModel = ViewModelProvider(this).get(ContributorInfoViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        val login = intent.extras?.get("login") as String

        viewModel.getContributorInfo(login)

        viewModel.contInfo.observe(this, Observer{contributor ->
            imgProfile.loadUrl(contributor.avatar_url)
            txtLogin.text = contributor.login
            txtName.text = contributor.name
            txtEmail.text =contributor.email
        })
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}