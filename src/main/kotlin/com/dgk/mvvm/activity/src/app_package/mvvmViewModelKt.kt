package com.dgk.mvvm.activity.src.app_package

import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:27
 * @email dingguangkuo@163.com
 */
fun mvvmViewModelKt(packageName: String, className: String) = """
package $packageName

import com.dgk.common.base.BaseViewModel

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${className}ViewModel : BaseViewModel() {
    
}
"""