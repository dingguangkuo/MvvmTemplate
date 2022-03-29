package com.dgk.mvvm.fragment.src.app_package

import com.android.tools.idea.wizard.template.underlinesToCamelCase
import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:14
 * @email dingguangkuo@163.com
 */
fun mvvmPageFragmentKt(
    packageName: String,
    className: String, layoutName: String,
    itemClassName: String,
    useResPrefix: Boolean, resPrefix: String
) = """
package $packageName

import android.os.Bundle
import com.dgk.common.base.BasePageFragment

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${className}Fragment : BasePageFragment<${itemClassName}VO, ${
    if (useResPrefix) underlinesToCamelCase(
        resPrefix
    ) else ""
}Fragment${className}Binding, ${className}ViewModel>(
    contentLayoutID = R.layout.${if (useResPrefix) resPrefix else ""}${layoutName},
    vmVariableId = BR.viewModel, clVariableId = BR.clickListener,
    refreshListenerVariableId = BR.refreshListener,
    itemDataVariableId = BR.itemData, itemPositionVariableId = BR.itemPosition,
    itemListenerVariableId = BR.itemListener
) {

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.setItemListener(object : PagingListAdapter.OnItemListener<${itemClassName}VO> {
            override fun onClick(v: View, position: Int, item: ${itemClassName}VO) {
            }
        })
    }
    
    override fun initViewModel(): ${className}ViewModel {
        return ViewModelProvider(this, ${className}ViewModel.ViewModelFactory(this))[${className}ViewModel::class.java]
    }

    /**
     * 控件的点击事件
     */
    override fun onMultiClick(v: View?) {
    }
    
    override fun getRecyclerView(): RecyclerView = dataBinding.recyclerView

    override fun getRefreshLayout(): SmartRefreshLayout = dataBinding.refreshLayout

    companion object {
        fun newFragment(): ${className}Fragment = ${className}Fragment()
    }
}
"""