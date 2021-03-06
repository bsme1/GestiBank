package com.example.gestibank;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;

import java.util.List;
import android.util.Log;

public class ListeAgentAdapter extends BaseAdapter {

    private  List<Agent> listCustomer;
    private  LayoutInflater layoutInflater;
    private Context context;

    public ListeAgentAdapter(Context aContext, List<Agent> listData) {
        this.context = aContext;
        this.listCustomer = listData;
        layoutInflater = LayoutInflater.from(aContext);

    }
    @Override
    public int getCount() {
        return listCustomer.size();
    }
    @Override
    public Object getItem(int position) {
        return listCustomer.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListeAgentAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item, null);
            holder = new ListeAgentAdapter.ViewHolder();
            holder.customerName = (TextView)
                    convertView.findViewById(R.id.textViewNinfo);
            holder.customerPrenom = (TextView)
                    convertView.findViewById(R.id.textViewPinfo);
            holder.customerMatricule = (TextView)
                    convertView.findViewById(R.id.textViewMinfo);
            holder.customerEmail = (TextView)
                    convertView.findViewById(R.id.textViewEinfo);
        } else {
            holder = (ListeAgentAdapter.ViewHolder) convertView.getTag();
        }
        Agent customer = this.listCustomer.get(position);
        holder.customerName.setText("" +customer.getName());
        holder.customerPrenom.setText("" + customer.getPrenom());
        holder.customerMatricule.setText("" + customer.getMatricule());
        holder.customerEmail.setText("" + customer.getEmail());

        return convertView;
    }

    static class ViewHolder {
        TextView customerName;
        TextView customerPrenom;
        TextView customerMatricule;
        TextView customerEmail;
    }

}

