plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.7.4"
    id("com.gradleup.shadow") version "8.3.5"
}

group = "dev.cortex"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_21

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.21.3-R0.1-SNAPSHOT")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.10.17")
    implementation("dev.jorel:commandapi-bukkit-shade:9.6.0")
}

tasks {
    shadowJar {
        relocate("com.github.stefvanschie.inventoryframework", "dev.cortex.IF")
        relocate("dev.jorel.commandapi", "dev.cortex.commandapi")
    }

    build {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()

        options.release.set(21)
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
}

