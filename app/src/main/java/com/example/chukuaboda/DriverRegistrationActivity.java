package com.example.chukuaboda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DriverRegistrationActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etEmail, etPhone, etCity, etVehicleMakeModel, etLicensePlate;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registration);

        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etCity = findViewById(R.id.et_city);
        etVehicleMakeModel = findViewById(R.id.et_vehicle_make_model);
        etLicensePlate = findViewById(R.id.et_license_plate);

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDriver();
            }
        });
    }

    private void registerDriver() {
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String vehicleMakeModel = etVehicleMakeModel.getText().toString().trim();
        String licensePlate = etLicensePlate.getText().toString().trim();

        // Validate input fields
        if (TextUtils.isEmpty(firstName)) {
            etFirstName.setError("Please enter your first name");
            etFirstName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            etLastName.setError("Please enter your last name");
            etLastName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter your email address");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email address");
            etEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Please enter your phone number");
            etPhone.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(city)) {
            etCity.setError("Please enter your city");
            etCity.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(vehicleMakeModel)) {
            etVehicleMakeModel.setError("Please enter your vehicle make and model");
            etVehicleMakeModel.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(licensePlate)) {
            etLicensePlate.setError("Please enter your vehicle license plate number");
            etLicensePlate.requestFocus();
            return;
        }

        // Save driver details to database
        // ...

        // Navigate to the driver dashboard screen
        Intent intent = new Intent(this, DriverDashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
