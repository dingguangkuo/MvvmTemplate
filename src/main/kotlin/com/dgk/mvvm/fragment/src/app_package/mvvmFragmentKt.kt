package com.dgk.mvvm.fragment.src.app_package

import com.android.tools.idea.wizard.template.underlinesToCamelCase
import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:14
 * @email dingguangkuo@163.com
 */
fun mvvmFragmentKt(
    className: String, layoutName: String, packageName: String,
    useResPrefix: Boolean, resPrefix: String
) = """
package $packageName

import android.os.Bundle
import com.dgk.common.base.BaseFragment

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${className}Fragment : BaseFragment<${if (useResPrefix) underlinesToCamelCase(resPrefix) else ""}Fragment${className}Binding, ${className}ViewModel>(
    contentLayoutID = R.layout.${if (useResPrefix) resPrefix else ""}${layoutName},
    vmVariableId = BR.viewModel, clVariableId = BR.clickListener
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * 控件的点击事件
     */
    override fun onMultiClick(v: View?) {
    }

    companion object {
    
        fun newInstance() = ${className}Fragment()
    }
}
"""