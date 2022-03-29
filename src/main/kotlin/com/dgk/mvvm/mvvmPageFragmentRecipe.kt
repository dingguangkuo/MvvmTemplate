package com.dgk.mvvm

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.dgk.mvvm.activity.src.app_package.mvvmPageViewModelKt
import com.dgk.mvvm.activity.src.mvvmPageItemXml
import com.dgk.mvvm.activity.src.app_package.entity.mvvmPageItemEntityKt
import com.dgk.mvvm.activity.src.app_package.entity.mvvmPageItemVOKt
import com.dgk.mvvm.mapper.entity2VOMapperKt
import com.dgk.mvvm.fragment.res.layout.mvvmPageFragmentXml
import com.dgk.mvvm.fragment.src.app_package.mvvmPageFragmentKt
import com.dgk.mvvm.mapper.vo2EntityMapperKt
import java.io.File

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:12
 * @email dingguangkuo@163.com
 */
fun RecipeExecutor.mvvmPageFragmentRecipe(
    moduleData: ModuleTemplateData,
    className: String, layoutName: String,
    itemClassName: String, itemLayoutName: String,
    packageName: String,
    useResPrefix: Boolean, resPrefix: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val fragmentFile = srcOut.resolve("${className}Fragment.${ktOrJavaExt}")
    save(mvvmPageFragmentKt(packageName, className, layoutName, itemClassName, useResPrefix, resPrefix), fragmentFile)
    open(fragmentFile)

    val viewModelFile = srcOut.resolve("${className}ViewModel.${ktOrJavaExt}")
    save(mvvmPageViewModelKt(packageName, className, itemClassName), viewModelFile)
    open(viewModelFile)

    val layoutFile = resOut.resolve("layout/${if (useResPrefix) resPrefix else ""}${layoutName}.xml")
    save(mvvmPageFragmentXml(packageName, className), layoutFile)
    open(layoutFile)

    var dataDir: File? = null
    var temp: File = srcOut
    var tempPackageName = packageName
    do {
        if (dataDir?.name == "java" || dataDir?.name == "main") {
            break
        }
        dataDir = temp.listFiles()?.find { it.isDirectory && (it.name == "data") }
        if (dataDir != null) {
            break
        }
        temp = temp.parentFile
        tempPackageName = tempPackageName.substring(0, tempPackageName.lastIndexOf("."))
    } while (dataDir == null)
    if (dataDir != null) {
        val entityPackageName = "$tempPackageName.data.entity"
        val entityClassFile = File(dataDir, "entity/${className}Entity.${ktOrJavaExt}")
        save(mvvmPageItemEntityKt(entityPackageName, itemClassName), entityClassFile)
        open(entityClassFile)

        val voPackageName = "$tempPackageName.bean"
        val voClassFile = File(dataDir.parentFile, "bean/${className}VO.${ktOrJavaExt}")
        save(mvvmPageItemVOKt(voPackageName, itemClassName, itemLayoutName, useResPrefix, resPrefix), voClassFile)
        open(voClassFile)

        val itemLayoutFile = resOut.resolve("layout/${if (useResPrefix) resPrefix else ""}${itemLayoutName}.xml")
        save(mvvmPageItemXml(voPackageName, itemClassName), itemLayoutFile)
        open(itemLayoutFile)

        val mapperPackageName = "$tempPackageName.data.mapper"
        val entity2VOFile = File(dataDir, "mapper/Entity2${className}Mapper.${ktOrJavaExt}")
        save(entity2VOMapperKt(mapperPackageName, itemClassName), entity2VOFile)
        open(entity2VOFile)

        val vo2EntityFile = File(dataDir, "mapper/${className}2EntityMapper.${ktOrJavaExt}")
        save(vo2EntityMapperKt(mapperPackageName, itemClassName), vo2EntityFile)
        open(vo2EntityFile)
    }
}