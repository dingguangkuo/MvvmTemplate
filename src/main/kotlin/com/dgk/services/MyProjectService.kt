package com.dgk.services

import com.intellij.openapi.project.Project
import com.dgk.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
