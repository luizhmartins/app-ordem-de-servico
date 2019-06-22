package com.example.appordemdeservico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Classe Responsável pela criação do Adapter de Ordem de Serviço.
 *
 */
public class AdapterListaOrdemServico extends BaseAdapter {


    private Context context;
    private List<OrdemServico> ordemServicos;
    private Cliente c;
    private LayoutInflater inflater;

    public AdapterListaOrdemServico(Context context, List<OrdemServico> os) {
        this.context = context;
        this.ordemServicos = os;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ordemServicos.size();
    }

    @Override
    public Object getItem(int position) {
        return ordemServicos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ordemServicos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.layout_item_os, null);
            item = new Suporte();

            item.tvIdOS = (TextView) convertView.findViewById(R.id.tvIdOS);
            item.tvDescricaoOS = (TextView) convertView.findViewById(R.id.tvDescricaoOS);
            item.tvNomeCliente = (TextView) convertView.findViewById(R.id.tvNomeCliente);
            item.tvEnderecoCliente = (TextView) convertView.findViewById(R.id.tvEnderecoCliente);
            convertView.setTag(item);

        } else {
            item = (Suporte) convertView.getTag();
        }

        OrdemServico os = ordemServicos.get(position);
        item.tvIdOS.setText(String.valueOf(os.getId()));
        item.tvDescricaoOS.setText(os.getDescricao());
        item.tvNomeCliente.setText(c.getNome());
        item.tvEnderecoCliente.setText(c.getEndereco());

        return convertView;
    }

    private class Suporte {
        //TextView tvNomeProduto, tvQtdProduto, tvValorProduto;
        TextView tvIdOS, tvDescricaoOS, tvNomeCliente, tvEnderecoCliente;
    }

}
