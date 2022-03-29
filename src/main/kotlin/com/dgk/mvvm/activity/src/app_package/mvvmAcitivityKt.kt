package com.dgk.mvvm.activity.src.app_package

import com.android.tools.idea.wizard.template.underlinesToCamelCase
import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:14
 * @email dingguangkuo@163.com
 */
fun mvvmAcitivityKt(
    packageName: String,
    className: String, layoutName: String,
    useCustomTitle: Boolean,
    useResPrefix: Boolean, resPrefix: String
) = """
package $packageName

import android.os.Bundle
import com.dgk.common.base.BaseActivity

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${className}Activity : BaseActivity<${if (useResPrefix) underlinesToCamelCase(resPrefix) else ""}Activity${className}Binding, ${className}ViewModel>(
    contentLayoutID = R.layout.${if (useResPrefix) resPrefix else ""}${layoutName},
    vmVariableId = BR.viewModel, clVariableId = BR.clickListener, useCustomTitle = $useCustomTitle
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * 控件的点击事件
     */
    override fun onMultiClick(v: View?) {
        super.onMultiClick(v)
    }
}
"""