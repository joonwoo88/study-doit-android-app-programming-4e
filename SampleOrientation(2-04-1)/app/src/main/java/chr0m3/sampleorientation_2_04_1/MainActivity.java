package chr0m3.sampleorientation_2_04_1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate()");

        editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                showToast("입력된 값을 변수에 저장했습니다." + name);
            }
        });

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            showToast("값을 복원했습니다." + name);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        showToast("onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("name", name);
    }

    public void showToast(String data) {
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }
}
