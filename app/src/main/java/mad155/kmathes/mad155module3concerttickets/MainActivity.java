package mad155.kmathes.mad155module3concerttickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tickets = (EditText) findViewById(R.id.txtTickets);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        Button cost = (Button) findViewById(R.id.btnCost);

        cost.setOnClickListener(new View.OnClickListener() {

            final TextView results = (TextView) findViewById(R.id.txtResult);


            @Override
            public void onClick(View v) {

                if (tickets.getText().toString().isEmpty() || tickets == null )
                {
                    System.out.println("NUMBER OF TICKETS MISSING");
                    Toast.makeText
                            (getApplicationContext(), "Please enter number of tickets" , Toast.LENGTH_SHORT)
                            .show();
                } else {

                    numberOfTickets = Integer.parseInt(tickets.getText().toString());
                    totalCost = costPerTicket * numberOfTickets;

                    DecimalFormat currency = new DecimalFormat("$###,###.##");

                    groupChoice = group.getSelectedItem().toString();

                    results.setText("Cost for group - " + groupChoice + " is: " +
                            currency.format(totalCost));
                }
            }
        });


    }
}
