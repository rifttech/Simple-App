package org.apparatum.simple_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.apparatum.simple_app.dto.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur Abramov on 30.10.2017.
 */

public class UserListAdapter extends BaseAdapter {

    private List<User> users = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public UserListAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            view = layoutInflater.inflate(R.layout.user_list_item, viewGroup, false);
        }

        ((TextView)view.findViewById(R.id.user_name)).setText(users.get(i).getUsernameString());
        ((TextView)view.findViewById(R.id.user_email)).setText(users.get(i).getEmail());
        ((TextView)view.findViewById(R.id.user_address_string)).setText(users.get(i).getAddressString());
        ((TextView)view.findViewById(R.id.user_phone)).setText(users.get(i).getPhone());
        ((TextView)view.findViewById(R.id.user_website)).setText(users.get(i).getWebsite());
        ((TextView)view.findViewById(R.id.user_company_string)).setText(users.get(i).getCompanyString());

        return view;
    }


}
