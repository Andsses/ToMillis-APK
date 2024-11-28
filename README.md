
# ToMillis

**ToMillis** es una aplicación que te ayuda a convertir unidades de tiempo en milisegundos de forma rápida y eficiente. 

[![Descargar en Google Play](https://upload.wikimedia.org/wikipedia/commons/7/78/Google_Play_Store_badge_EN.svg)](https://play.google.com/store/apps/details?id=com.tomillis)

---

## Capturas de pantalla

<img src="images/screen_one.webp" alt="Capture one" width="300"/> <img src="images/screen_two.webp" alt="Capture two" width="300"/>

---

## Características

- Interfaz intuitiva para realizar conversiones rápidas.
- Soporte para versiones anteriores de Android gracias a `coreLibraryDesugaring`.
- Implementación de Material Design 3.
- Navegación fluida con Jetpack Compose.

---

## Dependencias

El proyecto utiliza las siguientes dependencias para un desarrollo moderno y eficiente:

### Splash Screen
Para una experiencia de inicio agradable:
```gradle
implementation("androidx.core:core-splashscreen:1.0.0")
```

### Dagger Hilt
Para la inyección de dependencias:
```gradle
implementation("com.google.dagger:hilt-android:2.51.1")
kapt("com.google.dagger:hilt-android-compiler:2.51.1")
```

### Navigation con Hilt
Integración de navegación con Dagger Hilt:
```gradle
implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
```

### Core Library Desugaring
Para soporte de API modernas en versiones más antiguas de Android:
```gradle
coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
```

### Jetpack Compose y Material 3
Para crear la interfaz de usuario:
```gradle
implementation(libs.androidx.core.ktx)
implementation(libs.androidx.lifecycle.runtime.ktx)
implementation(libs.androidx.activity.compose)
implementation(platform(libs.androidx.compose.bom))
implementation(libs.androidx.ui)
implementation(libs.androidx.ui.graphics)
implementation(libs.androidx.ui.tooling.preview)
implementation(libs.androidx.material3)
```

### Testing
Configuración para pruebas unitarias y de interfaz:
```gradle
testImplementation(libs.junit)
androidTestImplementation(libs.androidx.junit)
androidTestImplementation(libs.androidx.espresso.core)
androidTestImplementation(platform(libs.androidx.compose.bom))
androidTestImplementation(libs.androidx.ui.test.junit4)
debugImplementation(libs.androidx.ui.tooling)
debugImplementation(libs.androidx.ui.test.manifest)
```

---

## Arquitectura

Clean Arquitecture

---

## Descarga la aplicación

Haz clic en el botón para descargar la aplicación desde Google Play:

[![Descargar en Google Play](https://upload.wikimedia.org/wikipedia/commons/7/78/Google_Play_Store_badge_EN.svg)](https://play.google.com/store/apps/details?id=com.tomillis)

## Developer

Andres Vaca

[LinkedIn](https://www.linkedin.com/in/andres-vaca-5794a7178/)
