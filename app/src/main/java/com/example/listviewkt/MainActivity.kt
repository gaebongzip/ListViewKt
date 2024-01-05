package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null;
    private val binding get() = mBinding!!

    var userList = arrayListOf<User>(
        User(R.drawable.android, "홍길동", "99", "안녕하세요")
        , User(R.drawable.android, "홍드로이드", "98", "안녕하세요")
        , User(R.drawable.android, "홍길순", "97", "안녕하세요")
        , User(R.drawable.android, "코틀린", "96", "안녕하세요")
        , User(R.drawable.android, "자바", "95", "안녕하세요")
        , User(R.drawable.android, "파이썬", "94", "안녕하세요")
        , User(R.drawable.android, "자바스크립트", "93", "안녕하세요")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val item = arrayOf("머임" ,"사과", "배", "딸기", "키위", "홍드로이드")
        //binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val adapter = UserAdapter(this, userList)
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, postion, id ->
                val selectItem = parent.getItemAtPosition(postion) as User
                Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}