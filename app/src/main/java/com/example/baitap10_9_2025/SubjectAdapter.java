package com.example.baitap10_9_2025;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SubjectAdapter extends ArrayAdapter<Subject> {
    private Context context;
    private List<Subject> subjectList;

    public SubjectAdapter(Context context, List<Subject> list) {
        super(context, 0, list);
        this.context = context;
        this.subjectList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false);

        Subject subject = subjectList.get(position);

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvCredit = convertView.findViewById(R.id.tvCredit);

        tvName.setText(subject.getName());
        tvCredit.setText("Số tín chỉ: " + subject.getCredit());

        return convertView;
    }
}
