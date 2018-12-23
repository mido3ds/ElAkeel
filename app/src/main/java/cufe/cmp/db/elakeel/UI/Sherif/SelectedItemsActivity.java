package cufe.cmp.db.elakeel.UI.Sherif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cufe.cmp.db.elakeel.R;

public class SelectedItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_items);
        final TextView Value = (TextView) findViewById(R.id.ToltoalPriceValue);
        Value.setText("200LE");//summation of total prices
        Button Promo = (Button) findViewById(R.id.UsePromoCode);
        final EditText promo = (EditText) findViewById(R.id.PromoCode);
        Promo.setOnClickListener(v -> {
            if (Integer.parseInt(promo.getText().toString())>0) {
                Value.setText("180LE");
            }
        });

    }
}
