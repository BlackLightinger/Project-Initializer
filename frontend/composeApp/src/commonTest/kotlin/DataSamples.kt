import org.locker.start_android.datasource.remote.model.BuildSrcDto
import org.locker.start_android.datasource.remote.model.GenerateProjectDto

object DataSamples {
    val generateProjectDto = GenerateProjectDto(
        BuildSrcDto(
            targetSdk = 10,
            minSdk = 20,
            compileSdk = 10,
            applicationId = "com.example"
        )
    )
}
