package ryan.nhg.gtg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class BusActivity extends Activity
{

    //  LAYOUTS
    private BusList list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        Intent intent = getIntent();

        initLayouts();
        setTitle(intent.getStringExtra("stop_name"));
        getBuses(intent.getStringExtra("stop_id"));

    }

    private void initLayouts()
    {
        LinearLayout layout_main = (LinearLayout)findViewById(R.id.layout_main);

        //  Initialize bus list
        list = new BusList(this);

        //  Add list to main layout
        layout_main.addView(list);

    }

    private void setTitle(String title)
    {
        ((Button)findViewById(R.id.btn_label)).setText(title);
    }

    private void getBuses(String stopId)
    {
        new DataGrabber(list).execute(""+DataGrabber.GET_BUSES_FOR_STOP,stopId);
    }

    public void backClicked(View v)
    {
        this.finish();
    }



}
