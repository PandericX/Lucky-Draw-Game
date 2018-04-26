import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Font;

class LuckyDraw extends JFrame implements ActionListener
{
	private final JButton [] buttonArray;
	private final GridLayout gl;
	ArrayList <Integer> intList 	= new ArrayList <Integer> ();
	ArrayList <Integer> luckyList 	= new ArrayList <Integer> ();

	public LuckyDraw ()
	{
		super ("Good Luck To You");
		gl = new GridLayout (7,7);
		setLayout (gl);

		//create an arrayList from 1 to 49
		for (int i = 0; i < 49; i++)
		{
			intList.add (i+1);
		}

		//shuffle the list, and take the first 7 numbers as the lucky numbers
		Collections.shuffle (intList);
		for (int i = 0; i < 7; i++)
		{
			luckyList.add (intList.get(i));
		}

		//re-shuffle the intList
		Collections.shuffle (intList);

		//create an array of 49 buttons
		buttonArray = new JButton [49];
		for (int i = 0; i < 49; i++)
		{
			buttonArray [i] = new JButton ("?");
			add (buttonArray [i]);
			buttonArray [i].addActionListener (this);
		}

		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	setSize (500, 500);
    	setVisible (true);
	}
	@Override
	public void actionPerformed (ActionEvent e)
	{
		int n = 0;
		for (JButton k : buttonArray)
		{
			if (e.getSource () == k)
			{
				k.setText (String.valueOf (intList.get(n)));
				k.setFont (new Font ("Arial", Font.BOLD, 15));
				for (int i = 0; i < 7; i++)
				{
					if (intList.get(n) == luckyList.get(0))
					{
						k.setBackground (Color.green);
						k.setFont (new Font ("Arial", Font.BOLD, 25));
					}
					else if (intList.get(n) == luckyList.get(i))
					{
						k.setBackground (Color.yellow);
						k.setFont (new Font ("Arial", Font.BOLD, 25));
					}
				}
			}
			n++;
		}
	}

    public static void main (String [] args)
    {
    	LuckyDraw lucky = new LuckyDraw ();
    }

}
