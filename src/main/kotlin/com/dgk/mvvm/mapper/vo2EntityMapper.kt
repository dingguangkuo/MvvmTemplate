package com.dgk.mvvm.mapper

import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/12 15:39
 * @email dingguangkuo@163.com
 */
fun vo2EntityMapperKt(mapperPackageName: String, itemClassName: String) = """
package $mapperPackageName

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class ${itemClassName}2EntityMapper : IMapper<${itemClassName}VO, ${itemClassName}Entity> {
    override fun map(input: ${itemClassName}VO): ${itemClassName}Entity {
        return ${itemClassName}Entity(input.id)
    }
}
"""