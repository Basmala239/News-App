KMPNewsDemo — Kotlin Multiplatform news app (Android + iOS)

This repository is a Compose Multiplatform Kotlin project that fetches news and demonstrates a small app architecture with:

- Network layer (Ktor)
- Local persistence (Room on Android)
- Domain / use-case layer
- Presentation with Jetpack Compose (shared UI for Android)
- Dependency injection with Koin

Key implemented features

- Article list fetched from a news API (see `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/data/network/ArticleService.kt`)
- Add / remove favorites using a heart button on each item
- Favorites screen showing saved articles
- Date formatting for publish dates and a small "NEW" badge for recent items

Quick start (Windows, PowerShell)

1. Make sure Android SDK and an emulator or device are available.
2. (Optional) Add adb to your PATH so you can use logcat. Example to add temporarily in PowerShell:
```powershell
$env:PATH += ";C:\Users\<YourUser>\AppData\Local\Android\Sdk\platform-tools"
```
3. Build the app:
```powershell
.\gradlew.bat :androidApp:assembleDebug --stacktrace
```
4. Install on the connected device/emulator:
```powershell
.\gradlew.bat :androidApp:installDebug --stacktrace
```
5. Launch from your emulator or Android Studio. To capture logs (if adb in PATH):
```powershell
# clear logs
adb logcat -c
# run app and capture logs to file
adb logcat > logcat_full.txt
# or filter for crashes
adb logcat | findstr /R "FATAL EXCEPTION\|AndroidRuntime" > crash_lines.txt
```

Project layout (important folders)

- `androidApp/` — Android application entry (MainActivity, Application)
- `shared/` — shared module with commonMain / androidMain / iosMain
  - `shared/src/commonMain/kotlin` contains domain, data, presentation code used across targets

Files changed / added while implementing favorites & UI

- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/domain/Article.kt` — added `isFavorite`
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/persentation/ui/NewsItem.kt` — added heart button + date badge
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/persentation/ui/AllNewsScreen.kt` — wired favorite actions
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/persentation/FavoritesViewModel.kt` — new
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/persentation/ui/FavoritesScreen.kt` — new
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/data/repository/Repository.kt` — persist/get favorites, mark network items as favorite
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/data/local/ArticleDao.kt` — added delete method
- `shared/src/commonMain/kotlin/com/example/kmpnewsdemo/di/*` — DI registrations updated

Notes, caveats and recommendations

- The sample uses the NewsAPI key embedded in `ArticleService.kt` — do not keep API keys in source for production.
- Date formatting currently uses `java.time` in the shared module which works on Android/JVM but is not portable to native iOS targets. If you need iOS support for formatted dates, convert the date helpers to `expect/actual` (platform-specific implementations).
- Favorites are matched by article title when saving/removing. If titles are not unique in your dataset, switch to an explicit stable id.

Suggested next steps

- Replace the boolean screen toggle in `App.kt` with Compose Navigation for better navigation.
- Move date utilities to a multiplatform-safe expect/actual pair if targeting iOS.
- Add animations to the heart toggle and NEW badge.

If you hit a runtime crash, collect Logcat (FATAL EXCEPTION block) and paste it here — I can analyze and fix it.

Learn more about Kotlin Multiplatform: https://kotlinlang.org/docs/multiplatform.html
