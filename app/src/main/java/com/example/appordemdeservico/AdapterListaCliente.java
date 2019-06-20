package com.example.appordemdeservico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListaCliente extends BaseAdapter {


    private Context context;
    private List<Cliente> clientes;
    private LayoutInflater inflater;

    public AdapterListaCliente(Context context, List<Cliente> c) {
        this.context = context;
        this.clientes = c;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.layout_item_cliente, null);
            item = new Suporte();

            item.tvNomeCliente = (TextView) convertView.findViewById(R.id.tvItemNomeCliente);
            item.tvEnderecoCliente = (TextView) convertView.findViewById(R.id.tvEndereco);
            item.tvTelefone = (TextView) convertView.findViewById(R.id.tvNumeroCliente);
            convertView.setTag(item);

        } else {
            item = (Suporte) convertView.getTag();
        }

        Cliente c = clientes.get(position);
        item.tvNomeCliente.setText(c.getNome());
        item.tvEnderecoCliente.setText(c.getEndereco());
        item.tvTelefone.setText(c.getTelefone());

        return convertView;
    }

    private class Suporte {
        //TextView tvNomeProduto, tvQtdProduto, tvValorProduto;
        TextView tvNomeCliente, tvEnderecoCliente, tvTelefone;
    }

}
