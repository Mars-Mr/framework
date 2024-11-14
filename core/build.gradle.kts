plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.viewpager2)
    //约束布局
    implementation(libs.androidx.constraintlayout)
    //布局容器
    implementation(libs.androidx.coordinatorlayout)
    //图片轮播框架依赖
    implementation(libs.banner)
    //卡片
    implementation(libs.androidx.cardview)
    //recyclerview
    implementation(libs.androidx.recyclerview)
    //高斯模糊
    implementation(libs.com.github.dimezis.blurView)
    implementation(libs.com.github.zaaach.cityPicker)
}