package Strigalev_Androud.ru;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);
        initThemeChooser();
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.rb_different_style_first),
                RbStyleFirst);
        initRadioButton(findViewById(R.id.rb_AppThemeLight),
                RbAppThemeLight);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(RbStyleFirst))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }
}