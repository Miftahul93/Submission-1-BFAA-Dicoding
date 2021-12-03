package com.example.submission1githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var listUser = arrayListOf<UserData>()

    override fun getCount(): Int = listUser.size

    override fun getItem(i: Int): Any = listUser[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user_github, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as UserData
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder (view: View) {
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_avatar)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtCompany: TextView = view.findViewById(R.id.txt_company)
        private val txtLocation: TextView = view.findViewById(R.id.txt_location)

        fun bind(user: UserData) {
            imgAvatar.setImageResource(user.avatar)
            txtName.text = user.name
            txtCompany.text = user.company
            txtLocation.text = user.location
        }
    }
}