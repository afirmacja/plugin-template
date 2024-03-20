plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

subprojects {
    group = "org.example"
    version = "1.0-SNAPSHOT"

    apply(plugin = "java-library")

    repositories {
        mavenCentral()
        maven("https://storehouse.okaeri.eu/repository/maven-public")
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    apply(plugin = "com.github.johnrengelman.shadow")

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
            options.release.set(17)
            options.compilerArgs.add("-parameters")
        }
        javadoc {
            options.encoding = Charsets.UTF_8.name()
        }
        processResources {
            filteringCharset = Charsets.UTF_8.name()
        }
    }

    dependencies {
        val lombok = "1.18.32"
        compileOnly("org.projectlombok:lombok:$lombok")
        annotationProcessor("org.projectlombok:lombok:$lombok")
        testCompileOnly("org.projectlombok:lombok:$lombok")
        testAnnotationProcessor("org.projectlombok:lombok:$lombok")
    }

}