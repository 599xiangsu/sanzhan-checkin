# 三战手记

三国志战略版个人记录工具，包含角色切换、抽卡、寻访、驯马、打铁记录，以及赛季边界设置、统计和版本检查。记录按角色保存在本机，不上传用户数据。

## Android APK

需要 Node.js、JDK 21 和 Android SDK 35。

```sh
npm install
npx cap sync android
cd android
gradlew.bat assembleDebug
```

APK 输出位置：`android/app/build/outputs/apk/debug/app-debug.apk`。

## 发布新版本

更新 `APP_VERSION`、`android/app/build.gradle` 中的 `versionCode` / `versionName` 和 `package.json` 版本号，然后提交并推送对应版本标签（例如 `v1.2.0`）。GitHub Actions 会自动构建 APK 并创建 Release，App 内的“检查更新”会读取最新 Release。

## Web 预览

通过本地静态服务器访问 `index.html`。`www/` 是 Android WebView 的打包目录，由根目录的页面和 `assets/` 同步生成。
