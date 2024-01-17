package com.example.attendanceapp;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    public static final String CLASS_ADD_DIALOG = "addClass";
    public static final String STUDENT_ADD_DIALOG = "addStudent";
    public static final String CLASS_UPDATE_DIALOG = "updateClass";
    public static final String STUDENT_UPDATE_DIALOG = "updateStudent";

    private OnClickListener listener;
    private int roll;
    private String name;

    public MyDialog(int roll, String name) {
        this.roll = roll;
        this.name = name;

    }

    public MyDialog() {

    }

    public interface OnClickListener{
        void onClick(String text1, String text2);
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = null;
        if (getTag().equals(CLASS_ADD_DIALOG)) dialog = getAddClassDialog();
        if(getTag().equals(STUDENT_ADD_DIALOG)) dialog = getAddStudentDialog();
        if(getTag().equals(CLASS_UPDATE_DIALOG)) dialog = getUpdateClassDialog();
        if(getTag().equals(STUDENT_UPDATE_DIALOG)) dialog = getUpdateStudentDialog();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        return dialog;
    }

    private Dialog getUpdateStudentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        EditText roll_edit = view.findViewById(R.id.edit01);
        EditText name_edit = view.findViewById(R.id.edit02);
        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);
        add.setText("Update");

        title.setText("Update Student");
        roll_edit.setHint("Roll");
        name_edit.setHint("Name");

        roll_edit.setText(roll +"");
        roll_edit.setEnabled(false);
        name_edit.setText(name);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = roll_edit.getText().toString();
                String name = name_edit.getText().toString();

                listener.onClick(roll, name);
                dismiss();
            }
        });
        return builder.create();

    }

    private Dialog getUpdateClassDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        EditText class_edit = view.findViewById(R.id.edit01);
        EditText subject_edit = view.findViewById(R.id.edit02);
        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);
        add.setText("Update");

        title.setText("Update Class");
        class_edit.setHint("Class");
        subject_edit.setHint("subject");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String className = class_edit.getText().toString();
                String subjectName = subject_edit.getText().toString();
                listener.onClick(className, subjectName);
                dismiss();
            }
        });

        return builder.create();
    }

    private Dialog getAddStudentDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        EditText roll_edit = view.findViewById(R.id.edit01);
        EditText name_edit = view.findViewById(R.id.edit02);
        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);

        title.setText("Add New Student");
        roll_edit.setHint("Roll");
        name_edit.setHint("Name");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = roll_edit.getText().toString();
                String name = name_edit.getText().toString();
                roll_edit.setText(String.valueOf(Integer.parseInt(roll)+1));
                name_edit.setText("");
                listener.onClick(roll, name);
                dismiss();
            }
        });
        return builder.create();
    }

    private Dialog getAddClassDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.titleDialog);
        EditText class_edit = view.findViewById(R.id.edit01);
        EditText subject_edit = view.findViewById(R.id.edit02);
        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);

        title.setText("Add New Class");
        class_edit.setHint("Class");
        subject_edit.setHint("subject");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String className = class_edit.getText().toString();
                String subjectName = subject_edit.getText().toString();
                listener.onClick(className, subjectName);
                dismiss();
            }
        });

        return builder.create();
    }
}
