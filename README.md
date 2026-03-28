# 🚀 EasyCards Android Library
[![](https://jitpack.io/v/Kishan8548/EasyCardsLibrary.svg)](https://jitpack.io/#Kishan8548/EasyCardsLibrary)

An incredibly lightweight, declarative, XML-first Material 3 Card Component designed specifically to help Junior Developers easily build beautiful dynamic UIs in Android!

With `EasyCards`, you never have to write convoluted programmatic Builder patterns in Kotlin. Just drop the component right into your `<LinearLayout>` or `<ConstraintLayout>` and instantly achieve sleek, flawlessly rendered cards!

## 📦 Installation

This library is distributed via JitPack. 

**1. Add the JitPack repository to your root `settings.gradle.kts`:**
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // <-- Add JitPack here!
    }
}
```

**2. Add the dependency to your app-level `build.gradle.kts`:**
```kotlin
dependencies {
    implementation("com.github.Kishan8548:EasyCardsLibrary:1.0.0")
}
```

## 🛠️ Usage

Building cards is brilliantly simple! Place an `EasyCardView` natively in your layout files (`activity_main.xml`, fragments, or Recycler items).

```xml
<com.example.easycards.EasyCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    
    <!-- Material Defaults for Structure -->
    app:cardCornerRadius="16dp"  
    app:cardElevation="6dp"      
    
    <!-- Text Customization -->
    app:ec_title="Chemistry"
    app:ec_description="Explore the chemical world"
    app:ec_titleColor="@android:color/white"
    
    <!-- Vibrant Background Gradients -->
    app:ec_backgroundGradientStart="#FFCA28"
    app:ec_backgroundGradientEnd="#FFA726"
    
    <!-- Local Drawables or Remote Image URLs supported natively! -->
    app:ec_imageUrl="https://images.unsplash.com/..." 
    />
```

### ✅ XML Attributes Catalog:
- **Core content:** `app:ec_title`, `app:ec_description`
- **Images:** `app:ec_imageUrl` *(Remote Web Images)*, `app:ec_imageSrc` *(Local Drawables)*
- **Typography styling:** `app:ec_titleColor`, `app:ec_descriptionColor`, `app:ec_titleTextSize`, `app:ec_descriptionTextSize`
- **Background finishes:** `app:ec_backgroundColor`, `app:ec_backgroundGradientStart`, `app:ec_backgroundGradientEnd`

## 🎨 System Theming Out-Of-The-Box
If you don't provide custom gradients or colors, it beautifully inherits your app's native Dark/Light mode theme without any layout breaks!

```xml
<!-- This natively adapts to Light/Dark Mode -->
<com.example.easycards.EasyCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:ec_title="Extra Curriculars"
    app:ec_description="Look, this card looks great by default safely running system aesthetics!" />
```

## 🧠 Behind the Scenes
- **`merge` Optimized:** Built aggressively avoiding nested view penalties!
- **Glide Integrated:** We inherently leverage robust image loading under the hood. Images are cropped and gracefully rounded automatically to fit the UI! 

### Author
Designed and open-sourced by [@Kishan8548](https://github.com/Kishan8548).
