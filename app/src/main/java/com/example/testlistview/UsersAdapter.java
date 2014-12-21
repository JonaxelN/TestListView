package com.example.testlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jonathan on 21/12/14.
 */
public class UsersAdapter extends ArrayAdapter<User> {

    private static class ViewHolder {
        TextView name;
        TextView home;
    }

    public UsersAdapter(Context context, ArrayList<User> users) {
        super(context, R.layout.rowlayout, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rowlayout, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.home = (TextView) convertView.findViewById(R.id.tvHometown);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) convertView.getTag();

        // Populate the data into the template view using the data object
        viewHolder.name.setText(user.name);
        viewHolder.home.setText(user.hometown);

        // Return the completed view to render on screen
        return convertView;
    }
}
