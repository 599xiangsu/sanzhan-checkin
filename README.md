# 三战手记

三国志战略版个人记录工具，包含抽卡、寻访、驯马、打铁记录，以及赛季边界设置和统计。记录保存在本机，不上传用户数据。

## Android APK

需要 Node.js、JDK 21 和 Android SDK 35。

```sh
npm install
npx cap sync android
cd android
gradlew.bat assembleDebug
```

APK 输出位置：`android/app/build/outputs/apk/debug/app-debug.apk`。

## Web 预览

通过本地静态服务器访问 `index.html`。`www/` 是 Android WebView 的打包目录，由根目录的页面和 `assets/` 同步生成。
