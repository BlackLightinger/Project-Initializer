package org.locker.start_android.datasource.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsBytes
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.util.toJsArray
import kotlinx.browser.document
import org.locker.start_android.datasource.remote.model.GenerateProjectDto
import org.locker.start_android.datasource.remote.model.GenerateResponseDto
import org.locker.start_android.datasource.remote.model.ProjectInfoDto
import org.locker.start_android.util.Config
import org.w3c.dom.HTMLElement
import org.w3c.dom.url.URL
import org.w3c.files.Blob
import org.w3c.files.BlobPropertyBag

class GenerateProjectService(private val client: HttpClient) : IGenerateProjectService {

    override suspend fun generate(project: GenerateProjectDto): String? {
        val response = client.post("${Config.SERVER_ADDRESS}/$GENERATE_ENDPOINT") {
            contentType(Json)
            setBody(project)
        }

        return if (response.status == HttpStatusCode.OK) response.body<GenerateResponseDto>().uuid else null
    }

    override suspend fun download(projectInfo: ProjectInfoDto) {
        val response = client.post("${Config.SERVER_ADDRESS}/$DOWNLOAD_ENDPOINT") {
            contentType(Json)
            setBody(projectInfo)
        }

        val r = response.bodyAsBytes().toJsArray()

        val jsArray = listOf(r).toJsArray() as JsArray<JsAny?>

        val blob = Blob(jsArray, BlobPropertyBag(type = "application/zip"))

        val blobUrl = URL.createObjectURL(blob)

        val a = document.createElement("a") as HTMLElement
        a.setAttribute("href", blobUrl)
        a.setAttribute("download", projectInfo.projectName)
        document.body?.appendChild(a)

        a.click()
        document.body?.removeChild(a)

        URL.revokeObjectURL(blobUrl)
    }

    private companion object {
        const val GENERATE_ENDPOINT = "generate"
        const val DOWNLOAD_ENDPOINT = "download"
    }
}
