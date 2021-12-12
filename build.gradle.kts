/**
 * 🧧 Akali: Adds loveable red pandas into Minecraft! Who doesn't love a Red Panda in their world? :3
 * Copyright (C) 2021 Noel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
    id("com.diffplug.spotless") version "6.0.0"
    id("fabric-loom")
    java
    idea
}

group = "gay.floof"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.fabricmc.net")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:1.18.1")
    mappings("net.fabricmc:yarn:1.18.1+build.2:v2")
    modImplementation("net.fabricmc:fabric-loader:0.12.11")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.44.0+1.18")
}

spotless {
    java {
        trimTrailingWhitespace()
        licenseHeaderFile("${rootProject.projectDir}/assets/HEADING")
        endWithNewline()
        googleJavaFormat()
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"

        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(
                mapOf(
                    "version" to project.version
                )
            )
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.toString()))
        }

        withSourcesJar()
    }
}
