public class Main {

    public static void main(String[] args) {

        ActionListenerImpl1 listener1 = new ActionListenerImpl1();
        ActionListenerImpl2 listener2 = new ActionListenerImpl2();
        EventDispatcherImpl dispatcher = new EventDispatcherImpl();

        dispatcher.addActionListener(listener1);
        dispatcher.addActionListener(listener2);
        dispatcher.processActionEvent(null);
    }
}
