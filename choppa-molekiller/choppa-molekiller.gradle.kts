version = "0.0.1"

project.extra["PluginName"] = "Choppa Molekiller"
project.extra["PluginDescription"] = ""

plugins{
    kotlin("kapt")
}

dependencies {
    kapt(Libraries.pf4j)
    implementation(fileTree("libs") { include("*.jar") })
}

tasks {
    jar {
        manifest {
            attributes(mapOf(
                "Plugin-Version" to project.version,
                "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                "Plugin-Provider" to project.extra["PluginProvider"],
                "Plugin-Dependencies" to nameToId("example-utils"),
                "Plugin-Description" to project.extra["PluginDescription"],
                "Plugin-License" to project.extra["PluginLicense"]
            ))
        }
    }
}
