package com.dgk.mvvm

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.dgk.mvvm.activity.res.layout.mvvmActivityXml
import com.dgk.mvvm.activity.src.app_package.mvvmAcitivityKt
import com.dgk.mvvm.activity.src.app_package.mvvmViewModelKt
import com.dgk.mvvm.activity.src.mvvmManifest
import java.io.File

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:12
 * @email dingguangkuo@163.com
 */
fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    className: String,
    layoutName: String,
    useCustomTitle: Boolean,
    packageName: String,
    useResPrefix: Boolean, resPrefix: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val manifestFile = File(moduleData.manifestDir, "AndroidManifest.xml")
    mergeXml(mvvmManifest(className, useCustomTitle, packageName), manifestFile)
    open(manifestFile)

    val activityFile = srcOut.resolve("${className}Activity.${ktOrJavaExt}")
    save(mvvmAcitivityKt(packageName, className, layoutName, useCustomTitle, useResPrefix, resPrefix), activityFile)
    open(activityFile)

    val viewModelFile = srcOut.resolve("${className}ViewModel.${ktOrJavaExt}")
    save(mvvmViewModelKt(packageName, className), viewModelFile)
    open(viewModelFile)

    val layoutFile = resOut.resolve("layout/${if (useResPrefix) resPrefix else ""}${layoutName}.xml")
    save(mvvmActivityXml(packageName, className), layoutFile)
    open(layoutFile)
}