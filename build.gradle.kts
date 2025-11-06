plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "edu.bsu.cs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.github.palexdev:materialfx:11.17.0")
}

tasks.test {
    useJUnitPlatform()
}

javafx {
    version = "22"
    modules("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("edu.bsu.cs.UI")
}

tasks.named<JavaExec>("run") {
    jvmArgs = listOf("--enable-native-access=javafx.graphics")
}