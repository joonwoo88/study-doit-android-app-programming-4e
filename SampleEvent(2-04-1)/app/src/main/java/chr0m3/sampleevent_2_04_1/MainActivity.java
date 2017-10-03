package chr0m3.sampleevent_2_04_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GestureDetector detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                print("onDown() 호출됨.");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                print("onShowPress() 호출됨.");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                print("onSingleTapUp() 호출됨.");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                print("onScroll() 호출됨 : " + v + ", " + v1);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                print("onLongPress() 호출됨.");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                print("onFling() 호출됨: " + v + ", " + v1);
                return true;
            }
        });

        textView0 = (TextView) findViewById(R.id.textView0);

        View view0 = findViewById(R.id.view0);
        view0.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    print("손가락 눌림 : " + curX + ", " + curY);
                } else if (action == MotionEvent.ACTION_MOVE) {
                    print("손가락 움직임 : " + curX + ", " + curY);
                } else if (action == MotionEvent.ACTION_UP) {
                    print("손가락 뗌 : " + curX + ", " + curY);
                }

                return true;
            }
        });

        View view1 = findViewById(R.id.view1);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "시스템 [BACK] 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public void print(String data) {
        textView0.append(data + "\n");
    }
}
