package com.example.appordemdeservico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterOrdemServico extends BaseAdapter {

    private Context context;
    private List<OrdemServico> Oss;
    private LayoutInflater inflater;

    public AdapterListaProduto(Context context, List<OrdemServico> Oss) {
        this.context = context;
        this.Oss = Oss;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Oss.size();
    }

    @Override
    public Object getItem(int position) {
        return Oss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Oss.get(position).getIdcliente();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.layout_ordem_servico, null);
            item = new Suporte();

            item.tvIdOS = (TextView) convertView.findViewById(R.id.tvIdOS);
            item.tvClienteOS = (TextView) convertView.findViewById(R.id.tvClienteOS);
            item.tvDataOS = (TextView) convertView.findViewById(R.id.tvDataOS);
            item.tvPrecoOS= (TextView) convertView.findViewById(R.id.tvPrecoOS);
            convertView.setTag(item);

        } else {
            item = (Suporte) convertView.getTag();
        }

        OrdemServico prod = Oss.get(position);
        item.tvIdOS.setText(String.valueOf(prod.getIdcliente()));
        item.tvDataOS.setText((CharSequence) prod.getDataServico());
        item.tvPrecoOS.setText(String.valueOf(prod.getValor()));


        return convertView;
    }

    private class Suporte {
        TextView tvIdOS, tvClienteOS, tvDataOS, tvPrecoOS;
    }

}
}
