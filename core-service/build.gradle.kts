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
    //约束布局
    api(libs.androidx.constraintlayout)
    //viewpager
    api(libs.androidx.viewpager2)
    //布局容器
    api(libs.androidx.coordinatorlayout)
    //图片轮播框架依赖
    api(libs.banner)
    //卡片
    api(libs.androidx.cardview)
    //recyclerview
    api(libs.androidx.recyclerview)
    //高斯模糊
    api(libs.com.github.dimezis.blurView)
    //城市选择器
    implementation(libs.com.github.zaaach.cityPicker)
    //权限
    implementation(libs.com.github.getActivity.permissions)
}