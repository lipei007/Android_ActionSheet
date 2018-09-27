package jack.com.actionsheet;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final JKButton btn = findViewById(R.id.pop_btn);

        btn.setTitleForState(JKButton.JKButtonState.JKButtonStateNormal,"Normal");
        btn.setTitleForState(JKButton.JKButtonState.JKButtonStateHighlight,"Highlight");
        btn.setTitleForState(JKButton.JKButtonState.JKButtonStateSelected,"Selected");

        btn.setTitleColorForState(JKButton.JKButtonState.JKButtonStateNormal, Color.BLACK);
        btn.setTitleColorForState(JKButton.JKButtonState.JKButtonStateHighlight,Color.GREEN);
        btn.setTitleColorForState(JKButton.JKButtonState.JKButtonStateSelected,Color.RED);


        btn.setBackgroundDrawableForState(JKButton.JKButtonState.JKButtonStateNormal,getResources().getDrawable(R.drawable.actionsheet_round_corner_normal_bg));
        btn.setBackgroundDrawableForState(JKButton.JKButtonState.JKButtonStateHighlight,getResources().getDrawable(R.drawable.actionsheet_round_corner_highlight_bg));
        btn.setBackgroundDrawableForState(JKButton.JKButtonState.JKButtonStateSelected,getResources().getDrawable(R.drawable.actionsheet_round_corner_selected_bg));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showActionSheet();

            }
        });

    }

    /**
     * Action Sheet
     * */
    private void showActionSheet() {

        final ArrayList<String> pops = new ArrayList<>();
        pops.add("谷歌地图");
        pops.add("高德地图");


        ActionSheet actionSheet = new ActionSheet(this);
        for (int i = 0; i <pops.size(); i++) {

            final String title = pops.get(i);
            actionSheet.addAction(pops.get(i), ActionSheet.ActionType.ActionTypeDefault, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ActionSheet", "onClick: " + title);
                }
            });
        }

        actionSheet.addAction("取消", ActionSheet.ActionType.ACtionTypeCancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ActionSheet", "onClick: Cancel");
            }
        });

        actionSheet.show();

    }
}
