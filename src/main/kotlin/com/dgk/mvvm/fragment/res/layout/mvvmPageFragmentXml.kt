package com.dgk.mvvm.fragment.res.layout

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:31
 * @email dingguangkuo@163.com
 */
fun mvvmPageFragmentXml(packageName: String, className: String) = """
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
    
    <com.scwang.smart.refresh.layout.SmartRefreshLayout
        android:id="@+id/refresh_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:srlEnableLoadMore="false"
        app:srlEnableRefresh="true"
        tools:context="${packageName}.${className}Fragment">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recycler_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />
    </com.scwang.smart.refresh.layout.SmartRefreshLayout>
</layout>
"""