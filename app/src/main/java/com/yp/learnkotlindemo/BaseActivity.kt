package com.yp.learnkotlindemo

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

class BaseActivity<VM: AndroidViewModel,VDB: ViewDataBinding> :AppCompatActivity() {
}