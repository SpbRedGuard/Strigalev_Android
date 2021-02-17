package Strigalev_Androud.ru;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String NameSharedPreference = "LOGIN";
    // Имя параметра в настройках
    private static final String AppTheme = "APP_THEME";

    protected static final int RbStyleFirst = 0;
    protected static final int RbAppThemeLight = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.different_style_first));
    }
    private int getAppTheme (int codeStyle){
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }
    // Чтение настроек, параметр «тема»
    protected int getCodeStyle ( int codeStyle){
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(AppTheme, codeStyle);
    }
    // Сохранение настроек
    protected void setAppTheme ( int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }
    private int codeStyleToStyleId (int codeStyle){
        switch (codeStyle) {
            case RbStyleFirst:
                return R.style.different_style_first;
            case RbAppThemeLight:
                return R.style.AppThemeLight;

        }
        return codeStyle;
    }
    public abstract void onClick (View v);
}
