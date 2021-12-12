rootProject.name = "Akali"

pluginManagement {
    repositories {
        maven {
            name = "fabric"
            url = uri("https://maven.fabricmc.net")
        }

        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("fabric-loom").version("0.10.64")
    }
}
