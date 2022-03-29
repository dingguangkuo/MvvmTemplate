package com.dgk.mvvm.mapper

import java.util.*

/**
 *
 * @author Guangkuo
 * @date 2021/8/12 15:39
 * @email dingguangkuo@163.com
 */
fun entity2VOMapperKt(mapperPackageName: String, itemClassName: String) = """
package $mapperPackageName

/**
 *
 * @author Guangkuo
 * @date ${Date()}
 * @email dingguangkuo@163.com
 */
class Entity2${itemClassName}Mapper : IMapper<${itemClassName}Entity, ${itemClassName}VO> {
    override fun map(input: ${itemClassName}Entity): ${itemClassName}VO {
        return ${itemClassName}VO(input.id)
    }
}
"""