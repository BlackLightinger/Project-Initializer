package com.example.datasource.util

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object ZipManager {
    fun createZip(src: String, dst: String, projectName: String) {
        val sourceDir = File(src)

        ZipOutputStream(BufferedOutputStream(FileOutputStream(dst))).use { zos ->
            zipFiles(zos, sourceDir, src, projectName)
        }
    }

    private fun zipFiles(
        outStream: ZipOutputStream,
        src: File,
        projectRootDir: String,
        projectName: String
    ) {
        src.listFiles()?.forEach { file ->
            val relativeFilePath = file.path.drop(projectRootDir.length)
            val filePath = "$projectName$relativeFilePath"
            val newPath = "$filePath${if (file.isDirectory) "/" else ""}"
            outStream.putNextEntry(ZipEntry(newPath))

            if (file.isDirectory)
                zipFiles(outStream, file, projectRootDir, projectName)
            else
                BufferedInputStream(FileInputStream(file)).use { input ->
                    input.copyTo(outStream)
                }
        }
    }
}