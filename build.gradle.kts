import ProjectVersions.unethicaliteVersion

buildscript {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

plugins {
  `java-library`
  checkstyle
  kotlin("jvm") version "1.6.21"
  id("org.jetbrains.kotlin.plugin.lombok") version "1.6.21"
}

apply<BootstrapPlugin>()

allprojects {
  group = "net.unethicalite"

  project.extra["PluginProvider"] = "choppa"
  project.extra["ProjectSupportUrl"] = ""
  project.extra["PluginLicense"] = "3-Clause BSD License"
  project.extra["GithubUrl"] = "lalaland"

  apply<JavaPlugin>()
  apply(plugin = "java-library")
  apply(plugin = "kotlin")
  apply(plugin = "checkstyle")
  apply<MavenPublishPlugin>()

  repositories {
    mavenCentral()
    mavenLocal()
  }

  dependencies {
    annotationProcessor(Libraries.lombok)
    annotationProcessor(Libraries.pf4j)

    implementation("net.unethicalite:http-api:$unethicaliteVersion+")
    implementation("net.unethicalite:runelite-api:$unethicaliteVersion+")
    implementation("net.unethicalite:runelite-client:$unethicaliteVersion+")
    implementation("net.unethicalite.rs:runescape-api:$unethicaliteVersion+")

    implementation(Libraries.guice)
    implementation(Libraries.javax)
    implementation(Libraries.lombok)
    implementation(Libraries.pf4j)
  }

  configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  configure<PublishingExtension> {
    repositories { maven { url = uri("$buildDir/repo") } }
    publications { register("mavenJava", MavenPublication::class) { from(components["java"]) } }
  }

  tasks {
    withType<JavaCompile> { options.encoding = "UTF-8" }

    withType<AbstractArchiveTask> {
      isPreserveFileTimestamps = false
      isReproducibleFileOrder = true
      dirMode = 493
      fileMode = 420
    }

    compileKotlin { kotlinOptions.jvmTarget = "11" }

    //        register<Copy>("copyDeps") {
    //            into("./build/deps/")
    //            from(configurations["runtimeClasspath"])
    //        }
  }
}
