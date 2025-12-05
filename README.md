# Android Project Overview

## 1. 项目简介
- **应用结构**：包含 `LoginActivity`、`MainActivity`、`ProfileActivity` 等基础界面，用于演示用户登录后的主界面与资料页流程。
- **主要模块**：应用当前位于 `app/` 模块，可根据需要继续扩展业务逻辑、网络层或数据存储。

## 2. 环境与依赖
- **开发工具**：Android Studio Giraffe 及以上版本（或 IntelliJ 带 Android 插件）。
- **JDK**：11（`app/build.gradle` 中的 `compileOptions` 指定为 Java 11）。
- **Android SDK**：34（`compileSdk` 与 `targetSdk`）。
- **Gradle**：使用仓库内置的 `gradlew` Wrapper，确保无需额外安装。

> 如果首次配置环境，记得在 Android Studio 中安装对应版本的 SDK Platform、Build-Tools，并在 `local.properties` 中正确指定 `sdk.dir`。

## 3. 运行步骤
```powershell
# 1. 清理并编译 Debug 版本
./gradlew clean assembleDebug

# 2. 将 Debug 包安装到已连接的设备/模拟器
./gradlew installDebug
```

- 也可以在 Android Studio 中选择 `Run > Run 'app'`，自动完成编译与部署。
- 若需要 Release 构建，先在 `app/build.gradle` 配置签名信息，再执行 `./gradlew assembleRelease`。

## 4. 测试
```powershell
# 运行本地单元测试
./gradlew test

# 运行仪器化测试（设备或模拟器必须在线）
./gradlew connectedAndroidTest
```



