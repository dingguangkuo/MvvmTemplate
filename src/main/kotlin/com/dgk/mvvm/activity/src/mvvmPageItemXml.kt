package com.dgk.mvvm.activity.src

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:31
 * @email dingguangkuo@163.com
 */
fun mvvmPageItemXml(voPackageName: String, itemClassName: String) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <variable
            name="itemData"
            type="${voPackageName}.${itemClassName}VO" />

        <variable
            name="itemPosition"
            type="java.lang.Integer" />

        <variable
            name="itemListener"
            type="com.dgk.common.adapter.PagingListAdapter.OnItemListener" />
    </data>
    
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:context="${voPackageName}.${itemClassName}VO">
        
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""