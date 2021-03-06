package com.ibmr.appreceitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.ibmr.appreceitas.models.Recipe;
import com.ibmr.appreceitas.utils.RecyclerViewAdapter;
import com.ibmr.appreceitas.utils.RecyclerViewOnItemTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Recipe> recipes = new ArrayList<Recipe>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        this.insertData();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(new RecyclerViewAdapter(recipes));

        recyclerView.addOnItemTouchListener(
            new RecyclerViewOnItemTouchListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerViewOnItemTouchListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                            intent.putExtra("recipeImage", recipes.get(position).getImage());
                            intent.putExtra("recipeName", recipes.get(position).getName());
                            intent.putExtra("recipeDescription", recipes.get(position).getDescription());

                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {}

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {}
                    }
            )
        );
    }

    public void insertData() {
        recipes.add(new Recipe(
                "Fraldinha Assada na Cerveja",
                "Marinada na cerveja, a fraldinha sai do forno dourada, suculenta e macia. E ainda rende um molho saboroso. Aten????o para a t??cnica de corte, que deixa as fatias da carne bem macias.",
                R.drawable.fraldinha
        ));

        recipes.add(new Recipe(
                "Rosbife",
                "Cl??ssico ?? cl??ssico! Com a t??cnica certa, o rosbife fica perfeito. Atente para os tempos e as temperaturas. Ele n??o pode estar gelado e precisa mesmo do descanso depois de assado.",
                R.drawable.rosbife
        ));

        recipes.add(new Recipe(
                "Lombo Assado com Tomates e Ervas",
                "Diga adeus ao lombo ressecado! Este fica ??mido e perfumado. Os tomates assados, al??m de lindos, d??o sabor ao molho feito com o l??quido da assadeira. Receita para receber a fam??lia no fim de semana e boa candidata para o Natal!",
                R.drawable.lombo
        ));

        recipes.add(new Recipe(
                "Carne-seca Acebolada com Manteiga de Garrafa",
                "Comida bem brasileira, vers??til e cheia de personalidade. Com vinagrete de feij??o-fradinho e quibebe, a refei????o est?? resolvida. Mas vai bem tamb??m com pur?? de banana, com arroz e feij??o, com farofa???",
                R.drawable.carne_seca
        ));

        recipes.add(new Recipe(
                "Carne de Sol",
                "Apesar do nome, n??o precisa de sol para curar a carne. Precisa de sal, a????car mascavo e tempo. A espera compensa: o resultado ?? um carne com sabor acentuado e textura macia. A receita ?? do chef Rodrigo Oliveira.",
                R.drawable.carne_de_sol
        ));

        recipes.add(new Recipe(
                "Bife ?? Milanesa com Salada de Batatas e Repolho Agridoce",
                "Combina????o cl??ssica, com ar vintage, jeit??o tradicional??? n??o importa o r??tulo, bife ?? milanesa com salada de batatas ?? deliciosamente f??cil de preparar e vai bem em muitas ocasi??es.",
                R.drawable.bife_milanesa
        ));

        recipes.add(new Recipe(
                "Picadinho Oriental com Lombo e Abacaxi",
                "A receita ?? oriental, os sabores s??o bem brasileiros. E o encontro ?? surpreendente. Lombo e abacaxi combinam muito, isso tudo mundo sabe; e a couve entra, em quadrad??es, dando uma sacudida nesse picadinho. Uma dica: n??o cabule o pr??-preparo dos ingredientes. O cozimento ?? bem r??pido. Antes de come??ar, deixe tudo no jeito.",
                R.drawable.picadinho
        ));

        recipes.add(new Recipe(
                "Pa??oca de Carne-Seca",
                "Na vers??o tradicional, a carne-seca ?? batida no pil??o at?? formar uma pa??oca. Na vers??o Panelinha, usamos o processador, para deixar mais pr??tico. E para ficar mais saboroso, o refogado ?? com manteiga de garrafa.",
                R.drawable.pacoca
        ));

        recipes.add(new Recipe(
                "Escondidinho de Mandioca com Carne-Seca",
                "Cl??ssico brasileiro, o escondidinho pode parecer trabalhoso mas compensa cada etapa do preparo (que pode ser distribu??do em dias diferentes para facilitar). Ele rende que ?? uma beleza e funciona como prato ??nico.",
                R.drawable.escondidinho
        ));
    }
}
