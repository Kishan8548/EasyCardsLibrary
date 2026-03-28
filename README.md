# 🚀 EasyCards Android Library
[![](https://jitpack.io/v/Kishan8548/EasyCardsLibrary.svg)](https://jitpack.io/#Kishan8548/EasyCardsLibrary)

An incredibly lightweight, declarative, XML-first Material 3 Card Component designed specifically to help Junior Developers easily build beautiful dynamic UIs in Android!

With `EasyCards`, you never have to write a single line of Kotlin to build stunning cards. Just drop it in your XML layout and all the heavy lifting is done for you automatically!

---

## ✨ What Makes It Different From a Plain CardView?

A standard `MaterialCardView` gives you a blank box. You have to manually set up `TextView`, `ImageView`, load images with Glide, write gradient drawables, and handle all the styling yourself in Kotlin.

**EasyCards does all of that for you, natively in XML:**

| Feature | MaterialCardView | EasyCardView |
|---|---|---|
| Title & Description | ❌ Manual setup | ✅ `app:ec_title` |
| Remote Image Loading | ❌ Glide setup in Kotlin | ✅ `app:ec_imageUrl` |
| Local Drawable Image | ❌ Manual `ImageView` | ✅ `app:ec_imageSrc` |
| Rounded Image Corners | ❌ Custom Glide transform | ✅ Auto-rounded |
| Gradient Background | ❌ XML drawable file needed | ✅ `app:ec_backgroundGradientStart/End` |
| System Theme Adaptive | ✅ Yes | ✅ Yes (inherited) |

---

## 🎨 System Theming Out-Of-The-Box

The most powerful feature: **you don't have to define anything.** If you skip gradients or colors, the card automatically adapts to the user's Light/Dark mode theme using Material 3 design tokens. Zero configuration required!

```xml
<com.example.easycards.EasyCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:ec_title="Extra Curriculars"
    app:ec_description="This card perfectly adapts to Light and Dark mode automatically!" />
```

---

## 🛠️ Full Usage

When you want full control — add gradients and images with simple XML attributes:

```xml
<com.example.easycards.EasyCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:ec_title="Chemistry"
    app:ec_description="Explore the chemical world"
    app:ec_imageUrl="https://images.unsplash.com/..." />
```

Want gradients and custom colors too? Totally optional:

```xml
<com.example.easycards.EasyCardView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:ec_title="Chemistry"
    app:ec_description="Explore the chemical world"
    app:ec_imageUrl="https://images.unsplash.com/..."
    app:ec_titleColor="@android:color/white"
    app:ec_descriptionColor="#E6FFFFFF"
    app:ec_backgroundGradientStart="#FFCA28"
    app:ec_backgroundGradientEnd="#FFA726" />
```

### ✅ Full XML Attributes Catalog

| Attribute | Description |
|---|---|
| `app:ec_title` | Card title text |
| `app:ec_description` | Card description text |
| `app:ec_imageUrl` | Remote image URL (loaded via Glide) |
| `app:ec_imageSrc` | Local drawable resource (e.g. `@drawable/my_image`) |
| `app:ec_titleColor` | Title text color |
| `app:ec_descriptionColor` | Description text color |
| `app:ec_titleTextSize` | Title font size |
| `app:ec_descriptionTextSize` | Description font size |
| `app:ec_backgroundColor` | Solid background color |
| `app:ec_backgroundGradientStart` | Gradient start color |
| `app:ec_backgroundGradientEnd` | Gradient end color |

> All standard `MaterialCardView` attributes like `app:cardCornerRadius` and `app:cardElevation` are also fully supported!

---

## 📦 Installation

**1. Add the JitPack repository to your root `settings.gradle.kts`:**
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

**2. Add the dependency to your app-level `build.gradle.kts`:**
```kotlin
dependencies {
    implementation("com.github.Kishan8548:EasyCardsLibrary:1.0.0")
}
```

---

## 🧠 Behind the Scenes
- **`merge` Optimized:** Zero nested view penalties — `EasyCardView` IS the `MaterialCardView`.
- **Glide Integrated:** Automatic image loading with `CenterCrop` and graceful rounded corners.
- **No Kotlin Required:** Completely driven from XML. Perfect for junior developers.

### Author
Designed and open-sourced by [@Kishan8548](https://github.com/Kishan8548).
