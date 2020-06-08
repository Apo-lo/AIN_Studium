import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class EventDispatcherImpl implements EventDispatcher {
    private LinkedList<ActionListener> listenerList;

    public EventDispatcherImpl() {
        listenerList = new LinkedList<>();
    }

    @Override
    public void addActionListener(ActionListener al) {
        listenerList.add(al);
    }

    @Override
    public void processActionEvent(ActionEvent ae) {
        for(ActionListener al: listenerList) {
            new Thread(() -> al.actionPerformed(ae)).start();
        }
    }
}
