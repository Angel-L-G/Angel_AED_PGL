package es.iespto.agl.dosierandroid2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Descomponer_34#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Descomponer_34 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Descomponer_34() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Descomponer_34.
     */
    // TODO: Rename and change types and number of parameters
    public static Descomponer_34 newInstance(String param1, String param2) {
        Descomponer_34 fragment = new Descomponer_34();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private void descomponerEnPrimos() {
        /*String numeroStr = numeroEditText.getText().toString();
        try {
            int numero = Integer.parseInt(numeroStr);
            String resultado = obtenerFactoresPrimos(numero);
            resultadoTextView.setText(resultado);
        } catch (NumberFormatException e) {
            resultadoTextView.setText("Ingrese un número válido.");
        }*/
    }

    private String obtenerFactoresPrimos(int numero) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 2; i <= numero; i++) {
            while (numero % i == 0) {
                resultado.append(i).append(" ");
                numero /= i;
            }
        }

        return resultado.toString().trim();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descomponer_34, container, false);
    }
}