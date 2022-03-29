package com.dgk

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.dgk.mvvm.mvvmActivityRecipe
import com.dgk.mvvm.mvvmFragmentRecipe
import com.dgk.mvvm.mvvmPageActivityRecipe
import com.dgk.mvvm.mvvmPageFragmentRecipe
import java.io.File

/**
 *
 * @author Guangkuo
 * @date 2021/8/4 11:06
 * @email dingguangkuo@163.com
 */
class MvvmPluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> {
        return listOf(
            mvvmActivityTemplate, mvvmFragmentTemplate,
            mvvmPageActivityTemplate, mvvmPageFragmentTemplate
        )
    }

    private val mvvmActivityTemplate
        get() = template {
            revision = 1
            name = "Mvvm Activity"
            description = "Mvvm Activity"
            minApi = MIN_API
            minBuildApi = MIN_API
            category = Category.Activity
            formFactor = FormFactor.Mobile
            screens = listOf(
                WizardUiContext.ActivityGallery,
                WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule
            )
            thumb { File("template_empty_activity.png") }

            val packageName = defaultPackageNameParameter
            widgets(
                TextFieldWidget(activityClassName),
                TextFieldWidget(activityLayoutName),
                CheckBoxWidget(useCustomTitle),
                CheckBoxWidget(useResPrefix),
                TextFieldWidget(resPrefix),
                PackageNameWidget(packageName)
            )
            recipe = { data: TemplateData ->
                mvvmActivityRecipe(
                    data as ModuleTemplateData,
                    activityClassName.value, activityLayoutName.value,
                    useCustomTitle.value,
                    packageName.value,
                    useResPrefix.value, resPrefix.value
                )
            }
        }

    private val mvvmPageActivityTemplate
        get() = template {
            revision = 1
            name = "Mvvm Page Activity"
            description = "Mvvm Page Activity"
            minApi = MIN_API
            minBuildApi = MIN_API
            category = Category.Activity
            formFactor = FormFactor.Mobile
            screens = listOf(
                WizardUiContext.ActivityGallery,
                WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule
            )
            thumb { File("template_empty_activity.png") }

            val packageName = defaultPackageNameParameter
            widgets(
                TextFieldWidget(activityClassName),
                TextFieldWidget(activityLayoutName),
                CheckBoxWidget(useCustomTitle),
                TextFieldWidget(itemClassName),
                CheckBoxWidget(useResPrefix),
                TextFieldWidget(resPrefix),
                PackageNameWidget(packageName)
            )
            recipe = { data: TemplateData ->
                mvvmPageActivityRecipe(
                    data as ModuleTemplateData,
                    activityClassName.value,
                    activityLayoutName.value,
                    useCustomTitle.value,
                    itemClassName.value,
                    "item_${camelCaseToUnderlines(itemClassName.value)}",
                    packageName.value,
                    useResPrefix.value, resPrefix.value
                )
            }
        }

    private val activityClassName = stringParameter {
        name = "Activity Name"
        default = "Main"
        help = "Input Activity Name"
        constraints = listOf(Constraint.CLASS)
    }

    private val activityLayoutName = stringParameter {
        name = "Layout Name"
        default = "activity_main"
        help = "Input Layout Name"
        suggest = { activityToLayout(activityClassName.value) }
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
    }

    private val useCustomTitle = booleanParameter {
        name = "Custom Title"
        default = true
        help = "Use Custom Title"
    }

    private val itemClassName = stringParameter {
        name = "Item Name"
        default = "Main"
        help = "Input Item Name"
        suggest = { activityClassName.value }
        constraints = listOf(Constraint.NONEMPTY)
    }

    private val mvvmFragmentTemplate
        get() = template {
            revision = 1
            name = "Mvvm Fragment"
            description = "Mvvm Fragment"
            minApi = MIN_API
            minBuildApi = MIN_API
            category = Category.Fragment
            formFactor = FormFactor.Mobile
            screens = listOf(
                WizardUiContext.FragmentGallery,
                WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule
            )
            thumb { File("template_empty_activity.png") }

            val packageName = defaultPackageNameParameter

            widgets(
                TextFieldWidget(fragmentClassName),
                TextFieldWidget(fragmentLayoutName),
                CheckBoxWidget(useResPrefix),
                TextFieldWidget(resPrefix),
                PackageNameWidget(packageName)
            )

            recipe = { data: TemplateData ->
                mvvmFragmentRecipe(
                    data as ModuleTemplateData,
                    fragmentClassName.value, fragmentLayoutName.value,
                    packageName.value,
                    useResPrefix.value, resPrefix.value
                )
            }
        }

    private val mvvmPageFragmentTemplate
        get() = template {
            revision = 1
            name = "Mvvm Page Fragment"
            description = "Mvvm Page Fragment"
            minApi = MIN_API
            minBuildApi = MIN_API
            category = Category.Fragment
            formFactor = FormFactor.Mobile
            screens = listOf(
                WizardUiContext.FragmentGallery,
                WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule
            )
            thumb { File("template_empty_activity.png") }

            val packageName = defaultPackageNameParameter

            widgets(
                TextFieldWidget(fragmentClassName),
                TextFieldWidget(fragmentLayoutName),
                TextFieldWidget(itemClassName2),
                CheckBoxWidget(useResPrefix),
                TextFieldWidget(resPrefix),
                PackageNameWidget(packageName)
            )

            recipe = { data: TemplateData ->
                mvvmPageFragmentRecipe(
                    data as ModuleTemplateData,
                    fragmentClassName.value, fragmentLayoutName.value,
                    itemClassName2.value,
                    "item_${camelCaseToUnderlines(itemClassName2.value)}",
                    packageName.value,
                    useResPrefix.value, resPrefix.value
                )
            }
        }

    private val fragmentClassName = stringParameter {
        name = "Fragment Name"
        default = "Main"
        help = "Input Fragment Name"
        constraints = listOf(Constraint.CLASS)
    }

    private val fragmentLayoutName = stringParameter {
        name = "Layout Name"
        default = "fragment_main"
        help = "Input Layout Name"
        suggest = { fragmentToLayout(fragmentClassName.value) }
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
    }

    private val itemClassName2 = stringParameter {
        name = "Item Name"
        default = "Main"
        help = "Input Item Name"
        suggest = { fragmentClassName.value }
        constraints = listOf(Constraint.NONEMPTY)
    }

    private val useResPrefix = booleanParameter {
        name = "Resource Prefix"
        default = false
        help = "Use Resource Prefix"
    }

    private val resPrefix = stringParameter {
        name = "Resource Prefix Name"
        visible = { useResPrefix.value }
        default = ""
        help = "Input Resource Prefix Name"
        constraints = listOf(Constraint.NONEMPTY, Constraint.LAYOUT)
    }

    private val defaultPackageNameParameter
        get() = stringParameter {
            name = "Package Name"
            visible = { !isNewModule }
            default = "com.dgk.mvvm"
            help = "Input Package Name"
            suggest = { packageName }
            constraints = listOf(Constraint.PACKAGE)
        }
}