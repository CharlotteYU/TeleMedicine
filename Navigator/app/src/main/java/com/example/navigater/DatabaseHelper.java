package com.example.navigater;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import com.example.navigater.model.Patient;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "TelMedicine.db";
    public static final int DB_VERSION = 1;

    //constructor: create a database
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPatient = "CREATE TABLE Patient(patient_id INTEGER PRIMARY KEY , firstname VARCHAR NOT NULL, lastname VARCHAR NOT NULL, age INTEGER NOT NULL, symptom VARCHAR )";
        String sqlProgram = "CREATE TABLE Program(program_id INTEGER PRIMARY KEY AUTOINCREMENT, max_step INTEGER NOT NULL, step INTEGER CHECK(step <= max_step), pro_content VARCHAR, patient_id INTEGER,FOREIGN KEY(patient_id) REFERENCES Patient(patent_id))";
/*        String sqlGps = "CREATE TABLE GPS(gps_id INTEGER PRIMARY KEY , longitude DECIMAL NOT NULL, latitude DECIMAL NOT NULL，FOREIGN KEY(patient_id) REFERENCES Patient(patent_id))";
        String sqlDoctor = "CREATE TABLE Doctor(doctor_id INTEGER PRIMARY KEY , doctor_name VARCHAR NOT NULL)";
        String sqlQuestion = "CREATE TABLE Question(question_id INTEGER PRIMARY KEY , question VARCHAR NOT NULL,answer VARCHAR, answered BOOLEAN DEFAULT FALSE,FOREIGN KEY(doctorques_id) REFERENCES Doctor(doctor_id) ,FOREIGN KEY(patientques_id) REFERENCES Patient(patent_id))";
        String sqlMedicine = "CREATE TABLE Medicine(medicine_id INTEGER PRIMARY KEY , medicine_name VARCHAR NOT NULL, curative_effect VARCHAR NOT NULL, FOREIGN KEY(patientm_id) REFERENCES Patient(patent_id))";*/
        //String sqlCaseReport = "CREATE TABLE CaseReport(report_id INTEGER PRIMARY KEY AUTOINCREMENT, disease_name VARCHAR NOT NULL, disease_symptom VARCHAR NOT NULL, advice_of_docotr VARCHAR NOT NULL)";

/*        String sqlAsk = "CREATE TABLE Ask(id INTEGER PRIMARY KEY AUTOINCREMENT, date DATE NOT NULL, FOREIGN KEY (question_id) REFERENCES Question(question_id)," +
                " FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id) )";
        String sqlConsult = "CREATE TABLE Consult(id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)," +
                " FOREIGN KEY (question_id) REFERENCES Question(question_id))";
        String sqlTake = "CREATE TABLE Take(id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)," +
                " FOREIGN KEY (medicine_id) REFERENCES Medicine(medicine_id))";*/
        sqLiteDatabase.execSQL(sqlPatient);
        sqLiteDatabase.execSQL(sqlProgram);
        /*
        sqLiteDatabase.execSQL(sqlGps);
        sqLiteDatabase.execSQL(sqlDoctor);
        sqLiteDatabase.execSQL(sqlQuestion);
        sqLiteDatabase.execSQL(sqlMedicine);
        sqLiteDatabase.execSQL(sqlCaseReport);
        sqLiteDatabase.execSQL(sqlAsk);
        sqLiteDatabase.execSQL(sqlConsult);
        sqLiteDatabase.execSQL(sqlTake);
        */

    }

    //add new patient

    public boolean AddPatient(String firstname, String lastname, int age, String symptom) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("age", age);
        contentValues.put("symptom", symptom);
        db.insert("Patient", null, contentValues);
        db.close();
        return true;
    }

    //add new program
    public boolean AddProgram(int max_step, int step, String pro_content, int patient_id ) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("max_step", max_step);
        contentValues.put("step", step);
        contentValues.put("pro_content", pro_content);
        contentValues.put("patient_id", patient_id);
        db.insert("Program", null, contentValues);
        db.close();
        return true;
    }
/*
    //add new doctor
    public boolean AddDoctor(String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("doctor_name",name);
        db.insert("Doctor",null,contentValues);
        db.close();
        return true;
    }

    //add new gps
    public boolean AddGPS(double longitude, double latitude){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("longitude",longitude);
        contentValues.put("latitude",latitude);
        db.insert("GPS",null,contentValues);
        db.close();
        return true;
    }

    //add new question
    public boolean AddQuestion(String question, String answer){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("question",question);
        contentValues.put("answer",answer);
        db.insert("Question",null,contentValues);
        db.close();
        return true;
    }

    //add new medicine
    public boolean AddMedicine(String medicine_name, String curative_effect){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("medicine_name",medicine_name);
        contentValues.put("curative_effect",curative_effect);
        db.insert("Medicine",null,contentValues);
        db.close();
        return true;
    }

    //add new CaseReport
    public boolean AddCaseReport(String disease_name, String symptom, String advice){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("disease_name",disease_name);
        contentValues.put("disease_sy",symptom);
        contentValues.put("advice_of_doctor",advice);
        db.insert("CaseReport",null,contentValues);
        db.close();
        return true;
    }
*/


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sqlPatient = "DROP TABLE IF EXISTS Patient";
        String sqlProgram = "DROP TABLE IF EXISTS Program";

/*        String sqlGps = "DROP TABLE IF EXISTS GPS";
        String sqlDoctor = "DROP TABLE IF EXISTS Doctor";
        String sqlQuestion = "DROP TABLE IF EXISTS Question";
        String sqlMedicine = "DROP TABLE IF EXISTS Medicine";
        String sqlCaseReport = "DROP TABLE IF EXISTS CaseReport";
*/
        sqLiteDatabase.execSQL(sqlPatient);
        sqLiteDatabase.execSQL(sqlProgram);
       /*
        sqLiteDatabase.execSQL(sqlGps);
        sqLiteDatabase.execSQL(sqlDoctor);
        sqLiteDatabase.execSQL(sqlQuestion);
        sqLiteDatabase.execSQL(sqlMedicine);
        sqLiteDatabase.execSQL(sqlCaseReport);
        */
    }

    //get a Patient
    public Patient getPatient(long patient_id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Patient WHERE patient_id = " + patient_id;

        Cursor c = sqLiteDatabase.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();

        Patient patient = new Patient();
        patient.setFirstname(c.getString(c.getColumnIndex("firstname")));
        patient.setAge(c.getInt(c.getColumnIndex("age")));
        patient.setSymptom(c.getString(c.getColumnIndex("symptom")));
        return patient;
    }

    //getProgram array
    public Program getProgram(long patient_id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String selectQuery = "SELECT DISTINCT max_step FROM Program WHERE step = 1 AND patient_id = " + patient_id;

        Cursor c = sqLiteDatabase.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        int max_step = c.getInt(c.getColumnIndex("max_step"));

        Program program = new Program();
        program.setMax(max_step);

        for (int i = 1; i<=max_step; ++i) {
            String selectQuery_pro = "SELECT pro_content FROM Program WHERE patient_id = " + patient_id + " AND step = " + i + " LIMIT 1";
            Cursor c_content = sqLiteDatabase.rawQuery(selectQuery_pro, null);
            if (c_content != null)
                c_content.moveToFirst();
            program.setPro_content("Step "+ i+ " : " +c_content.getString(c_content.getColumnIndex("pro_content")));
        }

        return program;
    }


}
