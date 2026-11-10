package com.sanzhan.checkin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(Color.rgb(25, 25, 21));
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(false);

        View webView = getBridge().getWebView();
        ViewGroup container = (ViewGroup) webView.getParent();
        ViewCompat.setOnApplyWindowInsetsListener(container, (view, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            ViewGroup.MarginLayoutParams layout = (ViewGroup.MarginLayoutParams) webView.getLayoutParams();
            int minTop = (int) (28 * getResources().getDisplayMetrics().density);
            layout.topMargin = Math.max(bars.top, minTop);
            layout.bottomMargin = bars.bottom;
            webView.setLayoutParams(layout);
            return WindowInsetsCompat.CONSUMED;
        });
        ViewCompat.requestApplyInsets(container);
    }
}
