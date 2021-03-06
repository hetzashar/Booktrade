package sjsu.com.booktrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by hetal on 4/10/2016.
 */
public class BookInputActivity extends AppCompatActivity {

//    EditText etFirstName,etLastName,etEmail,etPass,etContactNo;
//    Button btnRegister;

    @InjectView(R.id.fName) EditText etFirstName;
    @InjectView(R.id.lName) EditText etLastName;
    @InjectView(R.id.eMail) EditText etEmail;
    @InjectView(R.id.uPass) EditText etPass;
    @InjectView(R.id.cNumber) EditText etContactNo;
    @InjectView(R.id.btn_signup) Button btnRegister;
    @InjectView(R.id.link_login)
    TextView _loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.inject(this);

//        etFirstName = (EditText) findViewById(R.id.et_first_name);
//        etLastName = (EditText) findViewById(R.id.et_last_name);
//        etEmail = (EditText) findViewById(R.id.et_email);
//        etPass = (EditText) findViewById(R.id.et_password);
//        etContactNo = (EditText) findViewById(R.id.et_contact_no);
//        btnRegister = (Button) findViewById(R.id.btn_register);
//        btnRegister.setOnClickListener(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBarcodeScanner();
            }
        });
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });

    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_register:
//
//                startBarcodeScanner();
//// call Register AsyncTask
//                //new RegiserAsyncTask().execute();
//                break;
//        }
//
//    }

    private class RegiserAsyncTask extends AsyncTask<Void,Void,Void> {
        ProgressDialog progress = new ProgressDialog(BookInputActivity.this);
        String result = "";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setMessage("Loading...");
            progress.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
// call regiseter web service
// result = getResult()
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progress.dismiss();
// parse result here and redirect to main activity
        }
    }

    private void startBarcodeScanner(){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult intentScanningResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
        if(intentScanningResult != null){
            String scanContent = intentScanningResult.getContents();
            String scanFormat = intentScanningResult.getFormatName();
            Toast.makeText(this, "Format: " + scanFormat + "Result: " + scanFormat, Toast.LENGTH_LONG).show();
        }

    }

}
