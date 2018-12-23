package cufe.cmp.db.elakeel.UI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import cufe.cmp.db.elakeel.Data.Database.DbOpenHelper;
import cufe.cmp.db.elakeel.Data.Utility.Statistics;
import cufe.cmp.db.elakeel.R;

public class StatisticsActivity extends Activity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Statistics statistics = new Statistics(new DbOpenHelper(this).getWritableDatabase());

        ((TextView) findViewById(R.id.totalUsers)).setText(statistics.totalUsers());
        ((TextView) findViewById(R.id.totalOrders)).setText(statistics.totalOrders());
        ((TextView) findViewById(R.id.totalMoney)).setText(statistics.totalMoney());
        ((TextView) findViewById(R.id.avgMealPrice)).setText(Float.toString(statistics.avgMealPrice()));
    }
}
