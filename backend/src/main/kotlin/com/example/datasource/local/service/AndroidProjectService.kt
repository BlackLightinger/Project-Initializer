package com.example.datasource.local.service

import com.example.datasource.local.model.*
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.UUID
import kotlin.reflect.full.memberProperties

class AndroidProjectService : IAndoidProjectService {
    private val projectPath: String = File("").toPath().toAbsolutePath().toString()
    private val userProjectsDir = "$projectPath/projects/"

    private val androidProjectPathString: String = javaClass.getResource("/androidApp").file
    private val androidProjectTemplatePath: Path = File(androidProjectPathString).toPath()

    override fun getProjectPathByUuid(uuid: UUID): FilePathDto? {
        val dirPath = "$userProjectsDir$uuid"
        return if (File(dirPath).exists()) FilePathDto(dirPath) else null
    }

    override fun getNewTemplateProject(): UUID {
        val uuid = UUID.randomUUID()
        val dst: Path = resolveNewFilePath(uuid)

        Files.walk(androidProjectTemplatePath).forEach { filePath ->
            Files.copy(
                filePath,
                dst.resolve(androidProjectTemplatePath.relativize(filePath)),
                StandardCopyOption.REPLACE_EXISTING
            )
        }
        return uuid
    }

    override fun setBuildSrcConfig(uuid: UUID, buildSrc: BuildSrcDto) {
        val newProjectPath = getProjectPathByUuid(uuid) ?: return
        val newBuildSrcPath = "${newProjectPath.filePath}$RELATIVE_BUILD_SRC_PATH"
        val file = File(newBuildSrcPath)

        val content = file.readText()
        val newContent = BuildSrcDto::class.memberProperties.fold(content) { text, member ->
            text.replace("${member.name}Plug", member.get(buildSrc).toString())
        }
        file.writeText(newContent)
    }

    override fun setLibsVersionsConfig(uuid: UUID, libsVersions: LibsVersionsDto) {
        val newProjectPath = getProjectPathByUuid(uuid) ?: return
        val newLibsVersionsPath = "${newProjectPath.filePath}$RELATIVE_LIBS_VERSIONS_PATH"
        val file = File(newLibsVersionsPath)

        val content = file.readText()
        val newContent = LibsVersionsDto::class.memberProperties.fold(content) { text, member ->
            text.replace("${member.name}Plug", member.get(libsVersions).toString())
        }
        file.writeText(newContent)
    }

    private fun resolveNewFilePath(uuid: UUID): Path {
        createProjectsDir()
        val newName = "$userProjectsDir/$uuid"
        return File(newName).toPath()
    }

    private fun createProjectsDir() {
        val dir = File(userProjectsDir)
        if (!dir.exists())
            dir.mkdir()
    }

    private companion object {
        const val RELATIVE_LIBS_VERSIONS_PATH: String = "/gradle/libs.versions.toml"
        const val RELATIVE_BUILD_SRC_PATH: String = "/buildSrc/src/main/kotlin/Android.kt"
    }
}

//fun main()
//{
//    val libs = LibsVersionsDto("7.4.2",
//        "1.7.10",
//        "1.7.0",
//        "1.6.1",
//        "1.9.0",
//        "2.0.4",
//        "4.13.2",
//        "1.1.5",
//        "3.5.1"
//    )
//    val build = BuildSrcDto(
//        "VERSION_1_8",
//        "VERSION_1_8",
//        33,
//        24,
//        3234,
//        1,
//        "1.0",
//        "com.example.project_initializer",
//        "androidx.test.runner.AndroidJUnitRunner",
//        true,
//        true,
//        "1.8"
//    )
//    val service = AndroidProjectService()
//    val uuid = service.getNewTemplateProject()
//    service.setLibsVersionsConfig(uuid, libs)
//    service.setBuildSrcConfig(uuid, build)
//    println(service.getProjectPathByUuid(uuid))
//}