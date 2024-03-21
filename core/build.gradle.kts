import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import xyz.jpenilla.runpaper.RunPaperPlugin
import xyz.jpenilla.runpaper.task.RunServer

plugins {
    id("xyz.jpenilla.run-paper") version "2.2.3"
}

repositories {
    maven("https://repo.purpurmc.org/snapshots")
}

dependencies {

    compileOnly("org.purpurmc.purpur:purpur-api:1.20.4-R0.1-SNAPSHOT")

    implementation("eu.okaeri:okaeri-platform-bukkit:0.4.18")
    implementation("eu.okaeri:okaeri-configs-json-simple:5.0.1")
    implementation("eu.okaeri:okaeri-persistence-redis:2.0.3")
    implementation("eu.okaeri:okaeri-persistence-mongo:2.0.3")
    implementation("eu.okaeri:okaeri-persistence-jdbc:2.0.3")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.3.3")
    implementation("com.h2database:h2:2.2.224")
}

tasks.withType<ShadowJar> {

    relocate("eu.okaeri", "org.example.libs.eu.okaeri")
    relocate("io.lettuce.core", "org.example.libs.io.lettuce.core")
    relocate("io.netty", "org.example.libs.io.netty")
    relocate("reactor", "org.example.libs.reactor")
    relocate("org.reactivestreams", "org.example.libs.org.reactivestreams")
    relocate("org.bson", "org.example.libs.org.bson")
    relocate("com.mongodb", "org.example.libs.com.mongodb")
    relocate("com.zaxxer.hikari", "org.example.libs.com.zaxxer.hikari")
    relocate("org.slf4j", "org.example.libs.org.slf4j")
    relocate("org.mariadb.jdbc", "org.example.libs.org.mariadb.jdbc")
    relocate("com.h2database", "org.example.libs.com.h2database")
    relocate("org.json.simple", "org.example.libs.org.json.simple")

}

tasks.withType<RunServer> {
    minecraftVersion("1.20.4")
}