package Strigalev_Androud.ru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity{

    /*
        Задание 4-го урока
    1.	Переделайте все кнопки на материал.
    2.	Все размеры и строки сделайте ресурсами.
    3.	Создайте стиль для своего приложения.
    4.	* Создайте светлую и тёмную тему для приложения.

        Задание 5-го урока
    1.	Создайте активити с настройками, где включите выбор темы приложения.
    2.	Доделайте приложение «Калькулятор». Это последний урок с созданием приложения «Калькулятор».
    3.	* Сделайте интент-фильтр для запуска калькулятора извне, а также напишите тестовое приложение, запускающее приложение-калькулятор.
     */


    private Logic_calc calculator;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberIds = new int[]{
                R.id.button_double0,
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9
        };

        int[] actionsIds = new int[]{
                R.id.addition,
                R.id.subtraction,
                R.id.multiplication,
                R.id.division,
                R.id.button_equality
        };

        text = findViewById(R.id.textView);
        calculator = new Logic_calc();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });

        findViewById(R.id.correct_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.correct();
                text.setText(calculator.getText());
            }
        });
    }

    Button btnSettings = findViewById(R.id.settings);
    btnSettings.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        // Чтобы стартовать активити, надо подготовить интент
        // В данном случае это будет явный интент
        Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
        // Метод стартует активити, указанную в интенте
        startActivity(runSettings);
    }
    }
}

