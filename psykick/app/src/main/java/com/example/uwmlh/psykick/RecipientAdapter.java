package com.example.uwmlh.psykick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nngo1 on 02-Dec-17.
 */

public class RecipientAdapter extends ArrayAdapter<Recipient> {
    private Context context;
    private List<Recipient> recipients;
    private LayoutInflater inflater;

    public RecipientAdapter(Context context, List<Recipient> recipients) {
        super(context, -1, recipients);
        this.context = context;
        this.recipients = recipients;
        this.inflater = LayoutInflater.from(context);
    }

    public void swapItems(List<Recipient> recipients) {
        this.recipients = recipients;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CreateNotificationActivity.RecipientViewHolder holder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.recipients_layout, parent, false);
            holder = new CreateNotificationActivity.RecipientViewHolder();
            holder.code = (TextView) convertView.findViewById(R.id.course_code);
            holder.courseName = (TextView) convertView.findViewById(R.id.course_name);
            holder.profName = (TextView) convertView.findViewById(R.id.prof_name);
            holder.email = (TextView) convertView.findViewById(R.id.email);
            convertView.setTag(holder);
        } else {
            holder = (CreateNotificationActivity.RecipientViewHolder) convertView.getTag();
        }
        holder.code.setText(recipients.get(position).getCode());
        holder.courseName.setText(recipients.get(position).getCourseName());
        holder.profName.setText(recipients.get(position).getProf());
        holder.email.setText(recipients.get(position).getEmail());


        return convertView;
    }
}
