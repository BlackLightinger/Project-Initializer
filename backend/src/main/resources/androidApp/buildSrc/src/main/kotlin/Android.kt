import org.gradle.api.JavaVersion

object Android {
    object CompileOptions {
        val sourceCompatibility = JavaVersion.sourceCompatibilityPlug
        val targetCompatibility = JavaVersion.targetCompatibilityPlug
//        VERSION_1_8
    }

    object DefaultConfig {
        const val targetSdk = targetSdkPlug
        const val compileSdk = compileSdkPlug
        const val minSdk = minSdkPlug
        const val versionCode = versionCodePlug
        const val versionName = "versionNamePlug"
        const val applicationId = "applicationIdPlug"
        const val testInstrumentationRunner = "testInstrumentationRunnerPlug"
    }

    object BuildFeatures {
        const val dataBindingState = dataBindingStatePlug
        const val viewBindingState = viewBindingStatePlug
    }

    object KotlinOptions {
        const val jvmTarget = "jvmTargetPlug"
    }
}