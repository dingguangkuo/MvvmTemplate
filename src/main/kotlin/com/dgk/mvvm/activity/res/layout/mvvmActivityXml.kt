package com.dgk.mvvm.activity.res.layout

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:31
 * @email dingguangkuo@163.com
 */
fun mvvmActivityXml(packageName: String, className: String) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <variable
            name="viewModel"
            type="${packageName}.${className}ViewModel" />

        <variable
            name="clickListener"
            type="com.dgk.common.listener.OnMultiClickListener" />
    </data>
    
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${className}Activity">
        
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""