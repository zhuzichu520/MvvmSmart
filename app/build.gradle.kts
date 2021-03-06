plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

Config.initJenkinsProperties(project)

android {

    compileSdkVersion(Config.compileSdkVersion())

    signingConfigs {
        create("appSign") {
            keyAlias = Config.keyAlias()
            keyPassword = Config.keyPassword()
            storeFile = file(Config.storeFile())
            storePassword = Config.storePassword()
        }
    }

    defaultConfig {
        applicationId = Config.applicationId()
        minSdkVersion(Config.minSdkVersion())
        targetSdkVersion(Config.targetSdkVersion())
        versionCode = Config.versionCode()
        versionName = Config.versionName()
        signingConfig = signingConfigs.getByName("appSign")
//        renderscriptTargetApi = 18
//        renderscriptSupportModeEnabled = true
        resValue("string", "app_name_new", Config.appName())
        val fields = Config.getBuildConfigFields()
        fields.forEach {
            buildConfigField(it[0], it[1], it[2])
        }
        manifestPlaceholders.apply {
            put("ic_launcher_new", "@mipmap/ic_launcher")
            put("ic_launcher_round_new", "@mipmap/ic_launcher_round")
        }
    }

    buildTypes {
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            isZipAlignEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    sourceSets {
        sourceSets["main"].apply {
            java.srcDir("src/main/kotlin")
        }
    }
}

//configurations.all {
//    resolutionStrategy {
//        resolutionStrategy.eachDependency {
//            if (this.requested.group == "androidx.activity") {
//                this.useVersion("1.1.0")
//            }
//        }
//    }
//}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to "*.jar"))
    api(project(path = ":shared"))
    kapt(Dep.kaptDaggerCompiler)
    kapt(Dep.kaptDaggerProcessor)
    kapt(Dep.kaptRxhttp)
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.0-beta-3")
}
