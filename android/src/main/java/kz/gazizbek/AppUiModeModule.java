package kz.gazizbek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AppUiModeModule.NAME)
public class AppUiModeModule extends ReactContextBaseJavaModule {
    public static final String NAME = "AppUiMode";

    public AppUiModeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setStyle(String mode) {
        int m = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
        if (mode.equals("dark")) {
            m = AppCompatDelegate.MODE_NIGHT_YES;
        } else if (mode.equals("light")) {
            m = AppCompatDelegate.MODE_NIGHT_NO;
        }
        AppCompatDelegate.setDefaultNightMode(m);
    }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void multiply(int a, int b, Promise promise) {
        promise.resolve(a * b);
    }

    public static native int nativeMultiply(int a, int b);
}
