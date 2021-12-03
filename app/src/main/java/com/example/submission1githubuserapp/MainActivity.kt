package com.example.submission1githubuserapp

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    private lateinit var dataAvatar: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var listUser = arrayListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val listDataUser: UserData = listUser[position]
            val moveData = Intent(this@MainActivity, DetailActivity::class.java)
            moveData.putExtra(DetailActivity.EXTRA_DATA, listDataUser)
            startActivity(moveData)
        }
    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = UserData(
                    dataAvatar.getResourceId(position, -1),
                    dataUsername[position],
                    dataName[position],
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataFollowers[position],
                    dataFollowing[position]
            )
            listUser.add(user)
        }
        adapter.listUser = listUser
    }
}