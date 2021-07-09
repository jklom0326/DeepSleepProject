package com.example.safaud20.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.safaud20.MainActivity
import com.example.safaud20.R
import com.example.safaud20.alarm.AlarmMakeFragment
import com.example.safaud20.alarm.ListAdapter
import com.example.safaud20.alarm.TimeViewModel
import com.example.safaud20.alarm.alramData

class AlarmFragment : Fragment() {

    private val newWordActivityRequestCode = 1
    private lateinit var timeViewModel: TimeViewModel
    var button : Button? = null
    val list_time = ArrayList<String>(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_alarm, container, false)

        button = view.findViewById(R.id.add_alram)
        button?.setOnClickListener {
            val main_activity = activity as MainActivity
            main_activity.setAlarm("make")
        }

//        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_list)
//        recyclerView?.adapter = adapter
//        recyclerView?.layoutManager= LinearLayoutManager(this)

    return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerview_list)
        val adapter = ListAdapter(context!!)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager=LinearLayoutManager(this.context)

        timeViewModel = ViewModelProvider(this).get(TimeViewModel::class.java)
        timeViewModel.alllist.observe(this, Observer { alramData ->
            alramData?.let { adapter.settimes(it) }
        })

        val fab = recyclerView?.findViewById<Button>(R.id.button1)
        fab?.setOnClickListener{
            val intent = Intent(context, AlarmMakeFragment::class.java)
            startActivityForResult(intent,newWordActivityRequestCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(AlarmMakeFragment.EXTRA_REPLY)?.let {
                val word = alramData(it)
                timeViewModel.insert(word)
            }
        }else{
            Toast.makeText(activity!!.applicationContext,R.string.empty_not_saved, Toast.LENGTH_LONG).show()
        }
    }


}
