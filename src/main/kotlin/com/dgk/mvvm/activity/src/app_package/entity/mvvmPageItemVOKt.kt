package com.dgk.mvvm.activity.src.app_package.entity

import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:27
 * @email dingguangkuo@163.com
 */
fun mvvmPageItemVOKt(
    voPackageName: String,
    itemClassName: String, itemLayoutName: String,
    useResPrefix: Boolean, resPrefix: String
) = """
package $voPackageName

import com.dgk.common.base.BaseVO

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${itemClassName}VO(override val id: Long? = null) : BaseVO() {

    override fun getItemLayoutID(): Int {
        return R.layout.${if (useResPrefix) resPrefix else ""}${itemLayoutName}
    }
}
"""