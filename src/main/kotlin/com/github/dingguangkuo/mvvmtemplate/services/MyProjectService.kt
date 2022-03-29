package com.github.dingguangkuo.mvvmtemplate.services

import com.intellij.openapi.project.Project
import com.github.dingguangkuo.mvvmtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
