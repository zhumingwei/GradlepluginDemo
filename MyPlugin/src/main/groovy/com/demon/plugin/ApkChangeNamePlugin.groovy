package com.demon.plugin

import org.gradle.api.Project
import org.gradle.api.Plugin

class ApkChangeNamePlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {

        if(!project.android){
            throw new IllegalStateException('Must apply \'com.android.application\' or \'com.android.library\' first!');
        }
        System.out.println("hello gradle")

        project.android.applicationVariants.all{
            variant ->
                variant.outputs.all{
                    outputFileName = "${variant.name}-${variant.versionName}.apk"
                }
        }
    }
}