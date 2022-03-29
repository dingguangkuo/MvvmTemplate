package com.dgk.mvvm

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.dgk.mvvm.activity.src.app_package.mvvmViewModelKt
import com.dgk.mvvm.fragment.res.layout.mvvmFragmentXml
import com.dgk.mvvm.fragment.src.app_package.mvvmFragmentKt

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:12
 * @email dingguangkuo@163.com
 */
fun RecipeExecutor.mvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    className: String, layoutName: String,
    packageName: String,
    useResPrefix: Boolean, resPrefix: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val fragmentFile = srcOut.resolve("${className}Fragment.${ktOrJavaExt}")
    save(mvvmFragmentKt(className, layoutName, packageName, useResPrefix, resPrefix), fragmentFile)
    open(fragmentFile)

    val viewModelFile = srcOut.resolve("${className}ViewModel.${ktOrJavaExt}")
    save(mvvmViewModelKt(packageName, className), viewModelFile)
    open(viewModelFile)

    val layoutFile = resOut.resolve("layout/${if (useResPrefix) resPrefix else ""}${layoutName}.xml")
    save(mvvmFragmentXml(packageName, className), layoutFile)
    open(layoutFile)
}