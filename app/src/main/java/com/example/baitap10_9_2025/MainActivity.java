package com.example.baitap10_9_2025;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnAdd;
    ArrayList<Subject> subjects;
    SubjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);

        subjects = new ArrayList<>();
        adapter = new SubjectAdapter(this, subjects);
        listView.setAdapter(adapter);

        // Thêm môn học
        btnAdd.setOnClickListener(v -> showAddDialog());

        // Nhấn giữ để xóa
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            subjects.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

        // Nhấn để cập nhật
        listView.setOnItemClickListener((parent, view, position, id) -> showUpdateDialog(position));
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm môn học");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        EditText edtName = new EditText(this);
        edtName.setHint("Tên môn học");
        layout.addView(edtName);

        EditText edtCredit = new EditText(this);
        edtCredit.setHint("Số tín chỉ");
        edtCredit.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(edtCredit);

        builder.setView(layout);

        builder.setPositiveButton("Thêm", (dialog, which) -> {
            String name = edtName.getText().toString();
            int credit = Integer.parseInt(edtCredit.getText().toString());
            subjects.add(new Subject(name, credit));
            adapter.notifyDataSetChanged();
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    private void showUpdateDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cập nhật số tín chỉ");

        Subject subject = subjects.get(position);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        EditText edtCredit = new EditText(this);
        edtCredit.setHint("Số tín chỉ mới");
        edtCredit.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtCredit.setText(String.valueOf(subject.getCredit()));
        layout.addView(edtCredit);

        builder.setView(layout);

        builder.setPositiveButton("Cập nhật", (dialog, which) -> {
            int newCredit = Integer.parseInt(edtCredit.getText().toString());
            subject.setCredit(newCredit);
            adapter.notifyDataSetChanged();
        });

        builder.setNegativeButton("Hủy", null);
        builder.show();
    }
}
