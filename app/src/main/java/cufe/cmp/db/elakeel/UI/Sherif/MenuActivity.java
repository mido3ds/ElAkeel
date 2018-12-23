package cufe.cmp.db.elakeel.UI.Sherif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import cufe.cmp.db.elakeel.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<MenuItem> Menuitemss = new ArrayList<MenuItem>();
        final ListView List = (ListView) findViewById(R.id.MenuList);
        final MenuAdpater MenuItemsAdapter = new MenuAdpater(MenuActivity.this,Menuitemss);
        List.setAdapter(MenuItemsAdapter);

        findViewById(R.id.AddNewItem).setOnClickListener(v -> {
            // TODO: 23/12/2018
        });
    }
}
