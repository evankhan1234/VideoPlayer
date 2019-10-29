package anywhere.com.videoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    Button buttonPlayUrlVideo;

    Button buttonPlayDefaultVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        buttonPlayUrlVideo=findViewById(R.id.buttonPlayUrlVideo);
        buttonPlayDefaultVideo=findViewById(R.id.buttonPlayDefaultVideo);
        buttonPlayDefaultVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonPlayUrlVideo:
                        showDialogPrompt();
                        break;
                    case R.id.buttonPlayDefaultVideo:
                        Intent mIntent = ExoPlayerActivity.getStartIntent(MainActivity.this, VideoPlayerConfig.DEFAULT_VIDEO_URL);
                        startActivity(mIntent);
                        break;
                }
            }
        });
        buttonPlayUrlVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonPlayUrlVideo:
                        showDialogPrompt();
                        break;
                    case R.id.buttonPlayDefaultVideo:
                        Intent mIntent = ExoPlayerActivity.getStartIntent(MainActivity.this, VideoPlayerConfig.DEFAULT_VIDEO_URL);
                        startActivity(mIntent);
                        break;
                }
            }
        });
    }



    private void showDialogPrompt() {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialog_prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInputURL = (EditText) promptsView
                .findViewById(R.id.editTextDialogUrlInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                boolean isURL = Patterns.WEB_URL.matcher(userInputURL.getText().toString().trim()).matches();
                                if (isURL) {
                                    Intent mIntent = ExoPlayerActivity.getStartIntent(MainActivity.this, userInputURL.getText().toString().trim());
                                    startActivity(mIntent);
                                } else {
                                    Toast.makeText(MainActivity.this, getString(R.string.error_message_url_not_valid), Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
