import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerImpl1 implements ActionListener{

    @Override
    synchronized public void actionPerformed(ActionEvent e) {
        System.out.println("ActionListener 1 wurde aufgerufen");
    }
}
