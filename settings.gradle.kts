pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://jitpack.io")
        maven(url = "https://tencent-tds-maven.pkg.coding.net/repository/shiply/repo")
        maven(url = "https://maven.aliyun.com/repository/google")
        maven(url = "https://maven.aliyun.com/repository/public")
        maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":core-service")
include(":repository-service")
include(":repository-service:net")
include(":repository-service:database")
include(":logger-service")
include(":repository-service:mmkv")
include(":eventbus")
include(":payment-service")
include(":push-service")
include(":push-service:getui")
include(":push-service:jiguang")
include(":update-service")
