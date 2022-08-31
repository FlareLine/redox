// Project properties
// Redox
val modVersion: String by project
val modVersionType: String by project
val mavenGroup: String by project
val baseName: String by project
// Modrinth
val modrinthId: String by project
val modrinthSlug: String by project
// Loader
val minecraftVersion: String by project
val yarnMappings: String by project
val loaderVersion: String by project
// Fabric
val fabricVersion: String by project
val fabricKotlinVersion: String by project

base {
	archivesName.set(baseName)
}

plugins {
	id("fabric-loom")
	val kotlinVersion: String by System.getProperties()
	kotlin("jvm").version(kotlinVersion)
	id("com.modrinth.minotaur") version "2.+"
}

version = modVersion
group = mavenGroup

dependencies {
	minecraft("com.mojang", "minecraft", minecraftVersion)
	mappings("net.fabricmc", "yarn", yarnMappings, null, "v2")
	modImplementation("net.fabricmc", "fabric-loader", loaderVersion)
	modImplementation("net.fabricmc.fabric-api", "fabric-api", fabricVersion)
	modImplementation("net.fabricmc", "fabric-language-kotlin", fabricKotlinVersion)
}

tasks {
	val javaVersion = JavaVersion.VERSION_17
	withType<JavaCompile> {
		options.encoding = "UTF-8"
		sourceCompatibility = javaVersion.toString()
		targetCompatibility = javaVersion.toString()
		options.release.set(javaVersion.toString().toInt())
	}
	withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions { jvmTarget = javaVersion.toString() } }
	jar { from("LICENSE") { rename { "${it}_${base.archivesName}" } } }
	processResources {
		inputs.property("version", project.version)
		filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
	}
	java {
		toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
		sourceCompatibility = javaVersion
		targetCompatibility = javaVersion
		withSourcesJar()
	}
	modrinth {
		projectId.set(modrinthId)
		versionNumber.set(modVersion)
		versionType.set(modVersionType)
		uploadFile.set(jar.get())
		gameVersions.add(minecraftVersion)
		loaders.add("fabric")
		syncBodyFrom.set(project.file("README.md").path)
		dependencies {
			build
			required.project("fabric-api")
		}
		token.set(System.getenv("MODRINTH_TOKEN").orEmpty())
	}
}
