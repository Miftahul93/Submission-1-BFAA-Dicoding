package com.example.submission1githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val dtl_avatar: CircleImageView = findViewById(R.id.dtl_avatar)
        val dtl_username: TextView = findViewById(R.id.dtl_username)
        val dtl_name: TextView = findViewById(R.id.dtl_name)
        val dtl_location: TextView = findViewById(R.id.dtl_location)
        val dtl_repository: TextView = findViewById(R.id.dtl_repository)
        val dtl_company: TextView = findViewById(R.id.dtl_company)
        val dtl_followers: TextView = findViewById(R.id.dtl_followers)
        val dtl_following: TextView = findViewById(R.id.dtl_following)
        val btnShare: Button = findViewById(R.id.btn_share)

        val dataUser = intent.getParcelableExtra<UserData>(EXTRA_DATA)

        if (dataUser != null) {
            dtl_avatar.setImageResource(dataUser.avatar)
            dtl_username.text = dataUser.username
            dtl_name.text = dataUser.name
            dtl_location.text = dataUser.location
            dtl_repository.text = dataUser.repository
            dtl_company.text = dataUser.company
            dtl_followers.text = dataUser.followers
            dtl_following.text = dataUser.following

            btnShare.setOnClickListener {
                Toast.makeText(this, "Share " + dtl_name.text, Toast.LENGTH_SHORT).show()
            }

            val  actionBar = supportActionBar
            actionBar?.title = "Github User"
            actionBar?.setDisplayHomeAsUpEnabled(true)

        }
  }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}