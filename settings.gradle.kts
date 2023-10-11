rootProject.name = "unethicalite-plugins"

//include("hoot-blackjack")
//include("hoot-trawler")
//include("hoot-pickpocket")
//include("hoot-aerialfishing")
//include("hoot-chins")
//include("hoot-notifier")
//include("hoot-karambwanfisher")

include("hoot-tempoross")

include("choppa-molekiller")
include("unethical-fighter")
include("unethical-butler")
include("unethical-birdhouses")
include("unethical-kebab-buyer")
include("unethical-autologin")
include("unethical-oneclick")
include("unethical-agility")
include("unethical-prayer")
include("unethical-explorer")
include("unethical-chopper")
include("unethical-zulrah")
include("unethical-cooker")
include("unethical-bankpin")
include("unethical-tempoross")
include("unethical-pickpocket")
include("unethical-logout")

include("m-autoswitcher")
include("m-powerfisher")
include("m-wintertodt")

include("example-kotlin")

for (project in rootProject.children) {
    project.apply {
        projectDir = file(name)
        buildFileName = "$name.gradle.kts"

        require(projectDir.isDirectory) { "Project '${project.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${project.path} must have a $buildFile build script" }
    }
}
