package com.dgk.mvvm.activity.src.app_package.entity

import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:27
 * @email dingguangkuo@163.com
 */
fun mvvmPageItemEntityKt(entityPackageName: String, itemClassName: String) = """
package $entityPackageName

import com.dgk.common.base.BaseEntity
import kotlinx.parcelize.Parcelize

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
@Parcelize
data class ${itemClassName}Entity(override val id: Long? = null) : BaseEntity()
"""