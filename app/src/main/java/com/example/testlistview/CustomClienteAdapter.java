package com.example.testlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomClienteAdapter extends ArrayAdapter<Cliente> {

    private ArrayList<Cliente> miCliente = new ArrayList<>();
    private Cliente cliente;

    private static class ViewHolder {
        TextView nombreCliente;
        TextView hora;
        TextView duracion;
    }

    public CustomClienteAdapter(Context context, ArrayList<Cliente> clientes) {
        super(context, R.layout.item_vista, clientes);
        miCliente = clientes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder; // view lookup cache stored in tag

        // Check if an existing view is being reused, otherwise inflate the view
        View itemView = convertView;
        if (itemView == null) {
            //Create the ViewHolder
            viewHolder = new ViewHolder();

            //Create inflater
            LayoutInflater inflater = LayoutInflater.from(getContext());

            //Inflate the layout specified
            itemView = inflater.inflate(R.layout.item_vista, parent, false);

            //Find the client to work with
            cliente = miCliente.get(position);

            //Find resources from xml to java objects
            viewHolder.nombreCliente = (TextView) itemView.findViewById(R.id.cliente);
            viewHolder.hora = (TextView) itemView.findViewById(R.id.hora);
            viewHolder.duracion = (TextView) itemView.findViewById(R.id.duracion);
            itemView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) convertView.getTag();

        // Populate the data into the template view using the data object
        viewHolder.nombreCliente.setText(cliente.getNombreCliente());
        viewHolder.hora.setText("" + cliente.getHora());
        viewHolder.duracion.setText("" + cliente.getDuracion());

        // Return the completed view to render on screen
        return itemView;
    }
}
