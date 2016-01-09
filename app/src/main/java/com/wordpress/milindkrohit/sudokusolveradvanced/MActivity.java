package com.wordpress.milindkrohit.sudokusolveradvanced;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MActivity extends AppCompatActivity {
    private AdView mAdView;
    int mk[][] = new int[9][9];
    private EditText A[][] = new EditText[9][9];
    int viewArr[][] = new int[9][9];
    private Button fillbox, nilbox;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        mInterstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        mInterstitialAd.setAdUnitId(getString(R.string.ad_Interstitial));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                resetvalue();
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        A[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast msg = Toast.makeText(getBaseContext(), "Enter digit 1 to 9",
                        Toast.LENGTH_LONG);
                msg.show();
            }
        });


        fillbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setvalue();

            }
        });
        nilbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_m, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.rate_us:
                rate_us();
                return true;
            case R.id.help:
                showHelp();
                return true;
            case R.id.action_settings:
                Intent intent = new Intent(this, AboutUs.class);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                sendEmail();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init() {

        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView.loadAd(adRequest);
        fillbox = (Button) findViewById(R.id.mstart);
        nilbox = (Button) findViewById(R.id.reset);
        viewArr[0][0] = R.id.row1col1;
        viewArr[0][1] = R.id.row1col2;
        viewArr[0][2] = R.id.row1col3;
        viewArr[0][3] = R.id.row1col4;
        viewArr[0][4] = R.id.row1col5;
        viewArr[0][5] = R.id.row1col6;
        viewArr[0][6] = R.id.row1col7;
        viewArr[0][7] = R.id.row1col8;
        viewArr[0][8] = R.id.row1col9;
        viewArr[1][0] = R.id.row2col1;
        viewArr[1][1] = R.id.row2col2;
        viewArr[1][2] = R.id.row2col3;
        viewArr[1][3] = R.id.row2col4;
        viewArr[1][4] = R.id.row2col5;
        viewArr[1][5] = R.id.row2col6;
        viewArr[1][6] = R.id.row2col7;
        viewArr[1][7] = R.id.row2col8;
        viewArr[1][8] = R.id.row2col9;
        viewArr[2][0] = R.id.row3col1;
        viewArr[2][1] = R.id.row3col2;
        viewArr[2][2] = R.id.row3col3;
        viewArr[2][3] = R.id.row3col4;
        viewArr[2][4] = R.id.row3col5;
        viewArr[2][5] = R.id.row3col6;
        viewArr[2][6] = R.id.row3col7;
        viewArr[2][7] = R.id.row3col8;
        viewArr[2][8] = R.id.row3col9;
        viewArr[3][0] = R.id.row4col1;
        viewArr[3][1] = R.id.row4col2;
        viewArr[3][2] = R.id.row4col3;
        viewArr[3][3] = R.id.row4col4;
        viewArr[3][4] = R.id.row4col5;
        viewArr[3][5] = R.id.row4col6;
        viewArr[3][6] = R.id.row4col7;
        viewArr[3][7] = R.id.row4col8;
        viewArr[3][8] = R.id.row4col9;
        viewArr[4][0] = R.id.row5col1;
        viewArr[4][1] = R.id.row5col2;
        viewArr[4][2] = R.id.row5col3;
        viewArr[4][3] = R.id.row5col4;
        viewArr[4][4] = R.id.row5col5;
        viewArr[4][5] = R.id.row5col6;
        viewArr[4][6] = R.id.row5col7;
        viewArr[4][7] = R.id.row5col8;
        viewArr[4][8] = R.id.row5col9;
        viewArr[5][0] = R.id.row6col1;
        viewArr[5][1] = R.id.row6col2;
        viewArr[5][2] = R.id.row6col3;
        viewArr[5][3] = R.id.row6col4;
        viewArr[5][4] = R.id.row6col5;
        viewArr[5][5] = R.id.row6col6;
        viewArr[5][6] = R.id.row6col7;
        viewArr[5][7] = R.id.row6col8;
        viewArr[5][8] = R.id.row6col9;
        viewArr[6][0] = R.id.row7col1;
        viewArr[6][1] = R.id.row7col2;
        viewArr[6][2] = R.id.row7col3;
        viewArr[6][3] = R.id.row7col4;
        viewArr[6][4] = R.id.row7col5;
        viewArr[6][5] = R.id.row7col6;
        viewArr[6][6] = R.id.row7col7;
        viewArr[6][7] = R.id.row7col8;
        viewArr[6][8] = R.id.row7col9;
        viewArr[7][0] = R.id.row8col1;
        viewArr[7][1] = R.id.row8col2;
        viewArr[7][2] = R.id.row8col3;
        viewArr[7][3] = R.id.row8col4;
        viewArr[7][4] = R.id.row8col5;
        viewArr[7][5] = R.id.row8col6;
        viewArr[7][6] = R.id.row8col7;
        viewArr[7][7] = R.id.row8col8;
        viewArr[7][8] = R.id.row8col9;
        viewArr[8][0] = R.id.row9col1;
        viewArr[8][1] = R.id.row9col2;
        viewArr[8][2] = R.id.row9col3;
        viewArr[8][3] = R.id.row9col4;
        viewArr[8][4] = R.id.row9col5;
        viewArr[8][5] = R.id.row9col6;
        viewArr[8][6] = R.id.row9col7;
        viewArr[8][7] = R.id.row9col8;
        viewArr[8][8] = R.id.row9col9;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                A[i][j] = (EditText) findViewById(viewArr[i][j]);

            }
        }

    }

    private void showHelp() {
        String str = "https://www.milindkrohit.wordpress.com/sudokusolveradvanced";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
    }

    private void rate_us() {
        String str = "https://play.google.com/store/apps/details?id=com.wordpress.milindkrohit.sudokusolveradvanced";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public void setvalue() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                String add = A[i][j].getText().toString();
                A[i][j].setTextColor(Color.BLACK);
                //char ch = add.charAt(0);
                if (add.length() > 0)
                    mk[i][j] = add.charAt(0) - 48;
                else
                    mk[i][j] = 0;
            }
        }
        if (checkInput(mk) == true) {
            sudo(mk, 0, 0);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (A[i][j].getText().toString().length() > 0) {
                        A[i][j].setTextColor(Color.BLUE);
                    } else {
                        String sub;
                        char ch;
                        ch = (char) (mk[i][j] + 48);
                        sub = "" + Character.toString(ch);
                        A[i][j].setText(sub);

                    }
                }
            }
        } else {
            Toast msg = Toast.makeText(getBaseContext(), "Fill unique digit in same row ,col and box\n    Correct red coloured values",
                    Toast.LENGTH_LONG);
            msg.show();

        }
    }

    public boolean checkInput(int milind[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (milind[i][j] != 0) {
                    if (!checkInput_driver(milind, i, j, milind[i][j])) {
                        A[i][j].setTextColor(Color.RED);

                        return false;
                    }
                }
            }
        }
        return true;

    }

    public boolean checkInput_driver(int A[][], int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (i != col && A[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != row && A[i][col] == num) {
                return false;
            }
        }
        int row1 = row - (row % 3);
        int col1 = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + row1 != row && j + col1 != col && A[i + row1][j + col1] == num) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isplace(int A[][], int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (A[row][i] == num)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (A[i][col] == num)
                return false;
        }
        row = row - (row % 3);
        col = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (A[i + row][j + col] == num)
                    return false;
            }
        }
        return true;

    }

    public boolean sudo(int A[][], int row, int col) {

        if (row == 9) {
            return true;
        }
        if (A[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (isplace(A, row, col, i)) {
                    A[row][col] = i;
                    if (col >= 8) {
                        if (sudo(A, row + 1, 0)) {
                            return true;
                        }
                        A[row][col] = 0;
                    } else {
                        if (sudo(A, row, col + 1)) {
                            return true;
                        }
                        A[row][col] = 0;

                    }
                }
            }
        } else {
            if (col >= 8) {
                if (sudo(A, row + 1, 0)) {
                    return true;
                }

            } else {
                if (sudo(A, row, col + 1)) {
                    return true;
                }


            }
        }
        return false;
    }

    public void resetvalue() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                A[i][j].setText("");
            }
        }
    }

    private void sendEmail() {

        String info = "okay ", emailAdd;
        emailAdd = "milind0359@gmail.com";
        Log.i("Send email", "");
        String emailaddress[] = {emailAdd};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("plane/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailaddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "SudokuSolverAdvanced : state your subject here");

        emailIntent.putExtra(Intent.EXTRA_TEXT, info);
        //startActivity(emailIntent);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showInterstitial() {

        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {

            resetvalue();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

