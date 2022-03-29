package com.dgk.mvvm.activity.src.app_package

import com.android.tools.idea.wizard.template.underlinesToCamelCase
import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:14
 * @email dingguangkuo@163.com
 */
fun mvvmPageActivityKt(
    packageName: String,
    className: String, layoutName: String,
    itemClassName: String,
    useCustomTitle: Boolean,
    useResPrefix: Boolean, resPrefix: String,
) = """
package $packageName

import android.os.Bundle
import com.dgk.common.base.BasePageActivity

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${className}Activity : BasePageActivity<${itemClassName}VO, ${
    if (useResPrefix) underlinesToCamelCase(
        resPrefix
    ) else ""
}Activity${className}Binding, ${className}ViewModel>(
    contentLayoutID = R.layout.${if (useResPrefix) resPrefix else ""}${layoutName},
    vmVariableId = BR.viewModel, clVariableId = BR.clickListener,
    useCustomTitle = $useCustomTitle,
    itemDataVariableId = BR.itemData, itemPositionVariableId = BR.itemPosition,
    itemListenerVariableId = BR.itemListener
) {

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        super.onMultiClick(v)
    }
    
    override fun getRecyclerView(): RecyclerView = dataBinding.recyclerView

    override fun getRefreshLayout(): SmartRefreshLayout = dataBinding.refreshLayout
}
"""