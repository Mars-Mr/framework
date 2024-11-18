plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.custom.jiguang"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        ndk {
            //选择要添加的对应 cpu 类型的 .so 库。
            abiFilters.addAll(arrayOf("armeabi-v7a", "arm64-v8a"))
            // 还可以添加 'x86', 'x86_64', 'mips', 'mips64'
        }

        manifestPlaceholders += mutableMapOf(
            "JPUSH_PKGNAME " to "${rootProject.extra.get("myApplicationId")}",
            "JPUSH_APPKEY" to "${rootProject.extra.get("jpushAppKey")}",
            "JPUSH_CHANNEL" to "developer-default",

            //xiaomi_config_start
            "XIAOMI_APPID" to "MI-小米的APPID",
            "XIAOMI_APPKEY" to "MI-小米的APPKEY",
            //xiaomi_config_end
            //oppo_config_start
            "OPPO_APPKEY" to "OP-oppo的APPKEY",
            "OPPO_APPID" to "OP-oppo的APPID",
            "OPPO_APPSECRET" to "OP-oppo的APPSECRET",
            //oppo_config_end
            //vivo_config_start
            "VIVO_APPKEY" to "vivo的APPKEY",
            "VIVO_APPID" to "vivo的APPID",
            //honor_config_start
            "HONOR_APPID" to "honor的APPID",
           //honor_config_end

            "MY_APPLICATION_ID" to "${rootProject.extra.get("myApplicationId")}",

        )

        buildConfigField("String", "jpushAppKey", "\"${rootProject.extra.get("jpushAppKey")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.cn.jiguang.sdk.jpush)
    implementation(libs.cn.jiguang.sdk.plugin.xiaomi)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":logger-service"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}