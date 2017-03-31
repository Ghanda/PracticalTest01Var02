package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {

    private EditText topEditText = null;
    private EditText bottomEditText = null;
    private Button leftButton = null;
    private Button rightButton = null;
    private TextView textResult = null;
    private Button secondaryActivityButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int topNumber = Integer.parseInt(topEditText.getText().toString());
            int bottomNumber = Integer.parseInt(bottomEditText.getText().toString());
            switch(view.getId()) {
                case R.id.left_button:
                    textResult.setText(String.valueOf(topNumber + bottomNumber));
                    break;
                case R.id.right_button:
                    textResult.setText(String.valueOf(topNumber - bottomNumber));
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        topEditText = (EditText)findViewById(R.id.top_edit_text);
        bottomEditText = (EditText)findViewById(R.id.bottom_edit_text);
        topEditText.setText(String.valueOf(1));
        bottomEditText.setText(String.valueOf(1));

        textResult = (TextView)findViewById(R.id.text_result);

        leftButton = (Button)findViewById(R.id.left_button);
        rightButton = (Button)findViewById(R.id.right_button);

        leftButton.setOnClickListener(buttonClickListener);
        rightButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("topNumber")) {
                topEditText.setText(savedInstanceState.getString("topNumber"));
            } else {
                topEditText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("bottomNumber")) {
                bottomEditText.setText(savedInstanceState.getString("topNumber"));
            } else {
                bottomEditText.setText(String.valueOf(0));
            }
        } else {
            topEditText.setText(String.valueOf(0));
            bottomEditText.setText(String.valueOf(0));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main ,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("topNumber", topEditText.getText().toString());
        savedInstanceState.putString("BottomNumber", bottomEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("bottomNumber")) {
            bottomEditText.setText(savedInstanceState.getString("bottomNumber"));
        } else {
            bottomEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("topNumber")) {
            topEditText.setText(savedInstanceState.getString("topNumber"));
        } else {
            topEditText.setText(String.valueOf(0));
        }
    }
}
