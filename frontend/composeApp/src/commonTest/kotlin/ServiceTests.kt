import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.locker.start_android.datasource.remote.service.GenerateProjectService
import kotlin.test.Test
import kotlin.test.assertEquals


class ServiceTests {

    @Test
    fun generate_should_return_uuid_when_response_is_OK() = runTest {
        val expectedUuid = "test-uuid"

        val mockEngine = MockEngine { request ->
            assertEquals(HttpMethod.Post, request.method)
            assertEquals("/generate", request.url.encodedPath)

            respond(
                content = """{"uuid":"$expectedUuid"}""",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }

        val service = GenerateProjectService(client)

        val result = service.generate(DataSamples.generateProjectDto)

        assertEquals(expectedUuid, result)
    }

    @Test
    fun generate_should_return_null_when_response_is_not_OK() = runTest {
        val mockEngine = MockEngine { _ ->
            respond(
                content = "error",
                status = HttpStatusCode.BadRequest
            )
        }

        val client = HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }

        val service = GenerateProjectService(client)

        val result = service.generate(DataSamples.generateProjectDto)

        assertEquals(null, result)
    }
}

